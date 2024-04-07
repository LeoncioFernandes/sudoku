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
            if ((linha >= 'A' && linha <= 'I') || linha == 'S') {
                if (linha == 'S' && Game.SairGame(matriz, linhasColunasFixas)) {
                    break;
                }else if(linha != 'S'){
                    break;  
                }else{
                    LimparCmd.clean();
                    ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                }
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
            if ((coluna >= 'A' && coluna <= 'I') || coluna == 'S') {
                if (coluna == 'S' && Game.SairGame(matriz, linhasColunasFixas)) {
                    break;
                }else if(coluna != 'S'){
                    break;  
                }else{
                    LimparCmd.clean();
                    ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                }
            }else{
                LimparCmd.clean();
                System.out.println("DIGITE UMA COLUNA VÁLIDA!\n");
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
            }
        }
        return coluna;
    }

    //Jogada de VALOR
    public static char JogadaValor(String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        Scanner teclado = new Scanner(System.in);
        char valor = '0';
        
        while (true) {

            System.out.println("Agora Digite o valor (1 à 9): ");
            valor = teclado.next().charAt(0);
            if ((valor >= '1' && valor <= '9') || Character.toUpperCase(valor) == 'S') {
                if (Character.toUpperCase(valor) == 'S' && Game.SairGame(matriz, linhasColunasFixas)) {
                    break;
                }else if(Character.toUpperCase(valor) != 'S'){
                    break;  
                }else{
                    LimparCmd.clean();
                    ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                }
            }else{
                LimparCmd.clean();
                System.out.println("DIGITE UM VALOR ENTRE 1 e 9\n");
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
            }
        }
        return valor;
    }
    
}
