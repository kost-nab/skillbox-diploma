package ru.skillbox.blogenginediploma.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "captcha_codes")
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

    public CaptchaCode() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaptchaCode that = (CaptchaCode) o;
        return Objects.equals(id, that.id) && Objects.equals(time, that.time) && Objects.equals(code, that.code) && Objects.equals(secretCode, that.secretCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, code, secretCode);
    }
}
