package com.proiectSCD.proiectSCD.repository;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Location getById(final Long id);

    List<Location> getUserById(final Long userId);

    //TODO: finish implementation

}
