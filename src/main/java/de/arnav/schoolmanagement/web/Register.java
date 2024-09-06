package de.arnav.schoolmanagement.web;

import de.arnav.schoolmanagement.model.User;
import de.arnav.schoolmanagement.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Register {

    private final UserService userService;

    public Register(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
}
