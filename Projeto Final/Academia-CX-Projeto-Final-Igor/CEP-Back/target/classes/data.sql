CREATE TABLE endereco
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    cep      VARCHAR(255) NOT NULL,
    nome     VARCHAR(255) NOT NULL,
    rua      VARCHAR(255) NOT NULL,
    bairro   VARCHAR(255) NOT NULL,
    cidade   VARCHAR(255) NOT NULL,
    estado   VARCHAR(255) NOT NULL,
    numero   INT          NOT NULL,
    datetime TIMESTAMP    NOT NULL
);

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role     VARCHAR(255)
);