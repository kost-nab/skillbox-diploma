package ru.skillbox.blogenginediploma.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "posts")
public class Post {
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

    public Post() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ModerationStatus getModerationStatus() {
        return moderationStatus;
    }

    public void setModerationStatus(ModerationStatus moderationStatus) {
        this.moderationStatus = moderationStatus;
    }

    public User getModerator() {
        return moderator;
    }

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

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
