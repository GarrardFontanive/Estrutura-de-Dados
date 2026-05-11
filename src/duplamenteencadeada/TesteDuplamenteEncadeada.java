package duplamenteencadeada;

public class TesteDuplamenteEncadeada {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada nd = new ListaDuplamenteEncadeada();

        nd.inserirInicio(8);
        nd.inserirInicio(2);
        nd.inserirInicio(3);

        nd.inserirFim(5);
        nd.inserirFim(7);

        nd.mostrarLista();
        System.out.println("---------------------------------------------");
        nd.mostrarListaInversa();

        System.out.println("---------------------------------------------");
        nd.mostrarMaioreMenor();

        System.out.println("---------------removendo valor---------------");
        nd.removerValor(8);
        nd.removerValor(2);
        nd.mostrarLista();
        System.out.println("------------------inversa--------------------");
        nd.mostrarListaInversa();
        System.out.println("---------------------------------------------");
        nd.mostrarMaioreMenor();

        System.out.println("-----------------é palindromo?---------------");
        //3 5 7
        nd.inserirFim(5);
        nd.inserirFim(3);
        System.out.println(nd.ePalindromo());
        nd.mostrarLista();



    }
}
