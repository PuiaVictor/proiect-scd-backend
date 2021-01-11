package com.proiectSCD.proiectSCD.service;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.dal.model.dto.CreateLocationDTO;
import com.proiectSCD.proiectSCD.dal.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.dal.model.dto.LocationUpdateDTO;
import com.proiectSCD.proiectSCD.dal.model.entity.UserLocation;

import java.util.List;

public interface LocationService {
    CreateLocationDTO addNewLocation(CreateLocationDTO createLocationDTO);

    void deleteLocationById(Long id);

    UserLocation getLocationById(Long id) throws LocationException;

    UserLocation updateLocationById(LocationUpdateDTO locationUpdateDTO);

    List<UserLocation> getLocationByUserId(Long userId) throws LocationException;

    List<UserLocation> getLocationsByUserIdAndDate(LocationFilterDTO locationFilterDTO) throws LocationException;
}
