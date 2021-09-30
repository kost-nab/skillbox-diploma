package ru.skillbox.blogenginediploma.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skillbox.blogenginediploma.model.ModerationStatus;
import ru.skillbox.blogenginediploma.model.Post;

import java.time.LocalDateTime;

public interface PostRepo extends PagingAndSortingRepository<Post, Integer> {
    Page<Post> findByIsActiveTrueAndModerationStatusAndTimeBefore(ModerationStatus moderationStatus,
                                                     LocalDateTime time,
                                                     Pageable pageable
    );

}
