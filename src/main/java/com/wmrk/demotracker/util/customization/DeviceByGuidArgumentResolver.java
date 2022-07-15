package com.wmrk.demotracker.util.customization;

import com.wmrk.demotracker.entity.GeoDevice;
import com.wmrk.demotracker.repo.GeoDeviceRepo;
import com.wmrk.demotracker.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.security.Principal;


@Component
public final class DeviceByGuidArgumentResolver implements HandlerMethodArgumentResolver {

    private GeoDeviceRepo geoDeviceRepo;

    private final Class RESOLVED_CLASS = GeoDevice.class;
    private final Class ANNOTATION_CLASS = CurrentDevice.class;

    @Autowired
    public DeviceByGuidArgumentResolver(GeoDeviceRepo geoDeviceRepo) {
        this.geoDeviceRepo = geoDeviceRepo;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(ANNOTATION_CLASS) && methodParameter.getParameterType().equals(RESOLVED_CLASS);
    }

    @Override
    public Object resolveArgument(
            MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory
    ) throws Exception {
        return geoDeviceRepo.findByGuidIgnoreCase(nativeWebRequest.getParameter("guid"));
    }

    private boolean isNotSet(String value) {
        return value == null;
    }
}
