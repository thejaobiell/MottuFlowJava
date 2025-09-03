CREATE TABLE funcionario (
    id_funcionario BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    token VARCHAR(64) DEFAULT NULL,
    expiracao_token DATETIME DEFAULT NULL,
    refresh_token VARCHAR(64) DEFAULT NULL,
    expiracao_refresh_token DATETIME DEFAULT NULL
);