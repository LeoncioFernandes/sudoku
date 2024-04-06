import java.util.ArrayList;
import java.util.Scanner;

public class Jogadas {

    //Jogada de LINHA
    public static char JogadaLinha(String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        Scanner teclado = new Scanner(System.in);
        char linha = '0';

        while (true) {
            System.out.println("Digite a LINHA da próxima jogada: ");
            linha = Character.toUpperCase(teclado.next().charAt(0));
            if (linha >= 'A' && linha <= 'I') {
                break;
            }else{
                LimparCmd.clean();
                System.out.println("DIGITE UMA LINHA VÁLIDA!\n");
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
            }
        }

        return linha;
    }

    //Jogada de COLUNA
    public static char JogadaColuna(String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        Scanner teclado = new Scanner(System.in);
        char coluna = '0';

        while (true) {
            System.out.println("Digite a COLUNA da próxima jogada: ");
            coluna = Character.toUpperCase(teclado.next().charAt(0));
            if (coluna >= 'A' && coluna <= 'I') {
                break;
            }else{
                LimparCmd.clean();
                System.out.println("DIGITE UMA COLUNA VÁLIDA!\n");
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
            }
        }

        
        return coluna;
    }

    //Jogada de Valor
    public static int JogadaValor(String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        Scanner teclado = new Scanner(System.in);
        int valor = 0;
        
        while (true) {
            System.out.println("Agora Digite o valor (1 à 9): ");
            char val = teclado.next().charAt(0);
            if (val >= 49 && val <= 57) {
                valor = val-48;
                LimparCmd.clean();
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                break;
            }else{
                LimparCmd.clean();
                System.out.println("DIGITE UM VALOR ENTRE 1 e 9\n");
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
            }
        }
        return valor;
    }
    
}
