CREATE TABLE moto (
    id_moto BIGINT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(10) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    fabricante VARCHAR(50) NOT NULL,
    ano INT NOT NULL,
    id_patio BIGINT NOT NULL,
    localizacao_atual VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_patio) REFERENCES patio(id_patio)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);