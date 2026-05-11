package pilha;

public class TestePilha {
    public static void main(String[] args) {
        IPilha pilhaDinamica = new PilhaDinamica();
        System.out.println("Testando a pilha dinâmica:");
        executarPilha(pilhaDinamica);

        IPilha pilhaEstatica = new PilhaEstatica(3);
        System.out.println("\nTestando a pilha estática:");
        executarPilha(pilhaEstatica);

        System.out.println("\nTestando a inversão de texto:");
        String original = "Pneumultramiscropivucaniotico";
        String invertida = inverterTexto(original);
        System.out.println("Original: " + original);
        System.out.println("Invertida: " + invertida);
    }

    public static void executarPilha(IPilha p) {
        p.push(10);
        p.push(20);
        p.push(30);
        p.push(40);

        p.mostrarPilha();

        System.out.println("Topo: " + p.peek());
        System.out.println("Desempilhando: " + p.pop());

        p.mostrarPilha();
    }

    public static String inverterTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        IPilha pilha = new PilhaDinamica();

        for (int i = 0; i < texto.length(); i++) {
            pilha.push((int) texto.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!pilha.vazia()) {
            sb.append((char) pilha.pop());
        }

        return sb.toString();
    }
}
