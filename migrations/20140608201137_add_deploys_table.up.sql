CREATE TABLE versions
(
  id SERIAL PRIMARY KEY NOT NULL,
  git_ref varchar(255),
  github_url text,
  travis_url text,
  registry_url text,
  mesos_url text,
  marathon_url text,
  deployed boolean,
  deployer integer REFERENCES users( id ) ON DELETE CASCADE
)
