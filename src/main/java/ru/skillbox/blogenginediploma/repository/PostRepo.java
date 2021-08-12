package ru.skillbox.blogenginediploma.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skillbox.blogenginediploma.model.ModerationStatus;
import ru.skillbox.blogenginediploma.model.Post;

public interface PostRepo extends PagingAndSortingRepository<Post, Integer> {
    Page<Post> findByIsActiveTrueAndModerationStatus(ModerationStatus moderationStatus,
                                                     Pageable pageable
    );

}
