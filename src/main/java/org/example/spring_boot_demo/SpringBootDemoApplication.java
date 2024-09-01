package org.example.spring_boot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        // main 方法 是 Spring Boot 应用程序的入口点，调用 SpringApplication.run 启动应用
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
