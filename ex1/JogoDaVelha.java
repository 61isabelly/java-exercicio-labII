import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        Campo[][] jogodavelha = new Campo[3][3];
        EstadoCampo simboloAtual = EstadoCampo.JOGADOR1;
        boolean jogo = true;
        String vitoria = "";
        Scanner scan = new Scanner(System.in);

        iniciaJogo(jogodavelha);

        while (jogo) {
            desenhaJogo(jogodavelha);
            vitoria = verificaVitoria(jogodavelha);

            if (!vitoria.equals("")) {
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            }

            try {
                if (verificaJogada(jogodavelha, jogar(scan, simboloAtual.getSimbolo()), simboloAtual)) {
                    simboloAtual = (simboloAtual == EstadoCampo.JOGADOR1) ? EstadoCampo.JOGADOR2 : EstadoCampo.JOGADOR1;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
                scan.nextLine();
            }
        }

        desenhaJogo(jogodavelha);
        System.out.print("Fim de jogo");
    }

    public static void desenhaJogo(Campo[][] jogodavelha) {
        limparTela();
        System.out.println("   0   1   2");
        System.out.printf("0  %c | %c | %c%n", jogodavelha[0][0].getSimbolo(), jogodavelha[0][1].getSimbolo(), jogodavelha[0][2].getSimbolo());
        System.out.println("  ---+---+---");
        System.out.printf("1  %c | %c | %c%n", jogodavelha[1][0].getSimbolo(), jogodavelha[1][1].getSimbolo(), jogodavelha[1][2].getSimbolo());
        System.out.println("  ---+---+---");
        System.out.printf("2  %c | %c | %c%n", jogodavelha[2][0].getSimbolo(), jogodavelha[2][1].getSimbolo(), jogodavelha[2][2].getSimbolo());
    }

    public static void limparTela() {
        for (int cont = 0; cont < 50; cont++) {
            System.out.println();
        }
    }

    public static int[] jogar(Scanner scan, char simboloAtual) {
        int[] p = new int[2];
        System.out.printf("Quem joga: %c%n", simboloAtual);
        System.out.print("Informe a linha (0, 1 ou 2): ");
        p[0] = scan.nextInt();
        System.out.print("Informe a coluna (0, 1 ou 2): ");
        p[1] = scan.nextInt();
        return p;
    }


    public static boolean verificaJogada(Campo[][] jogodavelha, int[] p, EstadoCampo simboloAtual) {
        if (jogodavelha[p[0]][p[1]].getEstado() == EstadoCampo.VAZIO) {
            jogodavelha[p[0]][p[1]].setEstado(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    public static void iniciaJogo(Campo[][] jogodavelha) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                jogodavelha[l][c] = new Campo();
            }
        }
    }

    public static String verificaVitoria(Campo[][] velha) {
        for (int i = 0; i < 3; i++) {
            // Linha
            if (velha[i][0].getEstado() != EstadoCampo.VAZIO &&
                    velha[i][0].getEstado() == velha[i][1].getEstado() &&
                    velha[i][1].getEstado() == velha[i][2].getEstado()) {
                return String.valueOf(velha[i][0].getSimbolo());
            }
            // Coluna
            if (velha[0][i].getEstado() != EstadoCampo.VAZIO &&
                    velha[0][i].getEstado() == velha[1][i].getEstado() &&
                    velha[1][i].getEstado() == velha[2][i].getEstado()) {
                return String.valueOf(velha[0][i].getSimbolo());
            }
        }

        // Diagonais
        if (velha[0][0].getEstado() != EstadoCampo.VAZIO &&
                velha[0][0].getEstado() == velha[1][1].getEstado() &&
                velha[1][1].getEstado() == velha[2][2].getEstado()) {
            return String.valueOf(velha[0][0].getSimbolo());
        }

        if (velha[0][2].getEstado() != EstadoCampo.VAZIO &&
                velha[0][2].getEstado() == velha[1][1].getEstado() &&
                velha[1][1].getEstado() == velha[2][0].getEstado()) {
            return String.valueOf(velha[0][2].getSimbolo());
        }

        return "";
    }
}

