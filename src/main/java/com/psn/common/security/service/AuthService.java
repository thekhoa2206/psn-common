package com.psn.common.security.service;

import com.psn.common.security.client.AuthClient;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthClient authClient;

    public AuthService(AuthClient authClient) {
        this.authClient = authClient;
    }

//    public ApiResponse<IntrospectResponse> introspect(String token){
//        return authClient.introspect(IntrospectRequest.builder()
//                .token(token)
//                .build());
//    }
}
