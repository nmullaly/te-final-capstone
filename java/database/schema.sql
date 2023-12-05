BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS profiles;

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
	bio varchar(200),
	favorite_film varchar(50),
	favorite_snack varchar(50),
	constraint pk_profiles PRIMARY KEY (profile_id),
	constraint fk_profiles_users FOREIGN KEY (profile_id) references users (user_id)
);

COMMIT TRANSACTION;
