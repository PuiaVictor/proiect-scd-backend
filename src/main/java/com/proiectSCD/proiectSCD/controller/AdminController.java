package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.exceptionHandlers.UserException;
import com.proiectSCD.proiectSCD.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.model.entity.UserEntity;
import com.proiectSCD.proiectSCD.model.entity.UserLocation;
import com.proiectSCD.proiectSCD.service.LocationService;
import com.proiectSCD.proiectSCD.service.LocationServiceImpl;
import com.proiectSCD.proiectSCD.service.UserService;
import com.proiectSCD.proiectSCD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class is designed for ADMIN specific operations.
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImpl userService;
    private final LocationServiceImpl locationService;

    @Autowired
    public AdminController(UserServiceImpl userService, LocationServiceImpl locationService){
        this.userService = userService;
        this.locationService = locationService;
    }

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers() throws UserException{
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(path = "/findLocationsByUserIdAndDate")
    public ResponseEntity<List<UserLocation>> getLocationsByUserIdAndDate(@RequestBody LocationFilterDTO userLocationFilterDTO) throws LocationException {
        return ResponseEntity.ok(locationService.getLocationsByUserIdAndDate(userLocationFilterDTO));
    }
}
