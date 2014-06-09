CREATE TABLE applications (
  id SERIAL NOT NULL PRIMARY KEY,
  name varchar(255),
  github_url text,
  travis_url text,
  registry_url text,
  marathon_url text,
  mesos_url text,
  image_name varchar(255), 
  command varchar(255),
  created_at timestamp,
  updated_at timestamp
)
