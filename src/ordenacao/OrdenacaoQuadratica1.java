package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class OrdenacaoQuadratica1 {
        //1. BUBBLE SORT

    public static MetricaOrdenacao bubbleSort(int[] vetor) {
        MetricaOrdenacao metricas = new MetricaOrdenacao();
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                metricas.addComparacao();
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    metricas.addTroca();
                }
            }
        }
        return metricas;
    }
        // 2. Selection Sort
    public static MetricaOrdenacao selectionSort(int[] vetor) {
        MetricaOrdenacao metricas = new MetricaOrdenacao();
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                metricas.addComparacao();
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;

                metricas.addTroca();
            }
        }
        return metricas;
    }

    // 3. INSERTION SORT
    public static MetricaOrdenacao insertSort(int[] vetor) {
        MetricaOrdenacao metricas = new MetricaOrdenacao();
        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0) {
                metricas.addComparacao();
                if (vetor[j] > chave) {
                    vetor[j + 1] = vetor[j];
                    metricas.addTroca();
                    j--;
                } else {
                    break;
                }
            }

            if (j + 1 != i) {
                vetor[j + 1] = chave;
                metricas.addTroca();
            }
        }
        return metricas;
    }

//main aqui
    public static void main(String[] args) {
        int tamanho = 10000;
        int[] dadosOriginais = new int[tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            dadosOriginais[i] = rand.nextInt(100000);
        }

        System.out.println("Array original gerado com " + tamanho + " posições aleatórias.");
        System.out.println("--------------------------------------------------");

        // BUBBLE SORT
        int[] vetorBubble = dadosOriginais.clone();
        long inicioBubble = System.nanoTime();
        MetricaOrdenacao metricasBubble = bubbleSort(vetorBubble);
        long fimBubble = System.nanoTime();
        System.out.println("Métricas Bubble: " + metricasBubble.toString());
        System.out.println("Tempo de execução: " + ((fimBubble - inicioBubble) / 1000000) + " milissegundos\n");

        // SELECTION SORT
        int[] vetorSelection = dadosOriginais.clone();
        long inicioSelection = System.nanoTime();
        MetricaOrdenacao metricasSelection = selectionSort(vetorSelection);
        long fimSelection = System.nanoTime();
        System.out.println("Métricas Selection: " + metricasSelection.toString());
        System.out.println("Tempo de execução: " + ((fimSelection - inicioSelection) / 1000000) + " milissegundos\n");

        // INSERTION SORT
        int[] vetorInsertion = dadosOriginais.clone();
        long inicioInsertion = System.nanoTime();
        MetricaOrdenacao metricasInsertion = insertSort(vetorInsertion);
        long fimInsertion = System.nanoTime();
        System.out.println("Métricas Insertion: " + metricasInsertion.toString());
        System.out.println("Tempo de execução: " + ((fimInsertion - inicioInsertion) / 1000000) + " milissegundos");
    }
}
