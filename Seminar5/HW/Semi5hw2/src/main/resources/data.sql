-- Вставка трех пользователей в таблицу users
INSERT INTO users (username, password, email, role)
VALUES
    ('user1', 'password1', 'user1@example.com', 'ROLE_USER');

INSERT INTO users (username, password, email, role)
VALUES
    ('user2', 'password2', 'user2@example.com', 'ROLE_USER');

INSERT INTO users (username, password, email, role)
VALUES
    ('admin', 'admin123', 'admin@example.com', 'ROLE_ADMIN');

-- Вставка трех проектов в таблицу projects
INSERT INTO project (name, description, created_date)
VALUES
    ('Project A', 'Description for Project A', '2024-02-04');

INSERT INTO project (name, description, created_date)
VALUES
    ('Project B', 'Description for Project B', '2024-02-04');

INSERT INTO project (name, description, created_date)
VALUES
    ('Project C', 'Description for Project C', '2024-02-04');