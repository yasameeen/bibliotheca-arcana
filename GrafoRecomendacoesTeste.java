import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class GrafoRecomendacoesTeste {

    private GrafoRecomendacoes grafo;
    private Livro duna;
    private Livro fundacao;
    private Livro neuromancer;

    @BeforeEach
    public void setUp() {
        grafo = new GrafoRecomendacoes(); // não-direcionado por padrão
        duna      = new Livro("Duna", "Frank Herbert", 1965, "Ficção Científica", "🏜️");
        fundacao  = new Livro("Fundação", "Isaac Asimov", 1951, "Ficção Científica", "🌌");
        neuromancer = new Livro("Neuromancer", "William Gibson", 1984, "Cyberpunk", "💻");
    }

    @Test
    public void adicionarLivroDeveRegistrarNoGrafo() {
        grafo.adicionarLivro(duna);

        assertEquals(1, grafo.getTotalLivros(),
            "Grafo deve conter 1 livro após adição");
    }

    @Test
    public void recomendacaoBidirecionalDeveConectarAmbosSentidos() {
        grafo.adicionarRecomendacao(duna, fundacao);

        assertTrue(grafo.existeRecomendacao(duna, fundacao),
            "Deve existir recomendação de Duna para Fundação");
        assertTrue(grafo.existeRecomendacao(fundacao, duna),
            "Grafo não-direcionado deve ter recomendação de Fundação para Duna também");
    }

    @Test
    public void recomendacaoDirecionadaNaoDeveSerBidirecional() {
        GrafoRecomendacoes grafoDirecionado = new GrafoRecomendacoes(true);
        grafoDirecionado.adicionarRecomendacao(duna, fundacao);

        assertTrue(grafoDirecionado.existeRecomendacao(duna, fundacao));
        assertFalse(grafoDirecionado.existeRecomendacao(fundacao, duna),
            "Grafo direcionado não deve criar aresta no sentido inverso");
    }

    @Test
    public void sugerirPorLivroDeveRetornarRecomendacoesCorretas() {
        grafo.adicionarRecomendacao(duna, fundacao);
        grafo.adicionarRecomendacao(duna, neuromancer);

        Set<Livro> sugestoes = grafo.sugerirPorLivro(duna);

        assertEquals(2, sugestoes.size(), "Duna deve ter 2 recomendações");
        assertTrue(sugestoes.contains(fundacao));
        assertTrue(sugestoes.contains(neuromancer));
    }

    @Test
    public void sugerirPorLivroNaoCadastradoDeveRetornarSetVazio() {
        Livro livroForaDoGrafo = new Livro("Desconhecido", "Autor X", 2000, "Mistério");

        Set<Livro> sugestoes = grafo.sugerirPorLivro(livroForaDoGrafo);

        assertTrue(sugestoes.isEmpty(),
            "Livro não cadastrado não deve retornar sugestões");
    }

    @Test
    public void grafoNaoDeveTerRecomendacoesDuplicadas() {
        grafo.adicionarRecomendacao(duna, fundacao);
        grafo.adicionarRecomendacao(duna, fundacao); // duplicata

        Set<Livro> sugestoes = grafo.sugerirPorLivro(duna);

        assertEquals(1, sugestoes.size(),
            "Recomendação duplicada não deve ser inserida duas vezes (Set)");
    }
}