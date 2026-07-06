package work2;

public class SelectionSort implements Sorter {
    @Override
    public String getNome() {
        return "Selection Sort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        int n = vetor.length;

        for (int i = 0; i < n-1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                metricas.incrementarComparacoes();

                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;

                metricas.adicionarMovimentacoes(3);
            }
        }
    }
}
