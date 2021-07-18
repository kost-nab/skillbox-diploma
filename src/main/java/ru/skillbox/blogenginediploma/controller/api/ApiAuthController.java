package ru.skillbox.blogenginediploma.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.blogenginediploma.api.response.ResultResponse;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {
    @GetMapping("/check")
    public ResultResponse authCheck() {
        // TODO Проверка авторизации
        return new ResultResponse();
    }
}
