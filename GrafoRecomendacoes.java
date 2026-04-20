import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GrafoRecomendacoes {

    private HashMap<Livro, Set<Livro>> grafo;
    private boolean direcionado;

    public GrafoRecomendacoes() { this(false); }

    public GrafoRecomendacoes(boolean direcionado) {
        this.grafo = new HashMap<>();
        this.direcionado = direcionado;
    }

    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashSet<>());
    }

    public void adicionarRecomendacao(Livro origem, Livro destino) {
        adicionarLivro(origem);
        adicionarLivro(destino);
        grafo.get(origem).add(destino);
        if (!direcionado) {
            grafo.get(destino).add(origem);
        }
    }

    public Set<Livro> getRecomendacoesDiretas(Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }

    public Set<Livro> sugerirPorLivro(Livro livroLido) {
        if (!grafo.containsKey(livroLido)) return new HashSet<>();
        return new LinkedHashSet<>(grafo.get(livroLido));
    }

    public Set<Livro> sugerirPorHistorico(ListaEncadeadaLivros livrosLidos) {
        Set<Livro> sugestoes = new LinkedHashSet<>();
        Set<Livro> jaLidos = new HashSet<>();
        for (Livro candidato : grafo.keySet()) {
            if (livrosLidos.buscarPorTitulo(candidato.getTitulo()) != null) {
                jaLidos.add(candidato);
            }
        }
        for (Livro lido : jaLidos) {
            Set<Livro> recomendacoes = grafo.get(lido);
            if (recomendacoes == null) continue;
            for (Livro rec : recomendacoes) {
                if (!jaLidos.contains(rec)) sugestoes.add(rec);
            }
        }
        return sugestoes;
    }

    public boolean existeRecomendacao(Livro origem, Livro destino) {
        Set<Livro> vizinhos = grafo.get(origem);
        return vizinhos != null && vizinhos.contains(destino);
    }

    public int getTotalLivros() { return grafo.size(); }
    public HashMap<Livro, Set<Livro>> getGrafo() { return grafo; }
    public boolean isDirecionado() { return direcionado; }
    
    public void imprimirAgrupadoPorGenero(ListaEncadeadaLivros acervo,
                                          int pausaEntreLivros) {
        Map<String, List<Livro>> porGenero = new LinkedHashMap<>();
        for (Livro livro : acervo.getLivros()) {
            porGenero.computeIfAbsent(livro.getGenero(),
                    k -> new ArrayList<>()).add(livro);
        }

        int clusterIdx = 0;
        int totalClusters = porGenero.size();
        for (Map.Entry<String, List<Livro>> cluster : porGenero.entrySet()) {
            String genero = cluster.getKey();
            List<Livro> livrosDoGenero = cluster.getValue();

            String header = "── " + genero.toUpperCase() + " ";
            int larguraInterna = 61;
            int preenchimento = Math.max(0, larguraInterna - header.length());
            System.out.println("  ┌" + header + "─".repeat(preenchimento) + "┐");
            System.out.println("  │");

            for (Livro livro : livrosDoGenero) {
                Set<Livro> recomendacoes = grafo.get(livro);
                int posRomana = acervo.getLivros().indexOf(livro) + 1;
                String romano = Main.toRomanoPublico(posRomana);

                System.out.println("  │  " + String.format("%-5s", romano + ".")
                        + " " + livro.getIcone() + "  " + livro.getTitulo());

                if (recomendacoes == null || recomendacoes.isEmpty()) {
                    System.out.println("  │         (nenhuma recomendação)");
                } else {
                    List<Livro> recomendacoesOrdenadas = new ArrayList<>(recomendacoes);
                    recomendacoesOrdenadas.sort((a, b) ->
                            Integer.compare(
                                    acervo.getLivros().indexOf(a),
                                    acervo.getLivros().indexOf(b)));

                    int i = 0;
                    int total = recomendacoesOrdenadas.size();
                    for (Livro rec : recomendacoesOrdenadas) {
                        String conector = (i == total - 1) ? "└─❧" : "├─❧";
                        System.out.println("  │         " + conector + " "
                                + rec.getIcone() + "  " + rec.getTitulo());
                        i++;
                    }
                }
                System.out.println("  │");

                try { Thread.sleep(pausaEntreLivros); }
                catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            System.out.println("  └" + "─".repeat(61) + "┘");

            clusterIdx++;
            if (clusterIdx < totalClusters) System.out.println();
        }
    }
}