# 🚆 trenSpot

**trenSpot** é uma API RESTful desenvolvida em Java com o framework **Quarkus**, voltada para a gestão inteligente de estações de metrô, plataformas, passageiros e investidores. Este projeto foi desenvolvido como parte do curso de Análise e Desenvolvimento de Sistemas da FIAP – Sprint 4.

---

## 🧠 Tecnologias Utilizadas

- Java 17
- Quarkus
- Jakarta REST (JAX-RS)
- JPA / Hibernate ORM
- Maven
- Oracle SQL (ambiente acadêmico FIAP)

---

## 📦 Entidades do Sistema

- **Passageiro**: nome, e-mail
- **Estacao**: nome da estação, média de passageiros
- **Plataforma**: nome, status, descrição e vínculo com estação
- **Investidor**: nome, CNPJ
- **Conteudo**: tema, vídeo, áudio

---

## 🔗 Endpoints REST (Exemplos)

```http
GET    /passageiros
POST   /estacoes
PUT    /plataformas/{id}
DELETE /investidores/{id}
