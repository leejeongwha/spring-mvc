CREATE TABLE IF NOT EXISTS board_user ( 
 id varchar(40) primary key,
 passwd varchar(40) not null,
 user_name varchar(30) not null,
 age integer not null,
 role varchar(15) not null
);

INSERT INTO board_user
(id, passwd, user_name, age, role)
VALUES
('admin', 'admin', 'admin', 99, 'ADMIN');