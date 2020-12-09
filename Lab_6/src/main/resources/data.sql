INSERT INTO users (username, password, biography) VALUES ('user', '123', 'Admin') ON CONFLICT DO NOTHING;
INSERT INTO user_aut (username, role) VALUES ('user', 'USER') ON CONFLICT DO NOTHING;