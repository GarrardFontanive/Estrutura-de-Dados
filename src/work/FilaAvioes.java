package work;

public class FilaAvioes {
    private NodoFila inicio;
    private NodoFila fim;
    private int tamanho;

    public FilaAvioes() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void inserirFinal(Aviao aviao) {
        if (aviao == null) {
            return;
        }
        NodoFila novoNodo = new NodoFila(aviao);
        if (vazia()) {
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            fim.setProx(novoNodo);
            fim = novoNodo;
        }
        tamanho++;
    }

    public Aviao removerInicio() {
        if (vazia()) {
            return null;
        }
        Aviao removido = inicio.getAviao();
        inicio = inicio.getProx();
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return removido;
    }

    public Aviao removerEmergencia() {
        if (vazia()) {
            return null;
        }

        if (inicio.getAviao() != null && inicio.getAviao().getCombustivel() <= 0) {
            return removerInicio();
        }

        NodoFila aux = inicio;
        while (aux.getProx() != null) {
            if (aux.getProx().getAviao() != null && aux.getProx().getAviao().getCombustivel() <= 0) {
                Aviao aviaoRemovido = aux.getProx().getAviao();
                aux.setProx(aux.getProx().getProx());
                if (aux.getProx() == null) {
                    fim = aux;
                }
                tamanho--;
                return aviaoRemovido;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public void atualizarCombustivel() {
        NodoFila aux = inicio;
        while (aux != null) {
            if (aux.getAviao() != null) {
                aux.getAviao().setCombustivel(aux.getAviao().getCombustivel() - 1);
            }
            aux = aux.getProx();
        }
    }

    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Fila vazia");
        } else {
            NodoFila aux = inicio;
            while (aux != null) {
                if (aux.getAviao() != null) {
                    System.out.print("[" + aux.getAviao().getId() + "] ");
                }
                aux = aux.getProx();
            }
            System.out.println();
        }
    }
}