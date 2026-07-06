package work2;

public class SortMetrics {

    private long comparacoes;
    private long movimentacoes;
    private long tempoExecucaoNs;

    public void incrementarComparacoes() {
        comparacoes++;
    }

    public void incrementarMovimentacoes() {
        movimentacoes++;
    }

    public void adicionarMovimentacoes(long quantidade) {
        movimentacoes += quantidade;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public long getTempoExecucaoNs() {
        return tempoExecucaoNs;
    }

    public double getTempoExecucaoMs() {
        return tempoExecucaoNs / 1_000_000.0;
    }

    public void setTempoExecucaoNs(long tempoExecucaoNs) {
        this.tempoExecucaoNs = tempoExecucaoNs;
    }
}