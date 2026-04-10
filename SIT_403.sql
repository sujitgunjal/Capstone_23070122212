show databases;

-- Schema design: DesignDB for instagram
-- (ER Diagram & Normalization)

create database instaSIT;
use instaSIT;

create table users(
    user_id int auto_increment primary key,
    username varchar(50) unique not null,
    email varchar(100) unique not null,
    password varchar(100),
    bio text,
    created_at timestamp default current_timestamp
);

create table posts(
    post_id int auto_increment primary key,
    user_id int,
    caption text,
    media_url varchar(225),
    created_at timestamp default current_timestamp,
    foreign key(user_id) references users(user_id)
);

create table likes(
    like_id int auto_increment primary key,
    user_id int,
    post_id int,
    created_at timestamp default current_timestamp,
    unique(user_id, post_id),
    foreign key(user_id) references users(user_id),
    foreign key(post_id) references posts(post_id)
);

create table comments(
    comment_id int auto_increment primary key,
    user_id int, 
    post_id int, 
    text text,
    created_at timestamp default current_timestamp,
    foreign key(user_id) references users(user_id),
    foreign key(post_id) references posts(post_id)
);

create table follows(
    follower_id int,
    following_id int,
    created_at timestamp default current_timestamp,
    primary key(follower_id, following_id),
    foreign key(follower_id) references users(user_id),
    foreign key(following_id) references users(user_id)
);

insert into users(username, email, password, bio) values
('onkar', 'onkarholkar@gmail.com', '12345', 'AI Dev'),
('faheem', 'faheem@gmail.com', '67890', 'Software Engineer'),
('Shubham', 'shubham@gmail.com', '3fds', 'AI Eng'),
('yash', 'yash@gmail.com', '4567', 'DS'),
('Sujit', 'sujit@bmc.com', 'bmcforlife', 'FSD');

insert into posts(user_id, caption, media_url) values
(1, 'my first post', 'img1.jpeg'),
(2, 'my home', 'img2.jpeg'),
(3, 'my office', 'img3.jpeg'),
(4, 'trek post', 'imag4.jpeg');

insert into follows(follower_id, following_id) values
(1, 2),       -- onkar follows faheem
(1, 3),       -- onkar follows shubham
(2, 3),       -- faheem follows shubham
(4, 5),       -- yash follows sujit
(5, 4);       -- sujit follows yash

insert into likes(user_id, post_id) values
(1, 2),       -- onkar likes faheem's post
(1, 3),       -- onkar likes shubham's post
(2, 1),       -- faheem likes onkar's post
(3, 4),       -- shubham likes yash's post
(5, 4);       -- sujit likes yash's post

insert into comments(user_id, post_id, text) values
(1, 2, 'nice post'),
(2, 1, 'great'),
(3, 2, 'good look'),
(5, 4, 'fire');

-- ----------------------------------------------------------

-- Real time operations

-- Q1) Shows posts of people onkar follows