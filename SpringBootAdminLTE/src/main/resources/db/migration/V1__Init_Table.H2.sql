CREATE TABLE customer
(
    id         BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    firstname  VARCHAR(50)                         NOT NULL,
    lastname   VARCHAR(255)                        NOT NULL,
    email      VARCHAR(255)                        NOT NULL UNIQUE,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO customer (id, firstname, lastname, email, added_date)
VALUES (1, 'Uchiha', 'Sasuke', 'uchiha_sasuke@hotmail.com', '2020-03-29 07:52:34'),
       (2, 'Uzumaki', 'Naruto', 'uzumaki_naruto2@hotmail.com', '2020-03-29 08:18:59'),
       (3, 'Uzumaki', 'Naruto', 'uzumaki_naruto3@hotmail.com', '2020-03-29 08:18:59'),
       (4, 'Uzumaki', 'Naruto', 'uzumaki_naruto4@hotmail.com', '2020-03-29 08:18:59'),
       (5, 'Uzumaki', 'Naruto', 'uzumaki_naruto5@hotmail.com', '2020-03-29 08:18:59'),
       (6, 'Uzumaki', 'Naruto', 'uzumaki_naruto6@hotmail.com', '2020-03-29 08:18:59'),
       (7, 'Uzumaki', 'Naruto', 'uzumaki_naruto7@hotmail.com', '2020-03-29 08:18:59'),
       (8, 'Uzumaki', 'Naruto', 'uzumaki_naruto8@hotmail.com', '2020-03-29 08:18:59'),
       (9, 'Uzumaki', 'Naruto', 'uzumaki_naruto9@hotmail.com', '2020-03-29 08:18:59'),
       (10, 'Uzumaki', 'Naruto', 'uzumaki_naruto10@hotmail.com', '2020-03-29 08:18:59'),
       (11, 'Uzumaki', 'Naruto', 'uzumaki_naruto11@hotmail.com', '2020-03-29 08:18:59'),
       (12, 'Uzumaki', 'Naruto', 'uzumaki_naruto12@hotmail.com', '2020-03-29 08:18:59'),
       (13, 'Uzumaki', 'Naruto', 'uzumaki_naruto13@hotmail.com', '2020-03-29 08:18:59'),
       (14, 'Uzumaki', 'Naruto', 'uzumaki_naruto14@hotmail.com', '2020-03-29 08:18:59'),
       (15, 'Uzumaki', 'Naruto', 'uzumaki_naruto15@hotmail.com', '2020-03-29 08:18:59'),
       (16, 'Uzumaki', 'Naruto', 'uzumaki_naruto16@hotmail.com', '2020-03-29 08:18:59'),
       (17, 'Uzumaki', 'Naruto', 'uzumaki_naruto17@hotmail.com', '2020-03-29 08:18:59'),
       (18, 'Uzumaki', 'Naruto', 'uzumaki_naruto18@hotmail.com', '2020-03-29 08:18:59'),
       (19, 'Uzumaki', 'Naruto', 'uzumaki_naruto19@hotmail.com', '2020-03-29 08:18:59'),
       (20, 'Uzumaki', 'Naruto', 'uzumaki_naruto20@hotmail.com', '2020-03-29 08:18:59');
