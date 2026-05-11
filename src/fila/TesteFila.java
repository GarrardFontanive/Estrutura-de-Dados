package fila;

public class TesteFila {
    public static void main(String[] args) {
        System.out.println("Testando fila dinamica");
        IFila filad = new FilaDinamica();

        filad.enqueue(55);
        filad.enqueue(66);
        filad.enqueue(77);
        filad.enqueue(88);

        filad.mostrarFila();

        System.out.println("Desinfileirando " + filad.dequeue());

        filad.mostrarFila();

        filad.inverterFila(filad);
        System.out.println("Fila dinamica invertida:");
        filad.mostrarFila();

        System.out.println("Testando fila estatica");
        IFila filae = new FilaEstatica(3);
        filae.enqueue(10);
        filae.enqueue(20);
        filae.enqueue(30);

        filae.mostrarFila();

        filae.enqueue(40);

        filae.dequeue();

        filae.mostrarFila();

        filae.inverterFila(filae);
        System.out.println("Fila estatica invertida:");
        filae.mostrarFila();

        System.out.println("Sistema de caixas do supermercado");
        SistemaCaixasSupermercado sistemaCaixas = new SistemaCaixasSupermercado();

        sistemaCaixas.clienteChegou(1);
        sistemaCaixas.clienteChegou(2);
        sistemaCaixas.clienteChegou(3);
        sistemaCaixas.clienteChegou(4);
        sistemaCaixas.clienteChegou(5);

        sistemaCaixas.mostrarCaixas();
    }
}
