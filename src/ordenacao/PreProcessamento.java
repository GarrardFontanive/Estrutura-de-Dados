package ordenacao;

import java.util.Arrays;

public class PreProcessamento {

    public static int limparVetor(int[] vetor) {
        int k = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != -999) {
                int chave = vetor[i];
                int j = i - 1;

                while (j >= 0 && vetor[j] == -999) {
                    vetor[j + 1] = vetor[j];
                    j--;
                }

                vetor[j + 1] = chave;
                k++;
            }
        }

        return k;
    }

    public static void bubbleSortValidos(int[] vetor, int k) {
        if (k <= 1) return;

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

    public static void main(String[] args) {
        int[] temperaturas = {22, 24, -999, 23, 25, -999, 21, 26};
        System.out.println("Vetor original: " + Arrays.toString(temperaturas));
        int k = limparVetor(temperaturas);
        System.out.println("Após Limpeza (Passo A): " + Arrays.toString(temperaturas));
        System.out.println("Quantidade de Válidos: " + k);
        bubbleSortValidos(temperaturas, k);
        System.out.println("Após Ordenação (Passo B): " + Arrays.toString(temperaturas));
    }
}