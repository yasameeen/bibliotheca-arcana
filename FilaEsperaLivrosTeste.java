import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilaEsperaLivrosTeste {

    private FilaEsperaLivros fila;

    @BeforeEach
    public void setUp() {
        fila = new FilaEsperaLivros("Duna");
    }

    @Test
    public void filaDeveIniciarVazia() {
        assertTrue(fila.estaVazia(), "Fila recém-criada deve estar vazia");
        assertEquals(0, fila.getTamanho());
    }

    @Test
    public void enfileirarDeveAdicionarLeitoresNaOrdemCorreta() {
        fila.enfileirar("Hermione");
        fila.enfileirar("Gandalf");
        fila.enfileirar("Frodo");

        assertEquals(3, fila.getTamanho());
        assertEquals("Hermione", fila.verProximo(),
            "O primeiro enfileirado deve ser o próximo (FIFO)");
    }

    @Test
    public void desenfileirarDeveRespeiarOrdemFIFO() {
        fila.enfileirar("Hermione");
        fila.enfileirar("Gandalf");

        String primeiro = fila.desenfileirar();
        String segundo = fila.desenfileirar();

        assertEquals("Hermione", primeiro, "Primeiro a entrar deve ser o primeiro a sair");
        assertEquals("Gandalf", segundo);
        assertTrue(fila.estaVazia());
    }

    @Test
    public void desenfileirarFilaVaziaDeveRetornarNull() {
        assertNull(fila.desenfileirar(),
            "Desenfileirar fila vazia deve retornar null");
    }

    @Test
    public void posicaoRomanaDeveConverterTamanhoCorretamente() {
        fila.enfileirar("Leitor A");
        fila.enfileirar("Leitor B");
        fila.enfileirar("Leitor C"); // tamanho = 3

        assertEquals("III", fila.posicaoRomana(),
            "3 leitores na fila deve retornar III em romano");
    }

    @Test
    public void getTituloDoLivroDeveRetornarTituloCorreto() {
        assertEquals("Duna", fila.getTituloDoLivro());
    }
}