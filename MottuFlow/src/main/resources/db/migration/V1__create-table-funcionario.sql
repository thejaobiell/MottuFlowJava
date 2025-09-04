CREATE TABLE funcionario (
    id_funcionario BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    cargo VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    refresh_token VARCHAR(255) DEFAULT NULL,
    expiracao_refresh_token DATETIME DEFAULT NULL
);

INSERT INTO funcionario (
    nome,
    cpf,
    cargo,
    telefone,
    email,
    senha,
    refresh_token,
    expiracao_refresh_token
) VALUES (
    'CONTA ADMIN',
    '000.000.000-00',
    'Administrador',
    '(00) 00000-0000',
    'admin@email.com',
    '$2a$12$HkHTbCOCrUW55EXH8MjZfO.8MpjpyKWsVd.4oM1xCbceqtCpaqOFK',
    NULL,
    NULL
);