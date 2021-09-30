package ru.skillbox.blogenginediploma.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PostAnnounceTest {
    private static final Post testPost = new Post();
    private static final String shortAnnounce =
            "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\".";

    @ParameterizedTest
    @ValueSource(strings = {
            "<p>В России полным ходом идет вакцинация, привиться можно двумя вариантами &quot;Спутника&quot;, &quot;ЭпиВакКороной&quot; и &quot;КовиВаком&quot;.</p>",
            "<p>В России <b>полным <i>ходом</b> идет вакцинация</i>, привиться<br>можно двумя вариантами &quot;Спутника&quot;, &quot;ЭпиВакКороной&quot; и &quot;КовиВаком&quot;.</p>",
            "В России полным ходом идет вакцинация, привиться можно двумя вариантами \"Спутника\", \"ЭпиВакКороной\" и \"КовиВаком\"."
    })
    void shortAnnounceTest(String text) {
        testPost.setText(text);
        assertEquals(shortAnnounce, testPost.getAnnounce());
    }

    @Test
    void longAnnounceTest() {
        testPost.setText("<p>Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития <a href=\"https://smotrim.ru/article/2597355\">постковидного синдрома</a>. По мнению эксперта, этот синдром чаще развивается у женщин.</p>");
        String expectedAnnounce = "Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития...";
        assertEquals(expectedAnnounce, testPost.getAnnounce());
    }
}