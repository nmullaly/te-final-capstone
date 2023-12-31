BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('nate','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('AdalynDanger','$2a$10$25rilUrz2gt4jssWJgHIwukj7efQbSECVszTH2IxLl.dBC/gA6DeW','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('lovrek','$2a$10$Jla2EgIaAS/A83zdGCBInu0EDDAbw1mnNgIzFSb1cRWiJVYVinVE6','ROLE_USER');

INSERT INTO profiles (username) VALUES ('user');
INSERT INTO profiles (username) VALUES ('admin');
INSERT INTO profiles (username, bio, favorite_film, favorite_snack, favorite_genres) VALUES 
	('nate', 'I watched 40 movies in the last 30 days.', 'Nope', 'Takis', 'Psychological Thriller'),
	('AdalynDanger', 'A force of chaos in a world of peace', 'The Matrix', 'Popcorn', null),
	('lovrek', 'i love movies!!!!', null, null, null);

INSERT INTO reviews (profile_id, movie_id, headline, body, rating) VALUES
	(3, 579974, 'masterpiece', 'greatest film i ever did see', 5),
	(3, 124532, 'this is a movie fr', 'fr fr', 4),
	(3, 124532, 'what did i just watch', 'this is an experience', 4),
	(3, 124532, 'awful', 'i hated it', 1),
	(3, 49051, 'Great film', 'This is a very good film with a twist ending. But I really dont want to spoil the ending for anyone so I wont say much. But this was a great film, lots of thrills and again a very exciting ending twist at the end that I will not reveal because everyone should experience it for themselves. All I can say is this was a really fun film to watch and very good.', 5);

INSERT INTO watchlist (profile_id, movie_id) VALUES
	(3, 579974),
	(3, 619778),
	(3, 458723),
	(3, 536554),
	(3, 475557);
	
-- INSERT INTO admin_movies (title) VALUES ('Pricemaster');

COMMIT TRANSACTION;
