<div align="center">
  <img src="https://github.com/thejaobiell/MottuFlowJava/blob/main/MottuFlow/src/main/resources/static/images/logo.png?raw=true" alt="MottuFlow" width="200"/>
  <h1>𝙈𝙤𝙩𝙩𝙪𝙁𝙡𝙤𝙬</h1>
</div>

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)
![Oracle](https://img.shields.io/badge/Oracle-Database-red.svg)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-lightgreen.svg)
![Deploy](https://img.shields.io/badge/Deploy-Render-46E3B7.svg)

## Visão Geral

- **📱 Arquitetura Híbrida**: API REST para integração mobile + Interface web Thymeleaf
- **🔒 Segurança Robusta**: Autenticação JWT e Spring Security
- **📊 Gestão Completa**: Controle de funcionários, frotas, pátios e status em tempo real

### 🌐 Acesso à Aplicação

| Ambiente | URL | Status |
|----------|-----|--------|
| **💻 Local** | http://localhost:8080 | Desenvolvimento |


### 🎥 Demonstração

[![Ver demonstração da aplicação](https://img.shields.io/badge/YouTube-Demonstração%20da%20Aplicação-red?style=for-the-badge&logo=youtube)](https://youtu.be/bOPGT5gL_h0)


### 🔗 Recursos Externos

- **[📂 Repositório GitHub](https://github.com/thejaobiell/MottuFlowJava)**
- **[🔌 Collection Postman](https://github.com/thejaobiell/MottuFlowJava/blob/database/MottuFlow/jsonsAPIREST/API%20-%20MottuFlow.postman_collection.json)**

---

## Estrutura de Branches

O projeto utiliza branches separadas para gerenciar ambientes de desenvolvimento e produção:

| Branch | Ambiente | Banco de Dados | URL |
|--------|----------|----------------|-----|
| **`main`** | Desenvolvimento Local | MySQL 8.0+ | http://localhost:8080 |
| **`sprint4`** | Produção | PostgreSQL 15 (Render) | https://mottuflowjava.onrender.com |
| **`databse`** | Mastering Database (**Apenas para matéria de Mastering Database**) | Oracle Database | http://localhost:8080/api |

---

## Funcionalidades

| Módulo | Descrição | Funcionalidades |
|--------|-----------|-----------------|
| **👥 Funcionários** | Gestão de Funcionários | CRUD completo, perfis de acesso, histórico |
| **🏪 Pátios** | Gerenciamento de locais | Cadastro, monitoramento, capacidade |
| **🏍️ Motos** | Controle de frota | Registro, status, localização, manutenção |
| **📹 Câmeras** | Sistema de monitoramento | Configuração e status |
| **🏷️ ArUco Tags** | Identificação visual | Cadastro e rastreamento |
| **📍 Status & Localização** | Tracking em tempo real | Posição, disponibilidade, alertas |
| **Procedures** | Integração com a matéria de `Mastering Database` | Relatorios de Funcionario e Moto |

### Recursos Avançados

- ✅ **API REST Completa** - Documentação OpenAPI/Swagger
- ✅ **Interface Web Responsiva** - Thymeleaf
- ✅ **Autenticação Segura** - JWT + Spring Security
- ✅ **Migração de Dados** - Flyway para versionamento de BD
- ✅ **Validação de Dados** - Bean Validation integrado

## 🛠️Tecnologias

### Backend
- **Java 21** - LTS com recursos modernos
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Autenticação e autorização
- **Spring Web** - API REST

### Database & Migration
- **Oracle Database** - Suporte para desenvolvimento local
- **Flyway** - Controle de versão do schema
- **HikariCP** - Pool de conexões otimizado

### Frontend & Templates
- **Thymeleaf** - Engine de templates

## Arquitetura

```
MottuFlow/
├── 📁 src/main/java/com/sprint/MottuFlow/
│   ├── 📁 controller/         # Controladores REST e Web
│   │   ├── 📁 rest/           # Endpoints API REST
│   │   └── 📁 web/            # Controladores Thymeleaf
│   ├── 📁 domain/             # Entidades de domínio (com Model, Repository, Service e DTO)
│   │   ├── 📁 arucotag/       # ArUco Tags
│   │   ├── 📁 autenticao/     # Autenticação
│   │   ├── 📁 camera/         # Câmeras
│   │   ├── 📁 funcionario/    # Funcionários
│   │   ├── 📁 localidade/     # Localidades
│   │   ├── 📁 masteringdatabase/     # Service para integração para matéria de Mastering Database
│   │   ├── 📁 moto/           # Motocicletas
│   │   ├── 📁 patio/          # Pátios
│   │   └── 📁 status/         # Status das motos
│   ├── 📁 infra/              # Infraestrutura
│   │   ├── 📁 exception/      # Tratamento de exceções
│   │   └── 📁 security/       # Configurações de segurança
│   └── 📄 MottuFlowApplication.java
├── 📁 src/main/resources/
│   ├── 📁 db/migration/       # Scripts Flyway
│   ├── 📁 static/             # Recursos estáticos
│   │   ├── 📁 css/            # Arquivos CSS
│   │   └── 📁 images/         # Imagens
│   ├── 📁 templates/          # Templates Thymeleaf
│   │   ├── 📁 arucotags/      # Templates ArUco Tags
│   │   ├── 📁 cameras/        # Templates Câmeras
│   │   ├── 📁 components/     # Componentes reutilizáveis
│   │   ├── 📁 funcionarios/   # Templates Funcionários
│   │   ├── 📁 localidades/    # Templates Localidades
│   │   ├── 📁 motos/          # Templates Motocicletas
│   │   ├── 📁 patios/         # Templates Pátios
│   │   └── 📁 status/         # Templates Status
│   └── 📄 application.properties      # Configuração (varia por branch)
└── 📄 pom.xml                 # Dependências Maven
```

## Instalação
### Pré-requisitos
- **Java 21+** ([OpenJDK](https://openjdk.org/install/) ou [Oracle JDK](https://www.oracle.com/java/technologies/downloads/))
- **Oracle Database** (via [Docker](https://hub.docker.com/r/gvenzl/oracle-free) ou usando o Oracle da Própria Fiap)
- **Maven 3.8+ (OPICIONAL)** ([Download](https://maven.apache.org/download.cgi))
- **Git** ([Download](https://git-scm.com/downloads))
- **Oracle SQL Developer Extension for VSCode** [(Extensão para consultar o banco de dados) ](https://marketplace.visualstudio.com/items?itemName=Oracle.sql-developer)

#### Via Terminal (Linux/macOS/WSL)
```bash
# Clone o repositório
git clone https://github.com/thejaobiell/MottuFlowJava.git
cd MottuFlowJava
# Troque para a branch de deploy
git checkout database
cd MottuFlow
./mvnw spring-boot:run
```

#### Via CMD (Windows)
```cmd
# Clone o repositório
git clone main https://github.com/thejaobiell/MottuFlowJava.git
cd MottuFlowJava
# (Opcional) Troque para a branch de deploy
git checkout database
cd MottuFlow
# Execute a aplicação
.\mvnw.cmd spring-boot:run
```

---

## ⚙️ Configuração

### Banco de Dados

#### 🌿 Branch `Database` - Oracle Database

##### `application.properties` (Branch database)
```properties
spring.application.name=MottuFlow

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl
spring.datasource.username=<seu usuario>
spring.datasource.password=<sua senha>
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.datasource.hikari.maximum-pool-size=5
spring.datasource.hikari.minimum-idle=1
spring.datasource.hikari.idle-timeout=10000
spring.datasource.hikari.max-lifetime=60000
spring.datasource.hikari.connection-timeout=30000

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true
spring.flyway.repair-on-migrate=true

server.port=8080
```

---

### 🧩 Como Usar o **Oracle SQL Developer Extension for VSCode**

#### 1. Abrir o painel da extensão

* Pressione `Ctrl+Shift+P` e digite **Database Client: Open View**
* Ou clique no ícone **Database** na barra lateral esquerda.

#### 2. Criar uma nova conexão

1. Clique no botão **+** (Add Connection).
2. Escolha o tipo de banco: **Oracle**.
3. Preencha os campos:

   * **Host:** `oracle.fiap.com.br`
   * **Port:** `1521`
   * **Service Name / SID:** `orcl`
   * **User:** `<seu usuario>`
   * **Password:** `<sua senha>`
4. Clique em **Test Connection** para verificar.
5. Se funcionar, clique em **Save**.

#### 3. Conectar-se ao banco

* Após salvar, dê **duplo clique** na conexão criada.
* O banco aparecerá expandido com as pastas: *Tables*, *Views*, *Procedures*, etc.

#### 4. Executar comandos SQL

1. Clique com o botão direito no banco → **New Query**.
2. Digite seus comandos SQL, por exemplo:

   ```sql
   SELECT * FROM funcionario;
   ```
3. Execute com `Ctrl+Enter` ou clicando em **Run** (▶).

---

## Uso

### 💻 Executando Localmente

#### 1. Iniciando a Aplicação
```bash
./mvnw spring-boot:run
```

**Saída esperada:**
```
 ██████╗ ███╗   ██╗██╗     ██╗███╗   ██╗███████╗██╗
██╔═══██╗████╗  ██║██║     ██║████╗  ██║██╔════╝██║
██║   ██║██╔██╗ ██║██║     ██║██╔██╗ ██║█████╗  ██║
██║   ██║██║╚██╗██║██║     ██║██║╚██╗██║██╔══╝  ╚═╝
╚██████╔╝██║ ╚████║███████╗██║██║ ╚████║███████╗██╗
 ╚═════╝ ╚═╝  ╚═══╝╚══════╝╚═╝╚═╝  ╚═══╝╚══════╝╚═╝
Clique aqui para acessar o Thymeleaf:   http://localhost:8080
Clique aqui para acessar o Swagger UI:   http://localhost:8080/swagger-ui/index.html
```

---

## Acessos Principais

| Serviço | URL Local | Descrição |
|---------|-----------|--------------|-----------|
| **🖥️ Interface Web** | http://localhost:8080 | Dashboard principal |
| **📡 API REST** | http://localhost:8080/api | Endpoints REST |
| **📚 Documentação** | http://localhost:8080/swagger-ui.html | Swagger UI |

#### Usuários Padrão

| Usuário | Senha | Cargo | Acesso |
|---------|-------|--------|--------|
| `admin@email.com` | `adminmottu` | Administrador | Completo | 

---

### 🔄 Migrações de Banco de Dados

O Flyway gerencia as migrações automaticamente:

```
src/main/resources/db/
                    └── migration/              
                            ├── V1__baseline.sql
                            └── V2__create-table-funcionario.sql
```

---

## 🔐 Autenticação JWT

Todas as requisições para a **API MottuFlow** exigem autenticação via **JWT (JSON Web Token)**.

### Usando o Postman

1. **Importe** a coleção [API - MottuFlow.postman_collection.json](https://github.com/thejaobiell/MottuFlowJava/blob/database/MottuFlow/jsonsAPIREST/API%20-%20MottuFlow.postman_collection.json) no Postman.

2. **Configure a variável de ambiente `baseURL`**:
   - **Local**: `http://localhost:8080/api`

3. No menu **`0 - JWT`**, execute o **POST Pegar Token JWT**, informando no **body** o `email` e `senha` do funcionário:

   ```json
   {
     "email": "admin@email.com",
     "senha": "adminmottu"
   }
   ```

4. Copie o valor de **`tokenAcesso`** retornado.

5. Vá até **API - MottuFlow → Variables**.

6. Substitua o valor da variável `jwt` pelo seu **token de acesso** sem estar entre aspas.

7. Agora todos os endpoints da coleção já estarão autenticados!

---

## 📡 API REST - Documentação Completa

### 🔧 Configuração Base
- **Autenticação:** Bearer Token (JWT)
- **Content-Type:** `application/json`

### Variáveis de Ambiente
- `{{baseUrl}}`: 
  - Local: `http://localhost:8080/api`
- `{{jwt}}`: Token JWT obtido no login

---

## 🔐 Autenticação (JWT)

### Login
```http
POST /login
Content-Type: application/json

{
  "email": "admin@email.com",
  "senha": "adminmottu"
}
```

### Atualizar Token
```http
POST /atualizar-token
Content-Type: application/json

{
  "refreshToken": "seu_refresh_token_aqui"
}
```

### Verificar Token
```http
POST /verificar-jwt
Content-Type: application/json

{
  "tokenAcesso": "seu_token_jwt_aqui"
}
```

---

## 📊 Relatórios Avançados (Branch `database` - Oracle)

### Relatório de Funcionário
```http
GET /database/funcionario/{id}
Authorization: Bearer {jwt_token}
```

**Exemplo:** `/database/funcionario/1`

---

### Relatório de Moto
```http
GET /database/moto/{id}
Authorization: Bearer {jwt_token}
```

**Exemplo:** `/database/moto/1`

---

## 👥 Funcionários

### Listar Funcionários
```http
GET /funcionario/listar
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /funcionario/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Buscar por CPF
```http
GET /funcionario/buscar-por-cpf/{cpf}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/funcionario/buscar-por-cpf/000.000.000-00`

### Criar Funcionário
```http
POST /funcionario/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "nome": "Novo Funcionário",
  "cpf": "333.333.333-33",
  "cargo": "MECANICO",
  "telefone": "(33) 33333-3333",
  "email": "novo@email.com",
  "senha": "senha123"
}
```

### Atualizar Funcionário
```http
PUT /funcionario/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "id": 2,
  "nome": "João Mecânico Atualizado",
  "cpf": "111.111.111-11",
  "cargo": "MECANICO",
  "telefone": "(11) 11111-1111",
  "email": "joao@email.com",
  "senha": "novaSenha123"
}
```

### Alterar Senha
```http
PATCH /funcionario/alterar-senha
Content-Type: application/json

{
  "email": "admin@email.com",
  "senhaAtual": "adminmottu",
  "novaSenha": "mottuadmin"
}
```

### Deletar Funcionário
```http
DELETE /funcionario/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 🏢 Pátios

### Listar Pátios
```http
GET /patios/listar
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /patios/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Criar Pátio
```http
POST /patios/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "nome": "Patio AlfaBeta",
  "endereco": "Rua Principal, 123",
  "capacidadeMaxima": 500
}
```

### Atualizar Pátio
```http
PUT /patios/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "nome": "Patio Atualizado",
  "endereco": "Rua Nova, 456",
  "capacidadeMaxima": 100
}
```

### Deletar Pátio
```http
DELETE /patios/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 🏍️ Motos

### Listar Motos
```http
GET /motos/listar
Authorization: Bearer {jwt_token}
```

### Listar Motos com ArUco Tags
```http
GET /motos/motos-com-tags
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /motos/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Buscar por Placa
```http
GET /motos/buscar-por-placa/{placa}
Authorization: Bearer {jwt_token}
```

### Buscar por Fabricante
```http
GET /motos/buscar-por-fabricante?fabricante={fabricante}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/motos/buscar-por-fabricante?fabricante=Yamaha`

### Buscar por Pátio
```http
GET /motos/buscar-por-patio/{idPatio}
Authorization: Bearer {jwt_token}
```

### Criar Moto
```http
POST /motos/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "placa": "ABC-1234",
  "modelo": "Honda CB500",
  "fabricante": "Honda",
  "ano": 2021,
  "idPatio": 2,
  "localizacaoAtual": "Setor A"
}
```

### Atualizar Moto
```http
PUT /motos/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "placa": "XYZ-5678",
  "modelo": "Yamaha MT-07",
  "fabricante": "Yamaha",
  "ano": 2022,
  "idPatio": 2,
  "localizacaoAtual": "Setor B"
}
```

### Deletar Moto
```http
DELETE /motos/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 📹 Câmeras

### Listar Câmeras
```http
GET /cameras/listar
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /cameras/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Buscar por Status Operacional
```http
GET /cameras/buscar-por-status/{status}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/cameras/buscar-por-status/Operacional`

### Criar Câmera
```http
POST /cameras/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "statusOperacional": "ONLINE",
  "localizacaoFisica": "Entrada do Patio",
  "idPatio": 2
}
```

### Atualizar Câmera
```http
PUT /cameras/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "statusOperacional": "INATIVA",
  "localizacaoFisica": "Saida do Patio",
  "idPatio": 3
}
```

### Deletar Câmera
```http
DELETE /cameras/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 🏷️ ArUco Tags

### Listar ArUco Tags
```http
GET /aruco-tags/listar
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /aruco-tags/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Buscar por Status
```http
GET /aruco-tags/buscar-por-status/{status}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/aruco-tags/buscar-por-status/ativo`

### Buscar por Código
```http
GET /aruco-tags/buscar-por-codigo/{codigo}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/aruco-tags/buscar-por-codigo/TAG004`

### Criar ArUco Tag
```http
POST /aruco-tags/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "codigo": "TAG12345",
  "idMoto": 4,
  "status": "ATIVO"
}
```

### Atualizar ArUco Tag
```http
PUT /aruco-tags/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "codigo": "TAG99999",
  "idMoto": 5,
  "status": "INATIVO"
}
```

### Deletar ArUco Tag
```http
DELETE /aruco-tags/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 📊 Status

### Listar Status
```http
GET /status/listar
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /status/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Buscar por Tipo de Status
```http
GET /status/buscar-por-tipo?tipoStatus={tipo}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/status/buscar-por-tipo?tipoStatus=BAIXA_BOLETIM_OCORRENCIA`

### Buscar por Descrição
```http
GET /status/buscar-por-descricao?descricao={descricao}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/status/buscar-por-descricao?descricao=Perda por BO`

### Buscar por Período
```http
GET /status/buscar-por-periodo?inicio={dataInicio}&fim={dataFim}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/status/buscar-por-periodo?inicio=2025-09-28T00:00:00&fim=2025-09-28T23:59:59`

### Criar Status
```http
POST /status/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "idMoto": 4,
  "tipoStatus": "DISPONIVEL",
  "descricao": "Moto disponível para uso",
  "idFuncionario": 3
}
```

### Atualizar Status
```http
PUT /status/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "idMoto": 4,
  "tipoStatus": "EM_MANUTENCAO",
  "descricao": "Moto em manutenção preventiva",
  "idFuncionario": 2
}
```

### Deletar Status
```http
DELETE /status/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 📍 Localidades

### Listar Localidades
```http
GET /localidades/listar
Authorization: Bearer {jwt_token}
```

### Buscar por ID
```http
GET /localidades/buscar-por-id/{id}
Authorization: Bearer {jwt_token}
```

### Buscar por Pátio
```http
GET /localidades/buscar-por-patio/{idPatio}
Authorization: Bearer {jwt_token}
```

### Buscar por Ponto de Referência
```http
GET /localidades/buscar-por-ponto-referencia/{pontoReferencia}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/localidades/buscar-por-ponto-referencia/Vaga`

### Buscar por Período
```http
GET /localidades/buscar-por-periodo?dataInicio={dataInicio}&dataFim={dataFim}
Authorization: Bearer {jwt_token}
```
**Exemplo:** `/localidades/buscar-por-periodo?dataInicio=2025-09-06T08:00:00&dataFim=2025-09-08T08:20:00`

### Criar Localidade
```http
POST /localidades/cadastrar
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "idMoto": 1,
  "idPatio": 2,
  "pontoReferencia": "Vaga A15",
  "observacoes": "Próximo à entrada"
}
```

### Atualizar Localidade
```http
PUT /localidades/editar/{id}
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "idMoto": 1,
  "idPatio": 2,
  "pontoReferencia": "Vaga B20",
  "observacoes": "Realocada para manutenção"
}
```

### Deletar Localidade
```http
DELETE /localidades/deletar/{id}
Authorization: Bearer {jwt_token}
```

---

## 📊 Códigos de Resposta HTTP

| Código | Descrição |
|--------|-----------|
| 200 | Sucesso na operação |
| 201 | Recurso criado com sucesso |
| 400 | Dados inválidos ou malformados |
| 401 | Token JWT ausente ou inválido |
| 403 | Acesso negado (permissões insuficientes) |
| 404 | Recurso não encontrado |
| 500 | Erro interno do servidor |

---

## 🔧 Troubleshooting

### ❌ Problemas Comuns

<details>
<summary><b>Token JWT inválido ou expirado</b></summary>

**Solução:**
1. Faça login novamente para obter um novo token
2. Verifique se o token está sendo enviado corretamente no header `Authorization: Bearer {token}`
3. Certifique-se de que não há espaços extras ou aspas no token. Copie apenas o código.

</details>

---

## 👥 Equipe de Desenvolvimento

<table align="center">
<tr>
<td align="center">
<a href="https://github.com/thejaobiell">
<img src="https://github.com/thejaobiell.png" width="100px;" alt="João Gabriel"/><br>
<sub><b>João Gabriel Boaventura</b></sub><br>
<sub>RM554874 • 2TDSB2025</sub><br>
</a>
</td>
<td align="center">
<a href="https://github.com/leomotalima">
<img src="https://github.com/leomotalima.png" width="100px;" alt="Léo Mota"/><br>
<sub><b>Léo Mota Lima</b></sub><br>
<sub>RM557851 • 2TDSB2025</sub><br>
</a>
</td>
<td align="center">
<a href="https://github.com/LucasLDC">
<img src="https://github.com/LucasLDC.png" width="100px;" alt="Lucas Leal"/><br>
<sub><b>Lucas Leal das Chagas</b></sub><br>
<sub>RM551124 • 2TDSB2025</sub><br>
</a>
</td>
</tr>
</table>
