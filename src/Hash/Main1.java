package Hash;

public class Main1 {
    public static void main (String[] args) {
        HashTable1 tabela = new HashTable1(5);

        tabela.inserir("UVA","R$8.00");
        tabela.inserir("MACA","R$5.00");

        tabela.mostrarTabela();

        System.out.println(tabela.recuperar("UVA"));

    }
}
