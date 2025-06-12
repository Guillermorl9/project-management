package com.example.service;


import com.example.dto.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserServiceClient {

    private final WebClient webClient;
    private final String BASE_URL = "http://localhost:8100/api/users";

    public UserServiceClient(WebClient.Builder clientBuilder) {
        this.webClient = clientBuilder.baseUrl(BASE_URL).build();
    }

    public Mono<LoginResponse> getUserByEmail(String email) {
        return this.webClient.get()
                .uri(BASE_URL + "/by-email?email={email}", email)
                .retrieve()
                .bodyToMono(LoginResponse.class);
    }

}
