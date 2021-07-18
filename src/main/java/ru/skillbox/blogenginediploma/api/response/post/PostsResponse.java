package ru.skillbox.blogenginediploma.api.response.post;

import lombok.Data;

import java.util.List;

@Data
public class PostsResponse {
    private int count;
    private List<PostResponse> posts;
}
