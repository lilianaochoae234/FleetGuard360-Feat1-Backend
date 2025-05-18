INSERT INTO usuario (email, password_hash, rol, bloqueo_hasta, intentos_fallidos) VALUES
('admin@mail.com', '$2a$10$e0MYzXyjpJS7Pd0RVvHwHeFx5gkYgRyl8M/9Sx4GJyz49Fbi5Ce6G', 'ADMIN', NULL, 0),
('juan@mail.com',  '$2a$10$7qJx7u5dP/rG8q/e8MCwE.ZJ7SoOKLwUqQkpwGk1FV4g1CrfB/rEy', 'CONDUCTOR', NULL, 1),
('ana@mail.com',   '$2a$10$Dc3e0Ql6Nf7HmyE8/1z6qOHrOnuwp8OxuGqXUd0ce9ozMvDoy4cMe', 'CONDUCTOR', '2025-05-18T10:00:00', 3);