import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PilhaHistoricoNavegacaoTeste {

    private PilhaHistoricoNavegacao historico;
    private Livro livro1;
    private Livro livro2;
    private Livro livro3;

    @BeforeEach
    public void setUp() {
        historico = new PilhaHistoricoNavegacao("Frodo");
        livro1 = new Livro("O Hobbit", "Tolkien", 1937, "Fantasia", "🧙");
        livro2 = new Livro("A Sociedade do Anel", "Tolkien", 1954, "Fantasia", "💍");
        livro3 = new Livro("As Duas Torres", "Tolkien", 1954, "Fantasia", "🗼");
    }

    @Test
    public void pilhaDeveIniciarVazia() {
        assertTrue(historico.estaVazia(), "Histórico recém-criado deve estar vazio");
        assertEquals(0, historico.getTamanho());
    }

    @Test
    public void empilharDeveAumentarTamanho() {
        historico.empilhar(livro1);
        historico.empilhar(livro2);

        assertEquals(2, historico.getTamanho());
        assertFalse(historico.estaVazia());
    }

    @Test
    public void verTopoDeveRetornarUltimoLivroEmpilhado() {
        historico.empilhar(livro1);
        historico.empilhar(livro2);

        assertEquals(livro2, historico.verTopo(),
            "O topo deve ser o último livro empilhado (LIFO)");
        assertEquals(2, historico.getTamanho(), "verTopo não deve remover o elemento");
    }

    @Test
    public void desempilharDeveRespeiarOrdemLIFO() {
        historico.empilhar(livro1);
        historico.empilhar(livro2);
        historico.empilhar(livro3);

        assertEquals(livro3, historico.desempilhar(), "Último a entrar deve ser o primeiro a sair");
        assertEquals(livro2, historico.desempilhar());
        assertEquals(livro1, historico.desempilhar());
        assertTrue(historico.estaVazia());
    }

    @Test
    public void desempilharPilhaVaziaDeveRetornarNull() {
        assertNull(historico.desempilhar(),
            "Desempilhar pilha vazia deve retornar null");
    }

    @Test
    public void verTopoPilhaVaziaDeveRetornarNull() {
        assertNull(historico.verTopo(),
            "verTopo em pilha vazia deve retornar null");
    }

    @Test
    public void getNomeLeitorDeveRetornarNomeCorreto() {
        assertEquals("Frodo", historico.getNomeLeitor());
    }
}