package work2;

public class MerchSort implements Sorter{
    @Override
    public String getNome() {
        return "Merch Sort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        int[] aux = new int[vetor.length];
        mergeSort(vetor, aux, 0, vetor.length - 1, metricas);
    }

    void mergeSort(int[] vetor, int[] aux, int inicio, int fim, SortMetrics metricas) {
        if (inicio >= fim) return;

        int meio = inicio + (fim - inicio) / 2;

        mergeSort(vetor, aux, inicio, meio, metricas);
        mergeSort(vetor, aux, meio + 1, fim, metricas);
        intercalar(vetor, aux, inicio, meio, fim, metricas);
    }

    void intercalar(int[] vetor, int[] aux, int inicio, int meio, int fim, SortMetrics metricas) {
        for (int i = inicio; i <= fim; i++) {
            aux[i] = vetor[i];
            metricas.incrementarMovimentacoes();
        }
    }


}
