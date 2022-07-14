package com.wmrk.demotracker.controller.rest;

import com.wmrk.demotracker.controller.httpexceptions.EntityExistsException;
import com.wmrk.demotracker.controller.httpexceptions.WrongFieldsException;
import com.wmrk.demotracker.entity.Role;
import com.wmrk.demotracker.entity.User;
import com.wmrk.demotracker.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("api/user")
public class UsersApiController {
    UserRepo userRepo;

    @Autowired
    public UsersApiController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    @Transactional
    public User create(@RequestBody User newUser) throws EntityExistsException, WrongFieldsException {

        if(newUser.getName() == null || newUser.getName().isEmpty()) {
            throw new WrongFieldsException();
        } else if (userRepo.existsByNameIgnoreCase(newUser.getName())) {
            throw new EntityExistsException();
        }

        newUser.setActive(true);
        newUser.setRoles(Collections.singleton(Role.USER));
        newUser.setId(null);
        userRepo.save(newUser);
        return newUser;
    }
}
