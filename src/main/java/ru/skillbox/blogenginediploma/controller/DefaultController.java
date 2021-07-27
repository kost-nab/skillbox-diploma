package ru.skillbox.blogenginediploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping({"/", "/posts/**"})
    public String index() {
        return "index";
    }
}
