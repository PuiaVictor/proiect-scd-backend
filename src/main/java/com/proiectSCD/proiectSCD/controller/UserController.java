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

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    //TODO: add beans
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/getMe")
    public List<Integer> getList(){
        List myList = new ArrayList();
        for(int i = 0; i<10; i++)
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


    /*
    TODO: implement the services below
    - login (anonymous) - done
- register (anonymous) - done
- get all users (ADMIN)
- create new location (ADMIN / BASIC_USER)
- get location by id (ADMIN / BASIC_USER)
- update location by id (ADMIN / BASIC_USER)
- delete location by id (ADMIN / BASIC_USER)
- filter locations by userId / startDate / endDate (ADMIN)
     */
}
