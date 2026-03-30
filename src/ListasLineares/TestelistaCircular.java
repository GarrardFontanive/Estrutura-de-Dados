package ListasLineares;

public class TestelistaCircular {
    public static void main(String[] args){

        System.out.println("==================================================");
        System.out.println("=== EXERCÍCIO 3: Tamanho da Lista Circular =======");
        System.out.println("==================================================");
        ListaCircular listaEx3 = new ListaCircular();
        listaEx3.inserirFinal(10);
        listaEx3.inserirFinal(20);
        listaEx3.inserirFinal(30);
        System.out.println("Elementos na lista: 10, 20, 30");
        // Supondo que você criou o método tamanho()
        // System.out.println("Tamanho calculado: " + listaEx3.tamanho());


        System.out.println("\n==================================================");
        System.out.println("=== EXERCÍCIO 7: Concatenar Listas ===============");
        System.out.println("==================================================");
        ListaCircular lista1 = new ListaCircular();
        ListaCircular lista2 = new ListaCircular();

        lista1.inserirFinal(1);
        lista1.inserirFinal(2);
        lista1.inserirFinal(3);

        lista2.inserirFinal(4);
        lista2.inserirFinal(5);

        System.out.println("--- Lista 1 Original ---");
        lista1.mostrarLista();

        System.out.println("\n--- Lista 2 Original ---");
        lista2.mostrarLista();

        lista1.concatenar(lista2);

        System.out.println("\n--- Lista 1 após a Concatenação ---");
        lista1.mostrarLista();


        System.out.println("\n==================================================");
        System.out.println("=== EXERCÍCIO 9: Batata Quente ===================");
        System.out.println("==================================================");
        ListaCircular rodaJogadores = new ListaCircular();
        // Inserindo 5 jogadores na roda (1 a 5)
        rodaJogadores.inserirFinal(1);
        rodaJogadores.inserirFinal(2);
        rodaJogadores.inserirFinal(3);
        rodaJogadores.inserirFinal(4);
        rodaJogadores.inserirFinal(5);

        System.out.println("Roda inicial de jogadores:");
        rodaJogadores.mostrarLista();

        int passes = 2; // Número de passes da batata
        System.out.println("\nIniciando o jogo com " + passes + " passes...");

        int vencedor = rodaJogadores.batataQuente(passes);
        System.out.println("-> O jogador VENCEDOR foi o número: " + vencedor);
    }
}