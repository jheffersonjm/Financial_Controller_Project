# Financial Controller - Backend

## 📋 Descrição do Projeto

O **Financial Controller** é uma aplicação backend desenvolvida em Java utilizando Spring Boot, destinada a criar um sistema de controle financeiro. O projeto está em fase inicial de desenvolvimento e atualmente conta com a estrutura básica de uma aplicação web com persistência de dados.

## 🚀 Tecnologias Utilizadas

- **Java 25** - Linguagem de programação principal
- **Spring Boot 4.0.3** - Framework para desenvolvimento de aplicações Java
- **Spring Data JPA** - Para persistência e acesso a dados
- **Spring Web MVC** - Para desenvolvimento de APIs REST
- **H2 Database** - Banco de dados em memória para desenvolvimento e testes
- **PostgreSQL** - Banco de dados relacional para produção
- **Lombok** - Biblioteca para reduzir código boilerplate
- **Maven** - Gerenciamento de dependências e build
- **Tomcat** - Servidor de aplicação embarcado

## 📁 Estrutura do Projeto

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/jhefferson/backend/
│   │   │       ├── BackendApplication.java          # Classe principal da aplicação
│   │   │       ├── ServletInitializer.java          # Configuração para deploy WAR
│   │   │       └── model/
│   │   │           └── ModelUsuario.java            # Entidade Usuario
│   │   └── resources/
│   │       ├── application.yaml                     # Configurações da aplicação
│   │       ├── static/                             # Arquivos estáticos
│   │       └── templates/                          # Templates (se aplicável)
│   └── test/
│       └── java/
│           └── br/com/jhefferson/backend/
│               └── BackendApplicationTests.java     # Testes da aplicação
├── target/                                         # Arquivos compilados
├── pom.xml                                        # Configurações Maven
├── mvnw                                          # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                      # Maven Wrapper (Windows)
└── HELP.md                                       # Documentação de ajuda
```

## 🗃️ Modelo de Dados

### Entidade Usuario

A aplicação atualmente possui uma entidade `ModelUsuario` que representa os usuários do sistema:

**Tabela: Usuario**

| Campo | Tipo | Descrição | Constraints |
|-------|------|-----------|-------------|
| id | Integer | Identificador único | Primary Key, Auto Increment |
| nome | String | Nome do usuário | Not Null, Max 100 caracteres |
| senha | String | Senha do usuário | - |
| email | String | E-mail do usuário | - |

```java
@Entity
@Table(name = "Usuario")
public class ModelUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    private String senha;
    private String email;
    
    // Getters e Setters
}
```

## ⚙️ Configuração e Instalação

### Pré-requisitos

- Java 25 ou superior
- Maven 3.6+ (ou usar o Maven Wrapper incluído)
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Instalação

1. **Clone o repositório:**
   ```bash
   git clone [URL_DO_REPOSITORIO]
   cd Financial_Controller_Project/backend/backend
   ```

2. **Compile o projeto:**
   ```bash
   ./mvnw clean compile
   ```

3. **Execute os testes:**
   ```bash
   ./mvnw test
   ```

4. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

### Configuração do Banco de Dados

A aplicação está configurada para usar:

- **H2 Database** para desenvolvimento (banco em memória)
- **PostgreSQL** para produção

As configurações podem ser ajustadas no arquivo [`application.yaml`](src/main/resources/application.yaml).

## 🚀 Executando a Aplicação

### Modo de Desenvolvimento

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada em: `http://localhost:8080`

### Build para Produção

```bash
./mvnw clean package
```

O arquivo WAR será gerado em: `target/backend-0.0.1-SNAPSHOT.war`

## 🔧 Desenvolvimento

### Próximos Passos Sugeridos

1. **Controllers** - Criar controladores REST para gerenciar usuários
2. **Repositories** - Implementar interfaces de repositório para acesso aos dados
3. **Services** - Criar camada de serviços para lógica de negócio
4. **Security** - Implementar autenticação e autorização
5. **Validação** - Adicionar validações aos modelos
6. **Documentação da API** - Integrar Swagger/OpenAPI
7. **Testes** - Expandir cobertura de testes unitários e de integração

### Estrutura Recomendada para Expansão

```
src/main/java/br/com/jhefferson/backend/
├── controller/          # Controladores REST
├── service/            # Lógica de negócio
├── repository/         # Interfaces de acesso a dados
├── model/             # Entidades JPA
├── dto/               # Data Transfer Objects
├── config/            # Configurações
├── exception/         # Tratamento de exceções
└── util/              # Utilitários
```

## 📝 Convenções de Código

- Utilizar **camelCase** para variáveis e métodos
- Utilizar **PascalCase** para classes
- Prefixar entidades com "Model" (ex: `ModelUsuario`)
- Seguir padrões REST para APIs
- Documentar métodos públicos
- Manter cobertura de testes acima de 80%

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Crie um Pull Request

## 📄 Licença

Este projeto está sob a licença [especificar licença].

## 👤 Autor

**Jhefferson** - Desenvolvedor Principal

---

**Nota:** Este projeto está em desenvolvimento inicial. A documentação será atualizada conforme novas funcionalidades forem implementadas.