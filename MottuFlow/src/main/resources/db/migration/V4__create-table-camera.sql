CREATE TABLE camera (
    id_camera BIGINT PRIMARY KEY AUTO_INCREMENT,
    status_operacional VARCHAR(20) NOT NULL,
    localizacao_fisica VARCHAR(255) NOT NULL,
    id_patio BIGINT NOT NULL,
    FOREIGN KEY (id_patio) REFERENCES patio(id_patio)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);