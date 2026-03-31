# 🥷 Ninja & Mission Management System

[![Java](https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.4-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Flyway](https://img.shields.io/badge/Flyway-CC0202?style=for-the-badge&logo=flyway&logoColor=white)](https://flywaydb.org/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](http://localhost:8080/swagger-ui.html)

Este projeto foi desenvolvido como parte do curso **Batismo em Java do Fiasco**. Ele consiste em um sistema para gerenciar ninjas e suas missões, utilizando as melhores práticas de desenvolvimento com o ecossistema Spring.

---

## 🛠️ Stack Tecnológica

O projeto utiliza tecnologias modernas para garantir escalabilidade e facilidade de manutenção:

* **Java 25**: Utilizando os recursos mais recentes da linguagem.
* **Spring Boot 4.0.4**: Base da aplicação para desenvolvimento ágil.
* **Spring Data JPA**: Abstração para persistência de dados.
* **Flyway**: Gerenciamento e versionamento do banco de dados (Migrations).
* **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento.
* **Lombok**: Redução de código boilerplate através de anotações.
* **Thymeleaf**: Engine de templates para criação de telas dinâmicas.
* **SpringDoc OpenAPI (Swagger)**: Documentação interativa de todos os endpoints.

---

## 🚀 Funcionalidades

* **Cadastro de Ninjas**: CRUD completo (Criar, Ler, Atualizar e Deletar).
* **Gestão de Missões**: Criação de missões e vinculação com os ninjas.
* **Interface Web**: Visualização de dados via navegador com Thymeleaf.
* **Versionamento SQL**: Migrações automáticas de tabelas via Flyway.
* **Documentação Automática**: Interface visual para testes de API.

---

## 📂 Como Rodar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/gabriel-castelo/CadastroNinjas.git](https://github.com/gabriel-castelo/CadastroNinjas.git)
    ```
2.  **Verifique sua versão do Java:**
    Certifique-se de estar utilizando o JDK 25.
    ```bash
    java -version
    ```
3.  **Execute a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```

---

## 🔍 Links Úteis (Com a aplicação rodando)

* **Página Inicial (Web):** `http://localhost:8080/`
* **Swagger UI (Documentação):** `http://localhost:8080/swagger-ui/index.html`
* **H2 Console:** `http://localhost:8080/h2-console`
    * *Configuração JDBC URL:* `jdbc:h2:mem:testdb`

---

## 📐 Estrutura de Pacotes (`castelo.gabriel`)

Organização baseada em camadas:
- `model`: Entidades (Ninjas e Missões).
- `controller`: Controllers REST e Web.
- `service`: Regras de negócio.
- `repository`: Interfaces de acesso ao banco.

---
