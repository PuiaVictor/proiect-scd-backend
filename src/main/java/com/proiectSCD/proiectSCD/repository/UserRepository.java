package com.proiectSCD.proiectSCD.repository;

import com.proiectSCD.proiectSCD.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(final String email);

    UserEntity save(UserEntity user);

    UserEntity getById(Long id);
}
