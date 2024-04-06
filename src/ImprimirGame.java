import java.util.ArrayList;

public class ImprimirGame {
    public static void ImprimirJogo(String[][] matriz, ArrayList<String[]> linhasColunasFixas){
        
        int codAscii = 65;
        System.out.println("    A B C | D E F | G H I");
        System.out.println("   - - - - - - - - - - - -");

        for (int linha = 0; linha < matriz.length; linha++) {
            
            System.out.print((char)codAscii + " |");
            codAscii++;

            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                
                boolean corAmarela = false;

                for (String[] coordenadas : linhasColunasFixas) {
                    int linhaFixa = Integer.parseInt(coordenadas[0]);
                    int colunaFixa = Integer.parseInt(coordenadas[1]);
                    
                    if (linha == linhaFixa && coluna == colunaFixa) {
                        corAmarela = true;
                        break;
                    }
                }

                if (corAmarela) {
                    System.out.print(" " + CoresConsole.YELLOW + matriz[linha][coluna] + CoresConsole.RESET);
                } else {
                    if (!matriz[linha][coluna].equals("*")) {
                        System.out.print(" " + CoresConsole.GREEN + matriz[linha][coluna] + CoresConsole.RESET);
                    } else {
                        System.out.print(" " + matriz[linha][coluna]);
                    }
                    
                }
                
                if((coluna + 1) % 3 == 0){
                    System.out.print(" |");
                }
            }

            System.out.println("");
            if ((linha + 1) % 3 == 0) {
                System.out.println("   - - - - - - - - - - - -");
            }
        }
    }
}
