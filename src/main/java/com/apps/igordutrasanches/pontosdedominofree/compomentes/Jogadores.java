package apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;

import com.igordutrasanches.pontosdedominofree.R;


/**
 * Created by igord on 01/05/2019.
 */

public class Jogadores extends Service {

    private static ResourceLoader loader = new ResourceLoader();
    public static String getJogadorA(Context context){
        return get("PLAYA", loader.get(context, R.string.jogador_a), context);
    }
    public static String getJogadorB(Context context){
        return get("PLAYB", loader.get(context, R.string.jogador_b), context);
    }

    public static void setJogadorA(String name, Context context){
        set("PLAYA", name, context);
    }

    public static void setJogadorB(String name, Context context){
        set("PLAYB", name, context);
    }
}


