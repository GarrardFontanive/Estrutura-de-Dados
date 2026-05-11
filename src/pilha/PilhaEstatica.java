package pilha;

public class PilhaEstatica implements IPilha {
    private final int[] dados;
    private int topo;
    private final int capacidade;

    public PilhaEstatica(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new int[capacidade];
        this.topo = -1;
    }

    @Override
    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == (capacidade - 1);
    }

    @Override
    public void push(int dado) {
        if (cheia()) {
            System.out.println("Erro (Overflow): a pilha esta cheia");
            return;
        }
        topo++;
        dados[topo] = dado;

    }

    @Override
    public int pop() {
        if (vazia()) {
            System.out.println("Erro: Pilha esta vazia");
        return -1;
        }
        int valorRemovido = dados[topo];
        topo--;
        return valorRemovido;
    }

    @Override
    public int peek() {
        if (vazia()) {
            System.out.println("Erro: Pilha esta vazia");
            return -1;
        }
        return dados[topo];
    }

    @Override
    public void mostrarPilha() {
        if (vazia()) {
            System.out.println("Erro: Pilha esta vazia");
            return;
        }
        System.out.println("Pilha:");
        for (int i = topo; i >= 0; i--) {
            System.out.println(dados[i]);
        }
        System.out.println("--base--");
    }
}
