# Documentação Técnica - Financial Controller (BackEnd)

## 1. Visão geral

Este projeto é uma API backend em Spring Boot para gerenciamento de usuários, contas e transações financeiras.

Status atual:
- Camada de persistência (JPA) implementada para `ModelUsuario`, `ModelConta` e `ModelTransacao`.
- Serviços implementados para usuários, contas e transações.
- Endpoint REST implementado para usuários.
- Swagger/OpenAPI disponível via Springdoc.

## 2. Stack técnica

- Java (projeto configurado com `java.version` 25)
- Spring Boot `4.0.3`
- Spring Data JPA
- Spring Web MVC
- H2 (runtime)
- PostgreSQL (runtime)
- Springdoc OpenAPI UI `2.8.6`
- Maven Wrapper

## 3. Estrutura de pacotes

- `br.com.jhefferson.BackEnd.Controller` → endpoints REST
- `br.com.jhefferson.BackEnd.Service` → regras de negócio
- `br.com.jhefferson.BackEnd.Repository` → acesso a dados
- `br.com.jhefferson.BackEnd.model` → entidades JPA

## 4. Modelo de domínio

### 4.1 Usuário (`ModelUsuario`)
Tabela: `Usuario`

Campos:
- `idUsuario` (`Long`) - PK, auto increment
- `nomeUsuario` (`String`, 100)
- `emailUsuario` (`String`, 100, único)
- `senhaUsuario` (`String`, 255)

### 4.2 Conta (`ModelConta`)
Tabela: `Conta`

Campos:
- `idConta` (`Long`) - PK, auto increment
- `nomeConta` (`String`, 100)
- `idUsuarios` (`ModelUsuario`) - FK `id_usuario`
- `saldoConta` (`BigDecimal`, precision 10, scale 2)

### 4.3 Transação (`ModelTransacao`)
Tabela: `Transacao`

Campos:
- `idTransacao` (`Long`) - PK, auto increment
- `descricaoTransacao` (`String`, coluna `valor_transacao`)
- `dataTransacao` (`LocalTime`)
- `idConta` (`ModelConta`) - FK `id_conta`

## 5. API atual

Base URL local: `http://localhost:8080`

### 5.1 Usuários

Controller: `ControllerUsuarios`

#### GET `/usuarios/BuscarUsuarios`
Parâmetros de query:
- `nomeUsuario`
- `emailUsuario`

Retorno atual:
- `String` com a senha do usuário quando nome+email conferem
- `null` quando não encontra

> Observação: este comportamento expõe senha em texto puro e não é recomendado para produção.

#### POST `/usuarios/salvarUsuario`
Body JSON:

```json
{
  "nomeUsuario": "João",
  "emailUsuario": "joao@email.com",
  "senhaUsuario": "123456"
}
```

Retorno:
- `ModelUsuario` salvo

## 6. Serviços implementados

### 6.1 `ServiceUsuarios`
Funções principais:
- `criarUsuario(...)`
- `atualizarUsuario(...)`
- `deletarUsuario(...)`
- `obterUsuarioPorId(...)`
- `obterUsuario(emailUsuario)`
- `PegarSenha(nomeUsuario, emailUsuario)`

### 6.2 `ServiceContas`
Funções principais:
- `criarConta(...)`
- `atualizarConta(...)`
- `deletarConta(...)`
- `obterContaPorId(...)`

### 6.3 `ServiceTransacao`
Funções principais:
- `criarTransacao(...)`
- `atualizarTransacao(...)`
- `deletarTransacao(...)`
- `obterTransacaoPorId(...)`

## 7. Executar localmente

### 7.1 Pré-requisitos
- JDK 17+ (Spring Boot 4 exige Java 17 ou superior)
- Maven Wrapper

### 7.2 Comandos

Windows:

```bash
.\mvnw.cmd clean compile
.\mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw clean compile
./mvnw spring-boot:run
```

## 8. Swagger / OpenAPI

- UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## 9. Problemas conhecidos e solução

### 9.1 Erro de versão Java
Erro comum:
- `class file has wrong version 61.0, should be 52.0`

Causa:
- Maven executando com Java 8.

Correção:
- Configurar `JAVA_HOME` para JDK 17+ e reiniciar o terminal.

### 9.2 Erro Hibernate de `scale`
Erro já tratado no projeto:
- `scale has no meaning for SQL floating point types`

Correção aplicada:
- Campo monetário em `ModelConta` alterado para `BigDecimal`.

## 10. Melhorias recomendadas

- Não retornar senha no endpoint de busca.
- Criar DTOs para entrada/saída de API.
- Adicionar validações (`@Valid`, `@NotBlank`, `@Email`).
- Criar controllers para contas e transações.
- Padronizar nomes de endpoints para convenção REST (`/usuarios`, `/contas`, `/transacoes`).
- Adicionar autenticação/autorização.

## 11. Referências internas

- Histórico detalhado de correções: `RELATORIO_ERROS.md`
- Arquivo de build e dependências: `pom.xml`
