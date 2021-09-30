package ru.skillbox.blogenginediploma.service.post.impl;

import org.apache.logging.log4j.util.PropertySource;
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
import ru.skillbox.blogenginediploma.repository.post.PostRepo;
import ru.skillbox.blogenginediploma.service.post.PostService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private static final Map<PostSortMode, Sort> MODE_SORT_MAP = new HashMap<>() {{
        put(PostSortMode.RECENT, Sort.by("time").descending());
        put(PostSortMode.EARLY, Sort.by("time"));
        put(PostSortMode.POPULAR, Sort.by("commentCount").descending().and(Sort.by("time").descending()));
        put(PostSortMode.BEST, Sort.by("likeCount").descending().and(Sort.by("time").descending()));
    }};

    private static final Map<PostSortMode, Comparator<PostResponse>> MODE_COMP_MAP = new HashMap<>() {{
        put(PostSortMode.RECENT, (pr1, pr2) -> (int) (pr2.getTimestamp() - pr1.getTimestamp()));
        put(PostSortMode.EARLY, Comparator.comparingLong(PostResponse::getTimestamp));
        put(PostSortMode.POPULAR, (pr1, pr2) -> (int) (pr2.getCommentCount() - pr1.getCommentCount()));
        put(PostSortMode.BEST, (pr1, pr2) -> (int) (pr2.getLikeCount() - pr1.getLikeCount()));

    }};
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostsResponse getAllPosts(int offset, int limit, PostSortMode sortMode, LocalDateTime time) {
         Page<Post> allPosts = postRepo.findByIsActiveTrueAndModerationStatusAndTimeBefore(
                ModerationStatus.ACCEPTED, time, PageRequest.of(offset, limit, MODE_SORT_MAP.get(sortMode)));
         List<PostResponse> responses = allPosts.get()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
        return new PostsResponse(allPosts.getTotalElements(), responses);
    }
}
