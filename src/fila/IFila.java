package fila;

public interface IFila {
    void enqueue(int dado);
    int dequeue();
    int peek();
    int tamanho();
    boolean vazia();
    void mostrarFila();
    void inverterFila(IFila fila);
}
