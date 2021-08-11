package ru.skillbox.blogenginediploma.api.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsResponse {
    private long count;
    private List<PostResponse> posts = new ArrayList<>();
}
