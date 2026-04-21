# 📚 Bibliotheca Arcana

> *"Um sistema de gerenciamento de biblioteca virtual, onde cada estrutura de dados conta uma história."*

Projeto desenvolvido em Java para a disciplina de **Métodos de Pesquisa e Ordenação em Estruturas de Dados** e utilizado na disciplina de **DevOps** para aprendizado prático de controle de versão, CI/CD e containerização com Docker.

---

## 🪄 Sobre o projeto

A **Bibliotheca Arcana** é um sistema de biblioteca virtual que demonstra na prática o uso de quatro estruturas de dados fundamentais do Java, integradas em um único sistema coeso e narrativo.

O sistema gerencia um acervo de 12 obras literárias clássicas, simula empréstimos e listas de espera, registra o histórico de consultas dos leitores e oferece recomendações personalizadas baseadas em um grafo de conexões entre livros.

---

## 🎲 Estruturas de dados

| Semana | Estrutura | Aplicação no sistema |
|--------|-----------|----------------------|
| 2 | `LinkedList<Livro>` | Acervo da biblioteca |
| 3 | `Queue<String>` | Lista de espera por empréstimo (FIFO) |
| 3 | `Stack<Livro>` | Histórico de consultas do leitor (LIFO) |
| 4 | `HashMap<Livro, Set<Livro>>` | Grafo de recomendações entre obras |

---

## 🔮 Como executar

**Pré-requisitos:** Java JDK 17 ou superior

\`\`\`bash
javac *.java
java Main
\`\`\`

**Com Docker:**

\`\`\`bash
docker build -t bibliotheca-arcana .
docker run --rm bibliotheca-arcana
\`\`\`

---

## 🪐 Estrutura do projeto

```text
bibliotheca-arcana/
├── .github/workflows/ci-cd.yml      # Pipeline CI/CD
├── Livro.java                        # Modelo principal
├── ListaEncadeadaLivros.java         # Semana 2 — LinkedList
├── FilaEsperaLivros.java             # Semana 3 — Queue (FIFO)
├── PilhaHistoricoNavegacao.java      # Semana 3 — Stack (LIFO)
├── GrafoRecomendacoes.java           # Semana 4 — HashMap
├── Main.java                         # Demonstração completa
├── Dockerfile                        # Containerização
└── README.md
```

---

## 🔐 CI/CD com GitHub Actions

[![CI/CD Pipeline](https://github.com/yasameeen/bibliotheca-arcana/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/yasameeen/bibliotheca-arcana/actions/workflows/ci-cd.yml)

O pipeline roda automaticamente a cada `push` ou `pull request` com dois jobs:

| Job | Tipo | O que faz |
|-----|------|-----------|
| `build` | CI | Configura Java 17 e compila o projeto |
| `deploy` | CD | Builda a imagem Docker e testa o container |

> O job `deploy` só roda se o `build` passar com sucesso.
