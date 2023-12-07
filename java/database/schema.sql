BEGIN TRANSACTION;

DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS watchlist;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profiles (
	profile_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	points int DEFAULT 0,
	bio varchar(200),
	favorite_film varchar(50),
	favorite_snack varchar(50),
	favorite_genres varchar(100),
	avatar_id INT,
	constraint pk_profiles PRIMARY KEY (profile_id),
	constraint fk_profiles_users FOREIGN KEY (profile_id) references users (user_id)
);

CREATE TABLE reviews (
	review_id SERIAL,
	profile_id int NOT NULL,
	movie_id int NOT NULL,
	headline VARCHAR(50) NOT NULL,
	body VARCHAR(2000) NOT NULL,
	rating int NOT NULL CHECK (rating >= 0 AND rating <= 5),
	score int NOT NULL DEFAULT 0,
	constraint pk_reviews PRIMARY KEY (review_id),
	constraint fk_reviews_profiles FOREIGN KEY (profile_id) REFERENCES profiles (profile_id)
);

CREATE TABLE watchlist (
	profile_id int NOT NULL,
	movie_id int NOT NULL,
	constraint pk_watchlist_profiles PRIMARY KEY (profile_id, movie_id),
	constraint fk_profiles FOREIGN KEY (profile_id) REFERENCES profiles (profile_id)
);

COMMIT TRANSACTION;

-- ROLLBACK;
