package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.exceptionHandlers.UserException;
import com.proiectSCD.proiectSCD.model.entity.UserEntity;
import com.proiectSCD.proiectSCD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class is designed for ADMIN specific operations.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers() throws UserException{
        return ResponseEntity.ok(userService.getUsers());
    }

    //TODO: implement filtering method
}
