package com.wmrk.demotracker.customization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
        import org.springframework.web.method.support.HandlerMethodArgumentResolver;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

        import java.util.List;

@Configuration
@EnableWebMvc
class WebMvcContextAddResolvers extends WebMvcConfigurerAdapter {
    @Autowired
    private CurrentUserArgumentResolver currentUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserArgumentResolver);
    }
}