CREATE SEQUENCE IF NOT EXISTS foto_pessoa_id_seq START WITH 2000 INCREMENT BY 1;

CREATE TABLE foto_pessoa (
    fp_id INT PRIMARY KEY DEFAULT nextval('foto_pessoa_id_seq'),
    pes_id INT NOT NULL,
    fp_data DATE,
    fp_bucket VARCHAR(50),
    fp_hash VARCHAR(50),
    CONSTRAINT fk_foto_pessoa_pessoa FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id) ON DELETE CASCADE
);

