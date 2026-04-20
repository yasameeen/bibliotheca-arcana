import java.util.Stack;

public class PilhaHistoricoNavegacao {

    private Stack<Livro> pilha;
    private String nomeLeitor;

    public PilhaHistoricoNavegacao(String nomeLeitor) {
        this.pilha = new Stack<>();
        this.nomeLeitor = nomeLeitor;
    }

    public void empilhar(Livro livro) {
        pilha.push(livro);
    }

    public Livro desempilhar() {
        if (pilha.isEmpty()) return null;
        return pilha.pop();
    }

    public Livro verTopo() {
        if (pilha.isEmpty()) return null;
        return pilha.peek();
    }

    public boolean estaVazia() {
        return pilha.isEmpty();
    }

    public int getTamanho() {
        return pilha.size();
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public Stack<Livro> getPilha() {
        return pilha;
    }
}