package ru.skillbox.blogenginediploma.service.settings.impl;

import org.springframework.stereotype.Service;
import ru.skillbox.blogenginediploma.model.GlobalSetting;
import ru.skillbox.blogenginediploma.repository.GlobalSettingRepo;
import ru.skillbox.blogenginediploma.service.settings.SettingsService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SettingsServiceImpl implements SettingsService {
    private final GlobalSettingRepo globalSettingRepo;

    public SettingsServiceImpl(GlobalSettingRepo globalSettingRepo) {
        this.globalSettingRepo = globalSettingRepo;
    }

    @Override
    public Map<String, Object> getSettings() {
        List<GlobalSetting> savedGlobalSettings = globalSettingRepo.findAll();

        return Arrays.stream(GlobalSettings.values())
                .collect(Collectors.toMap(
                        GlobalSettings::name,
                        gs -> {
                            Optional<GlobalSetting> globalSetting = getGlobalSetting(savedGlobalSettings, gs);
                            return globalSetting.isPresent() ?
                                    gs.getDefaultValue().getValue(globalSetting.get().getValue()) :
                                    gs.getDefaultValue().getValue();
                        }
                ));
    }

    @Override
    public void updateSettings() {
        // TODO implement update and saving of settings to database
    }

    private Optional<GlobalSetting> getGlobalSetting(List<GlobalSetting> settings, GlobalSettings globalSettings) {
        return settings.stream()
                .filter(gs -> gs.getCode().equals(globalSettings.name()))
                .findFirst();
    }
}
