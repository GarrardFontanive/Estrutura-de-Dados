package work;

import java.util.Random;

public class Aeroporto {
    private FilaAvioes aterrissagem1;
    private FilaAvioes aterrissagem2;
    private FilaAvioes decolagem1;
    private FilaAvioes decolagem2;

    private int idPouso;
    private int idDecolagem;

    private int tempoTotalEsperaPouso;
    private int qtdPousosRealizados;
    private int tempoTotalEsperaDecolagem;
    private int qtdDecolagensRealizadas;
    private int totalPousosEmergencia;

    private Random rand;

    public Aeroporto() {
        aterrissagem1 = new FilaAvioes();
        aterrissagem2 = new FilaAvioes();
        decolagem1 = new FilaAvioes();
        decolagem2 = new FilaAvioes();

        idPouso = 1;
        idDecolagem = 2;

        tempoTotalEsperaPouso = 0;
        qtdPousosRealizados = 0;
        tempoTotalEsperaDecolagem = 0;
        qtdDecolagensRealizadas = 0;
        totalPousosEmergencia = 0;

        rand = new Random();
    }

    public void iniciarSimulacao(int unidadesDeTempo) {
        for (int tempo = 1; tempo <= unidadesDeTempo; tempo++) {
            System.out.println("\nUNIDADE DE TEMPO: " + tempo);
            System.out.println("--- RADAR: CHEGADA DE AERONAVES ---");
            gerarChegadasPouso(tempo);
            gerarChegadasDecolagem(tempo);

            aterrissagem1.atualizarCombustivel();
            aterrissagem2.atualizarCombustivel();

            System.out.println("--- TORRE DE CONTROLE: OPERAÇÕES NAS PISTAS ---");
            processarPistas(tempo);

            exibirRelatorioPeriodico();
        }
        System.out.println("\nSIMULACAO FINALIZADA");
    }

    private void gerarChegadasPouso(int tempo) {
        int qtd = rand.nextInt(2) + 1;

        for (int i = 0; i < qtd; i++) {
            int combustivel = rand.nextInt(20) + 1;
            Aviao novo = new Aviao(idPouso, combustivel, tempo);

            if (aterrissagem1.getTamanho() <= aterrissagem2.getTamanho()) {
                aterrissagem1.inserirFinal(novo);
            } else {
                aterrissagem2.inserirFinal(novo);
            }
            System.out.println("APROXIMAÇÃO (POUSO): Aviao ID " + idPouso + " | Combustivel: " + combustivel);
            idPouso += 2;
        }
    }

    private void gerarChegadasDecolagem(int tempo) {
        int qtd = rand.nextInt(2) + 1;

        for (int i = 0; i < qtd; i++) {
            Aviao novo = new Aviao(idDecolagem, 0, tempo);

            if (decolagem1.getTamanho() <= decolagem2.getTamanho()) {
                decolagem1.inserirFinal(novo);
            } else {
                decolagem2.inserirFinal(novo);
            }
            System.out.println("TAXIAMENTO (DECOLAGEM): Aviao ID " + idDecolagem);
            idDecolagem += 2;
        }
    }

    private void processarPistas(int tempo) {
        int pistasLivres = 2;
        boolean operacaoRealizada = false;

        for (int i = 0; i < 2; i++) {
            if (pistasLivres > 0) {
                Aviao emergencia = aterrissagem1.removerEmergencia();
                if (emergencia == null) {
                    emergencia = aterrissagem2.removerEmergencia();
                }

                if (emergencia != null) {
                    pistasLivres--;
                    totalPousosEmergencia++;
                    qtdPousosRealizados++;
                    tempoTotalEsperaPouso += (tempo - emergencia.getTempoEntrada());
                    System.out.println("  [EMERGENCIA !] Aviao ID " + emergencia.getId() + " POUSOU SEM COMBUSTIVEL!");
                    operacaoRealizada = true;
                }
            }
        }

        while (pistasLivres > 0 && (!aterrissagem1.vazia() || !aterrissagem2.vazia())) {
            Aviao pouso;
            if (aterrissagem1.getTamanho() >= aterrissagem2.getTamanho() && !aterrissagem1.vazia()) {
                pouso = aterrissagem1.removerInicio();
            } else {
                pouso = aterrissagem2.removerInicio();
            }

            if (pouso != null) {
                pistasLivres--;
                qtdPousosRealizados++;
                tempoTotalEsperaPouso += (tempo - pouso.getTempoEntrada());
                System.out.println("  [POUSO NORMAL] Aviao ID " + pouso.getId() + " aterrissou com seguranca.");
                operacaoRealizada = true;
            }
        }

        while (pistasLivres > 0 && (!decolagem1.vazia() || !decolagem2.vazia())) {
            Aviao decolagem;
            if (decolagem1.getTamanho() >= decolagem2.getTamanho() && !decolagem1.vazia()) {
                decolagem = decolagem1.removerInicio();
            } else {
                decolagem = decolagem2.removerInicio();
            }

            if (decolagem != null) {
                pistasLivres--;
                qtdDecolagensRealizadas++;
                tempoTotalEsperaDecolagem += (tempo - decolagem.getTempoEntrada());
                System.out.println("  [DECOLAGEM] Aviao ID " + decolagem.getId() + " liberado e decolou.");
                operacaoRealizada = true;
            }
        }

        if (!operacaoRealizada) {
            System.out.println("  [INFO] Pistas livres. Nenhuma aeronave aguardando.");
        }
    }

    private void exibirRelatorioPeriodico() {
        System.out.println("--- STATUS ATUALIZADO DAS FILAS ---");

        System.out.print("a) Prateleiras de Pouso: P1: ");
        aterrissagem1.mostrarFila();
        System.out.print("                         P2: ");
        aterrissagem2.mostrarFila();
        System.out.print("   Filas de Decolagem:   F1: ");
        decolagem1.mostrarFila();
        System.out.print("                         F2: ");
        decolagem2.mostrarFila();

        System.out.println("---  ESTATISTICAS ---");
        if (qtdDecolagensRealizadas > 0) {
            double media = (double) tempoTotalEsperaDecolagem / qtdDecolagensRealizadas;
            System.out.printf("b) Tempo medio espera decolagem: %.2f ciclos\n", media);
        } else {
            System.out.println("b) Tempo medio espera decolagem: 0.00 (Nenhuma operacao)");
        }

        if (qtdPousosRealizados > 0) {
            double media = (double) tempoTotalEsperaPouso / qtdPousosRealizados;
            System.out.printf("c) Tempo medio espera aterrissagem: %.2f ciclos\n", media);
        } else {
            System.out.println("c) Tempo medio espera aterrissagem: 0.00 (Nenhuma operacao)");
        }

        System.out.println("d) Total pousos de emergencia: " + totalPousosEmergencia);
    }
}