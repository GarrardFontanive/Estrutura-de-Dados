package ListasLineares;

public class ListaCircular {
    private Nodo inicio;
    private Nodo fim;

    public ListaCircular() {
        this.inicio = null;
        this.fim = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFim() {
        return fim;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public void inserirInicio(int valor){
        Nodo novoNodo = new Nodo(valor);

        if(vazia()) {
            inicio = novoNodo;
            fim = novoNodo;
            fim.setProx(inicio);
            return;
        }

        novoNodo.setProx(inicio);
        inicio = novoNodo; //atualiza inicio
        fim.setProx(inicio); //fim aponta apra o novo inicio
    }

    public void inserirFinal(int valor) {
        if(vazia()){
            inserirInicio(valor);
            return;
        }
        Nodo novoNodo = new Nodo(valor);
        fim.setProx(novoNodo);
        fim = novoNodo;
        fim.setProx(inicio);
    }

    public void mostrarLista(){
        if(vazia()){
            System.out.println("Lista vazia");
            return;
        }

        Nodo aux = inicio;
        do {
            System.out.println(aux.getDado());
            aux = aux.getProx();
        } while (aux!= inicio);
    }

    public void removerValor(int valor) {
        if(vazia()){
            return;
        }
        //cas1 valor no incio
        if(inicio.getDado()==valor){
            //se for no unico elemtno
            if(inicio==fim) {
                inicio = null;
                fim = null;
                return;
            }
            inicio = inicio.getProx();
            fim.setProx(inicio);
            return;
        }
        //caso 2 no meio ou no final
        Nodo aux = inicio;
        while(aux.getProx() != inicio) {
            if (aux.getProx().getDado() == valor) {
                // se o valor removivel for o último
                if (aux.getProx() == fim){
                    fim = aux;
                    fim.setProx(inicio);
                } else {
                    //remover no meio
                    aux.setProx(aux.getProx().getProx());
                }
                return;
            }
            aux = aux.getProx();
        }
    }

    public void tamanho() {
        if (vazia()) {
            return;
        }
        int contador = 0;
        Nodo aux = inicio;
        do {
            contador++;
            aux = aux.getProx();
        } while (aux != inicio);
        System.out.println(contador);
    }

    public void concatenar(ListaCircular outraLista) {
        if (outraLista == null || outraLista.inicio == null) {
            return;
        }

        if (this.inicio == null) {
            this.inicio = outraLista.inicio;
            this.fim = outraLista.fim;
            return;
        }

        this.fim.setProx(outraLista.inicio);
        outraLista.fim.setProx(this.inicio);
        this.fim = outraLista.fim;
    }

    public int batataQuente(int passes) {
        if (inicio == null) {
            return -1;
        }

        Nodo anterior = fim;
        Nodo atual = inicio;

        while (atual.getProx() != atual) {
            for (int i = 0; i < passes; i++) {
                anterior = atual;
                atual = atual.getProx();
            }

            anterior.setProx(atual.getProx());

            if (atual == inicio) {
                inicio = atual.getProx();
            }
            if (atual == fim) {
                fim = anterior;
            }

            atual = anterior.getProx();
        }

        inicio = atual;
        fim = atual;

        return atual.getDado();
    }

}
