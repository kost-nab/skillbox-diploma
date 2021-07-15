package ru.skillbox.blogenginediploma.service.settings;

import java.util.HashMap;
import java.util.Map;

public interface SettingsService {
    Map<String, Object> getSettings();

    void updateSettings();
}
