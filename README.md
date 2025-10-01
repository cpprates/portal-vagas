# Portal Vagas API

API para gerenciamento de vagas de emprego — cadastro, busca, autenticação etc.

---

## 🧾 Funcionalidades

- CRUD de vagas (criar, ler, atualizar, excluir)  
- Autenticação de usuários  
- Filtros de busca por cargo, local, etc  
- Configuração via Spring / Java (ou tecnologia usada)  
- Documentação de endpoints (Swagger / OpenAPI)  

---

## 🚀 Tecnologias usadas

| Camada | Tecnologia |
|---|---|
| Linguagem | Java |
| Framework | Spring Boot |
| Persistência | (Ex: JPA / Hibernate / banco de dados) |
| Build | Gradle |
| Gerenciamento de dependências | Gradle |
| Configuração | application.yml / profiles |

---

## 🏗️ Estrutura do Projeto

```
├── src
│   ├── main
│   │   ├── java/… (código-fonte)
│   │   └── resources (application.yml, etc)
│   └── test (testes)
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
└── …  
```

---

## 🚧 Requisitos & Setup

1. Java JDK 17+  
2. Banco de dados MongoDB   
3. Ferramentas de build instaladas (Gradle wrapper já incluso)

### Para rodar localmente:

```bash
# clonar o repositório
git clone https://github.com/cpprates/portal-vagas.git

# entrar na pasta do projeto
cd portal-vagas

# rodar via Gradle
./gradlew bootRun
```

> A API ficará disponível no endereço padrão `http://localhost:8080` (ou porta configurada).

---

## 📋 Endpoints principais (exemplos)

| Método | Rota | Descrição |
|---|---|---|
| POST | /api/auth/login | Autenticar usuário |
| POST | /api/auth/register | Registrar novo usuário |
| GET | /api/vagas | Listar vagas |
| POST | /api/vagas | Criar nova vaga |
| PUT | /api/vagas/{id} | Atualizar vaga existente |
| DELETE | /api/vagas/{id} | Remover vaga |

> Detalhes como parâmetros, request/response, códigos de erro etc devem ser documentados com Swagger ou similar.

---

## 💡 Ideias futuras / melhorias

- Suporte a upload de currículo / documentos  
- Perfis de usuário com histórico de candidaturas  
- Integração com serviços externos  
- Validações mais robustas  
- Autorização baseada em papéis (roles)  
- Paginação, ordenação e filtros avançados

