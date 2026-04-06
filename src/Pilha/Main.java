package Pilha;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando a pilha dinâmica");
        IPilha pilha1 = new PilhaDinamica();
        executarPilha(pilha1);

        System.out.println("Testando a pilha estatica");
        IPilha pilha2 = new PilhaEstatica(3);
        executarPilha(pilha2);
    }
    public static void executarPilha(IPilha p) {
        p.push(10);
        p.push(20);
        p.push(30);
        p.push(40);

        p.mostrarPilha();

        System.out.println("Pilha topo" + p.peek());
        System.out.println("Desimpilhando " + p.pop());
        p.mostrarPilha();
    }
}
