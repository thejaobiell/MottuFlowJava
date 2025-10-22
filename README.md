<div align="center">
  <img src="https://github.com/thejaobiell/MottuFlowJava/blob/main/MottuFlow/src/main/resources/static/images/logo.png?raw=true" alt="MottuFlow" width="200"/>
  <h1>𝙈𝙤𝙩𝙩𝙪𝙁𝙡𝙤𝙬</h1>
</div>

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-lightgreen.svg)
![Deploy](https://img.shields.io/badge/Deploy-Render-46E3B7.svg)

**MottuFlow** é uma solução completa para gerenciamento de frotas de motocicletas, desenvolvida com arquitetura híbrida que combina **API REST** moderna com interface web intuitiva. O sistema utiliza **visão computacional** e **ArUco Tags** para identificação automática de veículos, oferecendo controle total sobre funcionários, pátios, motos, câmeras e localização de ativos.

## 🎯 Visão Geral

O MottuFlow foi desenvolvido como parte de um projeto acadêmico integrando as disciplinas de **Internet of Things (IoT)** e **Mobile Application Development**. A solução oferece:

- **📱 Arquitetura Híbrida**: API REST para integração mobile + Interface web Thymeleaf
- **🔒 Segurança Robusta**: Autenticação JWT e Spring Security
- **📊 Gestão Completa**: Controle de funcionários, frotas, pátios e status em tempo real
- **☁️ Deploy em Produção**: Aplicação rodando no Render com PostgreSQL

### 🌐 Acesso à Aplicação

| Ambiente | URL | Status |
|----------|-----|--------|
| **🚀 Produção** | [mottuflowjava.onrender.com](https://mottuflowjava.onrender.com) | [![Status](https://img.shields.io/badge/Status-Online-success)](https://mottuflowjava.onrender.com) |
| **💻 Local** | http://localhost:8080 | Desenvolvimento |

> ⚠️ **Nota**: O serviço gratuito do Render entra em modo sleep após inatividade. O primeiro acesso pode levar ~50 segundos para iniciar.

### 🎥 Demonstração

[![Ver demonstração no YouTube](https://img.shields.io/badge/YouTube-Ver%20Demonstração-red?style=for-the-badge&logo=youtube)]( depois mudar aqui )

### 🔗 Recursos Externos

- **[📂 Repositório GitHub](https://github.com/thejaobiell/MottuFlowJava)**
- **[🔌 Collection Postman](https://github.com/thejaobiell/MottuFlowJava/blob/main/MottuFlow/jsonsAPIREST/API%20-%20MottuFlow.postman_collection.json)**

---

## 🌿 Estrutura de Branches

O projeto utiliza branches separadas para gerenciar ambientes de desenvolvimento e produção:

| Branch | Ambiente | Banco de Dados | URL | Configuração |
|--------|----------|----------------|-----|--------------|
| **`main`** | Desenvolvimento Local | MySQL 8.0+ | http://localhost:8080 | `application.properties` |
| **`sprint4`** | Produção | PostgreSQL 15 (Render) | https://mottuflowjava.onrender.com | `application.properties` |

---

## ✨ Funcionalidades

### 🏢 Módulos Principais

| Módulo | Descrição | Funcionalidades |
|--------|-----------|-----------------|
| **👥 Funcionários** | Gestão de Funcionários | CRUD completo, perfis de acesso, histórico |
| **🏪 Pátios** | Gerenciamento de locais | Cadastro, monitoramento, capacidade |
| **🏍️ Motos** | Controle de frota | Registro, status, localização, manutenção |
| **📹 Câmeras** | Sistema de monitoramento | Configuração e status |
| **🏷️ ArUco Tags** | Identificação visual | Cadastro e rastreamento |
| **📍 Status & Localização** | Tracking em tempo real | Posição, disponibilidade, alertas |

### 🚀 Recursos Avançados

- ✅ **API REST Completa** - Documentação OpenAPI/Swagger
- ✅ **Interface Web Responsiva** - Thymeleaf + Bootstrap
- ✅ **Autenticação Segura** - JWT + Spring Security
- ✅ **Migração de Dados** - Flyway para versionamento de BD
- ✅ **Validação de Dados** - Bean Validation integrado
<<<<<<< HEAD
- ✅ **Deploy em Produção** - Render + PostgreSQL
=======
- ✅ **Deploy em Produção** - Render + Render PostgreSQL
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

## 🛠️ Tecnologias

### Backend
- **Java 21** - LTS com recursos modernos
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Autenticação e autorização
- **Spring Web** - API REST

### Database & Migration
<<<<<<< HEAD
- **PostgreSQL 15** - Banco de dados em produção
=======
- **PostgreSQL 15** - Banco de dados em produção(Disponibilizado pelo Render)
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
- **MySQL 8.0** - Suporte para desenvolvimento local
- **Flyway** - Controle de versão do schema
- **HikariCP** - Pool de conexões otimizado

### Frontend & Templates
- **Thymeleaf** - Engine de templates

<<<<<<< HEAD
### Infrastructure
=======
### InfraEstrutura
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
- **Render** - Plataforma de deploy em nuvem
- **PostgreSQL (Render)** - Banco de dados gerenciado

## 🏗️ Arquitetura

```
MottuFlow/
├── 📄 DockerFile              # Arquivo DockerFile para Deploy(apenas disponível na branch `sprint4`)
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
<<<<<<< HEAD
│   ├── 📄 application.properties           # Configuração local (MySQL)
│   └── 📄 application-prod.properties      # Configuração produção (PostgreSQL)
=======
│   └── 📄 application.properties      # Configuração (varia por branch)
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
└── 📄 pom.xml                 # Dependências Maven
```

## 💾 Instalação

### 📋 Pré-requisitos

- **Java 21+** ([OpenJDK](https://openjdk.org/install/) ou [Oracle JDK](https://www.oracle.com/java/technologies/downloads/))
- **PostgreSQL 15+** (produção) ou **MySQL 8.0+** (desenvolvimento local)
- **Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **Git** ([Download](https://git-scm.com/downloads))

### 🔧 Instalação Rápida

#### Via Terminal (Linux/macOS/WSL)

```bash
# Clone o repositório
git clone -b main https://github.com/thejaobiell/MottuFlowJava.git

cd MottuFlowJava

# (Opicional) Troque para a branch de deploy
git checkout sprint4

cd MottuFlow
.\mvnw.cmd spring-boot:run
```

#### Via CMD

```cmd
# Clone o repositório
git clone -b main https://github.com/thejaobiell/MottuFlowJava.git

cd MottuFlowJava

# (Opicional) Troque para a branch de deploy
git checkout sprint4

cd MottuFlow

# Execute a aplicação
.\mvnw.cmd spring-boot:run
```

---

## ⚙️ Configuração

### 🗄️ Banco de Dados

<<<<<<< HEAD
A aplicação suporta dois bancos de dados dependendo do ambiente:

#### 🐘 PostgreSQL (Produção - Render)

O PostgreSQL é usado automaticamente quando a aplicação detecta o profile `prod` ou a variável de ambiente `DATABASE_URL`.

```bash
# Variáveis de ambiente no Render (configuradas automaticamente)
DATABASE_URL=postgres://user:password@host:5432/database
SPRING_PROFILES_ACTIVE=prod
```

#### 🐬 MySQL (Desenvolvimento Local)
=======
A aplicação utiliza configurações diferentes dependendo da branch:

#### 🌿 Branch `main` - MySQL (Desenvolvimento Local)
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

##### 🔹 **Linux (Ubuntu/Debian)**

```bash
sudo apt update
sudo apt install mysql-server mysql-client
sudo mysql_secure_installation
```

##### 🔹 **Windows**

1. Baixe o **MySQL Installer**:
   👉 [Download MySQL Installer](https://dev.mysql.com/downloads/installer/)

2. Durante a instalação, escolha:
   * **Server Only** (somente servidor) ou **Full** (se quiser Workbench e utilitários).
   * Configure a senha do usuário `root`.

3. Após a instalação, inicie o MySQL.

4. Para acessar via terminal do Windows:
   * Pressione `Win + R`, digite `cmd` e execute:
   ```bash
   mysql -u root -p
   ```
   * Digite a senha configurada.

<<<<<<< HEAD
#### Criação do Usuário e Banco (MySQL)
=======
##### Criação do Usuário e Banco (MySQL)
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

```sql
-- Execute no MySQL como root
CREATE USER 'mottu_user'@'%' IDENTIFIED BY 'user123';
GRANT ALL PRIVILEGES ON mottuflow.* TO 'mottu_user'@'%';
FLUSH PRIVILEGES;
```

<<<<<<< HEAD
> Se quiser restringir só para a máquina local, use `'localhost'` no lugar de `%`.

---

### 📝 Configuração da Aplicação

#### `src/main/resources/application.properties` (Desenvolvimento Local - MySQL)
=======
##### `application.properties` (Branch main)
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

```properties
spring.application.name=MottuFlow

spring.datasource.url=jdbc:mysql://localhost:3306/mottuflow?createDatabaseIfNotExist=true
spring.datasource.username=mottu_user
spring.datasource.password=user123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=20000
spring.datasource.hikari.keepalive-time=300000
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.idle-timeout=300000
spring.datasource.hikari.connection-test-query=SELECT 1

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.repair=true
spring.flyway.repair-on-migrate=true

logging.level.root=WARN
logging.level.org.springframework=WARN
logging.level.org.hibernate=WARN
logging.level.com.sprint.MottuFlow=WARN

spring.main.allow-bean-definition-overriding=true

server.address=0.0.0.0
server.port=8080
```

#### `src/main/resources/application-prod.properties` (Produção - PostgreSQL)

```properties
spring.application.name=MottuFlow

spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=20000
spring.datasource.hikari.keepalive-time=300000
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.idle-timeout=300000
spring.datasource.hikari.connection-test-query=SELECT 1

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=false
spring.jpa.open-in-view=false

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.repair=true
spring.flyway.repair-on-migrate=true

logging.level.root=WARN
spring.main.allow-bean-definition-overriding=true

server.address=0.0.0.0
server.port=${PORT:8080}
```

---

#### 🚀 Branch `sprint4` - PostgreSQL (Produção - Render)

O PostgreSQL é usado automaticamente na branch `sprint4` para produção no Render.

##### Variáveis de Ambiente no Render

```bash
DATABASE_URL=jdbc:postgresql://dpg-d3sh9eili9vc73fr27ug-a.oregon-postgres.render.com:5432/mottuflowdb
DATABASE_USERNAME=rm554874
DATABASE_PASSWORD=F11qMduTmfLy8Xw15NBCTbsr7ypmBPbi
PORT=8080
```

##### `application.properties` (Branch sprint4)

```properties
spring.application.name=MottuFlow

spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=20000
spring.datasource.hikari.keepalive-time=300000
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.idle-timeout=300000
spring.datasource.hikari.connection-test-query=SELECT 1

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=false
spring.jpa.open-in-view=false

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.repair=true
spring.flyway.repair-on-migrate=true

logging.level.root=WARN
spring.main.allow-bean-definition-overriding=true

server.address=0.0.0.0
server.port=${PORT:8080}
```

---

## 🚀 Uso

### 🌐 Acessando a Aplicação em Produção

A aplicação está disponível em: **[mottuflowjava.onrender.com](https://mottuflowjava.onrender.com)**

> ⚠️ **Importante**: No plano gratuito do Render, a aplicação entra em modo sleep após 15 minutos de inatividade. O primeiro acesso pode levar até 50 segundos para "acordar" o serviço.

<<<<<<< HEAD
=======
#### Health Check

O Render verifica automaticamente a saúde da aplicação em:

[/actuator/health](https://mottuflowjava.onrender.com/actuator/health)

---

>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
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

<<<<<<< HEAD
#### 2. Acessos Principais

| Serviço | URL Local | URL Produção | Descrição |
|---------|-----------|--------------|-----------|
| **🖥️ Interface Web** | http://localhost:8080 | https://mottuflowjava.onrender.com | Dashboard principal |
| **📡 API REST** | http://localhost:8080/api | https://mottuflowjava.onrender.com/api | Endpoints REST |
| **📚 Documentação** | http://localhost:8080/swagger-ui.html | https://mottuflowjava.onrender.com/swagger-ui.html | Swagger UI |

#### 3. Usuários Padrão
=======
---

## Acessos Principais

| Serviço | URL Local | URL Produção | Descrição |
|---------|-----------|--------------|-----------|
| **🖥️ Interface Web** | http://localhost:8080 | https://mottuflowjava.onrender.com | Dashboard principal |
| **📡 API REST** | http://localhost:8080/api | https://mottuflowjava.onrender.com/api | Endpoints REST |
| **📚 Documentação** | http://localhost:8080/swagger-ui.html | https://mottuflowjava.onrender.com/swagger-ui.html | Swagger UI |

#### Usuários Padrão
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

| Usuário | Senha | Cargo | Acesso |
|---------|-------|--------|--------|
| `admin@email.com` | `adminmottu` | Administrador | Completo | 
| `joao@email.com` | `joao123` | Mecânico | Limitado | 
| `maria@email.com` | `maria123` | Gerente | Completo | 

> Recomendado usar a conta de Administrador para teste

---

<<<<<<< HEAD
## ☁️ Deploy no Render

### 📋 Configuração do Deploy

#### 1. Variáveis de Ambiente

Configure no painel do Render:

```bash
DATABASE_URL=jdbc:postgresql://dpg-d3sh9eili9vc73fr27ug-a.oregon-postgres.render.com:5432/mottuflowdb
DATABASE_USERNAME=rm554874
DATABASE_PASSWORD=F11qMduTmfLy8Xw15NBCTbsr7ypmBPbi
PORT=8080
```

#### 2. Health Check

O Render verifica automaticamente a saúde da aplicação em:
```
GET /actuator/health
```

=======
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
### 🔄 Migrações de Banco de Dados

O Flyway gerencia as migrações automaticamente:

```
src/main/resources/db/
                    └── migration/              
                            ├── V1__create-table-funcionario.sql
                            └── V2__create-table-patio.sql
```

---

## 🔐 Autenticação JWT

Todas as requisições para a **API MottuFlow** exigem autenticação via **JWT (JSON Web Token)**.

### ✅ Usando o Postman

1. **Importe** a coleção [API - MottuFlow.postman_collection.json](https://github.com/thejaobiell/MottuFlowJava/blob/main/MottuFlow/jsonsAPIREST/API%20-%20MottuFlow.postman_collection.json) no Postman.

<<<<<<< HEAD
2. **Configure a variável de ambiente**:
   - **Local**: `http://localhost:8080`
   - **Produção**: `https://mottuflowjava.onrender.com`
=======
2. **Configure a variável de ambiente `baseURLhttps://mottuflowjava.onrender.com/actuator/health`**:
   - **Local**: `http://localhost:8080/api`
   - **Produção**: `https://mottuflowjava.onrender.com/api`
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

3. No menu **`0 - JWT`**, execute o **POST Pegar Token JWT**, informando no **body** o `email` e `senha` do funcionário:

   ```json
   {
     "email": "admin@email.com",
     "senha": "adminmottu"
   }
   ```

4. Copie o valor de **`tokenAcesso`** retornado.

5. Vá até **API - MottuFlow → Variables**.

<<<<<<< HEAD
6. Substitua o valor da variável `jwt` pelo seu **token JWT**.
=======
6. Substitua o valor da variável `jwt` pelo seu **token de acesso**.
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

7. Agora todos os endpoints da coleção já estarão autenticados. 🚀

---

## 📡 API REST - Documentação Completa

### 🔧 Configuração Base
- **Autenticação:** Bearer Token (JWT)
- **Content-Type:** `application/json`

### Variáveis de Ambiente
- `{{baseUrl}}`: 
  - Local: `http://localhost:8080/api`
  - Produção: `https://mottuflowjava.onrender.com/api`
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

## ⚠️ Tratamento de Erros

### Erro de Autenticação (401)
```json
{
  "timestamp": "2025-09-29T10:30:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Token JWT inválido ou expirado"
}
```

### Erro de Validação (400)
```json
{
  "timestamp": "2025-09-29T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "CPF já cadastrado no sistema"
}
```

### Erro de Recurso Não Encontrado (404)
```json
{
  "timestamp": "2025-09-29T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Funcionário não encontrado com o ID: 999"
}
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
<<<<<<< HEAD
<summary><b>Aplicação não inicia no Render</b></summary>

**Solução:**
1. Verifique se o `DATABASE_URL` está configurado corretamente
2. Confirme que `SPRING_PROFILES_ACTIVE=prod` está definido
3. Revise os logs do Render para identificar erros específicos
4. Garanta que o Flyway está configurado para PostgreSQL

</details>

<details>
=======
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
<summary><b>Primeiro acesso muito lento</b></summary>

**Causa:** No plano gratuito do Render, serviços ficam em sleep após 15 minutos de inatividade.

**Solução:** Aguarde até 50 segundos no primeiro acesso. Requisições subsequentes serão rápidas.

</details>

<details>
<summary><b>Erro de conexão com banco de dados local</b></summary>

**Solução:**
<<<<<<< HEAD
1. Verifique se o MySQL está rodando: `sudo systemctl status mysql`
2. Confirme as credenciais em `application.properties`
3. Crie o banco manualmente se necessário: `CREATE DATABASE mottuflow;`
=======
1. Verifique se está na branch `main`
2. Confirme se o MySQL está rodando: `sudo systemctl status mysql`
3. Confirme as credenciais em `application.properties`
4. Crie o banco manualmente se necessário: `CREATE DATABASE mottuflow;`
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

</details>

<details>
<summary><b>Token JWT inválido ou expirado</b></summary>

**Solução:**
1. Faça login novamente para obter um novo token
2. Verifique se o token está sendo enviado corretamente no header `Authorization: Bearer {token}`
3. Certifique-se de que não há espaços extras no token

</details>

---

<<<<<<< HEAD
=======
## ⚡ Boas Práticas

### ✅ DO's

- ✅ **Sempre desenvolva na branch `main`** para testes locais
- ✅ **Teste completamente** antes de fazer merge para `sprint4`
- ✅ **Use commits semânticos**: `feat:`, `fix:`, `docs:`, `refactor:`
- ✅ **Faça pull antes de push** para evitar conflitos
- ✅ **Verifique os logs do Render** após deploy
- ✅ **Mantenha as configurações de cada branch separadas**
- ✅ **Documente mudanças significativas** no código

### ❌ DON'Ts

- ❌ **Não desenvolva diretamente na `sprint4`**
- ❌ **Não commite credenciais** no código (use variáveis de ambiente)
- ❌ **Não faça force push** em `sprint4`
- ❌ **Não misture configurações** de MySQL e PostgreSQL entre branches
- ❌ **Não ignore erros de build** do Render
- ❌ **Não faça merge sem testar** localmente primeiro

---
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a

## 👥 Equipe de Desenvolvimento

<table>
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

---

<div align="center">

[![GitHub](https://img.shields.io/badge/GitHub-MottuFlowJava-181717?style=for-the-badge&logo=github)](https://github.com/thejaobiell/MottuFlowJava)
[![Deploy](https://img.shields.io/badge/Deploy-Render-46E3B7?style=for-the-badge&logo=render)](https://mottuflowjava.onrender.com)

<<<<<<< HEAD
</div
=======
**MottuFlow** - Sistema de Gerenciamento de Frotas  
Desenvolvido com ❤️ pela equipe 2TDSB2025

</div>
>>>>>>> 2461396352ff15012a95025707dfa1d2edd86c9a
