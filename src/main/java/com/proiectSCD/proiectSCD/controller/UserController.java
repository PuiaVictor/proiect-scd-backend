package com.proiectSCD.proiectSCD.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping(path = "/getMe")
    public List<Integer> getList(){
        List myList = new ArrayList();
        for(int i = 0; i<10; i++)
            myList.add(i);
        return myList;
    }

    @GetMapping(path = "/getAllUsers")
    public void getAllUsers(){
        //TODO: implementation
    }

    //TODO: attach to DB

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
