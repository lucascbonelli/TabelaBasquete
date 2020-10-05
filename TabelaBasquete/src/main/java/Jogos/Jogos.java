package Jogos;

import java.util.ArrayList;

public class Jogos {
    ArrayList<int[]> LPlacar = new ArrayList<int[]>();

    private int MinTemp;
    private int MaxTemp;
    private int QRMin;
    private int iQRMin;
    private int QRMax;
    private int iQRMax;
    private int qtdJogos;
    private boolean bPrimeiroJogo;

    public Jogos() {
        ZeraDados();        

    }
    
    private void ZeraDados(){
        this.MinTemp = 0;
        this.MaxTemp = 0;
        this.QRMin = 0;
        this.QRMax = 0;
        this.iQRMin = 0;
        this.iQRMax = 0;
        this.qtdJogos = 0;
        this.bPrimeiroJogo = true;
    }
    
    public int getqtdJogos() {
        return qtdJogos;
    }
    public int[]getUltimoArray(){
        return LPlacar.get(qtdJogos - 1);
    }
    

    public void AtualizaTabela(int placar) {
        qtdJogos = qtdJogos + 1;

        if (!bPrimeiroJogo) {

            if (QRMax < placar) {
                iQRMax = iQRMax +1;
                QRMax = placar;

            }
            if (QRMin > placar) {
                iQRMin = iQRMin +1;
                QRMin = placar;
            }
            if (MinTemp > placar) {
                MinTemp = placar;
            }

            if (MaxTemp < placar) {
                MaxTemp = placar;
            }

        }
        else{
            bPrimeiroJogo = false;
            QRMax = placar;
            QRMin = placar;
            MinTemp = placar;
            MaxTemp = placar;
        }

        int[] tabela = new int[5];

            tabela[0] = placar;
            tabela[1] = MinTemp;
            tabela[2] = MaxTemp;
            tabela[3] = iQRMin;
            tabela[4] = iQRMax;


            LPlacar.add(tabela);

        }
    public void resetJogos(){
       
        while(LPlacar.size() > 0){
            LPlacar.remove(0);
        }
        
        ZeraDados();
        
    }
}

