delete from posts;
delete from users;

INSERT INTO users (id, code, email, is_moderator, name, password, photo, reg_time)
VALUES(1, NULL, 'aa@a.aa', 0, 'test user', 'pass', '', '2020-11-17')

;
INSERT INTO posts
(id, is_active, moderation_status, `text`, `time`, title, view_count, user_id, moderator_id) VALUES
(1, 1, 'ACCEPTED', 'Some text for test', '2020-11-23 15:47:38', 'Title of message', 4, 1, NULL)
;
