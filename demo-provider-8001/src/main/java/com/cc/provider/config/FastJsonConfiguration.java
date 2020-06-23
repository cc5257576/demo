package com.cc.provider.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/20 14:26
 * Description:
 */
//@Configuration
public class FastJsonConfiguration extends WebMvcConfigurationSupport  {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setDateFormat(JSON.DEFFAULT_DATE_FORMAT);
        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4、将convert添加到converters中
        converters.add(fastConverter);
        //5、追加默认转换器
        super.addDefaultHttpMessageConverters(converters);
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        super.configureMessageConverters(converters);
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
////        fastJsonConfig.setSerializeFilters((ValueFilter) (o, s, source) -> {
////                    if (source == null) {
////                        return "";
////                    }
////                    if (source instanceof Date) {
////                        SimpleDateFormat sf = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT);
////                        return sf.format(source);
////                    }
////                    return source;
////                });
//        fastJsonConfig.setDateFormat(JSON.DEFFAULT_DATE_FORMAT);
//        converter.setFastJsonConfig(fastJsonConfig);
//
//        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
//        supportedMediaTypes.add(MediaType.ALL); // 全部格式
//        converter.setSupportedMediaTypes(supportedMediaTypes);
//        converters.add(converter);
//    }


//    @Bean
//    public HttpMessageConverters fastJsonConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        // 创建配置类
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(
//                SerializerFeature.WriteNullListAsEmpty,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullStringAsEmpty
//        );
//
//        //此处是全局处理方式
//        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        config.setCharset(Charset.forName("UTF-8"));
//        fastConverter.setFastJsonConfig(config);
//
//        List<MediaType> supportedMediaTypes = new ArrayList<>();
//        supportedMediaTypes.add(MediaType.ALL);
//        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//        //支持text 转string
//        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
//        return new HttpMessageConverters(fastConverter, stringHttpMessageConverter);
//    }
}
