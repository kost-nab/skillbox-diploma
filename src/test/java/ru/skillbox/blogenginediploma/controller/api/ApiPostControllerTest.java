package ru.skillbox.blogenginediploma.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import ru.skillbox.blogenginediploma.AbstractIntegrationTest;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(scripts = {
        "/db-scripts/clear.sql",
        "/db-scripts/post/01_users-and-posts.sql",
        "/db-scripts/post/02_likes.sql",
        "/db-scripts/post/03_comments.sql"
})
class ApiPostControllerTest extends AbstractIntegrationTest {
    @Test
    @Sql(scripts = "/db-scripts/clear.sql")
    void noPostsTest() throws Exception {
        mockMvc.perform(get(BASE_PATH + "post"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"count\":0,\"posts\":[]}"));
    }

    @Test
    void allPostsTest() throws Exception {
        Path file = Paths.get(getClass().getResource("/responses/post/posts.json").toURI());
        String expectedJson = Files.readString(file);
        mockMvc.perform(get(BASE_PATH + "post")
//                        .param()
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }
}