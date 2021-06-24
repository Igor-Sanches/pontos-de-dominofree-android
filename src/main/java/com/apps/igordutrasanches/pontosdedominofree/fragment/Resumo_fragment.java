package com.apps.igordutrasanches.pontosdedominofree.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.compomentes.Diagnostico;
import com.igordutrasanches.pontosdedominofree.compomentes.Vencedores;

public class Resumo_fragment extends Fragment {

    TextView tetalhado, resumido;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resumo, container, false);

        try{
            tetalhado = (TextView)view.findViewById(R.id.descricaotetalhada);
            resumido = (TextView)view.findViewById(R.id.descricaoresumida);
            Animation animado = AnimationUtils.loadAnimation(view.getContext(), R.anim.frombottom);
            tetalhado.setAnimation(animado);
            resumido.setAnimation(animado);

            tetalhado.setText(tetalhar());
            resumido.setText(resumir());

        } catch (Exception x) {
            new AlertDialog.Builder(view.getContext()).setMessage(x.getMessage()).show();
        }
        return view;
    }

    boolean empate; String r;
    private CharSequence resumir() {
        if(goPlacarA() == goPlacarB())
            empate = true;
        else empate = false;

        if(empate)
            r = view.getContext().getString(R.string.narrar_empate);
        else{
            r = Vencedores.context(view.getContext()).vencedor(goPlacarA(), goPlacarB()) + " " + view.getContext().getString(R.string.aproveitamento) +
                    " " + goProgress() + view.getContext().getString(R.string.comvandage) + " " + goVantegem() + " " + view.getContext().getString(R.string.dife) + " " + Vencedores.context(view.getContext()).perdedor(goPlacarA(), goPlacarB());
        }
        return r;
    }

    private String goVantegem() {
        long v = Long.valueOf(Vencedores.context(view.getContext()).placarVencedor(goPlacarA(), goPlacarB())) - Long.valueOf(Vencedores.context(view.getContext()).placarPerdedor(goPlacarA(), goPlacarB()));
        return String.valueOf(v);
    }

    private long goPlacarA() {
        return Diagnostico.setContext(view.getContext()).getPlacares(Diagnostico.A);
    }

    private long goPlacarB() {
        return Diagnostico.setContext(view.getContext()).getPlacares(Diagnostico.B);
    }

    private CharSequence tetalhar() {
        return resumirEmTetalhes();
    }

    public String resumirEmTetalhes(){
        return Diagnostico.setContext(view.getContext()).isTetalhadoResumo();
    }

    public String goProgress(){
        double max = (double)goPlacarA() + (double)goPlacarB();
        double maior = goPlacarA() > goPlacarB() ? goPlacarA() : goPlacarB();
        int valor = (int)(100 * maior / max);
        return valor + "%";
    }

}