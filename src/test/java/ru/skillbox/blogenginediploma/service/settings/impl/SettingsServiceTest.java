package ru.skillbox.blogenginediploma.service.settings.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skillbox.blogenginediploma.model.GlobalSetting;
import ru.skillbox.blogenginediploma.repository.GlobalSettingRepo;
import ru.skillbox.blogenginediploma.service.settings.SettingsService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SettingsServiceTest {
    private final Map<String, Object> expectedDefaultValuesMap = new HashMap<>() {{
        put("MULTIUSER_MODE", true);
        put("POST_PREMODERATION", true);
        put("STATISTICS_IS_PUBLIC", false);
    }};


    @Autowired
    GlobalSettingRepo globalSettingRepo;

    @Autowired
    SettingsService settingsService;

    @BeforeEach
    void setUp() {
        globalSettingRepo.deleteAll();
    }

    @Test
    void getDefaultSettingsTest() {
        assertEquals(expectedDefaultValuesMap, settingsService.getSettings());
    }

    @Test
    void getCustomSettingsTest() {
        globalSettingRepo.save(new GlobalSetting("MULTIUSER_MODE", "ass", "YES"));
        globalSettingRepo.save(new GlobalSetting("STATISTICS_IS_PUBLIC", "ass", "NO"));

        Map<String, Object> expectedCustomValuesMap = new HashMap<>() {{
            put("MULTIUSER_MODE", true);
            put("POST_PREMODERATION", true);
            put("STATISTICS_IS_PUBLIC", false);
        }};
        assertEquals(expectedCustomValuesMap, settingsService.getSettings());
    }

    @Test
    void wrongSettingInRepoTest() {
        globalSettingRepo.save(new GlobalSetting("MULTIUSER_MODE", "ass", "NO"));
        globalSettingRepo.save(new GlobalSetting("STATISTICS_PUBLIC", "ass", "NO"));

        Map<String, Object> expectedCustomValuesMap = new HashMap<>() {{
            put("MULTIUSER_MODE", false);
            put("POST_PREMODERATION", true);
            put("STATISTICS_IS_PUBLIC", false);
        }};
        assertEquals(expectedCustomValuesMap, settingsService.getSettings());
    }

    @Test
    void updateSettings() {
        // TODO test settings updating
    }
}