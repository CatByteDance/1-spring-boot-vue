package org.example.spring_boot_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 也可以用@GetMapping("/hello")
    @RequestMapping (value = "/hello", method = RequestMethod.GET)
//  http://localhost:8080/hello?nickname=zhangsan&phone=123 传参数
    public String hello(String nickname, String phone) {
        System.out.println(nickname + " " + phone);
        return "Bye " + nickname;
    }

}
