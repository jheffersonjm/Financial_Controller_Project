# Relatório de Erros e Alterações

Data: 2026-03-03  
Projeto: BackEnd (Financial_Controller_Project)

## 1) Erros identificados

### Arquivo: `src/main/java/br/com/jhefferson/BackEnd/Service/ServiceContas.java`
- Erro de sintaxe: fechamento de classe/bloco incorreto (`}` fora de posição).
- Uso de métodos inexistentes em `ModelConta`:
  - `setNomeUsuario(...)`
  - `setEmailUsuario(...)`
  - `setSenhaUsuario(...)`
- Tipos de retorno incompatíveis (`Model` do Logback em vez de `ModelConta`).
- Retorno incorreto em `obterContaPorId` (`Optional<ModelConta>` retornado onde era esperado `Model`).
- Estrutura geral do serviço inconsistente com a interface e com o modelo real da entidade.

### Arquivo: `src/main/java/br/com/jhefferson/BackEnd/Interface/InterfaceConta.java`
- Assinaturas utilizando tipo incorreto (`ch.qos.logback.core.model.Model`) em vez de `ModelConta`.

## 2) Alterações realizadas

### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Interface/InterfaceConta.java`
- Substituído import incorreto do Logback por:
  - `br.com.jhefferson.BackEnd.model.ModelConta`
- Ajustadas assinaturas dos métodos:
  - `criarConta(...)` agora retorna `ModelConta`
  - `atualizarConta(...)` agora retorna `ModelConta`
  - `obterContaPorId(...)` agora retorna `ModelConta`

### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Service/ServiceContas.java`
- Reescrita completa para corrigir sintaxe e estrutura.
- Adicionada anotação `@Service`.
- Construtor corrigido para injeção de `RepositoryConta`.
- Método `criarConta(...)`:
  - Cria `ModelConta` válido.
  - Usa `setNomeConta(...)`.
  - Inicializa `saldoConta` com `0.0`.
  - Persiste com `repositoryConta.save(...)`.
- Método `atualizarConta(...)`:
  - Busca por ID com `findById(...)`.
  - Atualiza `nomeConta` quando encontrado.
  - Salva e retorna entidade atualizada.
- Método `deletarConta(...)`:
  - Verifica existência com `existsById(...)`.
  - Exclui com `deleteById(...)`.
- Método `obterContaPorId(...)`:
  - Retorna `repositoryConta.findById(idConta).orElse(null)`.

## 3) Resultado da validação

- Verificação de erros de compilação executada após as alterações.
- Resultado: **No errors found**.

## 4) Observações

- As assinaturas da interface foram preservadas (mesmos parâmetros), mas os tipos de retorno foram corrigidos para a entidade correta (`ModelConta`).
- A lógica foi ajustada para refletir os campos reais existentes em `ModelConta`.

## 5) Atualização recente (Usuários/Controller/Repository)

### Novos erros identificados

#### Arquivo: `src/main/java/br/com/jhefferson/BackEnd/Service/ServiceUsuarios.java`
- Chamada a método inexistente no repositório:
  - `repositoryUsuario.findByEmailUsuario(emailUsuario)`

#### Arquivo: `src/main/java/br/com/jhefferson/BackEnd/Controller/ControllerUsuarios.java`
- Chamada incompatível:
  - `ServiceUsuarios.PegarSenha(nomeUsuario, emailUsuario)` com assinatura incorreta para o método disponível.
- Uso indevido de chamada estática para método de serviço.

### Alterações aplicadas

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Repository/RepositoryUsuario.java`
- Adicionado método de consulta:
  - `Optional<ModelUsuario> findByEmailUsuario(String emailUsuario);`

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Service/ServiceUsuarios.java`
- Removidos campos de estado não necessários (`nomeUsuario`, `emailUsuario`, `senhaUsuario`).
- Mantido método `PegarSenha(String senhaUsuario)`.
- Adicionada sobrecarga `PegarSenha(String nomeUsuario, String emailUsuario)` para compatibilidade com o controller:
  - busca usuário por email,
  - valida nome,
  - retorna senha quando houver correspondência.

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Controller/ControllerUsuarios.java`
- Removido import inválido (`java.security.Provider.Service`).
- Adicionada injeção de dependência de `ServiceUsuarios` via construtor.
- Ajustada chamada para instância:
  - de `ServiceUsuarios.PegarSenha(...)`
  - para `serviceUsuarios.PegarSenha(...)`.

### Validação após atualização recente

- Verificação de compilação executada novamente.
- Resultado: **No errors found**.

## 6) Atualização recente (ControllerUsuarios)

### Erros identificados

#### Arquivo: `src/main/java/br/com/jhefferson/BackEnd/Controller/ControllerUsuarios.java`
- Tipo inválido no atributo e construtor:
  - `BackEnd.BackEndApplication` não resolvido.
- Chamada de método com assinatura incompatível:
  - `serviceUsuarios.obterUsuario(nomeUsuario, emailUsuario)`
  - o serviço expõe `obterUsuario(String emailUsuario)` e `PegarSenha(String nomeUsuario, String emailUsuario)`.

### Alterações aplicadas

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Controller/ControllerUsuarios.java`
- Removidas dependências inválidas/não usadas (`BackEndApplication`, `RepositoryUsuario`).
- Removido atributo `backEndApplication` e parâmetro correspondente do construtor.
- Construtor simplificado para injetar apenas `ServiceUsuarios`.
- Endpoint `BuscarUsuarios` ajustado para chamar:
  - `serviceUsuarios.PegarSenha(nomeUsuario, emailUsuario)`.

### Validação desta rodada

- Verificação de compilação executada após os ajustes.
- Resultado: **No errors found**.

## 7) Atualização recente (Falha de inicialização JPA/Hibernate)

### Erros identificados no log de execução

- Falha ao iniciar o `ApplicationContext` com erro:
  - `scale has no meaning for SQL floating point types`
- Exceção na criação do `entityManagerFactory` durante o mapeamento de entidades JPA.

### Causa raiz

- Campo monetário com `precision/scale` usando tipo de ponto flutuante em entidade JPA.
- Mapeamento inconsistente no campo `valor_transacao` em `ModelTransacao` (tipo `String` com `precision/scale`).

### Alterações aplicadas

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/model/ModelConta.java`
- Alterado tipo de `saldoConta` de `Double` para `BigDecimal`.
- Mantido `@Column(precision = 10, scale = 2)` agora compatível com tipo decimal exato.
- Ajustados `getter` e `setter` para `BigDecimal`.

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Service/ServiceContas.java`
- Ajustada inicialização do saldo para `BigDecimal.ZERO`.

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/model/ModelTransacao.java`
- Ajustado mapeamento de `descricaoTransacao`:
  - de `precision/scale` para `length = 255`, compatível com tipo `String`.

### Validação

- Verificação de compilação (`get_errors`) executada após correções.
- Resultado: **No errors found**.

### Observação de ambiente (não-código)

- Ao executar via Maven no terminal local, foi identificado Java 8 ativo (`java version 1.8.x`), incompatível com Spring Boot 4.
- Erro observado no terminal Maven:
  - `class file has wrong version 61.0, should be 52.0`
- Necessário executar Maven com JDK compatível (Java 17+).

## 8) Atualização recente (Swagger UI 404)

### Erro identificado no runtime

- Requisição para `/swagger-ui/index.html` retornando `404 Not Found`.
- Exceção registrada: `No static resource swagger-ui/index.html`.

### Causa raiz

- Dependência do Swagger/OpenAPI não estava presente no projeto.

### Alterações aplicadas

- Dependência adicionada no [pom.xml](pom.xml):
  - `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.6`

### Arquivos alterados (links)

- [pom.xml](pom.xml)
- [src/main/resources/application.yaml](src/main/resources/application.yaml)

### Resultado da validação

- Validação de código após a alteração: **No errors found**.

### Observação operacional

- Para o Swagger responder em execução, o backend precisa subir com JDK compatível com Spring Boot 4 (Java 17+).

## 9) Comandos utilizados para diagnosticar/corrigir

### Comandos executados no terminal

- `./mvnw.cmd -q -DskipTests spring-boot:run`
  - Objetivo: subir a aplicação para validar se o erro de inicialização do Hibernate persistia.

- `java -version; .\mvnw.cmd -version`
  - Objetivo: verificar versão do Java em uso pelo sistema e pelo Maven Wrapper.

- `Get-ChildItem "C:\Program Files\Java" -Name`
  - Objetivo: listar JDKs instalados e confirmar disponibilidade de versão compatível.

### Comandos/ações de validação no workspace

- `get_errors`
  - Objetivo: validar se os arquivos alterados ficaram sem erros de compilação.

- `read_file`
  - Objetivo: inspecionar mapeamentos JPA e serviços antes de corrigir.

- `apply_patch`
  - Objetivo: aplicar correções pontuais nos arquivos de código e no relatório.

## 10) Atualização recente (Endpoint salvarUsuario)

### Erro identificado

#### Arquivo: `src/main/java/br/com/jhefferson/BackEnd/Controller/ControllerUsuarios.java`
- Incompatibilidade de tipos no endpoint `salvarUsuario`:
  - retorno declarado como `String`,
  - chamada `serviceUsuarios.criarUsuario(...)` retornando `ModelUsuario`.

### Causa raiz

- Assinatura do controller não estava alinhada com o contrato do service.
- Corpo da requisição modelado de forma incorreta para criação de usuário.

### Alterações aplicadas

#### Arquivo alterado: `src/main/java/br/com/jhefferson/BackEnd/Controller/ControllerUsuarios.java`
- Método `salvarUsuario` alterado para:
  - receber `@RequestBody ModelUsuario usuario`.
  - retornar `ModelUsuario`.
- Chamada para o service mantida com os campos do objeto recebido:
  - `serviceUsuarios.criarUsuario(usuario.getNomeUsuario(), usuario.getEmailUsuario(), usuario.getSenhaUsuario())`.

### Validação

- Verificação de compilação executada após ajuste.
- Resultado: **No errors found**.
