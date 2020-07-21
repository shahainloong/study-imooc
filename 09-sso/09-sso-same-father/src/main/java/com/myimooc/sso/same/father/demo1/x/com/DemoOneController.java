package com.myimooc.sso.same.father.demo1.x.com;

import com.myimooc.sso.same.father.util.HttpUtils;
import com.myimooc.sso.same.father.util.LoginCheck;
import com.myimooc.sso.same.father.util.RespMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Demo1 控制器
 *
 * @author zc 2017-04-02
 */
@Controller
public class DemoOneController {

    @RequestMapping("/demo1")
    public ModelAndView main(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //校验cookie是否为空
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            //校验cookie是否存在
            for (Cookie cookie : cookies) {
                if (LoginCheck.COOKIE_NAME.equals(cookie.getName())) {
                    //向校验服务器发送校验请求
                    String url = "http://check.x.com:8080/sso/checkCookie";
                    RespMessage respMessage = HttpUtils.doGet(url, cookie.getName(), cookie.getValue());
                    if ("200".equals(respMessage.getRespCode())) {
                        mv.setViewName("demo1");
                        return mv;
                    }
                }
            }
        }
        mv.addObject("gotoUrl", "http://demo1.x.com:8080/demo1");
        mv.setViewName("login");
        return mv;
    }
}
