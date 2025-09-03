CREATE TABLE registro_status (
    id_status BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo_status VARCHAR(50) NOT NULL,
    descricao VARCHAR(255),
    data_status DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_moto BIGINT NOT NULL,
    id_funcionario BIGINT NOT NULL,
    FOREIGN KEY (id_moto) REFERENCES moto(id_moto)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);