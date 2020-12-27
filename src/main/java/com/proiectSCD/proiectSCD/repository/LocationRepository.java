package com.proiectSCD.proiectSCD.repository;

import com.proiectSCD.proiectSCD.model.entity.UserLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface LocationRepository extends CrudRepository<UserLocation, Long> {

    UserLocation getLocationById(final Long id);

    List<UserLocation> getUserById(final Long userId);

    @Query(value="SELECT * FROM user_location WHERE user_id=?1 AND date>=?2 AND date<=?3",nativeQuery = true)
    List<UserLocation> customQuery(final Long userId, final Date startDate, final Date endDate);

    void deleteLocationById(final Long id);
}
