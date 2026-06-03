package ordenacao;
import java.util.Arrays;

public class OdenacaoQuadratica {
    //1. BUBBLE SORT

    public static void bubbleSort(int [] vetor) {
        int n = vetor.length;
        boolean trocou;

        for(int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++){
                if(vetor[j] > vetor[j+1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
    //2. SelectionSort
    public static void selectionSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n-1; i++) {
            int indiceMenor = i;

            for (int j = i; j < n; j++) {
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

    //3. insertionSort
    public static void insertSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 0 ; i < n; i++ ) {
            int chave = vetor[i];
            int j = i - 1;
            while(j >= 0 && vetor[j]>chave) {
                vetor[j+1] = vetor[j];
                j--;
            }

            vetor[j + 1] = chave;
        }


    }

    // 4. Main
    public static void main(String[] args) {
        int[] dadosOriginais = {64, 34, 25, 12, 22, 11, 90, 5, 42, 18};
        System.out.println("Array original: " + Arrays.toString(dadosOriginais));
        System.out.println("--------------------------------------------------");
        int[] vetorBubble = dadosOriginais.clone();
        long inicioBubble = System.nanoTime();
        bubbleSort(vetorBubble);
        long fimBubble = System.nanoTime();
        System.out.println("Bubble sort: " + Arrays.toString(vetorBubble));
        System.out.println("Tempo de execução: " + (fimBubble - inicioBubble) + " nanosegundos\n");
        int[] vetorSelection = dadosOriginais.clone();
        long inicioSelection = System.nanoTime();
        selectionSort(vetorSelection);
        long fimSelection = System.nanoTime();
        System.out.println("Selection sort: " + Arrays.toString(vetorSelection));
        System.out.println("Tempo de execução: " + (fimSelection - inicioSelection) + " nanosegundos\n");
        int[] vetorInsertion = dadosOriginais.clone();
        long inicioInsertion = System.nanoTime();
        insertSort(vetorInsertion);
        long fimInsertion = System.nanoTime();
        System.out.println("Insertion sort: " + Arrays.toString(vetorInsertion));
        System.out.println("Tempo de execução: " + (fimInsertion - inicioInsertion) + " nanosegundos");
    }

}
