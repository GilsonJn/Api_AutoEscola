# Api_AutoEscola 🚗

## Grupo:
- Gilson Dias Ramos Junior - RM552345
- Isabelle Toricelli da Silva - RM552806
- Jeferson Gabriel de Mendonça - RM553149

Turma: 3ESPA

## Sobre o projeto

Uma API RESTful robusta e segura desenvolvida para o gerenciamento do sistema de uma Autoescola. O projeto fornece endpoints para a administração de instrutores, alunos e controle de acesso de utilizadores, aplicando princípios de Clean Architecture e as melhores práticas do mercado de desenvolvimento back-end.

Esta API constrói uma base de dados sólida e protegida, deixando o sistema completamente pronto para ser integrado de forma fluida com futuras aplicações front-end focadas numa excelente experiência de utilizador (UX).

## 🚀 Principais Funcionalidades

- Gestão de Entidades: Operações completas de CRUD (Create, Read, Update, Delete) para Alunos e Instrutores, utilizando paginação inteligente nas listagens.
- Segurança Avançada: Autenticação stateless implementada com Spring Security e tokens JWT (JSON Web Token).
- Controlo de Acesso (RBAC): Sistema de autorização baseado em perfis (Administrador e Utilizador Padrão), garantindo que apenas os utilizadores com as permissões corretas acedem a rotas sensíveis e alteram palavras-passe de forma segura através do cruzamento de dados do token.
- Integridade de Dados: Validação rigorosa de dados de entrada com Spring Validation e tráfego seguro de informações isolado através do padrão de projeto DTO (Data Transfer Objects / Records).
- Exclusão Lógica (Soft Delete): Preservação do histórico da base de dados inativando registos em vez de os apagar permanentemente.
- Versionamento de Base de Dados: Gestão automatizada e rastreável do esquema MySQL utilizando o Flyway para as migrações (Migrations).

## 🛠️ Tecnologias e Stack

- Linguagem: Java 21
- Framework: Spring Boot (Web, Data JPA, Security, Validation)
- Base de Dados: MySQL
- Migrações: Flyway
- Autenticação: API Java JWT (Auth0)
- Otimização de Código: Lombok
