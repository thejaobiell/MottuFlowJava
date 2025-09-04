# 🚀 MottuFlow – API REST & Thymeleaf

**MottuFlow** é uma aplicação híbrida desenvolvida em **Java**, projetada para gerenciar de forma completa **funcionários, pátios, motos, câmeras, ArUco tags, status das motos e localidades**. Ela combina:

* **API REST**: para integração com front-ends externos (como aplicativos mobile em React Native).
* **Interface web com Thymeleaf**: para uso direto pelo navegador, com páginas de gerenciamento e visualização dos dados.

No contexto da disciplina de **IoT**, a solução utiliza **visão computacional** com câmeras para identificar motocicletas por meio de **ArUco Tags**.
👉 [Exemplo de imagem com ArUco Tag](https://docs.opencv.org/4.x/singlemarkersdetection.jpg)

A API comunica-se com o **banco de dados MySQL**, facilitando o envio e recebimento de informações, e será futuramente integrada ao aplicativo mobile desenvolvido na disciplina de **Mobile Application Development**.

---

## 🔗 Link do Repositório

[https://github.com/thejaobiell/MottuFlowJava](https://github.com/thejaobiell/MottuFlowJava)

---

## Funcionalidades

A aplicação oferece **CRUD completo** para os seguintes módulos:

* Funcionários: cadastro, atualização, listagem e remoção.
* Pátios: gerenciamento de pátios e suas localizações.
* Motos: registro de motos, status, localização e histórico.
* Câmeras: gerenciamento das câmeras dos pátios.
* ArUco Tags: identificação das motos usando tags de rastreamento.
* Status das motos: atualização automática e manual de status.
* Localidades: controle de localizações dentro dos pátios.

---

## 📚 Tecnologias Utilizadas

* **Java 21+**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL** (banco de dados)
* **Maven** (gerenciador de dependências)
* **JWT** (autenticação segura)
* **Thymeleaf** (templates para interface web)

---

## ⚙️ Como Executar o Projeto

### 🔁 Clonar o repositório via terminal:

```bash
git clone https://github.com/thejaobiell/MottuFlowJava.git
cd MottuFlowJava/MottuFlow
```

---

### 📥 Importar o projeto no IntelliJ IDEA:

1. Abra o **IntelliJ IDEA**
2. Vá em **File > Open**
3. Selecione a pasta `MottuFlow` que contém o `pom.xml`
4. O IntelliJ irá reconhecer automaticamente como **projeto Maven**

---

### 📥 Ou importar o projeto no Eclipse IDE: 
1. Abra o **Eclipse IDE**
2. Vá em **File > Import...**
3. Selecione **Maven > Existing Maven Projects**
4. Clique em **Browse** e selecione a pasta MottuFlow
5. Marque o arquivo pom.xml
6. Clique em **Finish** para concluir a importação
---

### 🛠️ Configuração do Banco de Dados MySQL

No arquivo `src/main/resources/application.properties`, configure o MySQL:

```properties
spring.application.name=MottuFlow

spring.datasource.url=jdbc:mysql://localhost:3306/mottuflow?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.repair=true
spring.flyway.repair-on-migrate=true

spring.main.allow-bean-definition-overriding=true
```

> ⚠️ Certifique-se de que o MySQL esteja rodando e que o usuário configurado tenha permissões para criar banco e tabelas.

---

### ▶️ Executando a aplicação

#### Via terminal:

```bash
./mvnw spring-boot:run
```

#### Via IntelliJ IDEA:

1. Navegue até: `MottuFlow/src/main/java/com/sprint/MottuFlow`
2. Abra `MottuFlowApplication.java`
3. Clique com o botão direito e selecione **Run 'MottuFlowApplication'**

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🔌 Acessando a API

Você pode consumir os endpoints REST utilizando ferramentas como **Postman** ou **Insomnia**.

* Todas as requisições e respostas utilizam **JSON**.
* Exemplo de endpoints CRUD:

```
GET /funcionarios
POST /funcionarios
PUT /funcionarios/{id}
DELETE /funcionarios/{id}
```

*(similares para motos, pátios, câmeras, tags e status)*

---

## 🧭 Observações

* Arquitetura em **camadas** com uso de **DTOs** para separar domínio e dados expostos
* Autenticação com **JWT** para API REST e **Spring Security** para Thymeleaf

---

## 👥 Equipe de Desenvolvimento

* **João Gabriel Boaventura Marques e Silva** – RM554874 – 2TDSB2025
* **Léo Mota Lima** – RM557851 – 2TDSB2025
* **Lucas Leal das Chagas** – RM551124 – 2TDSB2025

---
