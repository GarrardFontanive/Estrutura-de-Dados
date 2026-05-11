package pilha;

import nodo.Nodo;

public class PilhaDinamica implements IPilha {
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

    public String inverterTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        IPilha pilha = new PilhaDinamica();


        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            pilha.push((int) c);
        }

        StringBuilder textoInvertido = new StringBuilder();

        while (!pilha.vazia()) {
            char c = (char) pilha.pop();
            textoInvertido.append(c);
        }

        return textoInvertido.toString();
    }

}
