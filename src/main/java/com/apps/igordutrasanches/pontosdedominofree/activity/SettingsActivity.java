package com.apps.igordutrasanches.pontosdedominofree.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.compomentes.Service;

import com.apps.igordutrasanches.pontosdedominofree.compomentes.Service;

public class SettingsActivity
extends PreferenceActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {
    private AppCompatDelegate mDelegate;

    private AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }
    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    protected void onCreate(Bundle bundle) {
        //SettingsActivity.super.onResume();
        super.onCreate(bundle);
        try {
            this.addPreferencesFromResource(R.xml.preferences);
            setupActionBar();

        }catch (Exception x){
            Toast.makeText(this, x.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    protected void onPause() {
        super.onPause();
        this.getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
            //startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onResume() {
        super.onResume();
        this.getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        if (string.equals("key_geral_inc")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, false), this);
         }
        if (string.equals("key_finallizar_narrar")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, false), this);
        }
        if (string.equals("key_ativar_narador")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, false), this);
        }
        if (string.equals("key_dedura_narador")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, false), this);
        }
        if (string.equals("key_clicks_narador")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, false), this);
        }
        if (string.equals("key_maximo_pontos")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getString(string, "20"), this);
        }
        if (string.equals("key_vibrar")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, true), this);
        }
        if (string.equals("key_tempo_vibracao")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getString(string, "2000"), this);
        }
        if (string.equals("key_name_playss")) {
            Service.set(string, PreferenceManager.getDefaultSharedPreferences((Context)this).getBoolean(string, true), this);
        }
    }
}