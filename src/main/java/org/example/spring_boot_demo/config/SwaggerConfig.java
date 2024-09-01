package org.example.spring_boot_demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
  * 1.Swagger是一个规范和完整的框架，用于生成、描述、调用和可视化RESTful风格的Web服务，是非常流行的API表达工具
  * 2.Swagger能够自动生成完善的RESTful API文档，同时根据后台代码的修改同步更新，同时提供完整的测试页面来调试API
 */


@Configuration  // 告诉spring容器，这个类是一个配置类
@EnableSwagger2 // 启用swagger2功能
public class SwaggerConfig {
    /**
     * 配置Swagger2相关的bean
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org"))   // com包下面所有的API都交给Swagger2管理
                .paths(PathSelectors.any()).build();
    }


    /**
     * 此处是API文档页面显示信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("演示项目API")
                .description("演示项目")
                .version("1.0")
                .build();
    }
}
