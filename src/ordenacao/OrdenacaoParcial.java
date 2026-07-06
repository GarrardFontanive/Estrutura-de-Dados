package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenacaoParcial {

    public static void selectionSortTopK(int[] vetor, int k) {
        if (k <= 1 || k > vetor.length) return;

        for (int i = 0; i < k - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < k; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
        }
    }

    public static void bubbleSortTopK(int[] vetor, int k) {
        if (k <= 1 || k > vetor.length) return;

        for (int i = 0; i < k - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < k - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    public static void insertionSortTopK(int[] vetor, int k) {
        if (k <= 1 || k > vetor.length) return;

        for (int i = 1; i < k; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dadosOriginais = {99, 45, 12, 89, 33, 21, 9, 67, 54, 2, 78};
        System.out.println("Vetor original: " + Arrays.toString(dadosOriginais));

        System.out.print("Digite o valor de K (max " + dadosOriginais.length + "): ");
        int k = scanner.nextInt();

        if (k < 0 || k > dadosOriginais.length) {
            System.out.println("Valor de K inválido para este vetor.");
            scanner.close();
            return;
        }

        System.out.println("\n--- RESULTADOS COM K = " + k + " (Apenas os primeiros ordenados) ---");

        int[] vetorSelection = dadosOriginais.clone();
        selectionSortTopK(vetorSelection, k);
        System.out.println("Selection Sort Parcial: " + Arrays.toString(vetorSelection));

        int[] vetorBubble = dadosOriginais.clone();
        bubbleSortTopK(vetorBubble, k);
        System.out.println("Bubble Sort Parcial   : " + Arrays.toString(vetorBubble));

        int[] vetorInsertion = dadosOriginais.clone();
        insertionSortTopK(vetorInsertion, k);
        System.out.println("Insertion Sort Parcial: " + Arrays.toString(vetorInsertion));

        scanner.close();
    }
}