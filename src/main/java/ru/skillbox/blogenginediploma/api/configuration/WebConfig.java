package ru.skillbox.blogenginediploma.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.skillbox.blogenginediploma.api.request.post.SortModeConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SortModeConverter());
//        WebMvcConfigurer.super.addFormatters(registry);

    }
}
