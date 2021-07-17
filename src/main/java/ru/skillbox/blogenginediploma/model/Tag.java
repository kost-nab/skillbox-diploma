package ru.skillbox.blogenginediploma.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "tag")
    private List<Tag2Post> tag2Posts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return tag2Posts.stream()
                .map(Tag2Post::getPost)
                .collect(Collectors.toList());
    }

    public void addPost(Post post) {
        tag2Posts.add(new Tag2Post(this, post));
    }

    public boolean removePost(Post post) {
        Optional<Tag2Post> tag2Post = tag2Posts.stream()
                .filter(tp -> tp.getPost().equals(post))
                .findFirst();
        if (tag2Post.isEmpty()) {
            return false;
        }
        tag2Posts.remove(tag2Post.get());
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
