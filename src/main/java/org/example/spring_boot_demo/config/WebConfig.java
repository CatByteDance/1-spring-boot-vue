package org.example.spring_boot_demo.config;

import org.example.spring_boot_demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//为了让类生效要加入@Configuration注解，spring boot会自动读取这个类
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//      注册拦截器，否则不能用。addPathPatterns:只拦截user/**下的请求, 也可以不调用addPathPatterns
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/h/**");
    }
}
