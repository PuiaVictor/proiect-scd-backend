package com.proiectSCD.proiectSCD.controller;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.model.dto.CreateLocationDTO;
import com.proiectSCD.proiectSCD.model.dto.LocationUpdateDTO;
import com.proiectSCD.proiectSCD.model.entity.UserLocation;
import com.proiectSCD.proiectSCD.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "/delete/{id}")
    public void deleteLocationById(@PathVariable final Long id) throws LocationException {
        locationService.deleteLocationById(id);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserLocation> updateLocationById(@PathVariable final Long id, @RequestBody final LocationUpdateDTO locationUpdateDTO) throws LocationException {
        locationUpdateDTO.setId(id);
        return ResponseEntity.ok(locationService.updateLocationById(locationUpdateDTO));
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<UserLocation> getLocationById(@PathVariable final int id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }
}
