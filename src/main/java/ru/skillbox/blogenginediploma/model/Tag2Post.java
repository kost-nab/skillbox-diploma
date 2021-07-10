package ru.skillbox.blogenginediploma.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tag2Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Tag tag;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Post post;

    public Tag2Post() { }

    public Tag2Post(Tag tag, Post post) {
        this.tag = tag;
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag2Post tag2Post = (Tag2Post) o;
        return Objects.equals(id, tag2Post.id) && Objects.equals(tag, tag2Post.tag) && Objects.equals(post, tag2Post.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, post);
    }
}
