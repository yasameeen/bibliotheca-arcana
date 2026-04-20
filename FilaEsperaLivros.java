import java.util.LinkedList;
import java.util.Queue;

public class FilaEsperaLivros {

    private Queue<String> fila;
    private String tituloDoLivro;

    public FilaEsperaLivros(String tituloDoLivro) {
        this.fila = new LinkedList<>();
        this.tituloDoLivro = tituloDoLivro;
    }

    public void enfileirar(String nomeLeitor) {
        fila.offer(nomeLeitor);
    }

    public String desenfileirar() {
        return fila.poll();
    }

    public String verProximo() {
        return fila.peek();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public int getTamanho() {
        return fila.size();
    }

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public String posicaoRomana() {
        int pos = fila.size();
        int[] valores =   { 10,   9,   5,   4,   1 };
        String[] simbolos = { "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            while (pos >= valores[i]) {
                sb.append(simbolos[i]);
                pos -= valores[i];
            }
        }
        return sb.toString();
    }
}