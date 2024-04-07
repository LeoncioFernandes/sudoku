import java.util.ArrayList;

//REALIZAR A IMPRESSÃO DO SUDOKU NO PROMPT DE COMANDO
public class ImprimirGame {
    public static void ImprimirJogo(String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        
        //CABEÇALHO
        int codAscii = 65;
        System.out.println("Digite S para sair do jogo \n");
        System.out.println("    A B C | D E F | G H I");
        System.out.println("   - - - - - - - - - - - -");

        //CORPO
        for (int linha = 0; linha < matriz.length; linha++) {
            
            System.out.print((char)codAscii + " |");
            codAscii++;

            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                
                boolean corAmarela = false;

                for (String[] coordenadas : linhasColunasFixas) {
                    int linhaFixa = Integer.parseInt(coordenadas[0]);
                    int colunaFixa = Integer.parseInt(coordenadas[1]);
                    
                    //SE A LINHA E A COLUNA ATUAL ESTÃO CONTIDAS EM linhasColunasFixas, preencha a variável corAmarela com true
                    if (linha == linhaFixa && coluna == colunaFixa) {
                        corAmarela = true;
                        break;
                    }
                }

                //SE corAmarela = true, imprime posição atual na cor AMARELA
                if (corAmarela) {
                    System.out.print(" " + CoresConsole.YELLOW + matriz[linha][coluna] + CoresConsole.RESET);
                } else {
                    //Caso a posição atual NÃO seja um "*", imprime na cor VERDE
                    if (!matriz[linha][coluna].equals("*")) {
                        System.out.print(" " + CoresConsole.GREEN + matriz[linha][coluna] + CoresConsole.RESET);
                    } else {
                        System.out.print(" " + matriz[linha][coluna]);
                    }
                    
                }
                
                //SEPARAÇÃO (bloco 3 x 3)
                if((coluna + 1) % 3 == 0){
                    System.out.print(" |");
                }
            }

            //SEPARAÇÃO (bloco 3 x 3)
            System.out.println("");
            if ((linha + 1) % 3 == 0) {
                System.out.println("   - - - - - - - - - - - -");
            }
        }
    }
}
