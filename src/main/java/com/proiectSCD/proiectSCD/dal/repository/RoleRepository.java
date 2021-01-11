package com.proiectSCD.proiectSCD.dal.repository;

import com.proiectSCD.proiectSCD.dal.model.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<RolesEntity, Long> {

    Set<RolesEntity> findById(int id);

    Set<RolesEntity> findByRole(String role);
}
