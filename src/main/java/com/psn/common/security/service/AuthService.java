package com.psn.common.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService {
    UserDetailsService userDetailsService();
}
