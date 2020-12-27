package com.proiectSCD.proiectSCD.service;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.model.dto.CreateLocationDTO;
import com.proiectSCD.proiectSCD.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.model.entity.UserLocation;
import com.proiectSCD.proiectSCD.repository.LocationRepository;
import com.proiectSCD.proiectSCD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;
    private UserRepository userRepository;

    public LocationServiceImpl(LocationRepository locationRepository, UserRepository userRepository){
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreateLocationDTO addNewLocation(CreateLocationDTO createLocationDTO) {
        locationRepository.save(new UserLocation(createLocationDTO.getLatitude(),
                                createLocationDTO.getLongitude(),
                                createLocationDTO.getDate(),
                                userRepository.findByEmail(createLocationDTO.getEmail())));
        return null;
    }

    public UserLocation getLocationById(int id){
        return locationRepository.getLocationById((long) id);
    }

    public List<UserLocation> getLocationByUserId(Long userId){
        return locationRepository.getUserById(userId);
    }

    public List<UserLocation> getLocationsByUserIdAndDate(LocationFilterDTO locationFilterDTO) throws LocationException {
        if (locationFilterDTO.getStartDate().compareTo(locationFilterDTO.getEndDate()) > 0)
            throw new LocationException(403, "The start date cannot be sooner than the end date!");
        return locationRepository.customQuery(locationFilterDTO.getUserId(),locationFilterDTO.getStartDate(),locationFilterDTO.getEndDate());
    }
}
