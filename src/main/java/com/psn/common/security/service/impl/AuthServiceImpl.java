package com.psn.common.security.service.impl;

import com.psn.common.security.client.AuthServiceClient;
import com.psn.common.security.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthServiceClient authServiceClient;

    public AuthServiceImpl(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                var userDetails = authServiceClient.loadUserByUsername(username);
                if (Objects.isNull(userDetails)){
                    throw new UsernameNotFoundException("User not found!");
                }
                return userDetails;
            }
        };
    }
}
