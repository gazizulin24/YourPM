CREATE TABLE users(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    password VARCHAR NOT NULL,
    name VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR NOT NULL,
    role VARCHAR(10) NOT NULL
);



CREATE TABLE project(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
    deadline TIMESTAMP NOT NULL,
    priority VARCHAR NOT NULL,
    state VARCHAR NOT NULL
);


CREATE TABLE task(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    project_id INT REFERENCES project(id) ON DELETE CASCADE,
    name VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    deadline TIMESTAMP NOT NULL,
    state VARCHAR NOT NULL,
    priority VARCHAR NOT NULL
);


CREATE TABLE users_project(
    user_id INT REFERENCES users(id),
    project_id INT REFERENCES project(id),
    PRIMARY KEY (user_id, project_id)
);