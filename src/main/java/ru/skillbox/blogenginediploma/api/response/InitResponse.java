package ru.skillbox.blogenginediploma.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitResponse {
    @Value("${blog.title}")
    private String title;

    @Value("${blog.subtitle}")
    private String subtitle;

    @Value("${blog.phone}")
    private String phone;

    @Value("${blog.email}")
    private String email;

    @Value("${blog.copyright}")
    private String copyright;

    @Value("${blog.copyrightFrom}")
    private String copyrightFrom;
}
