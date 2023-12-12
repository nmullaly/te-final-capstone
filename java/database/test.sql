SELECT * FROM users;
SELECT * FROM profiles;
SELECT * FROM reviews;
SELECT * FROM watchlist;


-- INSERT INTO users (username, password_hash, role) VALUES ('test', 'asdfjklasdfjklasdfjkl', 'TEST');
-- INSERT INTO profiles (username) VALUES ('test');
-- INSERT INTO reviews (profile_id, movie_id, body, rating) VALUES (3, 5, 'masterpiece', 5);

-- UPDATE profiles SET
-- 	bio = 'i love movie',
-- 	favorite_film = 'Annette',
-- 	favorite_snack = 'Takis',
-- 	favorite_genres = 'Psychological Thriller'
-- 	WHERE profile_id = 3;


-- INSERT INTO watchlist (profile_id, movie_id) VALUES (1, 18)