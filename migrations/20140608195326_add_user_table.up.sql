CREATE TABLE users
(
  id SERIAL NOT NULL PRIMARY KEY,
  login varchar(255) UNIQUE,
  created_at timestamp,
  updated_at timestamp,
  token varchar(255),
  token_expire_at timestamp,
  permission_bit boolean
);
