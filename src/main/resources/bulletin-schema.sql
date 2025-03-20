CREATE TABLE posts (
	id 		SERIAL PRIMARY KEY,
	author 		VARCHAR(50) NOT NULL,
	password 	VARCHAR(64) NOT NULL,
	title 		VARCHAR(100) NOT NULL,
	body 		TEXT NOT NULL,
	views 		BIGINT NOT NULL,
	created_at 	TIMESTAMP NOT NULL,
	updated_at 	TIMESTAMP NOT NULL,
	deleted_at 	TIMESTAMP
);