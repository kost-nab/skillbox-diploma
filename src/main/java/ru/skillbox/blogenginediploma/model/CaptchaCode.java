package ru.skillbox.blogenginediploma.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "captcha_codes")
@Data
@NoArgsConstructor
public class CaptchaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(columnDefinition = "TINYTEXT", nullable = false)
    private String code;

    @Column(columnDefinition = "TINYTEXT", nullable = false)
    private String secretCode;
}
