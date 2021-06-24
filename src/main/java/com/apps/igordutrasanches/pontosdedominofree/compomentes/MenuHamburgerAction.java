package apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentManager;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.activity.DiagnosticoActivity;
import com.igordutrasanches.pontosdedominofree.activity.MainActivity;
import com.igordutrasanches.pontosdedominofree.activity.ManualActivity;
import com.igordutrasanches.pontosdedominofree.activity.SettingsActivity;
import com.igordutrasanches.pontosdedominofree.dialog.AboutDialog;

import apps.igordutrasanches.pontosdedominofree.dialog.AboutDialog;


public class MenuHamburgerAction {

    private Context mContext;
    public MenuHamburgerAction(Context mContext) { this.mContext = mContext; }

    public static MenuHamburgerAction go(Context mContext){
        return new MenuHamburgerAction(mContext);
    }

    public void diagnostico(){ mContext.startActivity(new Intent(mContext, DiagnosticoActivity.class)); }

    public void nomes(FragmentManager supportFragmentManager){
        MainActivity.DialogNameFragment name = new MainActivity.DialogNameFragment();
        name.show(supportFragmentManager, "incluir_fragment");
    }

    public void compartilharApp() {
         Action.findBy(mContext).goShare("https://play.google.com/store/apps/details?id=" + getPackage(), loader.get(mContext, R.string.app_name));
    }

    private String getPackage(){
        ApplicationInfo p = mContext.getApplicationInfo();
        return p.packageName;
    }

    public void comfiguracoes() { mContext.startActivity(new Intent(mContext, SettingsActivity.class)); }

    public void manual() { mContext.startActivity(new Intent(mContext, ManualActivity.class)); }

    public void sobre() {
        AboutDialog aboutDialog = new AboutDialog(mContext);
        aboutDialog.setCancelable(true);
        aboutDialog.show();
    }

    public void support() {
      Intent intent = new Intent(Intent.ACTION_SENDTO);
      intent.setData(Uri.parse("mailto:igordeveloper890@gmail.com"));
      intent.putExtra(Intent.EXTRA_EMAIL, "igordeveloper890@gmail.com");
      intent.putExtra(Intent.EXTRA_SUBJECT, assunto());
      if(intent.resolveActivity(mContext.getPackageManager()) != null){
          mContext.startActivity(intent);
      }
    }

    public void rate(){
        launcher(getPackage());
    }

    public void pro(){
        launcher(getPackage().replace("free", ""));
    }

    private void launcher(String launcher){
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
        intent.setData(Uri.parse("market://details?id=" + launcher));
        mContext.startActivity(intent);
    }

    private ResourceLoader loader = new ResourceLoader();
    private String assunto(){
        String string = "";
        try {
            string = mContext.getPackageManager().getPackageInfo((String) mContext.getPackageName(), (int) 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } return loader.get(mContext, R.string.app_name) + ": free " + loader.get(mContext, R.string.version) + " " + string;
    }
}
