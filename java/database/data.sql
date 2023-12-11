BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('nate','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO profiles (username) VALUES ('user');
INSERT INTO profiles (username) VALUES ('admin');
INSERT INTO profiles (username) VALUES ('nate');

INSERT INTO reviews (profile_id, movie_id, headline, body, rating) VALUES
	(3, 579974, 'masterpiece', 'greatest film i ever did see', 4);

INSERT INTO watchlist (profile_id, movie_id) VALUES
	(1, 3),
	(1, 4),
	(2, 7);
	
-- INSERT INTO admin_movies (title) VALUES ('Pricemaster');

COMMIT TRANSACTION;
