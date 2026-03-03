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
