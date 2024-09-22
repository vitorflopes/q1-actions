CREATE TABLE itens (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO itens (name, description) VALUES
    ('Item 1', 'Descrição do Item 1'),
    ('Item 2', 'Descrição do Item 2'),
    ('Item 3', 'Descrição do Item 3');
