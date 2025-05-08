package com.restclient.controller;

import com.restclient.service.WebClientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class WebClientController {
    private final WebClientService webClientService;

    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    /* retrieve data */
    @GetMapping("/posts/{id}")
    public Mono<String> getWebClientData(@PathVariable int id){
        return webClientService.getPostById(id);
    }

    /* post new data at postman */
    @PostMapping("/posts")
    public Mono<String> createNewPost(){
        return webClientService.createPost();
    }
}
