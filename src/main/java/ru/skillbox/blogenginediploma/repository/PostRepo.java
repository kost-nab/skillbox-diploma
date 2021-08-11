package ru.skillbox.blogenginediploma.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skillbox.blogenginediploma.model.Post;

public interface PostRepo extends PagingAndSortingRepository<Post, Integer> {
    @Query("select p from Post p where isActive and moderationStatua = 'ACCEPTED'")
    Page<Post> getAllPosts();

    @Query("select p from Post p where isActive and moderationStatua = 'ACCEPTED'")
    Page<Post> getAllPosts(Pageable pageable);


}
