package ListasLineares;

public class TesteNodo {
    public static void main(String[] args) {
        Nodo nd1 = new Nodo(9);
        Nodo nd2 = new Nodo(10);
        Nodo nd3 = new Nodo(11);

        nd1.setProx(nd2);
        nd2.setProx(nd3);

        int valorNodo2 = nd1.getProx().getDado();
        int valorNodo3 = nd1.getProx().getProx().getDado();

        System.out.println(valorNodo2);
        System.out.println(valorNodo3);
    }
}
