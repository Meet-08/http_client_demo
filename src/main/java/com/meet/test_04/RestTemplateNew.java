package com.meet.test_04;

import com.meet.test_04.models.Post;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

//New way to create RestTemplate using HttpExchange annotation
@HttpExchange(url = "https://jsonplaceholder.typicode.com")
public interface RestTemplateNew {

    @GetExchange("/posts")
    List<Post> findAll();

    @GetExchange("/posts/{id}")
    Post findById(Integer id);

    @PostExchange("/posts")
    Post create(Post post);
}
