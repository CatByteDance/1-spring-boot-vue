package org.example.spring_boot_demo.controller;

import org.example.spring_boot_demo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamsController {

    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public String getTest1() {
        return "GET请求";
    }

    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    public String getTest2(String nickname, String phone) {
        System.out.println("nicknam: " + nickname );
        System.out.println("phone: " + phone );
        return "GET请求";
    }
//    @RequestParam代表参数映射，这里指的是nickname映射为name，并且nickname必须提供才能请求；加上required = false则有无都能请求
    @RequestMapping("/getTest3")
    public String getTest3(@RequestParam(value = "nickname", required = false) String name) {
        System.out.println("nickname: " + name );
        return "GET请求";
    }


    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public String postTest1() {
        return "POST请求";
    }


    @RequestMapping(value = "postTest2", method = RequestMethod.POST)
    public String postTest2(String username, String password) {
        System.out.println("username: " + username );
        System.out.println("password: " + password );
        return "POST请求";
    }

//    当前台传过来的参数过多时，可以通过封装一个对象来简化，前提是传过来的参数必需和user类一致
    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(User user) {
        System.out.println(user);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest4", method = RequestMethod.POST)
//   前端传送过来json类型表单post要加入@RequestBody注解
    public String postTest4(@RequestBody User user) {
        System.out.println(user);
        return "postTest4";
    }

    @RequestMapping("/test/**")  // 后面接任意路径
    // @RequestMapping("/test/*")  // 后面只能有一个路径
    public String test() {
        return "通配符请求";
    }
}






