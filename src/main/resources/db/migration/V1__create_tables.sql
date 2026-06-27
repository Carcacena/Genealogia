CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    nome_id BIGINT,  -- referência ao pai/casal anterior
    nota VARCHAR(255) NULL,  -- campo para descrição ou observações
    CONSTRAINT fk_nome FOREIGN KEY (nome_id) REFERENCES pessoa(id)
);