package work;

public class NodoFila {
    private Aviao aviao;
    private NodoFila prox;

    public NodoFila(Aviao aviao) {
        this.aviao = aviao;
        this.prox = null;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public NodoFila getProx() {
        return prox;
    }

    public void setProx(NodoFila prox) {
        this.prox = prox;
    }
}
