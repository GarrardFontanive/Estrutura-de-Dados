package work2;

/**
 * 1⁰ Algoritmo adicional que escolhi, professor.
 *
 * Heap Sort
 * Escolhido por ter bom desempenho em grande volume de dados,
 * com complexidade O(n log n) no melhor, médio e pior caso.
 * Além disso, utiliza a estrutura de heap máxima, o que permite comparar
 * sua abordagem com Merch Sort, Quick Sort e os algoritmos quadráticos
 */

public class HeapSort implements Sorter {
    @Override
    public String getNome() {
        return "Heap Sort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        int n = vetor.length;

        for (int i = n / 2 - 1; i > 0; i --) {
            heapify(vetor, n, i, metricas);
        }

        for (int i = n - 1; i > 0; i --) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            metricas.adicionarMovimentacoes(3);

            heapify(vetor, i, 0, metricas);
        }
    }

    void heapify(int[] vetor, int tamanhoHeap, int raiz, SortMetrics metricas) {
        int maior = raiz;
        int esq = 2 * raiz + 1;
        int dir = 2 * raiz + 2;

        if (esq < tamanhoHeap) {
            metricas.incrementarComparacoes();
            if(vetor[esq] > vetor[maior]) {
                maior = esq;
            }
        }

        if (maior != raiz) {
            int temp = vetor[raiz];
            vetor[raiz] = vetor[maior];
            vetor[maior] = temp;

            metricas.adicionarMovimentacoes(3);

            heapify(vetor, tamanhoHeap, raiz, metricas);
        }
    }
}
