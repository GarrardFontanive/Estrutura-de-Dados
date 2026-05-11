package work;

public class Aviao {
    private int id;
    private int combustivel;
    private int tempoEntrada;

    public Aviao(int id, int combustivel, int tempoEntrada) {
        this.id = id;
        this.combustivel = combustivel;
        this.tempoEntrada = tempoEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public int getTempoEntrada() {
        return tempoEntrada;
    }

    public void setTempoEntrada(int tempoEntrada) {
        this.tempoEntrada = tempoEntrada;
    }
}
