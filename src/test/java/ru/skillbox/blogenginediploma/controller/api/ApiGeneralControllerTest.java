package ru.skillbox.blogenginediploma.controller.api;

import org.junit.jupiter.api.Test;
import ru.skillbox.blogenginediploma.AbstractIntegrationTest;
import ru.skillbox.blogenginediploma.api.response.InitResponse;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApiGeneralControllerTest extends AbstractIntegrationTest {
    private final Map<String, Object> expectedDefaultValuesMap = new HashMap<>() {{
        put("MULTIUSER_MODE", true);
        put("POST_PREMODERATION", true);
        put("STATISTICS_IS_PUBLIC", false);
    }};

    @Test
    void InitTest() throws Exception {
        String expectedInitJson = mapper.writeValueAsString(new InitResponse(
                "DevPub",
                "Подзаголовок",
                "+7 913 000-11-11",
                "test@gmail.com",
                "Тест Тестович",
                "1917"
        ));
        mockMvc.perform(get(BASE_PATH + "init"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedInitJson));
    }

    @Test
    void settingsTest() throws Exception {
        String expectedJson = mapper.writeValueAsString(expectedDefaultValuesMap);
        mockMvc.perform(get(BASE_PATH + "settings"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    void noTagTest() throws Exception {
        String expectedJson = mapper.writeValueAsString(expectedDefaultValuesMap);
        mockMvc.perform(get(BASE_PATH + "tag"))
                .andExpect(status().isOk())
                .andExpect(content().json("{tags:[]}"));
    }

}