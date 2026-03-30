package ListasLineares;

public class TesteDuplamenteEncadeada {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada nd = new ListaDuplamenteEncadeada();

        nd.inseririnicio(8);
        nd.inseririnicio(2);
        nd.inseririnicio(3);

        nd.inserirfim(5);
        nd.inserirfim(7);

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
        nd.inserirfim(5);
        nd.inserirfim(3);
        System.out.println(nd.ePalindromo());
        nd.mostrarLista();



    }
}
