package ordenacao;

public class MetricaOrdenacao {

    private int troca;
    private int comparacao;

    public MetricaOrdenacao() {
        this.troca = 0;
        this.comparacao = 0;
    }

    public int getTroca() {
        return troca;
    }

    public void addTroca() {
        this.troca++;
    }

    public int getComparacao() {
        return comparacao;
    }

    public void addComparacao() {
        this.comparacao++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MetricaOrdenacao{");
        sb.append("troca=").append(troca);
        sb.append(", comparacao=").append(comparacao);
        sb.append('}');
        return sb.toString();
    }
}
