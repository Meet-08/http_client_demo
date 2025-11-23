package com.meet.test_04;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.meet.test_04.models.Post;

//Old RestTemplate based implementation
@Service
public class RestTemplateOld {

    private final RestClient client;

    public RestTemplateOld(RestClient.Builder builder) {
        this.client = builder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public List<Post> findAll() {
        return client.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Post findById(Integer id) {
        return client.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

    public Post create(Post post) {
        return client.post()
                .uri("/posts")
                .body(post)
                .retrieve()
                .body(Post.class);
    }
}
