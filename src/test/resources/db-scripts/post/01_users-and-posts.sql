INSERT INTO users (id, code, email, is_moderator, name, password, photo, reg_time)
VALUES
(1, NULL, 'aa@a.aa',  0, 'test user',  'pass', NULL, '2020-11-17'),
(2, NULL, 'aa2@a.aa', 0, 'test user2', 'pass', NULL, '2020-11-17'),
(3, NULL, 'aa3@a.aa', 0, 'test user3', 'pass', NULL, '2020-11-17'),
(4, NULL, 'aa4@a.aa', 0, 'test user4', 'pass', NULL, '2020-11-17'),
(5, NULL, 'aa5@a.aa', 0, 'test user5', 'pass', NULL, '2020-11-17'),
(6, NULL, 'aa6@a.aa', 0, 'test user6', 'pass', NULL, '2020-11-17'),
(7, NULL, 'aa7@a.aa', 0, 'test user7', 'pass', NULL, '2020-11-17'),
(8, NULL, 'aa8@a.aa', 0, 'test user8', 'pass', NULL, '2020-11-17'),
(9, NULL, 'aa9@a.aa', 0, 'test user9', 'pass', NULL, '2020-11-17')
;
INSERT INTO posts
(id, is_active, moderation_status, `text`, `time`, title, view_count, user_id, moderator_id) VALUES
(1, 1,  'ACCEPTED',
    '<p>В России <b>полным <i>ходом</b> идет вакцинация</i>, привиться<br>можно двумя вариантами &quot;Спутника&quot;, &quot;ЭпиВакКороной&quot; и &quot;КовиВаком&quot;.</p>',
    '2020-11-12 15:47', 'Title of the first message', 47, 1, NULL),
(2, 1,  'ACCEPTED',
    '<p>Заместитель директора по клинической работе ФБУН ЦНИИ эпидемиологии Роспотребнадзора Антонина Плоскирева рассказала о факторах риска развития <a href="https://smotrim.ru/article/2597355">постковидного синдрома</a>. По мнению эксперта, этот синдром чаще развивается у женщин.</p>',
    '2020-11-12 15:47:10', 'Title of the big message', 14, 1, NULL),
(3, 1,  'ACCEPTED', 'Some text for test 3',  '2020-11-12 15:47:20', 'Title of message', 7, 4, NULL),
(4, 1,  'DECLINED', 'Some text for test 5',  '2020-11-14 15:48:10', 'Title of message', 15, 4, NULL),
(5, 1,  'NEW',  'Some text for test 5 new',  '2020-11-14 15:48:15', 'Title of message', 3, 7, NULL),
(6, 1,  'ACCEPTED', 'Some text for test 6',  '2020-11-14 15:48:24', 'Title of message', 2, 3, NULL),
(7, 1,  'ACCEPTED', 'Some <b>text</b> for test 7',  '2020-11-20 15:53:38', 'Title of message', 24, 1, NULL),
(8, 1,  'ACCEPTED', 'Some text for test 8',  '2020-11-23 10:47:38', 'Title of message', 38, 1, NULL)
;
