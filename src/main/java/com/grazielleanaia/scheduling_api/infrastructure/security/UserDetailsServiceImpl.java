package com.grazielleanaia.scheduling_api.infrastructure.security;

import com.grazielleanaia.scheduling_api.business.dto.CustomerDTO;
import com.grazielleanaia.scheduling_api.infrastructure.client.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    //Use of synchronous communication service OpenFeign

    @Autowired
    private CustomerClient client;


    public UserDetails loadUserByUsername(String email, String token) {
        CustomerDTO customerDTO = client.findCustomerByEmail(email, token);
        return User
                .withUsername(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .build();
    }
}
