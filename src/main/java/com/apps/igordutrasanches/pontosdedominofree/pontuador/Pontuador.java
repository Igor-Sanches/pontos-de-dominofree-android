package apps.igordutrasanches.pontosdedominofree.pontuador;

public class Pontuador {
    private boolean dobrado = false;
    public Pontuador(boolean dobrado){
        this.dobrado = dobrado;
    }

    public static Pontuador dobrado(boolean dobrado){
        return new Pontuador(dobrado);
    }

    public long placar(Pontos pontos){
        long placa = 0;
        switch (pontos){
            case passe:
                placa = dobrado ? 2 * 2 : 2;
                break;
            case passe2:
                placa = dobrado ? 2 * 4 : 4;
                break;
            case passe_saida:
                placa = dobrado ? 2 * 4 : 4;
                break;
            case passe_saida2:
                placa = dobrado ? 2 * 6 : 6;
                break;
            case geral:
                placa = dobrado ? 2 * 6 : 6;
                break;
            case geral_inconsciente:
                placa = dobrado ? 2 * 6 : 6;
                break;
            case batida:
                placa = dobrado ? 2 * 4 : 4;
                break;
            case batida_lascada:
                placa = dobrado ? 2 * 8 : 8;
                break;
            case batida_camburao:
                placa = dobrado ? 2 * 20 : 20;
                break;
        }

        return placa;
    }
}
