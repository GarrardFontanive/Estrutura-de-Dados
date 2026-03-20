package ListasLineares;

public class ListaEncadeada {
    private Nodo inicio;

    public ListaEncadeada() {
        inicio = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public void inserirInicio(int dado) {
        Nodo novoNodo = new Nodo(dado);
        novoNodo.setProx(inicio);
        inicio = novoNodo;
    }

    public void inserirFinal(int dado) {
        if(vazia()) {
            inserirInicio(dado);
            return;
        }
        Nodo novoNodo = new Nodo(dado);
        Nodo aux = inicio;
        while(aux.getProx() != null) {
            aux = aux.getProx();
        }
        aux.setProx(novoNodo);
    }

    public void removerValor(int dado) {
        if(vazia()) {
            return;
        }
        if(dado == inicio.getDado()) {
            inicio = inicio.getProx();
            return;
        }
        Nodo aux = inicio;
        while(aux.getProx() != null) {
            if(aux.getProx().getDado() == dado) {
                aux.setProx(aux.getProx().getProx());
                return;
            }
            aux = aux.getProx();
        }
    }

    public void mostrarLista() {
        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDado());
            aux = aux.getProx();
        }
    }

    public void imprimirMeio() {
        if (vazia()) {
            return;
        }

        Nodo auxR = inicio;
        Nodo auxL = inicio;

        while (auxR != null && auxR.getProx() != null) {
            auxL = auxL.getProx();
            auxR = auxR.getProx().getProx();
        }
        System.out.println(auxL.getDado());
    }

    public void transformarEmCircular() {
        if (vazia()) {
            return;
        }
        Nodo aux = inicio;
        Nodo fim;
        while (aux.getProx() != null ) {
            aux = aux.getProx();
        }
        aux.setProx(inicio);

    }

    public void removerTodos(int valor) {
        if (vazia()) {
            return;
        }
        Nodo aux = inicio;
        while (inicio != null && inicio.getDado() == valor) {
            inicio = inicio.getProx();
        }
        if (inicio == null) {
            return;
        }
        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getDado() == valor) {
                aux.setProx(aux.getProx().getProx());
            } else {
                aux = aux.getProx();
            }
        }
    }

    public void inverter() {
        if (vazia() || inicio.getProx() == null) {
            return;
        }

        Nodo anterior = null;
        Nodo atual = inicio;
        Nodo proximo = null;

        while (atual != null) {
            proximo = atual.getProx();
            atual.setProx(anterior);
            anterior = atual;
            atual = proximo;
        }
        inicio = anterior;
    }
}
