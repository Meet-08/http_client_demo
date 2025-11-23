package com.meet.test_04;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meet.test_04.models.Post;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final RestTemplateOld restTemplateOld;
    private final RestTemplateNew restTemplateNew;

    @GetMapping("/new/posts")
    public List<Post> getPostsUsingNew() {
        return restTemplateNew.findAll();
    }

    @GetMapping("/old/posts")
    public List<Post> getPostsUsingOld() {
        return restTemplateOld.findAll();
    }
}
