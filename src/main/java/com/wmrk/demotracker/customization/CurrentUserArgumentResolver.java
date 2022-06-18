package com.wmrk.demotracker.customization;

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
public final class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private UserRepo userRepo;

    private final Class RESOLVED_CLASS = CurrentUser.class;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(RESOLVED_CLASS);
    }

    @Override
    public Object resolveArgument(
            MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory
    ) throws Exception {
            Principal principal = nativeWebRequest.getUserPrincipal();
            User user = (User) ((Authentication) principal).getPrincipal();
            return (CurrentUser)() -> userRepo.findByNameIgnoreCase(user.getUsername());
    }

    private boolean isNotSet(String value) {
        return value == null;
    }
}
