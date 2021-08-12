package ru.skillbox.blogenginediploma.service.post.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.skillbox.blogenginediploma.api.request.post.PostSortMode;
import ru.skillbox.blogenginediploma.api.response.post.PostResponse;
import ru.skillbox.blogenginediploma.api.response.post.PostsResponse;
import ru.skillbox.blogenginediploma.model.ModerationStatus;
import ru.skillbox.blogenginediploma.model.Post;
import ru.skillbox.blogenginediploma.repository.PostRepo;
import ru.skillbox.blogenginediploma.service.post.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private static final Map<PostSortMode, Sort> MODE_SORT_MAP = new HashMap<>() {{
        put(PostSortMode.RECENT, Sort.by("time").descending());

    }};
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostsResponse getAllPosts(int offset, int limit, PostSortMode sortMode) {
        Page<Post> allPosts = postRepo.findByIsActiveTrueAndModerationStatus(
                ModerationStatus.ACCEPTED, PageRequest.of(offset, limit, MODE_SORT_MAP.get(sortMode)));
        List<PostResponse> responses = allPosts.get()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
        return new PostsResponse(allPosts.getTotalElements(), responses);
    }
}
