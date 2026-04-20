import java.util.Objects;

/**
 * Classe Livro: representa um livro da biblioteca virtual.
 *
 * Esta classe é usada como nó tanto da lista encadeada (semana 2) quanto
 * do grafo de recomendações (semana 4). Por isso, implementamos equals()
 * e hashCode() com base no título e autor — isso é o que permite que o
 * HashMap<Livro, Set<Livro>> funcione corretamente, já que o Java precisa
 * saber quando dois objetos Livro devem ser considerados o "mesmo livro".
 */
public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private String icone;

    // Construtor principal (com gênero E ícone, usado pela somativa)
    public Livro(String titulo, String autor, int anoPublicacao,
                 String genero, String icone) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.icone = icone;
    }

    public Livro(String titulo, String autor, int anoPublicacao, String genero) {
        this(titulo, autor, anoPublicacao, genero, "◆");
    }

    public Livro(String titulo, String autor, int anoPublicacao) {
        this(titulo, autor, anoPublicacao, "Não informado", "◆");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    // equals e hashCode por título+autor: necessário para o HashMap<Livro, Set<Livro>>
    // funcionar corretamente — sem isso, o Java não reconhece dois Livros iguais como a mesma chave
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro outro = (Livro) obj;
        return titulo.equalsIgnoreCase(outro.titulo)
                && autor.equalsIgnoreCase(outro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase(), autor.toLowerCase());
    }

    @Override
    public String toString() {
        return icone + "  \"" + titulo + "\" — " + autor
                + " (" + anoPublicacao + ") [" + genero + "]";
    }
}
