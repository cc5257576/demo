package com.cc.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cc.common.exception.IORuntimeException;
import com.cc.common.util.ArrayUtil;
import com.cc.common.util.CharsetUtil;
import com.cc.common.util.ObjectUtil;
import com.cc.common.util.StrUtil;
import com.cc.common.util.crypto.SecureUtil;
import com.cc.common.util.crypto.digest.DigestUtil;
import com.cc.common.util.map.MapUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 9:52
 * Description:
 */
@Log4j2
@Component
public class AuthorizedFilter extends ZuulFilter {

    @Value("${excludeUrlPaths}")
    public String[] excludeUrlPaths;

    //签名参数名
    private static final String SIGN_PARAMETER_KEY = "sign";
    //签名秘钥
    private static final String SIGN_CODE = "heque123";

    public AuthorizedFilter() {
    }

    public AuthorizedFilter(String[] excludeUrlPaths) {
        this.excludeUrlPaths = excludeUrlPaths;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        for (int i = 0; i < excludeUrlPaths.length; i++) {
            String urlPath = excludeUrlPaths[i];
            if (urlPath.contains(req.getRequestURI()))
                return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求的上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取请求的request对象
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        //获取post,put请求的 form-data, x-www-form-urlencoded格式数据对象, 也支持get请求数据获取
        HttpServletRequestWrapper httpServletRequestWrapper = (HttpServletRequestWrapper) httpServletRequest;
        ServletRequest req = httpServletRequestWrapper.getRequest();
        try {
            //请求方法处理
            String method = httpServletRequest.getMethod();
            String interfaceMethod = httpServletRequest.getServletPath();
            String conType = httpServletRequest.getHeader("content-type");
            log.info("请求方法method={},url={}", method, interfaceMethod);
            //进行Sign加密参数处理
            String[] parameterString = new String[2];
            if (StrUtil.isBlank(method)) {
                outError(requestContext);
                return null;
            }

            Map<String, String[]> parameterMap = new HashMap<>(req.getParameterMap());
            //处理application/json数据
            if (ObjectUtil.isNotEmpty(conType) && conType.contains("application/json")) {
                InputStream in = req.getInputStream();
                String reqBody = StreamUtils.copyToString(in, CharsetUtil.CHARSET_UTF_8);
                JSONObject json = JSON.parseObject(reqBody);
                parameterMap = MapUtil.convertMap(json);
//                requestContext.setResponseBody(reqBody);
            }
            parameterString = getParameterString(parameterMap);

            Map<String, Object> resultMap = new HashMap<>();
            // 客户端签名,从参数中获取
            String clientSign = parameterString[0];

            // URI,例如：/user/login/
            String requestURI = httpServletRequest.getRequestURI();

            if (StrUtil.isBlank(clientSign)) {
                outError(requestContext);
                return null;
            }

            if (StrUtil.isBlank(SIGN_CODE)) {
                outError(requestContext);
                return null;
            }

            // 签名串：URI + 按顺序的参数键与参数值  + MD5(双方约定的KEY)
            StringBuilder signStr = new StringBuilder();


            if (StrUtil.isNotBlank(requestURI)) {
                signStr.append(requestURI);
            }

            if (StrUtil.isNotBlank(parameterString[1])) {
                signStr.append(parameterString[1]);
            }

            if (StrUtil.isNotBlank(SIGN_CODE)) {
                signStr.append(DigestUtil.md5Hex(SIGN_CODE));
            }

            log.info("请求URI:[{}],加密前签名串:[{}]", requestURI, signStr);
            String sign = DigestUtil.md5Hex(signStr.toString()).toLowerCase();
            log.info("请求URI:[{}],加密后签名串:[{}],客户端签名串:[{}],是否匹配:[{}]", requestURI, sign, clientSign, clientSign.equals(sign));

            // 签名不匹配
            if (!clientSign.equals(sign)) {
                log.error("访问[{}]签名错误", requestURI);
                outError(requestContext);
                return null;
            }
        } catch (IOException io) {
            log.error(io.getMessage(), io);
        }
        return null;
    }

    private String[] getParameterString(Map<String, String[]> parameterMap){
        String result[] = new String[2];
        if (MapUtil.isNotEmpty(parameterMap)) {

            StringBuilder parameterStringBuilder = new StringBuilder();
            List<String> keyList = new ArrayList<String>(parameterMap.keySet());
            // 对POST请求参数名进行排序
            Collections.sort(keyList);

            for (int i = 0; i < keyList.size(); i++) {

                String parameterKey = keyList.get(i);
                // 排除签名参数
                if (SIGN_PARAMETER_KEY.equals(parameterKey)) {
                    result[0] = parameterMap.get(parameterKey)[0];
                    continue;
                }
                parameterStringBuilder.append(parameterKey);

                String[] parameterValue = parameterMap.get(parameterKey);
                if (ArrayUtil.isEmpty(parameterValue))
                    continue;

                if (parameterValue.length == 1 && StrUtil.isNotBlank(parameterValue[0])) {
                    parameterStringBuilder.append(parameterValue[0]);
                }
                // 如果参数值是数组，依次添加
                else {
                    for (int j = 0; j < parameterValue.length; j++) {
                        if (StrUtil.isNotBlank(parameterValue[j])) {
                            parameterStringBuilder.append(parameterValue[j]);
                        }
                    }
                }
            }
            result[1] = parameterStringBuilder.toString();
        }
        return result;
    }

    private void outError(RequestContext ctx) {
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        ctx.setResponseBody(""); //异常返回数据
        ctx.set("isSuccess", false);
    }

    public static void main(String[] args) {
        String sign = "/consumer-proxy/user/get" + "userId4" + DigestUtil.md5Hex(SIGN_CODE);
        System.out.println(sign);
        System.out.println(DigestUtil.md5Hex("123456"));
    }
}
