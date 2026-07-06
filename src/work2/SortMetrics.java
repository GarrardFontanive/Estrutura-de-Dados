package work2;

public class SortMetrics {
    private long comparacoes;
    private long movimentacoes;
    private long tempoExecucaoNs;

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
        return tempoExecucaoNs;
    }

    double getTempoExecicaoMs() {
        return tempoExecucaoNs / 1_000_000.0;
    }

    void setTempoExecucaoNs(long tempoExecucaoNs) {
        this.tempoExecucaoNs = tempoExecucaoNs;
    }
}
