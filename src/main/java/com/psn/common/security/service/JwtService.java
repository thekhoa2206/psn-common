package com.psn.common.security.service;

import com.psn.common.security.service.dto.UserSecurityDetails;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserSecurityDetails userDetails);

    boolean isTokenValid(String token, UserSecurityDetails userDetails);
}
