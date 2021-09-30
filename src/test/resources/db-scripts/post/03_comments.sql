INSERT INTO PUBLIC.POST_COMMENTS
( ID, TEXT, `TIME`, USER_ID, PARENT_ID, POST_ID) VALUES
-- post 1 - 7
(1, 'Some comment text', '2020-11-24 11:47', 1, NULL, 1),
(2, 'Some comment text', '2020-11-24 11:47', 2, NULL, 1),
(3, 'Some comment text', '2020-11-24 11:47', 3, NULL, 1),
(4, 'Some comment text', '2020-11-24 11:47', 4, NULL, 1),
(5, 'Some comment text', '2020-11-24 11:47', 5, NULL, 1),
(6, 'Some comment text child of 3', '2020-11-24 11:47', 6, 3, 1),
(7, 'Some comment text', '2020-11-24 11:47', 7, NULL, 1),
-- post 2 - 4
(8, 'Some comment text', '2020-11-24 11:47', 1, NULL, 2),
(9, 'Some comment text', '2020-11-24 11:47', 2, NULL, 2),
(10, 'Some comment text', '2020-11-24 11:47', 3, NULL, 2),
(11, 'Some comment text', '2020-11-24 11:47', 8, NULL, 2),
-- post 3 - 5
(12, 'Some comment text', '2020-11-24 11:47', 1, NULL, 3),
(13, 'Some comment text', '2020-11-24 11:47', 2, NULL, 3),
(14, 'Some comment text', '2020-11-24 11:47', 3, NULL, 3),
(15, 'Some comment text', '2020-11-24 11:47', 4, NULL, 3),
(16, 'Some comment text', '2020-11-24 11:47', 5, NULL, 3),
-- post 4 - 1
(17, 'Some comment text', '2020-11-24 11:47', 7, NULL, 4),
-- post 5 - 2
(18, 'Some comment text', '2020-11-24 11:47', 1, NULL, 5),
(19, 'Some comment text', '2020-11-24 11:47', 2, NULL, 5),
-- post 6 - 8
(20, 'Some comment text', '2020-11-24 11:47', 1, NULL, 6),
(21, 'Some comment text', '2020-11-24 11:47', 2, NULL, 6),
(22, 'Some comment text', '2020-11-24 11:47', 3, NULL, 6),
(23, 'Some comment text', '2020-11-24 11:47', 4, NULL, 6),
(24, 'Some comment text', '2020-11-24 11:47', 5, NULL, 6),
(25, 'Some comment text', '2020-11-24 11:47', 6, NULL, 6),
(26, 'Some comment text', '2020-11-24 11:47', 7, NULL, 6),
(27, 'Some comment text', '2020-11-24 11:47', 8, NULL, 6),
-- post 8 - 3
(28, 'Some comment text', '2020-11-24 11:47', 9, NULL, 8),
(29, 'Some comment text', '2020-11-24 11:47', 7, NULL, 8),
(30, 'Some comment text', '2020-11-24 11:47', 4, NULL, 8)
;
