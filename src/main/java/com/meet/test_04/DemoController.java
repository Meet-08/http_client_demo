package com.meet.test_04;

import com.meet.test_04.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final RestClientOld restClientOld;
    private final RestClientNew restClientNew;

    @GetMapping("/new/posts")
    public List<Post> getPostsUsingNew() {
        return restClientNew.findAll();
    }

    @GetMapping("/old/posts")
    public List<Post> getPostsUsingOld() {
        return restClientOld.findAll();
    }
}
