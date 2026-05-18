package Hash;

public class HashTable1 {
    private class Entrada {
        String chave;
        String valor;

        public Entrada (String chave, String valor){
            this.chave = chave;
            this.valor = valor;
        }
    }
    private int tam_array;
    private Entrada[] array;

    public HashTable1(int tam_array) {
        this.tam_array = tam_array;
        this.array = new Entrada[tam_array];
    }

    private int hash(String chave) {
        byte[] bytesChave = chave.getBytes();
        int hashCode = 0;

        for (int i=0 ; i<bytesChave.length ; i++) {
            hashCode += bytesChave[i];
        }
        return hashCode % tam_array;
    }

    public void inserir(String chave, String valor){
        int indiceArray = hash(chave);
        array[indiceArray] = new Entrada(chave, valor);
    }

    public String recuperar(String chave){
        int indiceArray = hash(chave);
        if(array[indiceArray] == null) {
            return "Vazio(nenhum dado encontrado)";
        } else {
            return array[indiceArray].valor;
        }
    }

    public void mostrarTabela() {
        for (int i = 0 ; i < tam_array ; i++) {
            if(array[i] == null){
                System.out.println("Índice[" + i + "]->[VAZIO]");
            } else {
                System.out.println("Índice[" + i + "] -> Valor: " + array[i].valor);
            }
        }
    }
}
