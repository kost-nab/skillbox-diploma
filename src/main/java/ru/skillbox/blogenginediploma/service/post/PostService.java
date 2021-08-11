package ru.skillbox.blogenginediploma.service.post;

import ru.skillbox.blogenginediploma.api.request.post.PostSortMode;
import ru.skillbox.blogenginediploma.api.response.post.PostsResponse;

public interface PostService {
    PostsResponse getAllPosts(int offset, int limit, PostSortMode sortMode);
}
