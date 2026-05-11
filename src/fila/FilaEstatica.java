package fila;

import pilha.IPilha;
import pilha.PilhaDinamica;

public class FilaEstatica implements IFila {
    private final int[] dados;
    private int inicio;
    private int fim;
    private int tamanho;
    private final int capacidade;

    public FilaEstatica(int capacidade) {
        this.capacidade = capacidade;
        dados = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    @Override
    public boolean vazia() {
        return tamanho == 0;
    }

    public boolean cheia() {
        return tamanho == capacidade;
    }

    @Override
    public void enqueue(int dado) {
        if (cheia()) {
            System.out.println("Erro: Overflow");
            return;
        }

        fim = (fim + 1) % capacidade;
        dados[fim] = dado;
        tamanho++;
    }

    @Override
    public int dequeue() {
        if (vazia()) {
            System.out.println("Erro: Vazia");
            return -1;
        }

        int valorRemovido = dados[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;

        return valorRemovido;
    }

    @Override
    public int peek() {
        if (vazia()) return -1;
        return dados[inicio];
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Erro: Vazia");
            return;
        }
        int contador = 0;
        int i = inicio;
        System.out.print("Inicio ==> [");

        while (contador < tamanho) {
            System.out.print(dados[i] + " ");
            i = (i + 1) % capacidade;
            contador++;
        }

        System.out.println("]  <== Fim");

    }

    @Override
    public void inverterFila(IFila fila) {
        if (fila == null || fila.vazia()) {
            System.out.println("Fila vazia");
            return;
        }

        IPilha pilhaAuxiliar = new PilhaDinamica();

        while (!fila.vazia()) {
            pilhaAuxiliar.push(fila.dequeue());
        }

        while (!pilhaAuxiliar.vazia()) {
            fila.enqueue(pilhaAuxiliar.pop());
        }
    }
}
