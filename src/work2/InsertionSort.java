package work2;

public class InsertionSort implements Sorter{
    @Override
    public String getNome() {
        return "InsertionSort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        for (int i = 0; i < vetor.length; i++) {
            int chave = vetor[i];
            metricas.incrementarMovimentacoes();

            int j = i -1;

            while (j >= 0) {
                metricas.incrementarComparacoes();

                if (vetor[j] > chave) {
                    vetor[j + 1] = vetor[j];
                    metricas.incrementarComparacoes();
                    j--;
                } else break;
            }

            vetor [j + 1] = chave;
            metricas.incrementarMovimentacoes();
        }
    }
}
