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

        this.MinTemp = 0;
        this.MaxTemp = 0;
        this.QRMin = 0;
        this.QRMax = 0;
        this.iQRMin = 0;
        this.iQRMax = 0;
        this.qtdJogos = 0;
        this.bPrimeiroJogo = true;

    }

    public void AtualizaTabela(int placar) {
        if (placar < 0) {
            return;
        }

        qtdJogos = qtdJogos + 1;

        if (MinTemp < placar) {
            MinTemp = placar;
        }

        if (MaxTemp < placar) {
            MaxTemp = placar;
        }
        if (!bPrimeiroJogo) {

            if (QRMax < placar) {
                iQRMax = iQRMax +1;
                QRMax = placar;

            }
            if (QRMin > placar) {
                iQRMin = iQRMin +1;
                QRMin = placar;
            }
        }
        else{
            bPrimeiroJogo = false;
            QRMax = placar;
            QRMin = placar;
        }

        int[] tabela = new int[5];

            tabela[0] = placar;
            tabela[1] = MinTemp;
            tabela[2] = MaxTemp;
            tabela[3] = iQRMin;
            tabela[4] = iQRMax;


            LPlacar.add(tabela);

        }


    public void AdicionaPlacar() {

        AtualizaTabela(12);
        AtualizaTabela(24);
        AtualizaTabela(10);
        AtualizaTabela(24);

    }

    public void EscreveTabela() {

        System.out.println("Jogo    Placar  Min. Temp   Max. Temp   Record Min  Record Max");
        for (int n = 0; n < this.qtdJogos; n = n + 1) {
            int[] Valor = LPlacar.get(n);
            System.out.println((n+1)+"         "+Valor[0] + "        " +
                                                 Valor[1] + "          " +Valor[2] + "             " +
                                                 Valor[3] + "          " +Valor[4] );
        }
    }
}
