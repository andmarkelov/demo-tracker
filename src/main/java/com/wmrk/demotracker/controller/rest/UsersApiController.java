package com.wmrk.demotracker.controller.rest;

import com.wmrk.demotracker.controller.httpexceptions.EntityExistsException;
import com.wmrk.demotracker.controller.httpexceptions.WrongFieldsException;
import com.wmrk.demotracker.entity.User;
import com.wmrk.demotracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UsersApiController {
    UserService userService;

    @PostMapping
    public User create(@RequestBody User newUser) throws EntityExistsException, WrongFieldsException {
        if(newUser.getName() == null || newUser.getName().isEmpty()) {
            throw new WrongFieldsException();
        }
        return userService.create(newUser);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void delete(@PathVariable("id") User user) {
        userService.getUserRepo().delete(user);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Iterable<User> listAll() {
        return userService.getUserRepo().findAll();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
