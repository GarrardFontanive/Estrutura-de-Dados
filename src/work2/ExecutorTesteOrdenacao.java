package work2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ExecutorTestesOrdenacao {

    private static final int[] TAMANHOS = {100_000, 1_000_000};
    private static final String[] CENARIOS = {"Ordenado", "Invertido", "Aleatorio"};
    private static final int QUANTIDADE_EXECUCOES = 3;
    private static final long SEMENTE_ALEATORIA = 2026L;

    private final List<Sorter> algoritmos;
    private final List<Resultado> resultados;

    public ExecutorTestesOrdenacao() {
        this.algoritmos = criarAlgoritmos();
        this.resultados = new ArrayList<>();
    }

    public void executar() {
        Locale.setDefault(Locale.US);

        System.out.println("TRABALHO 2 - ALGORITMOS DE ORDENACAO");
        System.out.println("Iniciando testes...");
        System.out.println();

        for (int tamanho : TAMANHOS) {
            for (String cenario : CENARIOS) {
                for (int execucao = 1; execucao <= QUANTIDADE_EXECUCOES; execucao++) {
                    executarTeste(tamanho, cenario, execucao);
                }
            }
        }

        try {
            salvarResultadosCompletos("resultados.csv");
            salvarMedias("medias.csv");

            System.out.println();
            System.out.println("Arquivos gerados:");
            System.out.println("- resultados.csv");
            System.out.println("- medias.csv");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivos: " + e.getMessage());
        }
    }

    private List<Sorter> criarAlgoritmos() {
        List<Sorter> lista = new ArrayList<>();

        lista.add(new BubbleSort());
        lista.add(new InsertionSort());
        lista.add(new SelectionSort());
        lista.add(new MergeSort());
        lista.add(new QuickSort());
        lista.add(new HeapSort());
        lista.add(new ShellSort());

        return lista;
    }

    private void executarTeste(int tamanho, String cenario, int execucao) {
        int[] vetorOriginal = gerarVetor(tamanho, cenario, execucao);

        for (Sorter algoritmo : algoritmos) {
            int[] copia = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            SortMetrics metricas = new SortMetrics();

            long inicio = System.nanoTime();
            algoritmo.sort(copia, metricas);
            long fim = System.nanoTime();

            metricas.setTempoExecucaoNs(fim - inicio);

            Resultado resultado = new Resultado(
                    tamanho,
                    cenario,
                    algoritmo.getNome(),
                    execucao,
                    metricas.getComparacoes(),
                    metricas.getMovimentacoes(),
                    metricas.getTempoExecucaoMs(),
                    estaOrdenado(copia)
            );

            resultados.add(resultado);
            imprimirResultado(resultado);
        }

        System.out.println();
    }

    private int[] gerarVetor(int tamanho, String cenario, int execucao) {
        int[] vetor = new int[tamanho];

        if (cenario.equals("Ordenado")) {
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = i;
            }
        } else if (cenario.equals("Invertido")) {
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = tamanho - i;
            }
        } else {
            Random random = new Random(SEMENTE_ALEATORIA + tamanho + execucao);

            for (int i = 0; i < tamanho; i++) {
                vetor[i] = random.nextInt(tamanho * 10);
            }
        }

        return vetor;
    }

    private boolean estaOrdenado(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i - 1] > vetor[i]) {
                return false;
            }
        }

        return true;
    }

    private void imprimirResultado(Resultado r) {
        System.out.printf(
                "%-15s | tamanho: %-8d | %-9s | execucao: %d | comparacoes: %-15d | movimentacoes: %-15d | tempo: %.3f ms | ordenado: %s%n",
                r.algoritmo,
                r.tamanho,
                r.cenario,
                r.execucao,
                r.comparacoes,
                r.movimentacoes,
                r.tempoMs,
                r.ordenado ? "sim" : "nao"
        );
    }

    private void salvarResultadosCompletos(String nomeArquivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho;cenario;algoritmo;execucao;comparacoes;movimentacoes;tempo_ms;ordenado");

            for (Resultado r : resultados) {
                writer.printf(
                        Locale.US,
                        "%d;%s;%s;%d;%d;%d;%.6f;%s%n",
                        r.tamanho,
                        r.cenario,
                        r.algoritmo,
                        r.execucao,
                        r.comparacoes,
                        r.movimentacoes,
                        r.tempoMs,
                        r.ordenado ? "sim" : "nao"
                );
            }
        }
    }

    private void salvarMedias(String nomeArquivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho;cenario;algoritmo;media_comparacoes;media_movimentacoes;media_tempo_ms");

            List<String> chavesProcessadas = new ArrayList<>();

            for (Resultado base : resultados) {
                String chave = base.tamanho + ";" + base.cenario + ";" + base.algoritmo;

                if (chavesProcessadas.contains(chave)) {
                    continue;
                }

                chavesProcessadas.add(chave);

                long somaComparacoes = 0;
                long somaMovimentacoes = 0;
                double somaTempo = 0.0;
                int quantidade = 0;

                for (Resultado r : resultados) {
                    boolean mesmoGrupo =
                            r.tamanho == base.tamanho
                                    && r.cenario.equals(base.cenario)
                                    && r.algoritmo.equals(base.algoritmo);

                    if (mesmoGrupo) {
                        somaComparacoes += r.comparacoes;
                        somaMovimentacoes += r.movimentacoes;
                        somaTempo += r.tempoMs;
                        quantidade++;
                    }
                }

                writer.printf(
                        Locale.US,
                        "%d;%s;%s;%.2f;%.2f;%.6f%n",
                        base.tamanho,
                        base.cenario,
                        base.algoritmo,
                        somaComparacoes / (double) quantidade,
                        somaMovimentacoes / (double) quantidade,
                        somaTempo / quantidade
                );
            }
        }
    }

    private static class Resultado {
        int tamanho;
        String cenario;
        String algoritmo;
        int execucao;
        long comparacoes;
        long movimentacoes;
        double tempoMs;
        boolean ordenado;

        Resultado(
                int tamanho,
                String cenario,
                String algoritmo,
                int execucao,
                long comparacoes,
                long movimentacoes,
                double tempoMs,
                boolean ordenado
        ) {
            this.tamanho = tamanho;
            this.cenario = cenario;
            this.algoritmo = algoritmo;
            this.execucao = execucao;
            this.comparacoes = comparacoes;
            this.movimentacoes = movimentacoes;
            this.tempoMs = tempoMs;
            this.ordenado = ordenado;
        }
    }
}