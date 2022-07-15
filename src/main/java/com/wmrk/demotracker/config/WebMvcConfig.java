package com.wmrk.demotracker.config;


import com.wmrk.demotracker.util.customization.CurrentUserArgumentResolver;
import com.wmrk.demotracker.util.customization.DeviceByGuidArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableAspectJAutoProxy
class WebMvcConfig implements WebMvcConfigurer {

    private CurrentUserArgumentResolver currentUserArgumentResolver;
    private DeviceByGuidArgumentResolver deviceByGuidArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserArgumentResolver);
        argumentResolvers.add(deviceByGuidArgumentResolver);
    }

    @Autowired

    public WebMvcConfig(CurrentUserArgumentResolver currentUserArgumentResolver, DeviceByGuidArgumentResolver deviceByGuidArgumentResolver) {
        this.currentUserArgumentResolver = currentUserArgumentResolver;
        this.deviceByGuidArgumentResolver = deviceByGuidArgumentResolver;
    }
}