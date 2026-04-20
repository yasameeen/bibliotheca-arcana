import java.util.LinkedList;

public class ListaEncadeadaLivros {

    private LinkedList<Livro> livros;

    public ListaEncadeadaLivros() {
        this.livros = new LinkedList<>();
    }

    public void adicionar(Livro livro) {
        livros.add(livro);
    }

    public boolean remover(String titulo) {
        return livros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
    }

    public Livro buscarPorTitulo(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    public LinkedList<Livro> getLivros() {
        return livros;
    }
    
    public void imprimir() {
        if (livros.isEmpty()) {
            System.out.println("  (acervo vazio)");
            return;
        }
        int i = 1;
        for (Livro l : livros) {
            System.out.println("  " + i + ". " + l);
            i++;
        }
    }

    public int getTamanho() {
        return livros.size();
    }

    public boolean estaVazia() {
        return livros.isEmpty();
    }
}
