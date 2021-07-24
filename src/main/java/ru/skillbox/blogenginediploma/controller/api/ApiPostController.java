package ru.skillbox.blogenginediploma.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.blogenginediploma.api.request.post.PostSortMode;
import ru.skillbox.blogenginediploma.api.response.post.PostsResponse;

import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {
    @GetMapping
    public PostsResponse getPosts(
            @RequestParam(required = false) Optional<Integer> offset,
            @RequestParam(required = false) Optional<Integer> limit,
            @RequestParam(required = false) Optional<PostSortMode> mode
            ) {
        // TODO реализовать получение постов

        return new PostsResponse();
    }
}
