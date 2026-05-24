package Hash.HashEncadeamento;
public class Main3 {

    public static void main(String[] args) {

        HashTable3 agenda = new HashTable3(10000);

//		agenda.inserir("Carlos", "999");
//		agenda.inserir("Kelim", "777");
//		agenda.inserir("solCar", "222");
//
//		agenda.mostrarTabela();
//		System.out.println(agenda.recuperar("Carlos"));
//
//		agenda.inserir("Roberto Carlos", "99932");
//		agenda.mostrarTabela();
//
//		agenda.removerChave("solCar");
//		agenda.mostrarTabela();
        System.out.println(System.currentTimeMillis());
        for(int i =0; i<10000;i++) {
            agenda.inserir("chave"+i, "valor"+i);
        }
        System.out.println(System.currentTimeMillis());
//	agenda.mostrarTabela();
    }

}