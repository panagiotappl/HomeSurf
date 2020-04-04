-- main.user_account definition

-- Drop table

-- DROP TABLE main.user_account;

CREATE TABLE main.user_account (
	id uuid NOT NULL,
	email varchar(255) NOT NULL,
	mobile varchar(255) NULL,
	"name" varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	surname varchar(255) NOT NULL,
	username varchar(255) NOT NULL,
	CONSTRAINT uk_castjbvpeeus0r8lbpehiu0e4 UNIQUE (username),
	CONSTRAINT uk_hl02wv5hym99ys465woijmfib UNIQUE (email),
	CONSTRAINT user_account_pkey PRIMARY KEY (id)
);


-- main.user_role definition

-- Drop table

-- DROP TABLE main.user_role;

CREATE TABLE main.user_role (
	id serial NOT NULL,
	"type" varchar(255) NOT NULL,
	CONSTRAINT uk_5dw7cievhogf8vopr2k1m16dl UNIQUE (type),
	CONSTRAINT user_role_pkey PRIMARY KEY (id)
);


-- main.user_role_rel definition

-- Drop table

-- DROP TABLE main.user_role_rel;

CREATE TABLE main.user_role_rel (
	user_id uuid NOT NULL,
	role_id int4 NOT NULL,
	CONSTRAINT user_role_rel_pkey PRIMARY KEY (user_id, role_id),
	CONSTRAINT fk61qowbfcws4j528p6mabx7hja FOREIGN KEY (role_id) REFERENCES main.user_role(id),
	CONSTRAINT fkr25n7qssh7x5slng9ag2cbvwd FOREIGN KEY (user_id) REFERENCES main.user_account(id)
);