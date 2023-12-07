-- SELECT * FROM users;
-- SELECT * FROM profiles;
-- SELECT * FROM reviews;


-- INSERT INTO users (username, password_hash, role) VALUES ('test', 'asdfjklasdfjklasdfjkl', 'TEST');
-- INSERT INTO profiles (username) VALUES ('test');
-- INSERT INTO reviews (profile_id, movie_id, body, rating) VALUES (3, 5, 'masterpiece', 5);

-- UPDATE profiles SET bio = 'i love movie' WHERE profile_id = 3;$2a$10$t0I.mP7HanMr9L8SGZXP/ODXDOk8I0a2mdwA5Q7Yd1oBDM12yNeqK

SELECT * FROM reviews WHERE movie_id = 5