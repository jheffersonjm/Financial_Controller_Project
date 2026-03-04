🧱 FASE 1 – Base Estrutural (Semanas 1–2)

Objetivo: arrumar a casa antes de colocar porta blindada.

Entregas:

[] Criar entidade Usuario separada
[] Criar entidade Categoria
[] Relacionamento 1:N (Usuario → Transacao)
[] Remover senha de Transacao
[] Implementar Soft Delete (deleted_at)
[] Implementar auditoria (created_by, updated_by)

Resultado:
Banco normalizado e arquitetura preparada para crescer.

🔒 FASE 2 – Segurança Fundamental (Semanas 3–4)

Objetivo: sair do modo laboratório e entrar no modo produção.

Entregas:

[] Implementar Spring Security
[] Implementar autenticação JWT
[] Criptografar senhas com BCrypt
[] Criar endpoint de login
[] Controlar permissões por usuário
[] Proteger rotas privadas

Resultado:
API autenticada, segura e pronta para multiusuário.

🧠 FASE 3 – Validação e Tratamento Global (Semanas 5–6)

Objetivo: parar de confiar no usuário.

Entregas:

[] Implementar @Valid
[] Bean Validation (@Email, @NotNull, @Positive)
[] Criar @ControllerAdvice global
[] Exception customizada
[] Padronizar resposta de erro

Resultado:
API robusta, previsível e profissional.

📊 FASE 4 – Funcionalidades Avançadas (Semanas 7–8)

Objetivo: transformar CRUD em sistema real.

Entregas:

[] Busca por data
[] Filtro por tipo
[] Paginação com Pageable
[] Ordenação dinâmica
[] Relatórios de saldo
[] Export CSV

Resultado:
API madura, utilizável por frontend real.

🧪 FASE 5 – Qualidade de Código (Semanas 9–10)

Objetivo: engenharia, não gambiarra funcional.

Entregas:

[] Testes unitários com JUnit
[] Testes de integração com MockMvc
[] Cobertura > 70% (80% depois)
[] Swagger/OpenAPI
[] Logs estruturados (SLF4J)
[] Ativar Actuator

Resultado:
Código confiável. Refatorações seguras.

⚡ FASE 6 – Performance e Infraestrutura (Semanas 11–12)

Objetivo: pensar como sistema que aguenta carga.

Entregas:

[] Cache (Redis ou Caffeine)
[] Índices compostos
[] Otimizar queries
[] Dockerfile funcional
[] CI/CD com GitHub Actions
[] Health check
[] Monitoramento básico

Resultado:
API preparada para deploy real.