package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.model.dto.UserCreationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path = "/getMe")
    public List<Integer> getList(){
        List myList = new ArrayList();
        for(int i = 0; i<10; i++)
            myList.add(i);
        return myList;
    }

    @PostMapping(path = "/createUser")
    public ResponseEntity createUser(@RequestBody final UserCreationDTO userCreationDTO){
        
    }

    @GetMapping(path = "/getAllUsers")
    public void getAllUsers(){
        //TODO: implementation
    }

//    @PostMapping(path = "/newLocation")
//    public ResponseEntity createNewLocation(){
//        return new ResponseEntity();
//    }
//
//    @GetMapping(path = "getLocationByID/{id}")
//    public void getLocationByID(int id){
//
//    }

    /*
    TODO: implement the services below
    - login (anonymous)
- register (anonymous)
- get all users (ADMIN)
- create new location (ADMIN / BASIC_USER)
- get location by id (ADMIN / BASIC_USER)
- update location by id (ADMIN / BASIC_USER)
- delete location by id (ADMIN / BASIC_USER)
- filter locations by userId / startDate / endDate (ADMIN)
     */
}
