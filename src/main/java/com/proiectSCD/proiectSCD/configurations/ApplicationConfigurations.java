package com.proiectSCD.proiectSCD.configurations;

import com.proiectSCD.proiectSCD.repository.RoleRepository;
import com.proiectSCD.proiectSCD.repository.UserRepository;
import com.proiectSCD.proiectSCD.service.UserService;
import com.proiectSCD.proiectSCD.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
