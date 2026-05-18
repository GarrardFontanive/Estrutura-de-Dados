package Hash;

public class Main2 {
    public static void main (String[] args) {
        hashTable2 agenda = new hashTable2(4);

        agenda.inserir("cauane", "(47)9999-9999");
        agenda.inserir("victor" , "Numero do djabo");

        agenda.mostrarTabela();
        //mesmas letras, colisao
        agenda.inserir("torvic" , "djabo do numero");
        agenda.mostrarTabela();

        agenda.inserir("pedro" , "(47)9191919191");
        agenda.mostrarTabela();


    }
}
