package work2;

public class BubbleSort implements Sorter{
    @Override
    public String getNome() {
        return "Bubble Sort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        int n = vetor.length;
        boolean trocou;

        for (int i = 0 ; i < n - 1 ; i++) {
            trocou = false;

            for (int j = 0; j < n - 1 - i ; j++) {
                metricas.incrementarComparacoes();

                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor [j + 1] = temp;

                    metricas.adicionarMovimentacoes(3);
                    trocou = true;
                }
            }

            if(!trocou) break;
        }
    }
}
