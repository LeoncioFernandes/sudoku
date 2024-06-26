import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void NewGame(int dificuldade, String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        
        int[] sortLinhas = new int[dificuldade];
        int[] sortColunas = new int[dificuldade];
        int[] sortVals = new int[dificuldade];

        //Sorteio das LINHAS que serão preenchidas
        for (int i = 0; i < sortLinhas.length; i++) {
            sortLinhas[i] = new Random().nextInt(9);
        }

        //Sorteio das COLUNAS que serão preenchidas
        for (int i = 0; i < sortColunas.length; i++) {
            sortColunas[i] = new Random().nextInt(9);
        }

        //Sorteio dos VALORES que terão as LINHAS e COLUNAS sorteadas
        for (int i = 0; i < sortVals.length; i++) {
            sortVals[i] = new Random().nextInt(9) + 1;
        }

        // matriz[8][7] = "*";
        // matriz[8][8] = "*";

        //Preencher todas as linhas e colunas com "*"
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = "*";
            }
        }

        //Preencher a Matriz com os Valores Sorteados (Linhas e Colunas sorteadas)
        for (int i = 0; i < dificuldade; i++) {
            if(matriz[sortLinhas[i]][sortColunas[i]].equals("*"))
            {
                matriz[sortLinhas[i]][sortColunas[i]] = String.valueOf(sortVals[i]);
            }  
        }

        //Remover as repetições dos números sorteados
        Validacoes.removerRepeticoes(matriz);

        //Carrega o ArrayList com as LINHAS e COLUNAS que são FIXAS (não pode ser modificadas)
        linhasColunasFixas.clear();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (!matriz[i][j].equals("*")) {
                    linhasColunasFixas.add(new String[]{String.valueOf(i),String.valueOf(j)});
                }
            }  
        }

    } 

    //CONFIRMAR SAÍDA
    public static boolean SairGame(String[][] matriz, ArrayList<String[]> linhasColunasFixas) {
        while (true) {
            System.out.println("Deseja sair do jogo? ( S / N ) ");
            Scanner teclado = new Scanner(System.in);
            char sairGame = Character.toUpperCase(teclado.next().charAt(0));

            switch (sairGame) {
                case 'S':
                    return true;
                case 'N':
                    return false;
                default:
                    LimparCmd.clean();
                    System.out.println("DIGITE S para SIM ou N para NÃO\n");
                    ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
            }
        }
    }

    //IMPRIMIR MENSAGEM DE SÁIDA
    public static void ImprimirSaida(String[][] matriz, ArrayList<String[]> linhasColunasFixas) {
        LimparCmd.clean();
        ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
        System.out.println("ATÉ MAIS!\n");
    }

    //VERIFICAR SE USUÁRIO DESEJA REINICIAR JOGO APÓS VITÓRIA
    public static boolean ReiniciarGame(){
        Scanner teclado = new Scanner(System.in);
        char repetirGame = '0';

        while (true) {
            System.out.println("Deseja Iniciar um novo jogo? ( S / N ) ");
            repetirGame = Character.toUpperCase(teclado.next().charAt(0));
            switch (repetirGame) {
                case 'S':
                    return true;
                case 'N':    
                    return false;
                default:
                    LimparCmd.clean();
                    System.out.println("DIGITE S para SIM ou N para NÃO\n");
            }
        }
    }

    //VERIFICAR SE O USUÁRIO CONSEGUIU PREENCHER todo O SUDOKU
    public static boolean Vitoria(String[][] matriz){
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (matriz[linha][coluna].equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }
}
