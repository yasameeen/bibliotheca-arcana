# 📚 Bibliotheca Arcana

> *"Um sistema de gerenciamento de biblioteca virtual, onde cada estrutura de dados conta uma história."*

Projeto desenvolvido em Java para a disciplina de **Métodos de Pesquisa e Ordenação em Estruturas de Dados** — PUCPR ADS.

---

## ✦ Sobre o projeto

A **Bibliotheca Arcana** é um sistema de biblioteca virtual que demonstra na prática o uso de quatro estruturas de dados fundamentais do Java, integradas em um único sistema coeso e narrativo.

O sistema gerencia um acervo de 12 obras literárias clássicas, simula empréstimos e listas de espera, registra o histórico de consultas dos leitores e oferece recomendações personalizadas baseadas em um grafo de conexões entre livros.

---

## 🗂 Estruturas de dados

| Semana | Estrutura | Aplicação no sistema |
|--------|-----------|----------------------|
| 2 | `LinkedList<Livro>` | Acervo da biblioteca |
| 3 | `Queue<String>` | Lista de espera por empréstimo (FIFO) |
| 3 | `Stack<Livro>` | Histórico de consultas do leitor (LIFO) |
| 4 | `HashMap<Livro, Set<Livro>>` | Grafo de recomendações entre obras |

---

## 📖 Acervo

| # | Ícone | Obra | Autor | Gênero |
|---|-------|------|-------|--------|
| I | ☯ | 1984 | George Orwell | Distopia |
| II | ⚗ | Admirável Mundo Novo | Aldous Huxley | Distopia |
| III | ✦ | Fahrenheit 451 | Ray Bradbury | Distopia |
| IV | ❂ | O Senhor dos Anéis | J.R.R. Tolkien | Fantasia |
| V | ⚡ | Harry Potter e a Pedra Filosofal | J.K. Rowling | Fantasia |
| VI | ❄ | As Crônicas de Nárnia | C.S. Lewis | Fantasia |
| VII | ♜ | Dom Casmurro | Machado de Assis | Literatura Brasileira |
| VIII | ⚓ | Capitães da Areia | Jorge Amado | Literatura Brasileira |
| IX | ✝ | Memórias Póstumas de Brás Cubas | Machado de Assis | Literatura Brasileira |
| X | ☀ | Duna | Frank Herbert | Ficção Científica |
| XI | ☸ | Fundação | Isaac Asimov | Ficção Científica |
| XII | ◉ | Neuromancer | William Gibson | Ficção Científica |

---

## ⚙️ Como executar

### Pré-requisitos
- Java JDK 11 ou superior

### Compilar e rodar

\`\`\`bash
javac *.java
java Main
\`\`\`

### Com Docker

\`\`\`bash
docker build -t bibliotheca-arcana .
docker run --rm bibliotheca-arcana
\`\`\`

---

## 🏗 Estrutura do projeto

\`\`\`
bibliotheca-arcana/
├── Livro.java                    # Modelo principal (critério: 20% da nota)
├── ListaEncadeadaLivros.java     # Semana 2 — LinkedList
├── FilaEsperaLivros.java         # Semana 3 — Queue (FIFO)
├── PilhaHistoricoNavegacao.java  # Semana 3 — Stack (LIFO)
├── GrafoRecomendacoes.java       # Semana 4 — HashMap (SOMATIVA)
├── Main.java                     # Demonstração completa
├── Dockerfile                    # Containerização da aplicação
└── README.md
\`\`\`

---

## 🔁 Pipeline CI/CD

O projeto utiliza **GitHub Actions** para integração e entrega contínuas:

- **CI** — compila e valida o código a cada push
- **CD** — empacota e publica o artefato automaticamente

---

## 🎓 Disciplina

**Métodos de Pesquisa e Ordenação em Estruturas de Dados**  
Curso de Análise e Desenvolvimento de Sistemas — PUCPR  
Atividade Somativa 1
