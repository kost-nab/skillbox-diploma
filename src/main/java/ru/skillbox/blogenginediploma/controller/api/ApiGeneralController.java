package ru.skillbox.blogenginediploma.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.blogenginediploma.api.response.InitResponse;
import ru.skillbox.blogenginediploma.api.response.tag.TagResponse;
import ru.skillbox.blogenginediploma.service.settings.SettingsService;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ApiGeneralController {
    private final InitResponse initResponse;
    private final SettingsService settingsService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
    }

    @GetMapping("init")
    public InitResponse init() {
        return initResponse;
    }

    @GetMapping("settings")
    public Map<String, Object> settings() {
        return settingsService.getSettings();
    }

    @GetMapping("tag")
    public TagResponse getTags(
            @RequestParam(required = false) String query
    ) {
        // TODO реализовать получение тэгов

        return new TagResponse();
    }
}
