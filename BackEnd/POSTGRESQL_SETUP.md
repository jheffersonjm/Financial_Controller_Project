# Configuração PostgreSQL - Financial Controller

## Opção 1: Usando Docker (Recomendado)

### Pré-requisitos
- Docker Desktop instalado e rodando

### Passos

1. **Acesse a pasta do BackEnd:**
```powershell
cd BackEnd\BackEnd
```

2. **Inicie o PostgreSQL com Docker Compose:**
```powershell
docker compose up -d db
```

3. **Verifique se está rodando:**
```powershell
docker compose ps
```

O banco será criado automaticamente com:
- **Usuário:** postgres
- **Senha:** 02022006
- **Database:** PCF
- **Porta:** 3000 (mapeada para 5432 interno)
- **Tabelas:** Usuario, Conta, Transacao, Logs (criadas automaticamente)

4. **Inicie a aplicação Spring Boot:**
```powershell
mvn spring-boot:run
```

---

## Opção 2: PostgreSQL Local (Instalado no Windows)

### Pré-requisitos
- PostgreSQL instalado localmente
- Porta 3000 disponível

### Passos

1. **Crie o banco de dados manualmente usando psql:**
```powershell
psql -U postgres -c "CREATE DATABASE PCF;"
```

2. **Execute o script de inicialização:**
```powershell
psql -U postgres -d PCF -f init.sql
```

3. **Inicie a aplicação Spring Boot:**
```powershell
mvn spring-boot:run
```

---

## Testando a Conexão

### Via cURL (criar usuário)
```powershell
$body = @{
    nomeUsuario = "João Silva"
    emailUsuario = "joao@example.com"
    senhaUsuario = "senha123"
} | ConvertTo-Json

curl -X POST http://localhost:8080/usuarios/salvarUsuario `
  -H "Content-Type: application/json" `
  -d $body
```

### Respostas Esperadas

**Sucesso (201 Created):**
```json
{
  "idUsuario": 1,
  "nomeUsuario": "João Silva",
  "emailUsuario": "joao@example.com",
  "senhaUsuario": "senha123"
}
```

**Email Duplicado (409 Conflict):**
```json
{
  "timestamp": "2026-03-11T16:38:09.052Z",
  "status": 409,
  "error": "Conflict",
  "message": "E-mail já cadastrado."
}
```

---

## Parar o PostgreSQL (Docker)

```powershell
docker compose down
```

Para remover o volume de dados também:
```powershell
docker compose down -v
```

---

## Variáveis de Conexão

| Propriedade | Valor |
|---|---|
| `spring.datasource.url` | `jdbc:postgresql://localhost:3000/PCF` |
| `spring.datasource.username` | `postgres` |
| `spring.datasource.password` | `02022006` |
| `spring.jpa.hibernate.ddl-auto` | `update` (cria/atualiza tabelas automaticamente) |

---

## Troubleshooting

### Erro: "Connection refused"
- Verifique se o PostgreSQL está rodando
- Docker: `docker compose ps`
- Local: Abra SQL Shell (psql) e teste a conexão

### Erro: "Database PCF does not exist"
- Docker: O init.sql deve ter sido executado. Verifique logs: `docker compose logs db`
- Local: Execute manualmente: `psql -U postgres -c "CREATE DATABASE PCF;"`

### Erro: "Unique constraint violation on email"
- O email já existe no banco
- Use um email diferente para novo usuário

---

## Dados de Teste (Admin Padrão)

Após executar o init.sql:
- **Email:** admin@test.com
- **Senha:** admin123
- **Nome:** Admin

