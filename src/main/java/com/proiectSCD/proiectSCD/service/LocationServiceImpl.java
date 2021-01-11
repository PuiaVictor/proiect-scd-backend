package com.proiectSCD.proiectSCD.service;

import com.proiectSCD.proiectSCD.exceptionHandlers.LocationException;
import com.proiectSCD.proiectSCD.dal.model.dto.CreateLocationDTO;
import com.proiectSCD.proiectSCD.dal.model.dto.LocationFilterDTO;
import com.proiectSCD.proiectSCD.dal.model.dto.LocationUpdateDTO;
import com.proiectSCD.proiectSCD.dal.model.entity.UserLocation;
import com.proiectSCD.proiectSCD.dal.model.security.UserDetailsSecurity;
import com.proiectSCD.proiectSCD.dal.repository.LocationRepository;
import com.proiectSCD.proiectSCD.dal.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;
    private UserRepository userRepository;

    public LocationServiceImpl(LocationRepository locationRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreateLocationDTO addNewLocation(CreateLocationDTO createLocationDTO) {
        final UserDetailsSecurity currentUser = (UserDetailsSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        locationRepository.save(new UserLocation(createLocationDTO.getLatitude(),
                createLocationDTO.getLongitude(),
                new Date(),
                userRepository.findByEmail(currentUser.getUser().getEmail())));
        return null;
    }

    public void deleteLocationById(Long id) {
        locationRepository.deleteById(id);
    }

    public UserLocation getLocationById(Long id) throws LocationException{
        if(locationRepository.getLocationById(id) == null){
            throw new LocationException(404, "The location you are looking for does not exist!");
        }
        return locationRepository.getLocationById((long) id);
    }

    public UserLocation updateLocationById(LocationUpdateDTO locationUpdateDTO) {
        UserLocation updatedUserLocation = locationRepository.getLocationById(locationUpdateDTO.getId());

        if (locationUpdateDTO.getLatitude() != null)
            updatedUserLocation.setLatitude(locationUpdateDTO.getLatitude());

        if (locationUpdateDTO.getLongitude() != null)
            updatedUserLocation.setLongitude(locationUpdateDTO.getLongitude());
        updatedUserLocation.setDate(new Date());

        return locationRepository.save(updatedUserLocation);
    }

    public List<UserLocation> getLocationByUserId(Long userId) throws LocationException{
        if(userRepository.getById(userId) == null){
            throw new LocationException(404, "The user you are looking for does not exist!");
        }
        return locationRepository.getByUserId(userId);
    }

    public List<UserLocation> getLocationsByUserIdAndDate(LocationFilterDTO locationFilterDTO) throws LocationException {
        if (locationFilterDTO.getStartDate().compareTo(locationFilterDTO.getEndDate()) > 0)
            throw new LocationException(403, "The start date cannot be sooner than the end date!");
        if(userRepository.getById(locationFilterDTO.getUserId()) == null){
            throw new LocationException(404, "The user you are looking for does not exist!");
        }
        //TODO: insert logic for throwing exception if user is invalid
        // if(locationFilterDTO.getUserId())
        return (List<UserLocation>)locationRepository.customQuery(locationFilterDTO.getUserId(), locationFilterDTO.getStartDate(), locationFilterDTO.getEndDate());
    }
}
