package com.restclient.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class WebClientService {
    private final WebClient webClient;

    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    /* Retrieve data */
    public Mono<String> getPostById(int id){
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(String.class)
                /* if success response in console */
                .doOnNext(result -> System.out.println("Response:\n" + result));
    }

    /* Create data */
    public Mono<String> createPost(){
        Map<String, Object> requestBody = Map.of(
            "title", "New post",
            "body", "Post content",
            "userId", 1
        );

        return webClient.post()
            .uri("/posts")
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(String.class)
            .doOnNext(response -> System.out.println("Response:\n" + response));
    }
}
