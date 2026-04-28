import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEncadeadaLivrosTeste {

    private ListaEncadeadaLivros acervo;
    private Livro livro1;
    private Livro livro2;

    @BeforeEach
    public void setUp() {
        acervo = new ListaEncadeadaLivros();
        livro1 = new Livro("O Senhor dos Anéis", "Tolkien", 1954, "Fantasia", "💍");
        livro2 = new Livro("Harry Potter", "Rowling", 1997, "Fantasia", "🧙");
    }

    @Test
    public void acervoDeveIniciarVazio() {
        assertTrue(acervo.estaVazia(), "Acervo recém-criado deve estar vazio");
        assertEquals(0, acervo.getTamanho());
    }

    @Test
    public void adicionarLivroDeveAumentarTamanho() {
        acervo.adicionar(livro1);
        acervo.adicionar(livro2);

        assertEquals(2, acervo.getTamanho(), "Acervo deve conter 2 livros após adições");
        assertFalse(acervo.estaVazia());
    }

    @Test
    public void buscarPorTituloDeveRetornarLivroCorreto() {
        acervo.adicionar(livro1);
        acervo.adicionar(livro2);

        Livro encontrado = acervo.buscarPorTitulo("Harry Potter");

        assertNotNull(encontrado, "Deve encontrar o livro pelo título");
        assertEquals("Rowling", encontrado.getAutor());
    }

    @Test
    public void buscarTituloInexistenteDeveRetornarNull() {
        acervo.adicionar(livro1);

        Livro resultado = acervo.buscarPorTitulo("Livro Inexistente");

        assertNull(resultado, "Busca por título inexistente deve retornar null");
    }

    @Test
    public void removerLivroExistenteDeveRetornarTrue() {
        acervo.adicionar(livro1);
        acervo.adicionar(livro2);

        boolean removido = acervo.remover("O Senhor dos Anéis");

        assertTrue(removido, "Remover livro existente deve retornar true");
        assertEquals(1, acervo.getTamanho(), "Acervo deve ter 1 livro após remoção");
        assertNull(acervo.buscarPorTitulo("O Senhor dos Anéis"));
    }

    @Test
    public void removerLivroInexistenteDeveRetornarFalse() {
        acervo.adicionar(livro1);

        boolean removido = acervo.remover("Livro que não existe");

        assertFalse(removido, "Remover livro inexistente deve retornar false");
        assertEquals(1, acervo.getTamanho(), "Tamanho não deve mudar");
    }
}