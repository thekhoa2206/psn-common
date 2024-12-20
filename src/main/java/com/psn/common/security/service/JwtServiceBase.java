package com.psn.common.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServiceBase {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
