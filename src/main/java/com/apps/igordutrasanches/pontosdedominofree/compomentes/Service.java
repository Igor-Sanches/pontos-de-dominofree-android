package com.apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by igord on 20/03/2019.
 */

public class Service {

    public static String PREFERENCE_NAME = "Igor_Sanches";

    private static final String PREFERENCE_FILE_NAME = "Picadas_db";
    private static SharedPreferences mSharedPreferences;

    private static SharedPreferences getmSharedPreferencesEditor(Context context){
        if(mSharedPreferences ==null){
            mSharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);

        }
        return mSharedPreferences;
    }

    public static void set(String key, int value, Context context){
        SharedPreferences.Editor editor = getmSharedPreferencesEditor(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int get(String key, int Default, Context context){
        return getmSharedPreferencesEditor(context).getInt(key, Default);
    }

    public static void set(String key, boolean value, Context context){
        SharedPreferences.Editor editor = getmSharedPreferencesEditor(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean get(String key, boolean Default, Context context){
        return getmSharedPreferencesEditor(context).getBoolean(key, Default);
    }


    public static void remove(String key, Context context){
        getmSharedPreferencesEditor(context).edit().remove(key).commit();
    }

    public static void set(String key, String value, Context context){
        SharedPreferences.Editor editor = getmSharedPreferencesEditor(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void set(String key, long value, Context context){
        SharedPreferences.Editor editor = getmSharedPreferencesEditor(context).edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long get(String key, long Default, Context context){
        return getmSharedPreferencesEditor(context).getLong(key, Default);
    }

    public static String get(String key, String Default, Context context){
        return getmSharedPreferencesEditor(context).getString(key, Default);
    }

    public static boolean isGeralIncFinaliza(Context context){
        return get("key_geral_inc", false, context);
    }
    public static String getThemes(Context context){
        return get("key_temas", "1", context);
    }
    public static boolean isBtn_name_inicial(Context context){
        return get("key_name_playss", true, context);
    }
    public static boolean isNarraFinalizar(Context context){
        return get("key_finallizar_narrar", false, context);
    }
    public static boolean isNarradorAtivado(Context context){
        return get("key_ativar_narador", false, context);
    }
    public static boolean isDedurar(Context context){
        return get("key_dedura_narador", false, context);
    }
    public static boolean isNarraClicks(Context context){
        return get("key_clicks_narador", false, context);
    }
    public static String isMaximoPontos(Context context){
        return get("key_maximo_pontos", "20", context);
    }
    public static String isMaximoVibration(Context context){
        return get("key_tempo_vibracao", "2000", context);
    }
    public static boolean isVibrar(Context context){
        return get("key_vibrar", true, context);
    }

    public static int getDoarView(Context context){
        return get("doarView", 0, context);
    }
    public static void setDoarView(Context context, int i){
        set("doarView", i, context);
    }

    public static int getRateView(Context context){
        return get("rateView", 0, context);
    }
    public static void setRateView(Context context, int i){
        set("rateView", i, context);
    }
}
