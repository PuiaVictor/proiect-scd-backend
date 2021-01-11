package com.proiectSCD.proiectSCD.service;

import com.proiectSCD.proiectSCD.exceptionHandlers.UserException;
import com.proiectSCD.proiectSCD.dal.model.dto.UserCreationDTO;
import com.proiectSCD.proiectSCD.dal.model.dto.UserLoginDTO;
import com.proiectSCD.proiectSCD.dal.model.entity.UserEntity;
import com.proiectSCD.proiectSCD.dal.repository.RoleRepository;
import com.proiectSCD.proiectSCD.dal.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encodedPassword;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encodedPassword) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encodedPassword = encodedPassword;
    }

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity userLogin(UserLoginDTO userLoginDTO) throws UserException {

        if (Objects.isNull(userLoginDTO)) {
            throw new UserException(401, "The request body is null!");
        }

        if (Objects.isNull(userLoginDTO.getEmail())) {
            throw new UserException(400, "An email address must be provided!");
        }

        if (Objects.isNull(userLoginDTO.getPassword())) {
            throw new UserException(400, "A password must be provided!");
        }

        final UserEntity userEntity = userRepository.findByEmail(userLoginDTO.getEmail());

        if (Objects.isNull(userEntity)) {
            throw new UserException(401, "The provided credentials are invalid!");
        }

        if (!encodedPassword.matches(userLoginDTO.getPassword(), userEntity.getPassword())) {
            throw new UserException(401, "The provided credentials are invalid!");
        }

        return userEntity;
    }

    @Override
    public UserEntity userRegistration(UserCreationDTO userCreationDTO) throws UserException{

        if(Objects.isNull(userCreationDTO)){
            throw new UserException(401, "The request body is null!");
        }

        if(userCreationDTO.getFirstName().isEmpty()){
            throw new UserException(400, "First name field cannot be empty!");
        }

        if(userCreationDTO.getLastName().isEmpty()){
            throw new UserException(400, "Last name field cannot be empty!");
        }

        if(userCreationDTO.getEmail().isEmpty()){
            throw new UserException(400, "Email field cannot be empty!");
        }

        if(userCreationDTO.getPassword().isEmpty()){
            throw new UserException(400, "Password field cannot be empty!");
        }

        if(!Objects.isNull(userRepository.findByEmail(userCreationDTO.getEmail()))){
            throw new UserException(409, "The email you have inserted is already in use!");
        }

        if(!userCreationDTO.getPassword().equals(userCreationDTO.getConfirmedPassword())){
            throw new UserException(401, "The inserted passwords don't match!");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userCreationDTO.getFirstName());
        userEntity.setLastName(userCreationDTO.getLastName());
        userEntity.setEmail(userCreationDTO.getEmail());
        userEntity.setPassword(encodedPassword.encode(userCreationDTO.getPassword()));
        userEntity.setRoles(roleRepository.findByRole("BASIC_USER"));
        return  userRepository.save(userEntity);
    }
}
