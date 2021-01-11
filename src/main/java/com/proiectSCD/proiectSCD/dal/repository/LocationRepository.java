package com.proiectSCD.proiectSCD.dal.repository;

import com.proiectSCD.proiectSCD.dal.model.entity.UserLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LocationRepository extends CrudRepository<UserLocation, Long> {

    UserLocation getLocationById(final Long id);

    List<UserLocation> getByUserId(final Long userId);

    @Query(value="SELECT * FROM location WHERE user_id=?1 AND date>=?2 AND date<=?3",nativeQuery = true)
    List<UserLocation> customQuery(@Param("userId") final Long userId, @Param("startDate") final Date startDate, @Param("endDate") final Date endDate);

    void deleteLocationById(final Long id);
}
