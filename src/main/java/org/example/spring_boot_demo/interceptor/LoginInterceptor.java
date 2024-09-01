package org.example.spring_boot_demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 必需集成该HandlerInterceptor类，才能实现拦截器的功能
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前调用preHandle类(Controller方法之前)
     */

    @Override
//  request是前端的请求，reponse返回给前端信息
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 可以在这里做一些处理
        System.out.println("You are intercepted by LoginInterceptor!");
        return true;
    }
}
