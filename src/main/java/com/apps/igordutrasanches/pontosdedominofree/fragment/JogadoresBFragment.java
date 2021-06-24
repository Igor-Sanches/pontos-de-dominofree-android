package com.apps.igordutrasanches.pontosdedominofree.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.igordutrasanches.pontosdedominofree.R;
import com.igordutrasanches.pontosdedominofree.compomentes.Diagnostico;
import com.igordutrasanches.pontosdedominofree.pontuador.Pontos;

@SuppressLint("ValidFragment")
public class JogadoresBFragment extends Fragment {

      private LinearLayout
            passeLayout,
            passe_saidaLayout,
            passe_saida_2Layout,
            passe_2Layout,
            geralLayout,
            geral_incLayout,
            batidaLayout,
            batida_lascadaLayout,
            semLayout,
            batida_camburaoLayout;
    private ProgressBar Bar_passe, Bar_passe_saida, Bar_passe_saida_2, Bar_passe_2, Bar_geral, Bar_geral_inc, Bar_batida, Bar_batida_lascada, Bar_batida_camburao;
    private TextView passe, passe_saida, passe_saida_2, passe_2, geral, geral_inc, batida, batida_lascada, batida_camburao;
    private TextView passe2, passe_saida2, passe_saida_22, passe_22, geral2, geral_inc2, batida2, batida_lascada2, batida_camburao2;
    private Context mContext;

    @SuppressLint("ValidFragment")
    public JogadoresBFragment(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jogadores_b, container, false);
        try {
            passe_saida_2Layout = (LinearLayout) view.findViewById(R.id.passe2_saidaLayout1B);
            passeLayout = (LinearLayout) view.findViewById(R.id.passeLayout1B);
            passe_saidaLayout = (LinearLayout) view.findViewById(R.id.passe_saidaLayout1B);
            passe_2Layout = (LinearLayout) view.findViewById(R.id.passe2Layout1B);
            geralLayout = (LinearLayout) view.findViewById(R.id.geralLayout1B);
            geral_incLayout = (LinearLayout) view.findViewById(R.id.geral_incLayout1B);
            batidaLayout = (LinearLayout) view.findViewById(R.id.batidaLayout1B);
            batida_lascadaLayout = (LinearLayout) view.findViewById(R.id.batida_lascLayout1B);
            batida_camburaoLayout = (LinearLayout) view.findViewById(R.id.batida_cambLayout1B);
            semLayout = (LinearLayout) view.findViewById(R.id.semLayout1B);
            passe = (TextView) view.findViewById(R.id.txt_paaseB);
            passe_saida = (TextView) view.findViewById(R.id.txt_passe_de_saidaB);
            passe_saida_2 = (TextView) view.findViewById(R.id.txt_passe_de_saida2B);
            passe_2 = (TextView) view.findViewById(R.id.txt_paase2B);
            geral = (TextView) view.findViewById(R.id.txt_geralB);
            geral_inc = (TextView) view.findViewById(R.id.txt_geral_incB);
            batida = (TextView) view.findViewById(R.id.txt_batidaB);
            batida_lascada = (TextView) view.findViewById(R.id.txt_batida_lascadaB);
            batida_camburao = (TextView) view.findViewById(R.id.txt_batida_camburoB);
            passe2 = (TextView) view.findViewById(R.id.txt_paaseB2);
            passe_saida2 = (TextView) view.findViewById(R.id.txt_passe_de_saidaB2);
            passe_saida_22 = (TextView) view.findViewById(R.id.txt_passe_de_saidaB22);
            passe_22 = (TextView) view.findViewById(R.id.txt_paase2B2);
            geral2 = (TextView) view.findViewById(R.id.txt_geralB2);
            geral_inc2 = (TextView) view.findViewById(R.id.txt_geral_incB2);
            batida2 = (TextView) view.findViewById(R.id.txt_batidaB2);
            batida_lascada2 = (TextView) view.findViewById(R.id.txt_batida_lascadaB2);
            batida_camburao2 = (TextView) view.findViewById(R.id.txt_batida_camburoB2);
            Bar_passe = (ProgressBar) view.findViewById(R.id.progressBar_paaseB);
            Bar_passe_saida = (ProgressBar) view.findViewById(R.id.progressBar_passe_de_saidaB);
            Bar_passe_saida_2 = (ProgressBar) view.findViewById(R.id.progressBar_passe_de_saida2B);
            Bar_passe_2 = (ProgressBar) view.findViewById(R.id.progressBar_paase2B);
            Bar_geral = (ProgressBar) view.findViewById(R.id.progressBar_geralB);
            Bar_geral_inc = (ProgressBar) view.findViewById(R.id.progressBar_geral_incB);
            Bar_batida = (ProgressBar) view.findViewById(R.id.progressBar_batidaB);
            Bar_batida_lascada = (ProgressBar) view.findViewById(R.id.progressBar_batida_lascadaB);
            Bar_batida_camburao = (ProgressBar) view.findViewById(R.id.progressBar_batida_camburoB);
            passe.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe)));
            passe_saida.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe2)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe2)));
            passe_saida_2.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe_saida)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe_saida)));
            passe_2.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe_saida2)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe_saida2)));
            geral.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.geral)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.geral)));
            geral_inc.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.geral_inconsciente)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.geral_inconsciente)));
            batida.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.batida)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.batida)));
            batida_lascada.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.batida_lascada)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.batida_lascada)));
            batida_camburao.setText(goVezes(Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.batida_camburao)) + goDobrados(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.batida_camburao)));
            passe2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe)));
            passe_saida2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe2)));
            passe_saida_22.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe_saida)));
            passe_22.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe_saida2)));
            geral2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.geral)));
            geral_inc2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.geral_inconsciente)));
            batida2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida)));
            batida_lascada2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida_lascada)));
            batida_camburao2.setText(goPontos(Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida_camburao)));
            Bar_passe.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe));
            Bar_passe_saida.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe2));
            Bar_passe_saida_2.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe_saida));
            Bar_passe_2.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe_saida2));
            Bar_geral.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.geral));
            Bar_geral_inc.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.geral_inconsciente));
            Bar_batida.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida));
            Bar_batida_lascada.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida_lascada));
            Bar_batida_camburao.setProgress((int) Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida_camburao));

            passeLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe)));
            passe_saidaLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe2), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe2), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe2)));
            passe_saida_2Layout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe_saida), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe_saida), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe_saida)));
            passe_2Layout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.passe_saida2), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.passe_saida2), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.passe_saida2)));
            geralLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.geral), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.geral), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.geral)));
            geral_incLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.geral_inconsciente), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.geral_inconsciente), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.geral_inconsciente)));
            batidaLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.batida), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.batida)));
            batida_lascadaLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.batida_lascada), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida_lascada), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.batida_lascada)));
            batida_camburaoLayout.setVisibility(getVisible(Diagnostico.setContext(mContext).getDobrado(Diagnostico.B, Pontos.batida_camburao), Diagnostico.setContext(mContext).getPontos(Diagnostico.B, Pontos.batida_camburao), Diagnostico.setContext(mContext).getVezes(Diagnostico.B, Pontos.batida_camburao)));
            semLayout.setVisibility(goVisible(passeLayout.getVisibility(), passe_saidaLayout.getVisibility(), passe_saida_2Layout.getVisibility(), passe_2Layout.getVisibility(), geralLayout.getVisibility(), geral_incLayout.getVisibility(), batidaLayout.getVisibility(), batida_lascadaLayout.getVisibility(), batida_camburaoLayout.getVisibility()));

        } catch (Exception x) {
            new AlertDialog.Builder(mContext).setMessage(x.getMessage()).show();
        }
        return view;
    }

    private int goVisible(int visibility, int visibility1, int visibility2, int visibility3, int visibility4, int visibility5, int visibility6, int visibility7, int visibility8) {
        if (visibility == View.GONE &&
                visibility1 == View.GONE &&
                visibility2 == View.GONE &&
                visibility3 == View.GONE &&
                visibility4 == View.GONE &&
                visibility5 == View.GONE &&
                visibility6 == View.GONE &&
                visibility7 == View.GONE &&
                visibility8 == View.GONE) return View.VISIBLE;
        else return View.GONE;
    }


    private int getVisible(long i, long i1, long i2) {
        if (i != 0 || i1 != 0 || i2 != 0) return View.VISIBLE;
        else return View.GONE;
    }

    private String txt;

    private String goPontos(long progress) {
        if (progress == 0)
            txt = getString(R.string.not_register);
        else if (progress == 1)
            txt = progress + " " + getString(R.string.ponto);
        else
            txt = progress + " " + getString(R.string.pontos);

        return txt;
    }

    private String x;

    private String goVezes(long progress) {
        if (progress == 0)
            x = getString(R.string.not_register);
        else if (progress == 1)
            x = progress + " " + getString(R.string.vez);
        else
            x = progress + " " + getString(R.string.vezes);

        return x;
    }

    private String y;

    private String goDobrados(long progress) {
        if (progress == 0)
            y = "";
        else
            y = ", " + progress + " " + getString(R.string.frag_dobrado);

        return y;

    }
}
