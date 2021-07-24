package ru.skillbox.blogenginediploma.api.response.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PostsResponse {
    private int count;
    private List<PostResponse> posts = new ArrayList<>();
}
