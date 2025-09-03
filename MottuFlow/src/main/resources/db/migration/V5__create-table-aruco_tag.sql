CREATE TABLE aruco_tag (
    id_tag BIGINT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    id_moto BIGINT NOT NULL,
    FOREIGN KEY (id_moto) REFERENCES moto(id_moto)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);