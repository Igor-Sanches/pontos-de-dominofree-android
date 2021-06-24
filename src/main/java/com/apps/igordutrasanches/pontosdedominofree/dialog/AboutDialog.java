package com.apps.igordutrasanches.pontosdedominofree.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.igordutrasanches.pontosdedominofree.compomentes.Action;
import com.igordutrasanches.pontosdedominofree.R;

public class AboutDialog
        extends Dialog {
    private String _txt;
    private Context mContext;

    public AboutDialog(Context context) {
        super(context);
        mContext = context;
    }

    private LinearLayout linearLayout;
    String string;

    public void onCreate(Bundle bundle) {
        this.setContentView(R.layout.about_dialog);

        ((Button)findViewById(R.id.btn_facebook)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Action.findBy(mContext).goFacebook();
            }
        });
        ((Button)findViewById(R.id.btn_fecharPainel)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                dismiss();
            }
        });
        try {
            string = mContext.getPackageManager().getPackageInfo((String) mContext.getPackageName(), (int) 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        TextView textView = (TextView)findViewById(R.id.versionInfo);
        textView.setText(mContext.getString(R.string.version) + " " + string);
        Linkify.addLinks((TextView)textView, (int)2);

}

}