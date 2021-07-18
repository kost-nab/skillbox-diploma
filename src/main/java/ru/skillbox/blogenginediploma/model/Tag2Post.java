package ru.skillbox.blogenginediploma.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Tag2Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Tag tag;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Post post;

    public Tag2Post(Tag tag, Post post) {
        this.tag = tag;
        this.post = post;
    }
}
