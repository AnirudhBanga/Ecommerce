package com.infosys.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.infosys.backend.model.User;
import com.infosys.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserService userService;

   @PostMapping("/register")
public ResponseEntity<?> register(@Valid @RequestBody User user) {
    User savedUser = userService.register(user);
    savedUser.setPassword(null); // hide password
    return ResponseEntity.ok(savedUser);
}
}
