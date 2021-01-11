package com.proiectSCD.proiectSCD.service;

import com.proiectSCD.proiectSCD.exceptionHandlers.UserException;
import com.proiectSCD.proiectSCD.dal.model.dto.UserCreationDTO;
import com.proiectSCD.proiectSCD.dal.model.dto.UserLoginDTO;
import com.proiectSCD.proiectSCD.dal.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();

    UserEntity userLogin(final UserLoginDTO userLoginDTO) throws UserException;

    UserEntity userRegistration(final UserCreationDTO userCreationDTO) throws UserException;

}

