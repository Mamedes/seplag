CREATE SEQUENCE IF NOT EXISTS lotacao_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE lotacao (
    lot_id INT PRIMARY KEY DEFAULT nextval('lotacao_id_seq'),
    pes_id INT NOT NULL,
    unid_id INT NOT NULL,
    lot_data_lotacao DATE NOT NULL,
    lot_data_remocao DATE,
    lot_portaria VARCHAR(100),
    CONSTRAINT fk_lotacao_pessoa FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id) ON DELETE CASCADE,
    CONSTRAINT fk_lotacao_unidade FOREIGN KEY (unid_id) REFERENCES unidade (unid_id) ON DELETE CASCADE
);

CREATE TABLE unidade_endereco (
    unid_id INT NOT NULL,
    end_id INT NOT NULL,
    PRIMARY KEY (unid_id, end_id),
    CONSTRAINT fk_unidade_endereco_unidade FOREIGN KEY (unid_id) REFERENCES unidade (unid_id) ON DELETE CASCADE,
    CONSTRAINT fk_unidade_endereco_endereco FOREIGN KEY (end_id) REFERENCES endereco (end_id) ON DELETE CASCADE
);

CREATE TABLE pessoa_endereco (
    pes_id INT NOT NULL,
    end_id INT NOT NULL,
    PRIMARY KEY (pes_id, end_id),
    CONSTRAINT fk_pessoa_endereco_pessoa FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id) ON DELETE CASCADE,
    CONSTRAINT fk_pessoa_endereco_endereco FOREIGN KEY (end_id) REFERENCES endereco (end_id) ON DELETE CASCADE
);

