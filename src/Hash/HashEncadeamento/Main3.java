package Hash.HashEncadeamento;

public class Main3 {
    public static void main(String[] args) {
        HashTable3 agenda = new HashTable3(4);

        agenda.inserir("cauane", "(47) 9999-9999");
        agenda.inserir("victor", "(47) 8888-8888");

        System.out.println("--- Tabela Inicial ---");
        agenda.mostrarTabela();

        // "victor" e "torvic" têm as mesmas letras, gerando o mesmo hash.
        // Como sua tabela usa encadeamento, eles vão ficar no mesmo índice!
        agenda.inserir("torvic", "(47) 7777-7777");

        System.out.println("\n--- Após Colisão (victor e torvic) ---");
        agenda.mostrarTabela();

        agenda.inserir("pedro", "(47) 1111-1111");

        System.out.println("\n--- Tabela Final ---");
        agenda.mostrarTabela();

        agenda.deletarChave("torvic");
        System.out.println("\n--- Tabela Final ---");
        agenda.mostrarTabela();
    }
}