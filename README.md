# 🚀 DualCore Solutions - Sistema de Autenticação Robusto

Projeto de backend focado em segurança e infraestrutura escalável, utilizando tecnologias modernas do ecossistema Java Enterprise.

## 🛠️ Tecnologias Utilizadas
* **Linguagem**: Java 17.
* **Framework**: Jakarta EE 10 (Servlets, JPA, EJB).
* **Servidor de Aplicação**: Payara Community.
* **Banco de Dados**: PostgreSQL.
* **Segurança**: BCrypt para hashing de senhas.

## 🏗️ Arquitetura e Desafios Resolvidos
* **Camada de Serviço (EJB)**: Implementação de `@Stateless` beans para garantir a integridade transacional e resolver erros de `TransactionRequiredException`.
* **Persistência**: Configuração de Pool de Conexões JDBC e JNDI Resources no Payara para comunicação eficiente com o PostgreSQL.
* **Autenticação Dinâmica**: Uso de sessões HTTP para proteger o acesso ao Dashboard e JSPs para renderização de dados do usuário.

## 📧 Contato
* **Empresa**: DualCore Solutions.
* **E-mail**: dualcoresolutions.tech@gmail.com.
* **Foco**: Infraestrutura, Python e Automação.
