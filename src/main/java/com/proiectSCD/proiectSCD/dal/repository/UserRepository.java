package com.proiectSCD.proiectSCD.dal.repository;

import com.proiectSCD.proiectSCD.dal.model.entity.RolesEntity;
import com.proiectSCD.proiectSCD.dal.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(final String email);

    UserEntity save(UserEntity user);

    UserEntity getById(Long id);

}
