CREATE TABLE todos (
    id BIGINT PRIMARY KEY UNIQUE NOT NULL,
    title TEXT NOT NULL,
    description TEXT
);