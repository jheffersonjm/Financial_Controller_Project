-- Script de inicializacao do banco PCF
-- Cria as tabelas necessarias

CREATE TABLE IF NOT EXISTS usuario (
    id_usuario BIGSERIAL PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    email_usuario VARCHAR(100) NOT NULL UNIQUE,
    senha_usuario VARCHAR(255) NOT NULL,
    version BIGINT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS transacao (
    id_transacao BIGSERIAL PRIMARY KEY,
    descricao_transacao VARCHAR(255) NOT NULL,
    data_transacao TIMESTAMP NOT NULL,
    tipo_transacao VARCHAR(50) NOT NULL,
    version BIGINT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS logs (
    id BIGSERIAL PRIMARY KEY,
    mensagem VARCHAR(255) NOT NULL,
    data VARCHAR(255) NOT NULL,
    id_usuario BIGINT NOT NULL REFERENCES usuario(id_usuario),
    id_transacao BIGINT NOT NULL REFERENCES transacao(id_transacao),
    level VARCHAR(50) NOT NULL,
    acao VARCHAR(50) NOT NULL,
    version BIGINT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Criar indices para performance
CREATE INDEX IF NOT EXISTS idx_usuario_email ON usuario(email_usuario);
CREATE INDEX IF NOT EXISTS idx_transacao_tipo ON transacao(tipo_transacao);
CREATE INDEX IF NOT EXISTS idx_logs_usuario ON logs(id_usuario);

-- Inserir usuario de teste (opcional)
INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario, version)
VALUES ('Admin', 'admin@test.com', 'admin123', 0)
ON CONFLICT (email_usuario) DO NOTHING;
