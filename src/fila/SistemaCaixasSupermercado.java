package fila;

public class SistemaCaixasSupermercado {
    private IFila[] caixas;

    public SistemaCaixasSupermercado() {
        caixas = new IFila[3];
        int i = 0;
        while (i < caixas.length) {
            caixas[i] = new FilaDinamica();
            i++;
        }
    }

    public void clienteChegou(int idCliente) {
        int indiceMenorFila = 0;
        int i = 1;
        while (i < caixas.length) {
            if (caixas[i].tamanho() < caixas[indiceMenorFila].tamanho()) {
                indiceMenorFila = i;
            }
            i++;
        }

        caixas[indiceMenorFila].enqueue(idCliente);
    }

    public void mostrarCaixas() {
        int i = 0;
        while (i < caixas.length) {
            System.out.print("Caixa " + (i + 1) + ": ");
            caixas[i].mostrarFila();
            i++;
        }
    }

    public IFila[] getCaixas() {
        return caixas;
    }
}
