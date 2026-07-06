package work2;

public class QuickSort implements Sorter {

    @Override
    public String getNome() {
        return "Quick Sort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        quickSort(vetor, 0, vetor.length - 1, metricas);
    }

    private void quickSort(int[] vetor, int inicio, int fim, SortMetrics metricas) {
        if (inicio >= fim) {
            return;
        }

        int i = inicio;
        int j = fim;
        int pivo = vetor[inicio + (fim - inicio) / 2];

        while (i <= j) {
            while (i <= fim) {
                metricas.incrementarComparacoes();

                if (vetor[i] < pivo) {
                    i++;
                } else break;
            }

            while (j >= inicio) {
                metricas.incrementarComparacoes();

                if (vetor[j] > pivo) {
                    j--;
                } else break;
            }

            if (i <= j) {
                if (i < j) {
                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;

                    metricas.adicionarMovimentacoes(3);
                }
                i++;
                j--;
            }
        }
        if (inicio < j) quickSort(vetor, inicio, j, metricas);
        if (i < fim) quickSort(vetor, i, fim, metricas);
    }
}