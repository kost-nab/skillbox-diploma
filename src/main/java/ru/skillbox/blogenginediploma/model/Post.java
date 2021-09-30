package ru.skillbox.blogenginediploma.model;

import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jsoup.Jsoup;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    private static final int ANNOUNCE_LENGTH = 150;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TINYINT",nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('NEW', 'ACCEPTED', 'DECLINED')", nullable = false)
    private ModerationStatus moderationStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "moderator_id")
    private User moderator;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "user_id")
    private User author;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @Column(nullable = false)
    private int viewCount;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "post", fetch = FetchType.EAGER)
    private List<Tag2Post> tag2Posts;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "post")
    private List<Comment> comments;

    @Formula("(SELECT count(pv.*) FROM post_votes pv WHERE pv.post_id = id AND pv.value = 1)")
    @Setter(AccessLevel.NONE)
    private long likeCount;
    @Formula("(SELECT count(pv.*) FROM post_votes pv WHERE pv.post_id = id AND pv.value = -1)")
    @Setter(AccessLevel.NONE)
    private long dislikeCount;
    @Formula("(SELECT count(pc.*) FROM post_comments pc WHERE pc.post_id = id)")
    @Setter(AccessLevel.NONE)
    private long commentCount;

    public List<Tag> getTags() {
        return tag2Posts.stream()
                .map(Tag2Post::getTag)
                .collect(Collectors.toList());
    }

    public void addTag(Tag tag) {
        tag2Posts.add(new Tag2Post(tag, this));
    }

    public boolean removeTag(Tag tag) {
        Optional<Tag2Post> tag2Post = tag2Posts.stream()
                .filter(tp -> tp.getTag().equals(tag))
                .findFirst();
        if (tag2Post.isEmpty()) {
            return false;
        }
        tag2Posts.remove(tag2Post.get());
        return true;
    }

    public String getAnnounce() {
        String plainText = Jsoup.parse(text).text();
        if (plainText.length() <= ANNOUNCE_LENGTH) {
            return plainText;
        }
        int lastSpaceIndex = plainText.lastIndexOf(" ", ANNOUNCE_LENGTH - 1);
        String announce = lastSpaceIndex == -1 ?
                plainText : plainText.substring(0, lastSpaceIndex);
        return announce.concat("...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(author, post.author) && Objects.equals(time, post.time) && Objects.equals(title, post.title) && Objects.equals(text, post.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, time, title, text);
    }
}
