package ru.skillbox.blogenginediploma.service.post.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import ru.skillbox.blogenginediploma.api.request.post.PostSortMode;
import ru.skillbox.blogenginediploma.api.response.post.PostResponse;
import ru.skillbox.blogenginediploma.api.response.post.PostsResponse;
import ru.skillbox.blogenginediploma.api.response.post.UserInPostResponse;
import ru.skillbox.blogenginediploma.service.post.PostService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {
        "/db-scripts/clear.sql",
        "/db-scripts/post/01_users-and-posts.sql",
        "/db-scripts/post/02_likes.sql",
        "/db-scripts/post/03_comments.sql"
})
class PostServiceTest {
    private static final LocalDateTime MOCK_NOW = LocalDateTime
            .of(2020, 11, 22, 10, 40);

    @Autowired private PostService postService;

    private final List<PostResponse> allResponsesForNow = new ArrayList<>() {{
        add(new PostResponse(8, 1606128458,
                new UserInPostResponse(1, "test user"), "Title of message",
                "Some text for test 8",
                8, 0, 3, 38
                ));
        add(new PostResponse(7, 1605887618,
                new UserInPostResponse(1, "test user"), "Title of message",
                "Some text for test 7",
                1, 0, 0, 24
        ));
        add(new PostResponse(6, 1605368904,
                new UserInPostResponse(3, "test user3"), "Title of message",
                "Some text for test 6",
                3, 0, 8, 2
        ));
        add(new PostResponse(3, 1605196040,
                new UserInPostResponse(4, "test user4"), "Title of message",
                "Some text for test 3",
                5, 2, 5, 7
        ));
        add(new PostResponse(2, 1605196030,
                new UserInPostResponse(1, "test user"), "Title of the big message",
                "Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития...",
                3, 5, 4, 14
        ));
        add(new PostResponse(1, 1605196020,
                new UserInPostResponse(1, "test user"), "Title of the first message",
                "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\".",
                3, 3, 7, 47
        ));
    }};

    private final List<PostResponse> allResponsesForMockNow = new ArrayList<>() {{
        add(new PostResponse(7, 1605887618,
                new UserInPostResponse(1, "test user"), "Title of message",
                "Some text for test 7",
                1, 0, 0, 24
        ));
        add(new PostResponse(6, 1605368904,
                new UserInPostResponse(3, "test user3"), "Title of message",
                "Some text for test 6",
                3, 0, 8, 2
        ));
        add(new PostResponse(3, 1605196040,
                new UserInPostResponse(4, "test user4"), "Title of message",
                "Some text for test 3",
                5, 2, 5, 7
        ));
        add(new PostResponse(2, 1605196030,
                new UserInPostResponse(1, "test user"), "Title of the big message",
                "Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития...",
                3, 5, 4, 14
        ));
        add(new PostResponse(1, 1605196020,
                new UserInPostResponse(1, "test user"), "Title of the first message",
                "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\".",
                3, 3, 7, 47
        ));
    }};

    private final List<PostResponse> firstPageOfResponses = new ArrayList<>() {{
        add(new PostResponse(7, 1605887618,
                new UserInPostResponse(1, "test user"), "Title of message",
                "Some text for test 7",
                1, 0, 0, 24
        ));
        add(new PostResponse(6, 1605368904,
                new UserInPostResponse(3, "test user3"), "Title of message",
                "Some text for test 6",
                3, 0, 8, 2
        ));
        add(new PostResponse(3, 1605196040,
                new UserInPostResponse(4, "test user4"), "Title of message",
                "Some text for test 3",
                5, 2, 5, 7
        ));
    }};

    private final List<PostResponse> secondPageOfResponses = new ArrayList<>() {{
        add(new PostResponse(2, 1605196030,
                new UserInPostResponse(1, "test user"), "Title of the big message",
                "Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития...",
                3, 5, 4, 14
        ));
        add(new PostResponse(1, 1605196020,
                new UserInPostResponse(1, "test user"), "Title of the first message",
                "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\".",
                3, 3, 7, 47
        ));
    }};

    private final List<PostResponse> allResponsesForEarlyMode = new ArrayList<>() {{
        add(new PostResponse(1, 1605196020,
                new UserInPostResponse(1, "test user"), "Title of the first message",
                "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\".",
                3, 3, 7, 47
        ));
        add(new PostResponse(2, 1605196030,
                new UserInPostResponse(1, "test user"), "Title of the big message",
                "Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития...",
                3, 5, 4, 14
        ));
        add(new PostResponse(3, 1605196040,
                new UserInPostResponse(4, "test user4"), "Title of message",
                "Some text for test 3",
                5, 2, 5, 7
        ));
    }};

    private final List<PostResponse> allResponsesForPopularMode = new ArrayList<>() {{
        add(new PostResponse(6, 1605368904,
                new UserInPostResponse(3, "test user3"), "Title of message",
                "Some text for test 6",
                3, 0, 8, 2
        ));
        add(new PostResponse(1, 1605196020,
                new UserInPostResponse(1, "test user"), "Title of the first message",
                "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\".",
                3, 3, 7, 47
        ));
        add(new PostResponse(3, 1605196040,
                new UserInPostResponse(4, "test user4"), "Title of message",
                "Some text for test 3",
                5, 2, 5, 7
        ));
    }};

    private final List<PostResponse> allResponsesForBestMode = new ArrayList<>() {{
        add(new PostResponse(3, 1605196040,
                new UserInPostResponse(4, "test user4"), "Title of message",
                "Some text for test 3",
                5, 2, 5, 7
        ));
        add(new PostResponse(6, 1605368904,
                new UserInPostResponse(3, "test user3"), "Title of message",
                "Some text for test 6",
                3, 0, 8, 2
        ));
        add(new PostResponse(2, 1605196030,
                new UserInPostResponse(1, "test user"), "Title of the big message",
                "Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития...",
                3, 5, 4, 14
        ));
    }};

    @Test
    void getAllPostsNowTest() {
        PostsResponse allPosts = postService.getAllPosts(0, 10, PostSortMode.RECENT, LocalDateTime.now());
        assertEquals(6, allPosts.getCount());
        assertEquals(allResponsesForNow, allPosts.getPosts());
    }

    @Test
    void getAllPostsMockNowTest() {
        PostsResponse allPosts = postService.getAllPosts(0, 10, PostSortMode.RECENT, MOCK_NOW);
        assertEquals(5, allPosts.getCount());
        assertEquals(allResponsesForMockNow, allPosts.getPosts());
    }

    @Test
    void getAllPostsFirstPageTest() {
        PostsResponse allPosts = postService.getAllPosts(0, 3, PostSortMode.RECENT, MOCK_NOW);
        assertEquals(5, allPosts.getCount());
        assertEquals(firstPageOfResponses, allPosts.getPosts());
    }

    @Test
    void getAllPostsSecondPageTest() {
        PostsResponse allPosts = postService.getAllPosts(1, 3, PostSortMode.RECENT, MOCK_NOW);
        assertEquals(5, allPosts.getCount());
        assertEquals(secondPageOfResponses, allPosts.getPosts());
    }

    @Test
    void getAllPostsEarlyModeTest() {
        PostsResponse allPosts = postService.getAllPosts(0, 3, PostSortMode.EARLY, MOCK_NOW);
        assertEquals(5, allPosts.getCount());
        assertEquals(allResponsesForEarlyMode, allPosts.getPosts());
    }

    @Test
    void getAllPostsPopularModeTest() {
        PostsResponse allPosts = postService.getAllPosts(0, 3, PostSortMode.POPULAR, MOCK_NOW);
        assertEquals(5, allPosts.getCount());
        assertEquals(allResponsesForPopularMode, allPosts.getPosts());
    }

    @Test
    void getAllPostsBestModeTest() {
        PostsResponse allPosts = postService.getAllPosts(0, 3, PostSortMode.BEST, MOCK_NOW);
        assertEquals(5, allPosts.getCount());
        assertEquals(allResponsesForBestMode, allPosts.getPosts());
    }

}