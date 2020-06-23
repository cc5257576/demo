package com.cc.security.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/10/16 12:18
 * Description:
 */
@Log4j2
@Controller
public class CaptchaController {

    @RequestMapping("/getVerifyCode")
    public void create(HttpServletRequest request, HttpServletResponse response){
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(80, 50,4,4);

        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("validateCode", captcha.getCode());

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream sos = null;
        try {
            sos = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        captcha.write(sos);
    }
}
