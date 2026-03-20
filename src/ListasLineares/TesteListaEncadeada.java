package ListasLineares;

public class TesteListaEncadeada {
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("=== EXERCÍCIO 2: Operações Básicas na Lista ===");
        System.out.println("==================================================");
        ListaEncadeada listaEx2 = new ListaEncadeada();

        listaEx2.inserirInicio(5);
        System.out.println("Após inserirInicio(5):");
        listaEx2.mostrarLista();

        listaEx2.inserirFinal(10);
        System.out.println("\nApós inserirFinal(10):");
        listaEx2.mostrarLista();

        listaEx2.inserirInicio(3);
        System.out.println("\nApós inserirInicio(3):");
        listaEx2.mostrarLista();

        listaEx2.removerValor(5);
        System.out.println("\nApós removerValor(5):");
        listaEx2.mostrarLista();


        System.out.println("\n==================================================");
        System.out.println("=== EXERCÍCIO 4: Imprimir o Meio da Lista ======");
        System.out.println("==================================================");
        ListaEncadeada listaEx4 = new ListaEncadeada();
        listaEx4.inserirFinal(1);
        listaEx4.inserirFinal(2);
        listaEx4.inserirFinal(3);
        listaEx4.inserirFinal(4);
        listaEx4.inserirFinal(5);
        System.out.println("Lista: 1, 2, 3, 4, 5");
        System.out.print("Valor do meio (esperado 3): ");
        listaEx4.imprimirMeio();


        System.out.println("\n==================================================");
        System.out.println("=== EXERCÍCIO 6: Remover Todos (Múltiplos) =======");
        System.out.println("==================================================");
        ListaEncadeada listaEx6 = new ListaEncadeada();
        listaEx6.inserirInicio(8);
        listaEx6.inserirInicio(2);
        listaEx6.inserirInicio(8);
        listaEx6.inserirInicio(3);
        listaEx6.inserirInicio(8);
        listaEx6.inserirFinal(4);
        listaEx6.inserirFinal(8);

        System.out.println("--- Lista ANTES da remoção (cheia de 8) ---");
        listaEx6.mostrarLista();

        listaEx6.removerTodos(8);

        System.out.println("\n--- Lista APÓS removerTodos(8) ---");
        listaEx6.mostrarLista();


        System.out.println("\n==================================================");
        System.out.println("=== EXERCÍCIO 8: Inverter Lista ==================");
        System.out.println("==================================================");
        ListaEncadeada listaEx8 = new ListaEncadeada();
        listaEx8.inserirFinal(1);
        listaEx8.inserirFinal(2);
        listaEx8.inserirFinal(3);

        System.out.println("--- Lista Original ---");
        listaEx8.mostrarLista();

        listaEx8.inverter();

        System.out.println("\n--- Lista Invertida ---");
        listaEx8.mostrarLista();


        System.out.println("\n==================================================");
        System.out.println("=== EXERCÍCIO 5: Transformar em Circular =========");
        System.out.println("==================================================");
        ListaEncadeada listaEx5 = new ListaEncadeada();
        listaEx5.inserirFinal(10);
        listaEx5.inserirFinal(20);
        System.out.println("Transformando a lista [10, 20] em circular...");
        listaEx5.transformarEmCircular();
        System.out.println("Operação concluída! (Cuidado: chamar mostrarLista() agora causará loop infinito se não houver trava na impressão)");
    }
}