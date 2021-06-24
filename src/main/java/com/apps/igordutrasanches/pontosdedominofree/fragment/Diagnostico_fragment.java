package apps.igordutrasanches.pontosdedominofree.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.compomentes.Jogadores;

@SuppressLint("ValidFragment")
public class Diagnostico_fragment extends Fragment {

    private Context mContext;

    public Diagnostico_fragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diagnostico, container, false);
        try{
            AdaptarFragments adapter = new AdaptarFragments(getActivity().getSupportFragmentManager());
            adapter.adicionar(new JogadoresAFragment(mContext), Jogadores.getJogadorA(mContext));
            adapter.adicionar(new JogadoresBFragment(mContext), Jogadores.getJogadorB(mContext));

            ViewPager viewPager = (ViewPager)view.findViewById(R.id.view2);
            viewPager.setAdapter(adapter);

            TabLayout tab = (TabLayout)view.findViewById(R.id.tabs2);
            tab.setupWithViewPager(viewPager);
        }catch(Exception x){
            new AlertDialog.Builder(mContext).setMessage(x.getMessage()).show();
        }
        return view;
    }

}