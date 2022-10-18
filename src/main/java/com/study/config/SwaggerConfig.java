package com.study.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * 未修改前报错：Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
 *
 * @author MoonMoonBird
 * @date 2022/7/24 19:19
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.study.controller")
@EnableKnife4j
public class SwaggerConfig {

    /**
     * 配置 Swagger 的 Docket 的 Bean 实例
     *
     * @return
     */
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        // 获取项目环境，通过environment.acceptsProfiles判断是否储在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.study.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置文档信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("软件sy2001赵骏鹏", "urn:tos", "1957298450@qq.com");
        return new ApiInfoBuilder()
                .title("软件开发工具Demo")
                .version("0.0.1 Dev")
                .contact(contact)
                .description("软件开发工具Demo的接口文档")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}