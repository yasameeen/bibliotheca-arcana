import java.util.Stack;

public class Main {

    private static final int PAUSA_ITEM     = 400;
    private static final int PAUSA_SECAO    = 1200;
    private static final int PAUSA_DESTAQUE = 800;
    private static final int LARGURA_BOX    = 66;

    public static void main(String[] args) {
        pausar(PAUSA_SECAO);
        exibirCapa();
        pausar(PAUSA_SECAO);

        // Semana 2 — LinkedList<Livro>
        tituloSecao("ACERVO DA BIBLIOTECA");

        ListaEncadeadaLivros acervo = new ListaEncadeadaLivros();

        Livro l1  = new Livro("1984", "George Orwell", 1949, "Distopia", "☯");
        Livro l2  = new Livro("Admirável Mundo Novo", "Aldous Huxley", 1932, "Distopia", "⚗");
        Livro l3  = new Livro("Fahrenheit 451", "Ray Bradbury", 1953, "Distopia", "✦");
        Livro l4  = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Fantasia", "❂");
        Livro l5  = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, "Fantasia", "⚡");
        Livro l6  = new Livro("As Crônicas de Nárnia", "C.S. Lewis", 1950, "Fantasia", "❄");
        Livro l7  = new Livro("Dom Casmurro", "Machado de Assis", 1899, "Literatura Brasileira", "♜");
        Livro l8  = new Livro("Capitães da Areia", "Jorge Amado", 1937, "Literatura Brasileira", "⚓");
        Livro l9  = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881, "Literatura Brasileira", "✝");
        Livro l10 = new Livro("Duna", "Frank Herbert", 1965, "Ficção Científica", "☀");
        Livro l11 = new Livro("Fundação", "Isaac Asimov", 1951, "Ficção Científica", "☸");
        Livro l12 = new Livro("Neuromancer", "William Gibson", 1984, "Ficção Científica", "◉");

        // Critério: grafo com ≥ 10 livros
        Livro[] todosLivros = { l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12 };

        System.out.println("  Registrando os exemplares no acervo da biblioteca...\n");
        pausar(PAUSA_DESTAQUE);

        int contador = 1;
        for (Livro l : todosLivros) {
            acervo.adicionar(l);
            String numeroFormatado = String.format("%-5s", toRomano(contador) + ".");
            System.out.println("  " + numeroFormatado + " \"" + l.getTitulo()
                    + "\" — " + l.getAutor() + " (" + l.getAnoPublicacao()
                    + ") [" + l.getGenero() + "]");
            contador++;
            pausar(PAUSA_ITEM);
        }

        System.out.println("\n  ✦ Acervo completo: " + acervo.getTamanho() + " exemplares registrados");
        pausar(PAUSA_SECAO);

        // Semana 3 — Queue<String> (FIFO)
        tituloSecao("LISTA DE ESPERA");

        System.out.println("  ⚜  O exemplar de \"1984\" está emprestado.  ⚜");
        System.out.println("  Três leitores procuram a obra e se registram na lista de espera.\n");
        pausar(PAUSA_DESTAQUE);

        FilaEsperaLivros esperaDe1984 = new FilaEsperaLivros(l1.getTitulo());

        esperaDe1984.enfileirar("Cecília");
        System.out.println("  → Cecília chega à biblioteca e se registra na lista de espera.");
        System.out.println("      Posição atual: " + esperaDe1984.posicaoRomana() + "  (primeira da fila)\n");
        pausar(PAUSA_ITEM);

        esperaDe1984.enfileirar("Antônio");
        System.out.println("  → Antônio também deseja ler \"1984\".");
        System.out.println("      Posição atual: " + esperaDe1984.posicaoRomana() + "  (atrás de Cecília)\n");
        pausar(PAUSA_ITEM);

        esperaDe1984.enfileirar("José");
        System.out.println("  → José é o terceiro interessado na obra.");
        System.out.println("      Posição atual: " + esperaDe1984.posicaoRomana() + "  (atrás de Antônio)");
        pausar(PAUSA_DESTAQUE);

        separadorFino();

        System.out.println("  ⚜  O exemplar de \"1984\" retornou ao acervo.  ⚜");
        System.out.println("  A fila será honrada: a primeira leitora terá a preferência.\n");
        pausar(PAUSA_DESTAQUE);
        esperaDe1984.desenfileirar();
        System.out.println("  → Cecília, a primeira interessada, tomou posse do livro.");
        pausar(PAUSA_DESTAQUE);

        separadorFino();

        System.out.println("  ⚜  A lista de espera foi atualizada:  ⚜");
        System.out.println("  Agora há apenas dois leitores na espera pela obra.\n");
        pausar(PAUSA_DESTAQUE);
        imprimirFilaNarrativa(esperaDe1984);
        pausar(PAUSA_SECAO);

        // Semana 3 — Stack<Livro> (LIFO)
        tituloSecao("HISTÓRICO DE CONSULTAS");

        System.out.println("  Maria, uma leitora assídua de distopias, percorre as estantes");
        System.out.println("  da biblioteca, consultando alguns exemplares pelo caminho.\n");
        pausar(PAUSA_DESTAQUE);

        PilhaHistoricoNavegacao historicoMaria = new PilhaHistoricoNavegacao("Maria");

        historicoMaria.empilhar(l1);  pausar(PAUSA_ITEM);
        historicoMaria.empilhar(l2);  pausar(PAUSA_ITEM);
        historicoMaria.empilhar(l3);  pausar(PAUSA_ITEM);
        historicoMaria.empilhar(l10); pausar(PAUSA_DESTAQUE);

        System.out.println("  Trajeto de Maria pelas estantes:\n");
        imprimirLinhaDoTempo(historicoMaria.getPilha());
        pausar(PAUSA_SECAO);

        System.out.println();
        System.out.println("  ⚜  Pilha de consultas resultante:  ⚜");
        System.out.println("  (topo = última consulta, primeira a sair)\n");
        imprimirPilha(historicoMaria.getPilha());
        pausar(PAUSA_SECAO);

        separadorFino();

        System.out.println("  Maria decide revisitar sua trajetória e recua sobre seus");
        System.out.println("  passos, encerrando as duas últimas consultas feitas.\n");
        pausar(PAUSA_DESTAQUE);
        Livro saiu1 = historicoMaria.desempilhar();
        System.out.println("  ⤺  Maria encerra a consulta de \"" + saiu1.getTitulo() + "\"");
        pausar(PAUSA_ITEM);
        Livro saiu2 = historicoMaria.desempilhar();
        System.out.println("  ⤺  Maria encerra a consulta de \"" + saiu2.getTitulo() + "\"");
        pausar(PAUSA_DESTAQUE);

        separadorFino();

        System.out.println("  ⚜  A pilha de consultas foi atualizada:  ⚜\n");
        imprimirPilha(historicoMaria.getPilha());
        pausar(PAUSA_SECAO);

        tituloSecao("GRAFO DE RECOMENDAÇÕES");

        System.out.println("  Construindo o grafo de recomendações entre livros...");
        System.out.println("  Estrutura utilizada: HashMap<Livro, Set<Livro>>\n");
        pausar(PAUSA_DESTAQUE);

        // Critério: HashMap<Livro, Set<Livro>> implementado + cada livro terá ≥ 2 recomendações 
        GrafoRecomendacoes grafo = new GrafoRecomendacoes();
        for (Livro l : todosLivros) grafo.adicionarLivro(l);
        
        grafo.adicionarRecomendacao(l1, l2);  
        grafo.adicionarRecomendacao(l1, l3);
        grafo.adicionarRecomendacao(l2, l3);
        grafo.adicionarRecomendacao(l4, l5);  
        grafo.adicionarRecomendacao(l4, l6);
        grafo.adicionarRecomendacao(l5, l6);
        grafo.adicionarRecomendacao(l7, l8);  
        grafo.adicionarRecomendacao(l7, l9);
        grafo.adicionarRecomendacao(l8, l9);
        grafo.adicionarRecomendacao(l10, l11); 
        grafo.adicionarRecomendacao(l10, l12);
        grafo.adicionarRecomendacao(l11, l12);
        grafo.adicionarRecomendacao(l1, l12);  
        grafo.adicionarRecomendacao(l3, l10);
        grafo.adicionarRecomendacao(l4, l10);
        grafo.adicionarRecomendacao(l2, l11);

        System.out.println("  ✦ Grafo construído: " + grafo.getTotalLivros()
                + " livros conectados por recomendações mútuas\n");
        pausar(PAUSA_DESTAQUE);

        boxInformativo(new String[] {
                "O grafo é não direcionado: se \"A recomenda B\",",
                "\"B também recomenda A\". Por isso cada conexão aparece",
                "nos dois sentidos, comprovando que todos os livros",
                "atendem ao requisito mínimo de duas recomendações."
        });
        pausar(PAUSA_DESTAQUE);

        grafo.imprimirAgrupadoPorGenero(acervo, PAUSA_ITEM);
        pausar(PAUSA_SECAO);

        tituloSecao("SUGESTÃO — A partir de um único livro");

        System.out.println("  Maria, apaixonada por distopias, acabou de terminar a leitura de:\n");
        System.out.println("    " + l1);
        pausar(PAUSA_DESTAQUE);

        separadorFino();

        System.out.println("  Obras sugeridas pelo grafo de recomendações,");
        System.out.println("  com base nas conexões temáticas e narrativas do livro:\n");
        pausar(PAUSA_DESTAQUE);
        for (Livro sugestao : grafo.sugerirPorLivro(l1)) {
            System.out.println("    " + sugestao);
            pausar(PAUSA_ITEM);
        }
        pausar(PAUSA_SECAO);

        tituloSecao("SUGESTÃO — A partir do histórico de leituras");

        System.out.println("  Em outra ocasião, Maria já havia passado pelas seguintes obras:\n");
        ListaEncadeadaLivros jaLidos = new ListaEncadeadaLivros();
        jaLidos.adicionar(l1);
        jaLidos.adicionar(l4);
        jaLidos.adicionar(l7);

        for (Livro l : jaLidos.getLivros()) {
            System.out.println("    " + l);
            pausar(PAUSA_ITEM);
        }
        pausar(PAUSA_DESTAQUE);

        separadorFino();

        System.out.println("  Sugestões personalizadas pelo grafo, cruzando os livros já lidos");
        System.out.println("  com suas respectivas recomendações. Obras que Maria já leu são");
        System.out.println("  automaticamente filtradas para evitar repetições.\n");
        pausar(PAUSA_DESTAQUE);

        for (Livro sugestao : grafo.sugerirPorHistorico(jaLidos)) {
            String origem = descobrirOrigemDaRecomendacao(sugestao, jaLidos, grafo);
            System.out.println("    " + sugestao);
            if (origem != null) System.out.println("       ↳ sugerido porque ela leu \"" + origem + "\"");
            System.out.println();
            pausar(PAUSA_ITEM);
        }
        pausar(PAUSA_SECAO);

        exibirFim();
    }

    private static void exibirCapa() {
        String ornamento  = "───────── ◆ ─── ❖ ─── ◆ ─────────";
        String titulo     = "BIBLIOTHECA ARCANA";
        String descricao  = "Sistema de gerenciamento de biblioteca virtual";

        System.out.println();
        System.out.println("  " + centralizar(ornamento, LARGURA_BOX));
        System.out.println();
        System.out.println();
        System.out.println("  " + centralizar(titulo, LARGURA_BOX));
        System.out.println();
        System.out.println("  " + centralizar(descricao, LARGURA_BOX));
        System.out.println();
        System.out.println();
        System.out.println("  " + centralizar(ornamento, LARGURA_BOX));
        System.out.println();
    }

    private static void exibirFim() {
        int interna  = LARGURA_BOX - 2;
        String orn   = "• ◈ •";
        int espOrn   = (interna - orn.length()) / 2;
        String borda = "─".repeat(espOrn) + " " + orn + " "
                + "─".repeat(interna - espOrn - orn.length() - 2);

        System.out.println();
        System.out.println("  ╭" + borda + "╮");
        System.out.println("  │" + " ".repeat(interna) + "│");
        System.out.println("  │" + centralizar("Fim da demonstração", interna) + "│");
        System.out.println("  │" + " ".repeat(interna) + "│");
        System.out.println("  ╰" + borda + "╯");
        System.out.println();
    }

    private static void tituloSecao(String titulo) {
        int interna = LARGURA_BOX - 2;
        System.out.println();
        System.out.println("  ╭" + "─".repeat(interna) + "╮");
        System.out.println("  │" + centralizar(titulo, interna) + "│");
        System.out.println("  ╰" + "─".repeat(interna) + "╯");
        System.out.println();
    }

    private static void boxInformativo(String[] linhas) {
        int interna      = LARGURA_BOX - 2;
        String header    = " ℹ  Como ler este grafo ";
        int espacoHeader = interna - header.length() - 1;

        System.out.println();
        System.out.println("  ┌─" + header + "─".repeat(Math.max(0, espacoHeader)) + "┐");
        System.out.println("  │" + " ".repeat(interna) + "│");
        for (String linha : linhas) {
            String conteudo = "   " + linha;
            System.out.println("  │" + conteudo + " ".repeat(Math.max(0, interna - conteudo.length())) + "│");
        }
        System.out.println("  │" + " ".repeat(interna) + "│");
        System.out.println("  └" + "─".repeat(interna) + "┘");
        System.out.println();
    }

    private static void separadorFino() {
        String sep = "◎ ══════════════════ ❈ ══════════════════ ◎";
        int esq    = Math.max(0, (LARGURA_BOX - sep.length() - 2) / 2);
        System.out.println();
        System.out.println("  " + " ".repeat(esq) + sep);
        System.out.println();
    }

    private static void imprimirFilaNarrativa(FilaEsperaLivros fila) {
        java.util.Queue<String> temp = new java.util.LinkedList<>();
        String[] acoes = {
                "assumiu o primeiro lugar da fila",
                "avançou para a segunda posição",
                "avançou para a terceira posição"
        };
        String leitorAnterior = null;
        int p = 1;

        while (!fila.estaVazia()) {
            String leitor = fila.desenfileirar();
            String desc   = (p == 1) ? "(primeira da fila)" : "(atrás de " + leitorAnterior + ")";
            String acao   = (p - 1 < acoes.length) ? acoes[p - 1] : "está aguardando na fila";

            System.out.println("  → " + leitor + " " + acao + ".");
            System.out.println("      Posição atual: " + toRomano(p) + "  " + desc + "\n");

            temp.offer(leitor);
            leitorAnterior = leitor;
            p++;
            pausar(PAUSA_ITEM);
        }
        while (!temp.isEmpty()) fila.enfileirar(temp.poll());
    }

    private static void imprimirLinhaDoTempo(Stack<Livro> pilha) {
        StringBuilder sb = new StringBuilder("    ");
        for (int i = 0; i < pilha.size(); i++) {
            Livro l = pilha.get(i);
            sb.append(l.getIcone()).append(" ").append(l.getTitulo());
            if (i < pilha.size() - 1) sb.append("  →  ");
        }
        System.out.println(sb.toString());
    }

    private static void imprimirPilha(Stack<Livro> pilha) {
        if (pilha.isEmpty()) { System.out.println("    (pilha vazia)"); return; }
        for (int i = pilha.size() - 1; i >= 0; i--) {
            Livro l = pilha.get(i);
            if (i == pilha.size() - 1) {
                System.out.println("    ▸ " + l.getIcone() + "  " + l.getTitulo() + "   ◂ topo");
            } else {
                System.out.println("      " + l.getIcone() + "  " + l.getTitulo());
            }
        }
    }

    private static String descobrirOrigemDaRecomendacao(Livro sugestao,
                                                        ListaEncadeadaLivros jaLidos,
                                                        GrafoRecomendacoes grafo) {
        for (Livro livroLido : jaLidos.getLivros()) {
            if (grafo.existeRecomendacao(livroLido, sugestao)) return livroLido.getTitulo();
        }
        return null;
    }

    private static String toRomano(int numero) {
        if (numero <= 0) return "";
        int[]    valores  = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] simbolos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < valores.length; i++)
            while (numero >= valores[i]) { sb.append(simbolos[i]); numero -= valores[i]; }
        return sb.toString();
    }

    public static String toRomanoPublico(int numero) { return toRomano(numero); }

    private static String centralizar(String texto, int largura) {
        int espaco = largura - texto.length();
        if (espaco <= 0) return texto;
        int esq = espaco / 2;
        return " ".repeat(esq) + texto + " ".repeat(espaco - esq);
    }

    private static void pausar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}