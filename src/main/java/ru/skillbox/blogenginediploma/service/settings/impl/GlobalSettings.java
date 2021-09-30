package ru.skillbox.blogenginediploma.service.settings.impl;

import java.io.Serializable;

public enum GlobalSettings {
    MULTIUSER_MODE("Многопользовательский режим", GlobalSettingValueFactory.newInstance(true)),
    POST_PREMODERATION("Премодерация постов", GlobalSettingValueFactory.newInstance(true)),
    STATISTICS_IS_PUBLIC("Показывать всем статистику блога", GlobalSettingValueFactory.newInstance(false));

    private final String settingName;
    private final GlobalSettingValue<?> defaultValue;

    GlobalSettings(String settingName, GlobalSettingValue<?> defaultValue) {
        this.settingName = settingName;
        this.defaultValue = defaultValue;
    }

    public String getSettingName() {
        return settingName;
    }

    public GlobalSettingValue<?> getDefaultValue() {
        return defaultValue;
    }
}
