package ru.skillbox.blogenginediploma.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.blogenginediploma.api.request.post.PostSortMode;
import ru.skillbox.blogenginediploma.api.response.post.PostsResponse;
import ru.skillbox.blogenginediploma.service.post.PostService;

import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {
    private final PostService postService;

    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public PostsResponse getPosts(
            @RequestParam(required = false) Optional<Integer> offset,
            @RequestParam(required = false) Optional<Integer> limit,
            @RequestParam(required = false) Optional<PostSortMode> mode
            ) {
        return postService.getAllPosts(offset.orElse(0), limit.orElse(10), mode.orElse(PostSortMode.RECENT));
    }
}
