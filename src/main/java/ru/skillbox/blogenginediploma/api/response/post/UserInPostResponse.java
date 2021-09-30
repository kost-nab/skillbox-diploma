package ru.skillbox.blogenginediploma.api.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInPostResponse {
    private int id;
    private String name;
}
