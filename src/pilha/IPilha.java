package pilha;

public interface IPilha {
    void push(int dado);
    int pop();
    int peek();
    void mostrarPilha();
    boolean vazia();
}
