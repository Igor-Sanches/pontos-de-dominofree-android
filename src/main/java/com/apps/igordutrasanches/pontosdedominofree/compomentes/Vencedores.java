package com.apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;

import com.igordutrasanches.pontosdedominofree.R;


/**
 * Created by igord on 01/05/2019.
 */

public class Vencedores extends Jogadores {

    private ResourceLoader loader = new ResourceLoader();
    private Context mContext;
    public Vencedores(Context context){
        mContext = context;
    }

    public static Vencedores context(Context context){
        return new Vencedores(context);
    }

    public String vencedor(long a, long b){
        String result = "";
        if(a == b) result = getJogadorA(mContext) + " " + loader.get(mContext, R.string.e) + " " + getJogadorB(mContext) + " " + loader.get(mContext, R.string.empate);
        else{
            result = a > b ? getJogadorA(mContext) + " " + loader.get(mContext, R.string.vencedor) : getJogadorB(mContext) + " " + loader.get(mContext, R.string.vencedor);
        }

        return result;
    }

    public String perdedor(long a, long b){
        String result = "";
        if(a == b) result = getJogadorA(mContext) + " " + loader.get(mContext, R.string.e) + " " + getJogadorB(mContext) + " " + loader.get(mContext, R.string.empate);
        else{
            result = a < b ? getJogadorA(mContext) + " " + loader.get(mContext, R.string.perdedor) : getJogadorB(mContext) + " " + loader.get(mContext, R.string.perdedor) ;
        }

        return result;
    }

    public String placarVencedor(long a, long b){
        String result = "";
        if(a == b) result = a + " " + loader.get(mContext, R.string.a) + " " + b;
        else{
            result = a > b ? String.valueOf(a) : String.valueOf(b);
        }
        return result;
    }

    public String placarPerdedor(long a, long b){
        String result = "";
        if(a == b) result = a + " " + loader.get(mContext, R.string.a) + " " + b;
        else{
            result = a < b ? String.valueOf(a) : String.valueOf(b);
        }
        return result;
    }

}
