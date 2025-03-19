CREATE SEQUENCE IF NOT EXISTS pessoa_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE pessoa (
    pes_id INT PRIMARY KEY DEFAULT nextval('pessoa_id_seq'),
    pes_nome VARCHAR(200) NOT NULL,
    pes_data_nascimento DATE,
    pes_sexo VARCHAR(9),
    pes_mae VARCHAR(200),
    pes_pai VARCHAR(200)
);