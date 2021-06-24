package apps.igordutrasanches.pontosdedominofree.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.compomentes.AbasAdapter;
import com.igordutrasanches.pontosdedominofree.compomentes.ResourceLoader;
import com.igordutrasanches.pontosdedominofree.fragment.Diagnostico_fragment;
import com.igordutrasanches.pontosdedominofree.fragment.Resumo_fragment;

import apps.igordutrasanches.pontosdedominofree.compomentes.AbasAdapter;
import apps.igordutrasanches.pontosdedominofree.compomentes.ResourceLoader;
import apps.igordutrasanches.pontosdedominofree.fragment.Diagnostico_fragment;
import apps.igordutrasanches.pontosdedominofree.fragment.Resumo_fragment;

public class DiagnosticoActivity extends AppCompatActivity {

    private ResourceLoader loader = new ResourceLoader();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostico);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        try{
            AbasAdapter adapter = new AbasAdapter(getSupportFragmentManager());
            adapter.adicionar(new Diagnostico_fragment(this), loader.get(this, R.string.diagno_menu));
            adapter.adicionar(new Resumo_fragment(), loader.get(this, R.string.resumo));

            ViewPager viewPager = (ViewPager)findViewById(R.id.pagina_tabs);
            viewPager.setAdapter(adapter);

            TabLayout tab = (TabLayout)findViewById(R.id.tabs);
            tab.setupWithViewPager(viewPager);
        }catch(Exception x){
            new AlertDialog.Builder(this).setMessage(x.getMessage()).show();
        }

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}

