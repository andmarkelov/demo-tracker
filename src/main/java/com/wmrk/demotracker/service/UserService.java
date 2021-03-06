package com.wmrk.demotracker.service;

import com.wmrk.demotracker.controller.httpexceptions.EntityExistsException;
import com.wmrk.demotracker.entity.Role;
import com.wmrk.demotracker.entity.User;
import com.wmrk.demotracker.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    UserRepo userRepo;

    @Transactional
    public User create(User newUser) throws EntityExistsException {
        if (userRepo.existsByNameIgnoreCase(newUser.getName())) {
            throw new EntityExistsException();
        }

        newUser.setActive(true);
        newUser.setRoles(Collections.singleton(Role.ROLE_USER));
        if(newUser.getName().equalsIgnoreCase("admin")) {
            newUser.setRoles(Collections.singleton(Role.ROLE_ADMIN));
        }

        newUser.setId(0);
        userRepo.save(newUser);
        return newUser;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
