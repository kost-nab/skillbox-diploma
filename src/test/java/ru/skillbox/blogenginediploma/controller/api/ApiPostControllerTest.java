package ru.skillbox.blogenginediploma.controller.api;

import org.junit.jupiter.api.Test;
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
}