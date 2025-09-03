CREATE TABLE patio (
    id_patio BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    capacidade_maxima INT NOT NULL
);