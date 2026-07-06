package work2;

/**
 * 2⁰ Algoritmo adicional que escolhi, professor.
 *
 * Shell Sort
 * Foi escolhido por ser uma melhoria do Insertion Sort.
 * Ele compara elementos com intervalos maiores no início e reduz esses
 * intervalos até chegar no intervalo 1. Com isso, tende a realizar menos
 * movimentações e apresentar melhor desempenho prático que os métodos simples.
 */

public class ShellSort implements Sorter{
    @Override
    public String getNome() {
        return "Shell Sort";
    }

    @Override
    public void sort(int[] vetor, SortMetrics metricas) {
        int n = vetor.length;
            for (int intervalo = n / 2; intervalo > 0; intervalo /= 2 ) {
                for (int i = intervalo; i < n; i++) {
                    int temp = vetor[i];
                    metricas.incrementarMovimentacoes();

                    int j = i;

                    while (j>= intervalo) {
                        metricas.incrementarComparacoes();

                        if ( vetor[j - intervalo] > temp) {
                            vetor[j] = vetor[j - intervalo];
                            metricas.incrementarComparacoes();

                            j -= intervalo;

                        } else break;
                    }

                    vetor[j] = temp;
                    metricas.incrementarMovimentacoes();
                }
            }
    }
}
