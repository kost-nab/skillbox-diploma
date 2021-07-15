package ru.skillbox.blogenginediploma.service.settings.impl;

public class GlobalSettingValueFactory {
    public static GlobalSettingValue<Boolean> newInstance(boolean value) {
        return new GlobalSettingValue<>(
                bValue -> bValue ? "YES" : "NO",
                dataValue -> dataValue.equals("YES"),
                value
                );
    }
}
