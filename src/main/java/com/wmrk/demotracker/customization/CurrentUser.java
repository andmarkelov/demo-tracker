package com.wmrk.demotracker.customization;

import com.wmrk.demotracker.entity.User;

/**
 * functional marker interface for {@link CurrentUserArgumentResolver}
 */
public interface CurrentUser {
    public User get();
}
