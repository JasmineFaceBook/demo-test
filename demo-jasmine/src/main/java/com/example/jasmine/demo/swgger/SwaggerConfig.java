package com.example.jasmine.demo.swgger;


/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

*//**
 * @Author : libingyao
 * @Date : 2018/4/13
 * @Description: 略
 * @Version : 略
 * Created by 24166
 *//*
@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig {
    private SpringSwaggerConfig springSwaggerConfig;

    *//**
     * Required to autowire SpringSwaggerConfig
     *//*
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    *//**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     *//*
    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*api*.*");//在此处，代表扫描的controller或者接口的名。有些教程在类开始处注解@compentScan，这个是无效的。
    }

    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "吃瓜app",
                "接口文档",
                "",
                "ywd979@foxmail.com",
                "",
                "");
        return apiInfo;
    }
}*/
