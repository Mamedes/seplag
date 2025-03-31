CREATE SEQUENCE IF NOT EXISTS unidade_id_seq START WITH 3000 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS cidade_id_seq START WITH 5565 INCREMENT BY 1;
CREATE SEQUENCE IF NOT EXISTS endereco_id_seq START WITH 5000 INCREMENT BY 1;

CREATE TABLE servidor_temporario (
    pes_id INT PRIMARY KEY,
    st_data_admissao DATE,
    st_data_demissao DATE,
    CONSTRAINT fk_servidor_temporario_pessoa FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id) ON DELETE CASCADE
);

CREATE TABLE servidor_efetivo (
    pes_id INT PRIMARY KEY,
    se_matricula VARCHAR(20) NOT NULL ,
    CONSTRAINT fk_servidor_efetivo_pessoa FOREIGN KEY (pes_id) REFERENCES pessoa (pes_id) ON DELETE CASCADE
);

CREATE TABLE unidade (
    unid_id INT PRIMARY KEY DEFAULT nextval('unidade_id_seq'),
    unid_nome VARCHAR(200) NOT NULL,
    unid_sigla VARCHAR(20) NOT NULL
);

CREATE TABLE cidade (
    cid_id  INT PRIMARY KEY DEFAULT nextval('cidade_id_seq'),
    cid_nome VARCHAR(200) NOT NULL,
    cid_uf CHAR(2) NOT NULL
);

CREATE TABLE endereco (
    end_id INT PRIMARY KEY DEFAULT nextval('endereco_id_seq'),
    end_tipo_logradouro VARCHAR(50),
    end_logradouro VARCHAR(200),
    end_numero INT,
    end_bairro VARCHAR(100),
    cid_id INT NOT NULL,
    CONSTRAINT fk_endereco_cidade FOREIGN KEY (cid_id) REFERENCES cidade (cid_id) ON DELETE CASCADE
);


