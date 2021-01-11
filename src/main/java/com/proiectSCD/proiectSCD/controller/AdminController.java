package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.exceptionHandlers.UserException;
import com.proiectSCD.proiectSCD.dal.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.dal.model.entity.UserEntity;
import com.proiectSCD.proiectSCD.dal.model.entity.UserLocation;
import com.proiectSCD.proiectSCD.service.LocationServiceImpl;
import com.proiectSCD.proiectSCD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public AdminController(UserServiceImpl userService, LocationServiceImpl locationService) {
        this.userService = userService;
        this.locationService = locationService;
    }

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers() throws UserException {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(path = "/findByUserId")
    public ResponseEntity<List<UserLocation>> getLocationsByUserId(@RequestBody LocationFilterDTO locationFilterDTO) throws LocationException{
        return ResponseEntity.ok(locationService.getLocationByUserId(locationFilterDTO.getUserId()));
    }

    @GetMapping(path="/findLocationsByUserIdAndDate")
    public ResponseEntity<List<UserLocation>> getLocationsByUserIdAndDate(@RequestBody LocationFilterDTO locationFilterDTO) throws LocationException{
        return ResponseEntity.ok(locationService.getLocationsByUserIdAndDate(locationFilterDTO));
    }
//    @GetMapping(path = "/findLocationsByUserIdAndDate")
//    public ResponseEntity<List<UserLocation>> getLocationsByUserIdAndDate(
//            @RequestParam(name = "userId") final Long userId,
//            @RequestParam(name = "startDate") final Date startDate,
//            @RequestParam(name = "endDate") final Date endDate) throws LocationException {
//        LocationFilterDTO locationFilterDTO = new LocationFilterDTO();
//        locationFilterDTO.setUserId(userId);
//        locationFilterDTO.setStartDate(startDate);
//        locationFilterDTO.setEndDate(endDate);
//        return ResponseEntity.ok(locationService.getLocationsByUserIdAndDate(locationFilterDTO));
//    }
}
