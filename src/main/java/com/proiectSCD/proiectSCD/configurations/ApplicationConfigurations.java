package com.proiectSCD.proiectSCD.configurations;

import com.proiectSCD.proiectSCD.repository.LocationRepository;
import com.proiectSCD.proiectSCD.repository.RoleRepository;
import com.proiectSCD.proiectSCD.repository.UserRepository;
import com.proiectSCD.proiectSCD.service.LocationService;
import com.proiectSCD.proiectSCD.service.LocationServiceImpl;
import com.proiectSCD.proiectSCD.service.UserService;
import com.proiectSCD.proiectSCD.service.UserServiceImpl;
import com.proiectSCD.proiectSCD.service.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfigurations {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService userService(final UserRepository userRepository, final RoleRepository roleRepository, final BCryptPasswordEncoder encodedPassword){
        return new UserServiceImpl(userRepository, roleRepository, encodedPassword);
    }

    @Bean
    public LocationService locationService(final LocationRepository locationRepository, final UserRepository userRepository){
        return new LocationServiceImpl(locationRepository, userRepository);
    }

    @Bean("customUserDetailsService")
    public UserDetailsService createUserDetailsService(final UserRepository userRepository) {
        return new UserDetailsServiceImpl(userRepository);
    }
}
