package Pilha;
import Nodo.Nodo;

public class PilhaDinamica implements IPilha{
    private Nodo topo;

    public PilhaDinamica() {
        topo = null;
    }

    @Override
    public boolean vazia(){
        return topo == null;
    }

    @Override
    public void push(int dado) {
        Nodo novoNodo = new Nodo(dado);
        novoNodo.setProx(topo);
        topo = novoNodo;
    }

    @Override
    public int pop() {
        if (vazia()) {
            System.out.println("Vazia");
            return -1;
        }
        int valorRemovido = topo.getDado();
        topo = topo.getProx();
        return valorRemovido;
    }

    @Override
    public int peek() {
        if (vazia()) {
            System.out.println("Vazia");
            return -1;
        }
        System.out.println("--Valor do topo--");
        return topo.getDado();
    }

    @Override
    public void mostrarPilha() {
        if (vazia()) {
            System.out.println("pilha dinamica vazia");
            return;
        }
        Nodo aux = topo;
        System.out.println("---Topo(Dinâmico)---");
        while (aux != null) {
            System.out.println(aux.getDado());
            aux = aux.getProx();
        }
        System.out.println("---Base---");
    }


}
