import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Validacoes {

    //REMOVER AS REPETIÇÕES QUANDO A MATRIX É GERADA
    public static void removerRepeticoes(String[][] matriz) {
        
        //Remover números repetidos BLOCO (SEPARANDO O BLOCO 3 X 3)
        for (int linha = 0; linha < matriz.length; linha += 3) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna += 3) {
                encontrarRepeticoesBloco(matriz, linha, coluna);
            }
        }

        //Remover números repetidos LINHA
        for (int linha = 0; linha < 9; linha++) {
            Set<String> numerosUnicos = new HashSet<>();
            for (int coluna = 0; coluna < 9; coluna++) {
                if(!matriz[linha][coluna].equals("*") && !numerosUnicos.add(matriz[linha][coluna])) {
                    matriz[linha][coluna] = "*";  
                }  
            }
        }

        //Remover números repetidos COLUNA
        for (int coluna = 0; coluna < 9; coluna++) {
            Set<String> numerosUnicos = new HashSet<>();
            for (int linha = 0; linha < 9; linha++) {
                if (!matriz[linha][coluna].equals("*") && !numerosUnicos.add(matriz[linha][coluna])) {
                    matriz[linha][coluna] = "*"; 
                }  
            }
        }
    }

    //ENCONTRAR OS CARACTERES REPETIDOS NO BLOCO 3 X 3
    public static void encontrarRepeticoesBloco(String[][] matriz, int linha, int coluna) {
       
        Set<String> caracteresVistos = new HashSet<>();
        for (int l = linha; l < linha + 3; l++) {
            for (int c = coluna; c < coluna + 3; c++) {
                String caractere = matriz[l][c];
                if (!caractere.equals("*") && caracteresVistos.contains(caractere)) {
                    substituirCaractereRepetidoNoBloco(matriz, caractere, linha, coluna);
                } else {
                    caracteresVistos.add(caractere);
                }
            }
        }

    }

    //SUBSTITUIR OS CARACTERES REPETIDOS NO BLOCO 3 X 3 POR *
    public static void substituirCaractereRepetidoNoBloco(String[][] matriz, String caractere, int linha, int coluna) {

        for (int l = linha; l < linha + 3; l++) {
            for (int c = coluna; c < coluna + 3; c++) {
                if (matriz[l][c] == caractere) {
                    matriz[l][c] = "*";
                }
            }
        }

    }

    //VALIDAR SE LINHA E COLUNA PODEM RECEBER JOGADA
    public static boolean validarLinhasColunasFixas(char linha, char coluna, ArrayList<String[]> linhasColunasFixas){
        
        for (String[] strings : linhasColunasFixas) {
            if ((linha - 65) == Integer.parseInt(strings[0]) && (coluna - 65) == Integer.parseInt(strings[1])) {
                return true;
            }
        }

        return false;
    }

    //VALIDAR SE JOGADA É PERMITIDA
    public static boolean validarJogada(int valor, char linha, char coluna, String[][] matriz){
        
        //Validar repetições na LINHA
        for (int c = 0; c < matriz.length; c++) {
            if(matriz[linha - 65][c].equals(String.valueOf(valor))){
                System.out.println("A JOGADA: " + valor + " não pode ser feita na LINHA: " + (char)linha + " e COLUNA: " + (char)coluna);
                return true;
            }
        }

        //Validar repetições na COLUNA
        for (int l = 0; l < matriz.length; l++) {
            if(matriz[l][coluna - 65].equals(String.valueOf(valor))){
                System.out.println("A JOGADA: " + valor + " não pode ser feita na LINHA: " + (char)linha + " e COLUNA: " + (char)coluna);
                return true;
            }
        }

        //Validar repetições no BLOCO 3X3
        int iniL = 0;
        int fimL = 0;
        int iniC = 0;
        int fimC = 0;

        if((linha - 65) <= 2 ) {iniL = 0; fimL = 2;}
        if(((linha - 65) >= 3) && ((linha - 65) <= 5)) {iniL = 3; fimL = 5;}
        if(((linha - 65) >= 6) && ((linha - 65) <= 8)) {iniL = 6; fimL = 8;}

        if((coluna - 65) <= 2 ) {iniC = 0; fimC = 2;}
        if(((coluna - 65) >= 3) && ((coluna - 65) <= 5)) {iniC = 3; fimC = 5;}
        if(((coluna - 65) >= 6) && ((coluna - 65) <= 8)) {iniC = 6; fimC = 8;}

        for (int l = iniL; l <= fimL; l++) {
            for (int c = iniC; c <= fimC; c++) {
                if(matriz[l][c].equals(String.valueOf(valor))){
                    System.out.println("A JOGADA: " + valor + " não pode ser feita na LINHA: " + (char)linha + " e COLUNA: " + (char)coluna);
                    return true;
                }
            }
        }

        return false;
    }

}
