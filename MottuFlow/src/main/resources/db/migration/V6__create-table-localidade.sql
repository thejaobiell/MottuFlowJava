CREATE TABLE localidade (
    id_localidade BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ponto_referencia VARCHAR(100) NOT NULL,
    id_moto BIGINT NOT NULL,
    id_patio BIGINT NOT NULL,
    id_camera BIGINT NOT NULL,
    FOREIGN KEY (id_moto) REFERENCES moto(id_moto)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_patio) REFERENCES patio(id_patio)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_camera) REFERENCES camera(id_camera)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);