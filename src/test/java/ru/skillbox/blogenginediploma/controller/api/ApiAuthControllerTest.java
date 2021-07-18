package ru.skillbox.blogenginediploma.controller.api;

import org.junit.jupiter.api.Test;
import ru.skillbox.blogenginediploma.AbstractIntegrationTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApiAuthControllerTest extends AbstractIntegrationTest {
    @Test
    void notAuthorizedUserTest() throws Exception {
        mockMvc.perform(get(BASE_PATH + "auth/check"))
                .andExpect(status().isOk())
                .andExpect(content().json("{result:false}"));
    }
}