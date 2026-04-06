package DuplamenteEncadeada;
import Nodo.NodoDuplo;

public class ListaDuplamenteEncadeada {
    private NodoDuplo inicio;
    private NodoDuplo fim;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.fim = null;
    }

    public NodoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NodoDuplo inicio) {
        this.inicio = inicio;
    }

    public NodoDuplo getFim() {
        return fim;
    }

    public void setFim(NodoDuplo fim) {
        this.fim = fim;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public void inseririnicio(int dado) {
        NodoDuplo novoNodo = new NodoDuplo(dado);
        if (vazia()) {
            inicio = novoNodo;
            fim = novoNodo;
            return;
        }

        novoNodo.setProx(inicio);
        inicio.setAnt(novoNodo);
        inicio = novoNodo;
    }

    public void inserirfim(int dado) {
        if (vazia()) {
            inseririnicio(dado);
            return;
        }
        NodoDuplo novoNodo = new NodoDuplo(dado);

        fim.setProx(novoNodo);
        novoNodo.setAnt(fim);
        fim = novoNodo;
    }

    public void mostrarLista() {
        if (vazia()) {
            System.out.println("Lista vazia");
            return;
        }
        NodoDuplo aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDado());
            aux = aux.getProx();
        }
    }

    public void removerValor(int valor) {
        if (vazia()) return;
        //caso 1 : valor no inicio
        if (inicio.getDado() == valor) {
            //for o único elemento
            if (inicio == fim) {
                inicio = null;
                fim = null;
                return;
            }
            //caso for o primeiro
            inicio = inicio.getProx();
            inicio.setAnt(null);
            return;
        }
        //caso 2: último elemento
        if (fim.getDado() == valor) {
            fim = fim.getAnt();
            fim.setProx(null);
            return;
        }
        //caso 3: valor está no meio
        NodoDuplo aux = inicio.getProx();
        while (aux != null) {
            if (aux.getDado() == valor) {
                aux.getAnt().setProx(aux.getProx());
                aux.getProx().setAnt(aux.getAnt());
                return;
            }
            aux = aux.getProx();
        }

    }

    public void mostrarListaInversa() {
        if (vazia()) return;

        NodoDuplo aux = fim;

        while (aux != null) {
            System.out.println(aux.getDado());
            aux = aux.getAnt();
        }
    }

    public void mostrarMaioreMenor() {
        if (vazia()) return;
        NodoDuplo aux = inicio;

        int maior = aux.getDado();
        int menor = aux.getDado();
        while (aux != null) {
            if (aux.getDado() < menor) {
                menor = aux.getDado();
            }
            if (aux.getDado() > maior) {
                maior = aux.getDado();
            }
            aux = aux.getProx();
        }
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
    }

    //verificar se os elementos ormam um palindromo ex: {1,2,3,2,1}
    public boolean ePalindromo() {
        if (vazia()) return true;
        NodoDuplo esq = inicio;
        NodoDuplo dir = fim;

        while (esq != dir && esq.getAnt() != dir) {
            if (esq.getDado() != dir.getDado()) {
                return false;
            }
            esq = esq.getProx();
            dir = dir.getAnt();
        }
        return true;
    }
}
