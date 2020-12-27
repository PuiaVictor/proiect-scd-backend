package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.exceptionHandlers.UserException;
import com.proiectSCD.proiectSCD.model.dto.UserCreationDTO;
import com.proiectSCD.proiectSCD.model.dto.UserLoginDTO;
import com.proiectSCD.proiectSCD.model.entity.UserEntity;
import com.proiectSCD.proiectSCD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is designed for USER creation operations.
 */

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //mock method
    @GetMapping(path = "/getMe")
    public List<Integer> getList() {
        List myList = new ArrayList();
        for (int i = 0; i < 10; i++)
            myList.add(i);
        return myList;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody final UserCreationDTO userCreationDTO) throws UserException {
        return ResponseEntity.ok(userService.userRegistration(userCreationDTO));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserEntity> loginUser(@RequestBody final UserLoginDTO userLoginDTO) throws UserException {
        return ResponseEntity.ok(userService.userLogin(userLoginDTO));
    }
}
