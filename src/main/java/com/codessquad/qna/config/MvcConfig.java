package com.codessquad.qna.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/form").setViewName("user/form");
        registry.addViewController("/user/login").setViewName("../static/user/login");
        registry.addViewController("/qna/form").setViewName("qna/form");
    }
}
