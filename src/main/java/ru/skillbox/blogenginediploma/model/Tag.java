package ru.skillbox.blogenginediploma.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "tag")
    private List<Tag2Post> tag2Posts;

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
}
