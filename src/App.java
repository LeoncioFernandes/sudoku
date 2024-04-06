import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        //CRIAR MATRIX 9 x 9
        String[][] matriz = new String[9][9];
        // String[][] matriz = {
        //     {"1", "3", "7", "9" ,"8", "6", "4", "5", "2"},
        //     {"9", "2", "5", "3" ,"4", "7", "1", "6", "8"},
        //     {"8", "6", "4", "5" ,"2", "1", "9", "7", "3"},
        //     {"7", "5", "3", "8" ,"1", "4", "6", "2", "9"},
        //     {"6", "1", "2", "7" ,"3", "9", "8", "4", "5"},
        //     {"4", "8", "9", "6" ,"5", "2", "3", "1", "7"},
        //     {"5", "7", "1", "4" ,"9", "3", "2", "8", "6"},
        //     {"2", "9", "8", "1" ,"6", "5", "7", "3", "4"},
        //     {"3", "4", "6", "2" ,"7", "8", "5", "*", "*"}
        // };

        //CRIAR ARRAYLIST QUE IRÃO CONTER AS LINHAS E COLUNAS QUE NÃO PODEM SER ALTERADAS
        ArrayList<String[]> linhasColunasFixas = new ArrayList<>();
        boolean newGame = true;
        
        while (true){

            //Iniciar NOVO JOGO
            if (newGame) {
                LimparCmd.clean();
                Game.NewGame(50, matriz, linhasColunasFixas);
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                newGame = false;
            }
            
            //Jogada de LINHA
            char linha = Jogadas.JogadaLinha(matriz, linhasColunasFixas);
            //Jogada de COLUNA
            char coluna = Jogadas.JogadaColuna(matriz, linhasColunasFixas);
            //Validar se LINHA e COLUNA pode receber Jogada
            boolean contem = Validacoes.validarLinhasColunasFixas(linha, coluna, linhasColunasFixas);

            char continuarGame = '0';

            //Se LINHA E COLUNA digitadas estão CONTIDAS no arrayList linhasColunasFixas (true), não será permitida a jogada!
            if (contem) {
                LimparCmd.clean();
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                System.out.println("Não é possível jogar na linha " + (char)linha + " e na coluna " + (char)coluna);
                continuarGame = Game.EndGame(matriz, linhasColunasFixas);
            } else {
                //Jogada de VALOR
                int valor = Jogadas.JogadaValor(matriz, linhasColunasFixas);

                //Validar repetições
                boolean numRepetido = Validacoes.validarJogada(valor, linha, coluna, matriz);

                //Se o Valor jogado NÃO estava repetido dentro das condições de validação (false), segue gravação da jogada em matriz
                if(!numRepetido){

                    matriz[linha - 65][coluna - 65] = String.valueOf(valor);
                    LimparCmd.clean();
                    ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);

                    //Se o array matriz já tiver sido TOTALMENTE preenchido (não contiver mais *), o jogo foi FINALIZADO 
                    if (Game.Vitoria(matriz)) {
                        System.out.println("PARABÉNS! Fim de Jogo!");
                        
                        newGame = Game.ReiniciarGame();

                        //Caso a resposta para ReiniciarGame seja negativa (false), preenche continuarGame com 'N'
                        if (!newGame) {
                            continuarGame = 'N';
                        }
                    } else {
                        continuarGame = Game.EndGame(matriz, linhasColunasFixas);
                    }
                    
                }else{
                    continuarGame = Game.EndGame(matriz, linhasColunasFixas);
                }
                
                
            }
            
            //Se continuarGame for 'N', finaliza o While e encerra o programa
            if (continuarGame == 'N') {
                LimparCmd.clean();
                ImprimirGame.ImprimirJogo(matriz, linhasColunasFixas);
                System.out.println("ATÉ MAIS!\n");
                break;
            }
        }
        
    }   
}
