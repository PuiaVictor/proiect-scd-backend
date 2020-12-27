package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.model.dto.CreateLocationDTO;
import com.proiectSCD.proiectSCD.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.model.entity.UserLocation;
import com.proiectSCD.proiectSCD.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {
    private final LocationServiceImpl locationService;

    @Autowired
    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<CreateLocationDTO> addLocation(@RequestBody final CreateLocationDTO locationDTO) {
        return ResponseEntity.ok(locationService.addNewLocation(locationDTO));
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<UserLocation> getLocationById(@PathVariable final int id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @GetMapping(path = "/findByUserId")
    public ResponseEntity<List<UserLocation>> getLocationsByUserId(@RequestBody LocationFilterDTO locationFilterDTO) {
        return ResponseEntity.ok(locationService.getLocationByUserId(locationFilterDTO.getUserId()));
    }
}
