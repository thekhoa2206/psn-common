package com.psn.common.security.client;

import com.psn.common.exception.ApiException;
import com.psn.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Objects;

import static io.jsonwebtoken.Header.CONTENT_TYPE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
@Slf4j
public class AuthServiceClient {
    @Value("${auth-service.load-user-by-user-name.path}")
    private String path;

    private final WebClient authServiceWebClient;

    public AuthServiceClient(WebClient authServiceWebClient) {
        this.authServiceWebClient = authServiceWebClient;
    }

    public UserDetails loadUserByUsername(String username) {
        try {
            ResponseEntity<UserDetails> response =
                    authServiceWebClient.method(HttpMethod.GET)
                            .uri( uriBuilder -> uriBuilder.path(path)
                                    .queryParam("username", username)
                                    .build())
                            .headers(httpHeaders -> {
                                httpHeaders.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
                            }).retrieve().toEntity(UserDetails.class)
                    .timeout(Duration.ofSeconds(60)).block();
            if (Objects.nonNull(response) && Objects.nonNull(response.getBody())) {
                log.info("load user by username success! username={}", username);
                return response.getBody();
            }

            log.error("Call Api load user by username failed. phoneNumber={}", username);
            throw new ApiException(ErrorCode.DATA_NOT_EXISTED);
        } catch (Exception e) {
            log.error("Error", e);
            throw new ApiException(ErrorCode.UNAUTHORIZED);
        }

    }
}
