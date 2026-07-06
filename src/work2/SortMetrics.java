package work2;

public class SortMetrics {
    private long comparacoes;
    private long movimentacoes;
    private long tempoExecucaoMs;

    void incrementarComparacoes() {
        comparacoes++;
    }

    void incrementarMovimentacoes() {
        movimentacoes++;
    }

    void adicionarMovimentacoes(long quantidade) {
        movimentacoes += quantidade;
    }

    long getComparacoes() {
        return comparacoes;
    }

    long getMovimentacoes() {
        return comparacoes;
    }

    long getTempoExecucaoNs() {
        return tempoExecucaoMs;
    }

    double getTempoExecicaoMs() {
        return tempoExecucaoMs / 1_000_000.0;
    }

    void setTempoExecucaoNs(long tempoExecucaoNs) {
        this.tempoExecucaoMs = tempoExecucaoNs;
    }
}
