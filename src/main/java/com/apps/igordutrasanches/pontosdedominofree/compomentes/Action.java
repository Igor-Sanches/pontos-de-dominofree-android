package com.apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/**
 * Created by igord on 21/03/2019.
 */

public class Action {
    private Context mContext = null;
    private View mView = null;

    private ResourceLoader loader = new ResourceLoader();
    public Action(View view, Context context){
        mView = view;
        mContext = context;
    }

    public void setSupport(){
        //String mineBook = loader.get(mContext, R.string.app_name) + "\n" + loader.get(mContext, R.string.systema);
    }

    public Action(Context context){
        mContext = context;
    }

    public static Action findBy(View view, Context context){
        return new Action(view, context);
    }

    public static Action findBy(Context context){
        return new Action(context);
    }

    public void goWhatsApp(){
        mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)"https://api.whatsapp.com/send?phone=5598985356501")));
    }


    public void goFacebook(){
        mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)"http://www.facebook.com/igor.dutra.3557")));
    }

    public void goShare(String historia, String titulo){
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "");
        intent.putExtra("android.intent.extra.TEXT", historia);
        mContext.startActivity(Intent.createChooser((Intent)intent, titulo));
    }
}
