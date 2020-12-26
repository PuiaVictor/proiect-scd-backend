package com.proiectSCD.proiectSCD.service.security;

import com.proiectSCD.proiectSCD.model.entity.UserEntity;
import com.proiectSCD.proiectSCD.model.security.UserDetailsSecurity;
import com.proiectSCD.proiectSCD.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

/**
 * Class that implements the spring security which is used for retrieving the user form the database
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByEmail(username);

        if(Objects.isNull(userEntity)){
            throw new UsernameNotFoundException("User not foud!");
        }

        return new UserDetailsSecurity(userEntity);
    }
}
