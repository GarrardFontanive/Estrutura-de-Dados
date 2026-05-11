package fila;

import nodo.Nodo;
import pilha.IPilha;
import pilha.PilhaDinamica;

public class FilaDinamica implements IFila {
    private Nodo inicio;
    private Nodo fim;

    public FilaDinamica() {
        inicio = fim = null;
    }

    @Override
    public boolean vazia() {
        return inicio == null;
    }

    @Override
    public void enqueue(int dado) {
        Nodo novoNodo = new Nodo(dado);
        if (vazia()) {
            inicio = fim = novoNodo;
            return;
        }
        fim.setProx(novoNodo);
        fim = novoNodo;
    }

    @Override
    public int dequeue() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }

        int valorRemovido = inicio.getDado();
        inicio = inicio.getProx();

        if (inicio == null) {
            fim = null;
        }

        return valorRemovido;
    }

    @Override
    public int peek() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }
        return inicio.getDado();
    }

    @Override
    public int tamanho() {
        int tamanho = 0;
        Nodo aux = inicio;

        while (aux != null) {
            tamanho++;
            aux = aux.getProx();
        }

        return tamanho;
    }

    @Override
    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        }
        Nodo aux = inicio;
        System.out.print("FRENTE ==>  [");
        while (aux != null) {
            System.out.print(aux.getDado() + " ");
            aux = aux.getProx();
        }
        System.out.println("] ");
    }

    @Override
    public void inverterFila(IFila fila) {
        if (vazia()) {
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
