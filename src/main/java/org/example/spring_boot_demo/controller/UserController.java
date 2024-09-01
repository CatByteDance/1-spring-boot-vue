package org.example.spring_boot_demo.controller;


import io.swagger.annotations.ApiOperation;
import org.example.spring_boot_demo.entity.User;
import org.springframework.web.bind.annotation.*;

/*
 * RESTful是一种非常流行的软件服务架构设计风格
 * 1.每一个URI代表一种资源
 * 2.客户端使用GET、POST、PUT、DELETE四种表示操作方式的动词对服务端资源进行操作：
 *   GET用于获取资源，POST用于新建资源
 *   PUT用户更新资源，DELETE用户删除资源
 * 3.通过操作资源的表现形式来实现服务端请求操作
 * 4.资源的表现形式是JSON或者HTML
 * 5.客户端与服务端之间的交互在请求之间是无状态的，从客户端到服务端的每个请求都包含必需的信息
 *
 * 对比传统方法和RESTful原则
 * 例如删除用户：
 * 传统：
 * get http://localhost:8080/del?id=10
 * 找到映射方法删除id为10的用户
 * RESTful
 * delete http://localhost:8080/user/10
 */



@RestController
public class UserController {

//  id是通过动态路径的方式传播的，在要接收的路径出加上花括号表明是动态变化的
    @ApiOperation("访问用户信息")     // swagger通过@ApiOperation注解，在ui界面简要说明
    @GetMapping("/user/{id}")
//  如果要拿到动态路径上的数据，必须加上@PathVariable注解
    public String getUserById(@PathVariable int id) {
        System.out.println(id);
        return "根据id获取用户信息";
    }

    @PostMapping("/user")
    public String save(User user){
        return "添加用户";
    }

    @PutMapping("/user")
    public String update(User user){
        return "更新用户";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        System.out.println(id);
        return "根据ID删除用户";
    }
}
