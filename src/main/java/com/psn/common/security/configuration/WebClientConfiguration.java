package com.psn.common.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import static reactor.netty.http.client.HttpClient.create;
import static reactor.netty.resources.ConnectionProvider.newConnection;

@Configuration
public class WebClientConfiguration {
    @Value("${auth-service.url}")
    private String authServiceUrl;

    @Bean("authServiceWebClient")
    public WebClient authServiceWebClient() {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(create(newConnection())))
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(5 * 1024 * 1024)).build())
                .baseUrl(authServiceUrl).build();
    }

}
