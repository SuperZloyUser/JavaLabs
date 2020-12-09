INSERT INTO users (username, password, biography) VALUES ('admin', '123', 'Admin') ON CONFLICT DO NOTHING;
INSERT INTO user_aut (username, role) VALUES ('admin', 'ADMIN') ON CONFLICT DO NOTHING;