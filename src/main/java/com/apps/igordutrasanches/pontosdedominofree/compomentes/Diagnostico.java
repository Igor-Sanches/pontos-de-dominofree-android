package apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.pontuador.Pontos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import apps.igordutrasanches.pontosdedominofree.pontuador.Pontos;

/**
 * Created by igord on 02/05/2019.
 */

public class Diagnostico extends Service {

    public static final int A = 0, B = 1;
    public static final String A_PONTOS_PASSE = "A_PONTOS_PASSE", A_PONTOS_PASSE2 = "A_PONTOS_PASSE2", A_PONTOS_PASSE_SAIDA = "A_PONTOS_PASSE_SAIDA", A_PONTOS_PASSE_SAIDA2 = "A_PONTOS_PASSE_SAIDA2", A_PONTOS_GERAL = "A_PONTOS_GERAL", A_PONTOS_GERAL_INCS  = "A_PONTOS_GERAL_INCS", A_PONTOS_BATIDA = "A_PONTOS_BATIDA", A_PONTOS_BATIDA_PONTOS_LASCADA = "A_PONTOS_BATIDA_PONTOS_LASCADA", A_PONTOS_BATIDA_PONTOS_CAMBURA0 = "A_PONTOS_BATIDA_PONTOS_CAMBURAO";
    public static final String B_PONTOS_PASSE = "B_PONTOS_PASSE", B_PONTOS_PASSE2 = "B_PONTOS_PASSE2", B_PONTOS_PASSE_SAIDA = "B_PONTOS_PASSE_SAIDA", B_PONTOS_PASSE_SAIDA2 = "B_PONTOS_PASSE_SAIDA2", B_PONTOS_GERAL = "B_PONTOS_GERAL", B_PONTOS_GERAL_INCS  = "B_PONTOS_GERAL_INCS", B_PONTOS_BATIDA = "B_PONTOS_BATIDA", B_PONTOS_BATIDB_PONTOS_LASCADA = "B_PONTOS_BATIDB_PONTOS_LASCADA", B_PONTOS_BATIDB_PONTOS_CAMBURA0 = "B_PONTOS_BATIDB_PONTOS_CAMBURAO";
    public static final String A_DOBRADO_PASSE = "A_DOBRADO_PASSE", A_DOBRADO_PASSE2 = "A_DOBRADO_PASSE2", A_DOBRADO_PASSE_SAIDA = "A_DOBRADO_PASSE_SAIDA", A_DOBRADO_PASSE_SAIDA2 = "A_DOBRADO_PASSE_SAIDA2", A_DOBRADO_GERAL = "A_DOBRADO_GERAL", A_DOBRADO_GERAL_INCS  = "A_DOBRADO_GERAL_INCS", A_DOBRADO_BATIDA = "A_DOBRADO_BATIDA", A_DOBRADO_BATIDA_DOBRADO_LASCADA = "A_DOBRADO_BATIDA_DOBRADO_LASCADA", A_DOBRADO_BATIDA_DOBRADO_CAMBURA0 = "A_DOBRADO_BATIDA_DOBRADO_CAMBURAO";
    public static final String B_DOBRADO_PASSE = "B_DOBRADO_PASSE", B_DOBRADO_PASSE2 = "B_DOBRADO_PASSE2", B_DOBRADO_PASSE_SAIDA = "B_DOBRADO_PASSE_SAIDA", B_DOBRADO_PASSE_SAIDA2 = "B_DOBRADO_PASSE_SAIDA2", B_DOBRADO_GERAL = "B_DOBRADO_GERAL", B_DOBRADO_GERAL_INCS  = "B_DOBRADO_GERAL_INCS", B_DOBRADO_BATIDA = "B_DOBRADO_BATIDA", B_DOBRADO_BATIDB_DOBRADO_LASCADA = "B_DOBRADO_BATIDB_DOBRADO_LASCADA", B_DOBRADO_BATIDB_DOBRADO_CAMBURA0 = "B_DOBRADO_BATIDB_DOBRADO_CAMBURAO";
    public static final String A_VEZES_PASSE = "A_VEZES_PASSE", A_VEZES_PASSE2 = "A_VEZES_PASSE2", A_VEZES_PASSE_SAIDA = "A_VEZES_PASSE_SAIDA", A_VEZES_PASSE_SAIDA2 = "A_VEZES_PASSE_SAIDA2", A_VEZES_GERAL = "A_VEZES_GERAL", A_VEZES_GERAL_INCS  = "A_VEZES_GERAL_INCS", A_VEZES_BATIDA = "A_VEZES_BATIDA", A_VEZES_BATIDA_VEZES_LASCADA = "A_VEZES_BATIDA_VEZES_LASCADA", A_VEZES_BATIDA_VEZES_CAMBURA0 = "A_VEZES_BATIDA_VEZES_CAMBURAO";
    public static final String B_VEZES_PASSE = "B_VEZES_PASSE", B_VEZES_PASSE2 = "B_VEZES_PASSE2", B_VEZES_PASSE_SAIDA = "B_VEZES_PASSE_SAIDA", B_VEZES_PASSE_SAIDA2 = "B_VEZES_PASSE_SAIDA2", B_VEZES_GERAL = "B_VEZES_GERAL", B_VEZES_GERAL_INCS  = "B_VEZES_GERAL_INCS", B_VEZES_BATIDA = "B_VEZES_BATIDA", B_VEZES_BATIDB_VEZES_LASCADA = "B_VEZES_BATIDB_VEZES_LASCADA", B_VEZES_BATIDB_VEZES_CAMBURA0 = "B_VEZES_BATIDB_VEZES_CAMBURAO";
    public static final String NAME_A = "PLAYA", NAME_B = "PLAYB", PLACAR_A = "PLACAR_A", PLACAR_B = "PLCACAR_B";

    private static Context mContext;

    public Diagnostico(Context mContext){
        this.mContext = mContext;
    }

    public static Diagnostico setContext(Context mContext){
        return new Diagnostico(mContext);
    }

    public void setPlacares(int type, long placar){
        if(type == A) setThis(PLACAR_A, placar);
        else setThis(PLACAR_B, placar);
    }

    public String isTetalhadoResumo(){
        return get("resumo", "", mContext);
    }

    public long getPlacares(int type){
        if(type == A) return getThis(PLACAR_A, 0);
        else return getThis(PLACAR_B, 0);
    }

    public void setNames(int type, String name){
        if(type == A) setThis(NAME_A, name);
        else setThis(NAME_B, name);
    }

    public String getNames(int type){
        if(type == A) return getThis(NAME_A, Jogadores.getJogadorA(mContext));
        else return getThis(NAME_B, Jogadores.getJogadorB(mContext));
    }

    public long getPontos(int type, Pontos pontosType){
        long pontos = 0;
        if(type == A){
            switch (pontosType){
                case passe:
                    pontos = getThis(A_PONTOS_PASSE, 0);
                    break;
                case passe2:
                    pontos = getThis(A_PONTOS_PASSE2,  0);
                    break;
                case passe_saida:
                    pontos = getThis(A_PONTOS_PASSE_SAIDA,  0);
                    break;
                case passe_saida2:
                    pontos = getThis(A_PONTOS_PASSE_SAIDA2,  0);
                    break;
                case geral:
                    pontos = getThis(A_PONTOS_GERAL,  0);
                    break;
                case geral_inconsciente:
                    pontos = getThis(A_PONTOS_GERAL_INCS,  0);
                    break;
                case batida:
                    pontos = getThis(A_PONTOS_BATIDA,  0);
                    break;
                case batida_lascada:
                    pontos = getThis(A_PONTOS_BATIDA_PONTOS_LASCADA,  0);
                    break;
                case batida_camburao:
                    pontos = getThis(A_PONTOS_BATIDA_PONTOS_CAMBURA0,  0);
                    break;
            }
        }else{
            switch (pontosType){
                case passe:
                    pontos = getThis(B_PONTOS_PASSE,  0);
                    break;
                case passe2:
                    pontos = getThis(B_PONTOS_PASSE2,  0);
                    break;
                case passe_saida:
                    pontos = getThis(B_PONTOS_PASSE_SAIDA,  0);
                    break;
                case passe_saida2:
                    pontos = getThis(B_PONTOS_PASSE_SAIDA2,  0);
                    break;
                case geral:
                    pontos = getThis(B_PONTOS_GERAL,  0);
                    break;
                case geral_inconsciente:
                    pontos = getThis(B_PONTOS_GERAL_INCS,  0);
                    break;
                case batida:
                    pontos = getThis(B_PONTOS_BATIDA,  0);
                    break;
                case batida_lascada:
                    pontos = getThis(B_PONTOS_BATIDB_PONTOS_LASCADA,  0);
                    break;
                case batida_camburao:
                    pontos = getThis(B_PONTOS_BATIDB_PONTOS_CAMBURA0,  0);
                    break;
            }

        }
        return pontos;
    }
    public void setPontos(int type, Pontos pontosType, long value){
        if(type == A){
            switch (pontosType){
                case passe:
                    setThis(A_PONTOS_PASSE, dublicate_pontos(A_PONTOS_PASSE, value));
                    break;
                case passe2:
                    setThis(A_PONTOS_PASSE2,  dublicate_pontos(A_PONTOS_PASSE2, value));
                    break;
                case passe_saida:
                    setThis(A_PONTOS_PASSE_SAIDA,  dublicate_pontos(A_PONTOS_PASSE_SAIDA, value));
                    break;
                case passe_saida2:
                    setThis(A_PONTOS_PASSE_SAIDA2,  dublicate_pontos(A_PONTOS_PASSE_SAIDA2, value));
                    break;
                case geral:
                    setThis(A_PONTOS_GERAL,  dublicate_pontos(A_PONTOS_GERAL, value));
                    break;
                case geral_inconsciente:
                    setThis(A_PONTOS_GERAL_INCS,  dublicate_pontos(A_PONTOS_GERAL_INCS, value));
                    break;
                case batida:
                    setThis(A_PONTOS_BATIDA,  dublicate_pontos(A_PONTOS_BATIDA, value));
                    break;
                case batida_lascada:
                    setThis(A_PONTOS_BATIDA_PONTOS_LASCADA,  dublicate_pontos(A_PONTOS_BATIDA_PONTOS_LASCADA, value));
                    break;
                case batida_camburao:
                    setThis(A_PONTOS_BATIDA_PONTOS_CAMBURA0,  dublicate_pontos(A_PONTOS_BATIDA_PONTOS_CAMBURA0, value));
                    break;
            }
        }else{
            switch (pontosType){
                case passe:
                    setThis(B_PONTOS_PASSE, dublicate_pontos(B_PONTOS_PASSE, value));
                    break;
                case passe2:
                    setThis(B_PONTOS_PASSE2,  dublicate_pontos(B_PONTOS_PASSE2, value));
                    break;
                case passe_saida:
                    setThis(B_PONTOS_PASSE_SAIDA,  dublicate_pontos(B_PONTOS_PASSE_SAIDA, value));
                    break;
                case passe_saida2:
                    setThis(B_PONTOS_PASSE_SAIDA2,  dublicate_pontos(B_PONTOS_PASSE_SAIDA2, value));
                    break;
                case geral:
                    setThis(B_PONTOS_GERAL,  dublicate_pontos(B_PONTOS_GERAL, value));
                    break;
                case geral_inconsciente:
                    setThis(B_PONTOS_GERAL_INCS,  dublicate_pontos(B_PONTOS_GERAL_INCS, value));
                    break;
                case batida:
                    setThis(B_PONTOS_BATIDA,  dublicate_pontos(B_PONTOS_BATIDA, value));
                    break;
                case batida_lascada:
                    setThis(B_PONTOS_BATIDB_PONTOS_LASCADA,  dublicate_pontos(B_PONTOS_BATIDB_PONTOS_LASCADA, value));
                    break;
                case batida_camburao:
                    setThis(B_PONTOS_BATIDB_PONTOS_CAMBURA0,  dublicate_pontos(B_PONTOS_BATIDB_PONTOS_CAMBURA0, value));
                    break;
            }

        }
    }

    public long getVezes(int type, Pontos pontosType){
        long pontos_vezes = 0;
        if(type == A){
            switch (pontosType){
                case passe:
                    pontos_vezes = getThis(A_VEZES_PASSE, 0);
                    break;
                case passe2:
                    pontos_vezes = getThis(A_VEZES_PASSE2,  0);
                    break;
                case passe_saida:
                    pontos_vezes = getThis(A_VEZES_PASSE_SAIDA,  0);
                    break;
                case passe_saida2:
                    pontos_vezes = getThis(A_VEZES_PASSE_SAIDA2,  0);
                    break;
                case geral:
                    pontos_vezes = getThis(A_VEZES_GERAL,  0);
                    break;
                case geral_inconsciente:
                    pontos_vezes = getThis(A_VEZES_GERAL_INCS,  0);
                    break;
                case batida:
                    pontos_vezes = getThis(A_VEZES_BATIDA,  0);
                    break;
                case batida_lascada:
                    pontos_vezes = getThis(A_VEZES_BATIDA_VEZES_LASCADA,  0);
                    break;
                case batida_camburao:
                    pontos_vezes = getThis(A_VEZES_BATIDA_VEZES_CAMBURA0,  0);
                    break;
            }
        }else{
            switch (pontosType){
                case passe:
                    pontos_vezes = getThis(B_VEZES_PASSE,  0);
                    break;
                case passe2:
                    pontos_vezes = getThis(B_VEZES_PASSE2,  0);
                    break;
                case passe_saida:
                    pontos_vezes = getThis(B_VEZES_PASSE_SAIDA,  0);
                    break;
                case passe_saida2:
                    pontos_vezes = getThis(B_VEZES_PASSE_SAIDA2,  0);
                    break;
                case geral:
                    pontos_vezes = getThis(B_VEZES_GERAL,  0);
                    break;
                case geral_inconsciente:
                    pontos_vezes = getThis(B_VEZES_GERAL_INCS,  0);
                    break;
                case batida:
                    pontos_vezes = getThis(B_VEZES_BATIDA,  0);
                    break;
                case batida_lascada:
                    pontos_vezes = getThis(B_VEZES_BATIDB_VEZES_LASCADA,  0);
                    break;
                case batida_camburao:
                    pontos_vezes = getThis(B_VEZES_BATIDB_VEZES_CAMBURA0,  0);
                    break;
            }

        }
        return pontos_vezes;
    }
    public void setVezes(int type, Pontos pontosType){
        if(type == A){
            switch (pontosType){
                case passe:
                    setThis(A_VEZES_PASSE, dublicate_vezes(A_VEZES_PASSE));
                    break;
                case passe2:
                    setThis(A_VEZES_PASSE2,  dublicate_vezes(A_VEZES_PASSE2));
                    break;
                case passe_saida:
                    setThis(A_VEZES_PASSE_SAIDA,  dublicate_vezes(A_VEZES_PASSE_SAIDA));
                    break;
                case passe_saida2:
                    setThis(A_VEZES_PASSE_SAIDA2,  dublicate_vezes(A_VEZES_PASSE_SAIDA2));
                    break;
                case geral:
                    setThis(A_VEZES_GERAL,  dublicate_vezes(A_VEZES_GERAL));
                    break;
                case geral_inconsciente:
                    setThis(A_VEZES_GERAL_INCS,  dublicate_vezes(A_VEZES_GERAL_INCS));
                    break;
                case batida:
                    setThis(A_VEZES_BATIDA,  dublicate_vezes(A_VEZES_BATIDA));
                    break;
                case batida_lascada:
                    setThis(A_VEZES_BATIDA_VEZES_LASCADA,  dublicate_vezes(A_VEZES_BATIDA_VEZES_LASCADA));
                    break;
                case batida_camburao:
                    setThis(A_VEZES_BATIDA_VEZES_CAMBURA0,  dublicate_vezes(A_VEZES_BATIDA_VEZES_CAMBURA0));
                    break;
            }
        }else{
            switch (pontosType){
                case passe:
                    setThis(B_VEZES_PASSE, dublicate_vezes(B_VEZES_PASSE));
                    break;
                case passe2:
                    setThis(B_VEZES_PASSE2,  dublicate_vezes(B_VEZES_PASSE2));
                    break;
                case passe_saida:
                    setThis(B_VEZES_PASSE_SAIDA,  dublicate_vezes(B_VEZES_PASSE_SAIDA));
                    break;
                case passe_saida2:
                    setThis(B_VEZES_PASSE_SAIDA2,  dublicate_vezes(B_VEZES_PASSE_SAIDA2));
                    break;
                case geral:
                    setThis(B_VEZES_GERAL,  dublicate_vezes(B_VEZES_GERAL));
                    break;
                case geral_inconsciente:
                    setThis(B_VEZES_GERAL_INCS,  dublicate_vezes(B_VEZES_GERAL_INCS));
                    break;
                case batida:
                    setThis(B_VEZES_BATIDA,  dublicate_vezes(B_VEZES_BATIDA));
                    break;
                case batida_lascada:
                    setThis(B_VEZES_BATIDB_VEZES_LASCADA,  dublicate_vezes(B_VEZES_BATIDB_VEZES_LASCADA));
                    break;
                case batida_camburao:
                    setThis(B_VEZES_BATIDB_VEZES_CAMBURA0,  dublicate_vezes(B_VEZES_BATIDB_VEZES_CAMBURA0));
                    break;
            }

        }
    }

    public long getDobrado(int type, Pontos pontosType){
        long pontos_Dobrado = 0;
        if(type == A){
            switch (pontosType){
                case passe:
                    pontos_Dobrado = getThis(A_DOBRADO_PASSE, 0);
                    break;
                case passe2:
                    pontos_Dobrado = getThis(A_DOBRADO_PASSE2,  0);
                    break;
                case passe_saida:
                    pontos_Dobrado = getThis(A_DOBRADO_PASSE_SAIDA,  0);
                    break;
                case passe_saida2:
                    pontos_Dobrado = getThis(A_DOBRADO_PASSE_SAIDA2,  0);
                    break;
                case geral:
                    pontos_Dobrado = getThis(A_DOBRADO_GERAL,  0);
                    break;
                case geral_inconsciente:
                    pontos_Dobrado = getThis(A_DOBRADO_GERAL_INCS,  0);
                    break;
                case batida:
                    pontos_Dobrado = getThis(A_DOBRADO_BATIDA,  0);
                    break;
                case batida_lascada:
                    pontos_Dobrado = getThis(A_DOBRADO_BATIDA_DOBRADO_LASCADA,  0);
                    break;
                case batida_camburao:
                    pontos_Dobrado = getThis(A_DOBRADO_BATIDA_DOBRADO_CAMBURA0,  0);
                    break;
            }
        }else{
            switch (pontosType){
                case passe:
                    pontos_Dobrado = getThis(B_DOBRADO_PASSE,  0);
                    break;
                case passe2:
                    pontos_Dobrado = getThis(B_DOBRADO_PASSE2,  0);
                    break;
                case passe_saida:
                    pontos_Dobrado = getThis(B_DOBRADO_PASSE_SAIDA,  0);
                    break;
                case passe_saida2:
                    pontos_Dobrado = getThis(B_DOBRADO_PASSE_SAIDA2,  0);
                    break;
                case geral:
                    pontos_Dobrado = getThis(B_DOBRADO_GERAL,  0);
                    break;
                case geral_inconsciente:
                    pontos_Dobrado = getThis(B_DOBRADO_GERAL_INCS,  0);
                    break;
                case batida:
                    pontos_Dobrado = getThis(B_DOBRADO_BATIDA,  0);
                    break;
                case batida_lascada:
                    pontos_Dobrado = getThis(B_DOBRADO_BATIDB_DOBRADO_LASCADA,  0);
                    break;
                case batida_camburao:
                    pontos_Dobrado = getThis(B_DOBRADO_BATIDB_DOBRADO_CAMBURA0,  0);
                    break;
            }

        }
        return pontos_Dobrado;
    }
    public void setDobrado(int type, Pontos pontosType){
        if(type == A){
            switch (pontosType){
                case passe:
                    setThis(A_DOBRADO_PASSE, dublicate_dobrado(A_DOBRADO_PASSE));
                    break;
                case passe2:
                    setThis(A_DOBRADO_PASSE2,  dublicate_dobrado(A_DOBRADO_PASSE2));
                    break;
                case passe_saida:
                    setThis(A_DOBRADO_PASSE_SAIDA,  dublicate_dobrado(A_DOBRADO_PASSE_SAIDA));
                    break;
                case passe_saida2:
                    setThis(A_DOBRADO_PASSE_SAIDA2,  dublicate_dobrado(A_DOBRADO_PASSE_SAIDA2));
                    break;
                case geral:
                    setThis(A_DOBRADO_GERAL,  dublicate_dobrado(A_DOBRADO_GERAL));
                    break;
                case geral_inconsciente:
                    setThis(A_DOBRADO_GERAL_INCS,  dublicate_dobrado(A_DOBRADO_GERAL_INCS));
                    break;
                case batida:
                    setThis(A_DOBRADO_BATIDA,  dublicate_dobrado(A_DOBRADO_BATIDA));
                    break;
                case batida_lascada:
                    setThis(A_DOBRADO_BATIDA_DOBRADO_LASCADA,  dublicate_dobrado(A_DOBRADO_BATIDA_DOBRADO_LASCADA));
                    break;
                case batida_camburao:
                    setThis(A_DOBRADO_BATIDA_DOBRADO_CAMBURA0,  dublicate_dobrado(A_DOBRADO_BATIDA_DOBRADO_CAMBURA0));
                    break;
            }
        }else{
            switch (pontosType){
                case passe:
                    setThis(B_DOBRADO_PASSE, dublicate_dobrado(B_DOBRADO_PASSE));
                    break;
                case passe2:
                    setThis(B_DOBRADO_PASSE2,  dublicate_dobrado(B_DOBRADO_PASSE2));
                    break;
                case passe_saida:
                    setThis(B_DOBRADO_PASSE_SAIDA,  dublicate_dobrado(B_DOBRADO_PASSE_SAIDA));
                    break;
                case passe_saida2:
                    setThis(B_DOBRADO_PASSE_SAIDA2,  dublicate_dobrado(B_DOBRADO_PASSE_SAIDA2));
                    break;
                case geral:
                    setThis(B_DOBRADO_GERAL,  dublicate_dobrado(B_DOBRADO_GERAL));
                    break;
                case geral_inconsciente:
                    setThis(B_DOBRADO_GERAL_INCS,  dublicate_dobrado(B_DOBRADO_GERAL_INCS));
                    break;
                case batida:
                    setThis(B_DOBRADO_BATIDA,  dublicate_dobrado(B_DOBRADO_BATIDA));
                    break;
                case batida_lascada:
                    setThis(B_DOBRADO_BATIDB_DOBRADO_LASCADA,  dublicate_dobrado(B_DOBRADO_BATIDB_DOBRADO_LASCADA));
                    break;
                case batida_camburao:
                    setThis(B_DOBRADO_BATIDB_DOBRADO_CAMBURA0,  dublicate_dobrado(B_DOBRADO_BATIDB_DOBRADO_CAMBURA0));
                    break;
            }

        }
    }

    public long getMaximo(int type, Pontos pontosType){
        return getPontos(A, pontosType) + getPontos(B, pontosType);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    Date hora = Calendar.getInstance().getTime();
    String agora = sdf.format(hora);
    String clicked; //long v;
    public void setTelhado(int x, long valorAntigo, long valor) {

        if (valorAntigo != valor) {
           /* if (valorAntigo > valor) v = valorAntigo - valor;
            else v = valor - valorAntigo;*/

            long valor_ = valorAntigo - valor;
            String modif = String.valueOf(valor_);
            if(modif.startsWith("-")){
                modif = modif.replace("-", "");
            }

            String addOutRemove = valorAntigo > valor ? mContext.getString(R.string.removeu) + " " + modif + " " + mContext.getString(R.string.pontos) : mContext.getString(R.string.adicionou) + " " + modif + " " + mContext.getString(R.string.pontos);

            switch (x) {
                case A:
                    clicked = mContext.getString(R.string.modif_placar_tel) + " " + goPlayA() + " " + mContext.getString(R.string.modif_de) + " " + valorAntigo + " " + mContext.getString(R.string.modif_para) + " " + valor + ". " + addOutRemove + mContext.getString(R.string.add) + " " + agora;
                    break;
                case B:
                    clicked = mContext.getString(R.string.modif_placar_tel) + " " + goPlayA() + " " + mContext.getString(R.string.modif_de) + " " + valorAntigo + " " + mContext.getString(R.string.modif_para) + " " + valor + ". " + addOutRemove + mContext.getString(R.string.add) + " " + agora;
                    break;
            }
            set("resumo", addResumo(clicked), mContext);
        }

    }

    public void setTelhado(Pontos y, int x) {
        switch (x){
            case A:
                switch (y) {
                    case passe:
                        clicked = mContext.getString(R.string.passe)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case passe2:
                        clicked = mContext.getString(R.string.passe_de_dois)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case passe_saida:
                        clicked = mContext.getString(R.string.passe_de_saida)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case passe_saida2:
                        clicked = mContext.getString(R.string.passe_de_saida2)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case geral:
                        clicked = mContext.getString(R.string.geral)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case geral_inconsciente:
                        clicked = mContext.getString(R.string.geral_inc)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case batida:
                        clicked = mContext.getString(R.string.batida)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case batida_lascada:
                        clicked = mContext.getString(R.string.batida_lascada)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case batida_camburao:
                        clicked = mContext.getString(R.string.batida_camburo)+ mContext.getString(R.string.por) + " " + goPlayA() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                }
                break;
            case B:
                switch (y) {
                    case passe:
                        clicked = mContext.getString(R.string.passe)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case passe2:
                        clicked = mContext.getString(R.string.passe_de_dois)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case passe_saida:
                        clicked = mContext.getString(R.string.passe_de_saida)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case passe_saida2:
                        clicked = mContext.getString(R.string.passe_de_saida2)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case geral:
                        clicked = mContext.getString(R.string.geral)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case geral_inconsciente:
                        clicked = mContext.getString(R.string.geral_inc)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case batida:
                        clicked = mContext.getString(R.string.batida)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case batida_lascada:
                        clicked = mContext.getString(R.string.batida_lascada)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                    case batida_camburao:
                        clicked = mContext.getString(R.string.batida_camburo)+ mContext.getString(R.string.por) + " " + goPlayB() + mContext.getString(R.string.add)+ " " + agora;
                        break;
                }    break;

        }
        set("resumo", addResumo(clicked), mContext);
    }

    public String goPlayA() {
        return Jogadores.getJogadorA(mContext);
    }

    public String goPlayB() {
        return Jogadores.getJogadorB(mContext);
    }
    private static long dublicate_dobrado(String key) {
        long a = getThis(key, 0);
        return a += 1;
    }


    private static long dublicate_vezes(String key) {
        long a = getThis(key, 0);
        return a += 1;
    }


    private static long dublicate_pontos(String key, long value) {
        long a = getThis(key, 0);
        return a += value;
    }

    private String addResumo(String clicked) {
        String linha = isTetalhadoResumo() == "" ? "" : "\n\n";
        String i = isTetalhadoResumo() + linha ;
        return i += clicked;
    }
    public void remover(long placarA, long placarB){
        remove("resumo", mContext);

        if(placarA == placarB){
            remove(NAME_A, mContext);
            remove(NAME_B, mContext);
        }
        else if(placarA > placarB)
            remove(NAME_B, mContext);
        else
            remove(NAME_A, mContext);

        remove(PLACAR_A, mContext);
        remove(PLACAR_B, mContext);
        remove(A_PONTOS_PASSE, mContext);
        remove(A_PONTOS_PASSE2, mContext);
        remove(A_PONTOS_PASSE_SAIDA, mContext);
        remove(A_PONTOS_PASSE_SAIDA2, mContext);
        remove(A_PONTOS_GERAL, mContext);
        remove(A_PONTOS_GERAL_INCS, mContext);
        remove(A_PONTOS_BATIDA, mContext);
        remove(A_PONTOS_BATIDA_PONTOS_LASCADA, mContext);
        remove(A_PONTOS_BATIDA_PONTOS_CAMBURA0, mContext);
        remove(A_VEZES_PASSE, mContext);
        remove(A_VEZES_PASSE2, mContext);
        remove(A_VEZES_PASSE_SAIDA, mContext);
        remove(A_VEZES_PASSE_SAIDA2, mContext);
        remove(A_VEZES_GERAL, mContext);
        remove(A_VEZES_GERAL_INCS, mContext);
        remove(A_VEZES_BATIDA, mContext);
        remove(A_VEZES_BATIDA_VEZES_LASCADA, mContext);
        remove(A_VEZES_BATIDA_VEZES_CAMBURA0, mContext);
        remove(A_DOBRADO_PASSE, mContext);
        remove(A_DOBRADO_PASSE2, mContext);
        remove(A_DOBRADO_PASSE_SAIDA, mContext);
        remove(A_DOBRADO_PASSE_SAIDA2, mContext);
        remove(A_DOBRADO_GERAL, mContext);
        remove(A_DOBRADO_GERAL_INCS, mContext);
        remove(A_DOBRADO_BATIDA, mContext);
        remove(A_DOBRADO_BATIDA_DOBRADO_LASCADA, mContext);
        remove(A_DOBRADO_BATIDA_DOBRADO_CAMBURA0, mContext);
        remove(B_PONTOS_PASSE, mContext);
        remove(B_PONTOS_PASSE2, mContext);
        remove(B_PONTOS_PASSE_SAIDA, mContext);
        remove(B_PONTOS_PASSE_SAIDA2, mContext);
        remove(B_PONTOS_GERAL, mContext);
        remove(B_PONTOS_GERAL_INCS, mContext);
        remove(B_PONTOS_BATIDA, mContext);
        remove(B_PONTOS_BATIDB_PONTOS_LASCADA, mContext);
        remove(B_PONTOS_BATIDB_PONTOS_CAMBURA0, mContext);
        remove(B_VEZES_PASSE, mContext);
        remove(B_VEZES_PASSE2, mContext);
        remove(B_VEZES_PASSE_SAIDA, mContext);
        remove(B_VEZES_PASSE_SAIDA2, mContext);
        remove(B_VEZES_GERAL, mContext);
        remove(B_VEZES_GERAL_INCS, mContext);
        remove(B_VEZES_BATIDA, mContext);
        remove(B_VEZES_BATIDB_VEZES_LASCADA, mContext);
        remove(B_VEZES_BATIDB_VEZES_CAMBURA0, mContext);
        remove(B_DOBRADO_PASSE, mContext);
        remove(B_DOBRADO_PASSE2, mContext);
        remove(B_DOBRADO_PASSE_SAIDA, mContext);
        remove(B_DOBRADO_PASSE_SAIDA2, mContext);
        remove(B_DOBRADO_GERAL, mContext);
        remove(B_DOBRADO_GERAL_INCS, mContext);
        remove(B_DOBRADO_BATIDA, mContext);
        remove(B_DOBRADO_BATIDB_DOBRADO_LASCADA, mContext);
        remove(B_DOBRADO_BATIDB_DOBRADO_CAMBURA0, mContext);
    }

    private static String getThis(String key, String value){
       return get(key, value, mContext);
    }
    private static boolean getThis(String key, boolean value){
        return get(key, value, mContext);
    }
    private static long getThis(String key, long value){
        return get(key, value, mContext);
    }
    private static void setThis(String key, String value){
        set(key, value, mContext);
    }
    private static void setThis(String key, boolean value){
        set(key, value, mContext);
    }
    private static void setThis(String key, long value){
        set(key, value, mContext);
    }
}
