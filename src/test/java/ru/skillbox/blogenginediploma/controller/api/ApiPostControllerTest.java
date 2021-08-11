package ru.skillbox.blogenginediploma.controller.api;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import ru.skillbox.blogenginediploma.AbstractIntegrationTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApiPostControllerTest extends AbstractIntegrationTest {
    @Test
    void noPostsTest() throws Exception {
        mockMvc.perform(get(BASE_PATH + "post"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"count\":0,\"posts\":[]}"));
    }

    @Test
    @Sql(scripts = "/db-scripts/post-mapping-test.sql")
    void one() throws Exception {
        mockMvc.perform(get(BASE_PATH + "post"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }
}