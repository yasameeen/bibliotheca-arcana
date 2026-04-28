import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTeste {

    @Test
    public void livrosComMesmoTituloEAutorDevemSerIguais() {
        Livro livro1 = new Livro("Dom Quixote", "Cervantes", 1605, "Aventura", "⚔️");
        Livro livro2 = new Livro("Dom Quixote", "Cervantes", 1800, "Romance", "📖");

        assertEquals(livro1, livro2,
            "Livros com mesmo título e autor devem ser considerados iguais (equals)");
    }

    @Test
    public void livrosComMesmoTituloEAutorDevemTerMesmoHashCode() {
        Livro livro1 = new Livro("Dom Quixote", "Cervantes", 1605, "Aventura", "⚔️");
        Livro livro2 = new Livro("Dom Quixote", "Cervantes", 1800, "Romance", "📖");

        assertEquals(livro1.hashCode(), livro2.hashCode(),
            "Livros iguais devem ter o mesmo hashCode");
    }

    @Test
    public void livrosComTitulosDiferentesDevemSerDiferentes() {
        Livro livro1 = new Livro("Dom Quixote", "Cervantes", 1605, "Aventura", "⚔️");
        Livro livro2 = new Livro("Odisseia", "Homero", -800, "Épico", "🌊");

        assertNotEquals(livro1, livro2,
            "Livros com títulos diferentes não devem ser considerados iguais");
    }

    @Test
    public void gettersDevemRetornarValoresCorretos() {
        Livro livro = new Livro("1984", "George Orwell", 1949, "Distopia", "👁️");

        assertEquals("1984", livro.getTitulo());
        assertEquals("George Orwell", livro.getAutor());
        assertEquals(1949, livro.getAnoPublicacao());
        assertEquals("Distopia", livro.getGenero());
        assertEquals("👁️", livro.getIcone());
    }

    @Test
    public void construtorSemIconeDeveUsarIconePadrao() {
        Livro livro = new Livro("A Metamorfose", "Kafka", 1915, "Ficção");

        assertEquals("◆", livro.getIcone(),
            "Construtor sem ícone deve usar '◆' como padrão");
    }
}