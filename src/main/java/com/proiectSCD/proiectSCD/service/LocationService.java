package com.proiectSCD.proiectSCD.service;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.model.dto.CreateLocationDTO;
import com.proiectSCD.proiectSCD.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.model.dto.LocationUpdateDTO;
import com.proiectSCD.proiectSCD.model.entity.UserLocation;

import java.util.List;

public interface LocationService {
    CreateLocationDTO addNewLocation(CreateLocationDTO createLocationDTO);

    void deleteLocationById(Long id);

    UserLocation getLocationById(int id);

    UserLocation updateLocationById(LocationUpdateDTO locationUpdateDTO);

    List<UserLocation> getLocationByUserId(Long userId);

    List<UserLocation> getLocationsByUserIdAndDate(LocationFilterDTO locationFilterDTO) throws LocationException;
}
