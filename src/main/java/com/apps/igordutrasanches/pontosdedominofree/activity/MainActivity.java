package apps.igordutrasanches.pontosdedominofree.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.igordutrasanches.pontosdedominofree.R;
import apps.igordutrasanches.pontosdedominofree.compomentes.Action;
import apps.igordutrasanches.pontosdedominofree.compomentes.Diagnostico;
import apps.igordutrasanches.pontosdedominofree.compomentes.Jogadores;
import apps.igordutrasanches.pontosdedominofree.compomentes.MenuHamburgerAction;
import apps.igordutrasanches.pontosdedominofree.compomentes.ResourceLoader;
import apps.igordutrasanches.pontosdedominofree.compomentes.Service;
import apps.igordutrasanches.pontosdedominofree.compomentes.Speek;
import apps.igordutrasanches.pontosdedominofree.compomentes.Vencedores;
import apps.igordutrasanches.pontosdedominofree.pontuador.Pontos;
import apps.igordutrasanches.pontosdedominofree.pontuador.Pontuador;

import java.util.Locale;

public class MainActivity extends AppCompatActivity //984870241
        implements NavigationView.OnNavigationItemSelectedListener {

    private Animation bottom, right;
    private static AppCompatTextView edit_paly_a, edit_paly_b;
    private CheckBox check_20pontos, check_partida_dobrada;
    private ViewSwitcher layout_editorA, layout_editorB, Layout_placarA, Layout_placarB;
    private Button Apasse, Apasse2, Apasse_saida, Apasse_saida2, Ageral, Ageral_inconsciente, Abatida, Abatida_lascada, Abatida_camburao;
    private Button Bpasse, Bpasse2, Bpasse_saida, Bpasse_saida2, Bgeral, Bgeral_inconsciente, Bbatida, Bbatida_lascada, Bbatida_camburao, zerar;
    private FloatingActionButton editor_A, editor_B, salva_A, salva_B;
    private EditText editor_placar_A, editor_placar_B;
    private TextView pontosA, pontosB, emojiA, emojiB;
    private long placarA = 0, placarB = 0;
    private ProgressBar bar1, bar2;
    private ResourceLoader loader = new ResourceLoader();

    private Context mContext;
    private MenuItem diagnostico_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            locutorLoader();
            mContext = this;
            //TextView
            pontosA = (TextView) findViewById(R.id.pontosA);
            pontosB = (TextView) findViewById(R.id.pontosB);
            emojiA = (TextView) findViewById(R.id.emojiA);
            emojiB = (TextView) findViewById(R.id.emojiB);

            bar1 = (ProgressBar) findViewById(R.id.progressBarTimeA);
            bar2 = (ProgressBar) findViewById(R.id.progressBarTimeB);
            //ViewSwitchers
            Layout_placarA = (ViewSwitcher) findViewById(R.id.Layout_placarA);
            Layout_placarB = (ViewSwitcher) findViewById(R.id.Layout_placarB);
            layout_editorA = (ViewSwitcher) findViewById(R.id.Layout_editA);
            layout_editorB = (ViewSwitcher) findViewById(R.id.Layout_editB);
            //FloatingActionButtons
            editor_A = (FloatingActionButton) findViewById(R.id.floating_editA);
            editor_B = (FloatingActionButton) findViewById(R.id.floating_editB);
            salva_A = (FloatingActionButton) findViewById(R.id.floating_saveA);
            salva_B = (FloatingActionButton) findViewById(R.id.floating_saveB);
            editor_A.setOnClickListener(click_editor);
            editor_B.setOnClickListener(click_editor);
            salva_A.setOnClickListener(click_editor);
            salva_B.setOnClickListener(click_editor);
            right = AnimationUtils.loadAnimation(this, R.anim.frombottom);
            bottom = AnimationUtils.loadAnimation(this, R.anim.fromtop);
            editor_A.setAnimation(bottom);
            editor_B.setAnimation(bottom);
            salva_A.setAnimation(bottom);
            salva_B.setAnimation(bottom);
            Layout_placarA.setAnimation(right);
            Layout_placarB.setAnimation(right);
            //EditText
            editor_placar_A = (EditText) findViewById(R.id.edit_pontosA);
            editor_placar_B = (EditText) findViewById(R.id.edit_pontosB);
            //CheckBoxs
            check_20pontos = (CheckBox) findViewById(R.id.check_20pontos);
            check_partida_dobrada = (CheckBox) findViewById(R.id.check_dobrado);
            //Buttons
            Apasse = (Button) findViewById(R.id.Abtn_passe);
            Apasse2 = (Button) findViewById(R.id.Abtn_passe2);
            Apasse_saida = (Button) findViewById(R.id.Abtn_passesaida);
            Apasse_saida2 = (Button) findViewById(R.id.Abtn_passe2saida);
            Ageral = (Button) findViewById(R.id.Abtn_geral);
            Ageral_inconsciente = (Button) findViewById(R.id.Abtn_geralinsco);
            Abatida = (Button) findViewById(R.id.Abtn_batida);
            Abatida_lascada = (Button) findViewById(R.id.Abtn_batidalascada);
            Abatida_camburao = (Button) findViewById(R.id.Abtn_batidacamburao);
            Bpasse = (Button) findViewById(R.id.Bbtn_passe);
            Bpasse2 = (Button) findViewById(R.id.Bbtn_passe2);
            Bpasse_saida = (Button) findViewById(R.id.Bbtn_passesaida);
            Bpasse_saida2 = (Button) findViewById(R.id.Bbtn_passe2saida);
            Bgeral = (Button) findViewById(R.id.Bbtn_geral);
            Bgeral_inconsciente = (Button) findViewById(R.id.Bbtn_geralinsco);
            Bbatida = (Button) findViewById(R.id.Bbtn_batida);
            Bbatida_lascada = (Button) findViewById(R.id.Bbtn_batidalascada);
            Bbatida_camburao = (Button) findViewById(R.id.Bbtn_batidacamburao);
            zerar = (Button) findViewById(R.id.btn_novapartida);
            zerar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    zerarTudo();
                }

            });
            //Buttons clicks
            Apasse.setOnClickListener(click);
            Apasse2.setOnClickListener(click);
            Apasse_saida.setOnClickListener(click);
            Apasse_saida2.setOnClickListener(click);
            Ageral.setOnClickListener(click);
            Ageral_inconsciente.setOnClickListener(click);
            Abatida.setOnClickListener(click);
            Abatida_lascada.setOnClickListener(click);
            Abatida_camburao.setOnClickListener(click);
            Bpasse.setOnClickListener(click);
            Bpasse2.setOnClickListener(click);
            Bpasse_saida.setOnClickListener(click);
            Bpasse_saida2.setOnClickListener(click);
            Bgeral.setOnClickListener(click);
            Bgeral_inconsciente.setOnClickListener(click);
            Bbatida.setOnClickListener(click);
            Bbatida_lascada.setOnClickListener(click);
            Bbatida_camburao.setOnClickListener(click);

            check_partida_dobrada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    narrarClicks(Speek.dobrada);
                }
            });

            check_20pontos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    narrarClicks(Speek.max_pontos);
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            Menu menu = navigationView.getMenu();
            diagnostico_btn = menu.findItem(R.id.nav_diagnostico);

            edit_paly_a = (AppCompatTextView) findViewById(R.id.name_palys_a);
            edit_paly_b = (AppCompatTextView) findViewById(R.id.name_palys_b);
            edit_paly_a.setOnClickListener(editNamsClick);
            edit_paly_b.setOnClickListener(editNamsClick);
            iniciar();
        } catch (Exception c) {
            messageBox(c.getMessage());
        }
    }

    private View.OnClickListener editNamsClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MenuHamburgerAction.go(MainActivity.this).nomes(getSupportFragmentManager());
        }
    };

    private void zerarTudo() {
        if (check_partida_dobrada.isChecked()) check_partida_dobrada.setChecked(false);
        check_20pontos.setEnabled(true);
        Diagnostico.setContext(this).remover(placarA, placarB);
        pontosTimeA(0, true);
        pontosTimeB(0, true);
        view();
        narrarClicks(Speek.zera);
        bar1.setIndeterminate(true);
        bar2.setIndeterminate(true);
        edit_paly_a.setText(Diagnostico.setContext(this).getNames(Diagnostico.A));
        edit_paly_b.setText(Diagnostico.setContext(this).getNames(Diagnostico.B));
    }

    private void iniciar() {
        try {
            edit_paly_a.setVisibility(Service.isBtn_name_inicial(this) ? View.VISIBLE : View.GONE);
            edit_paly_b.setVisibility(Service.isBtn_name_inicial(this) ? View.VISIBLE : View.GONE);
            pontosTimeA(Diagnostico.setContext(this).getPlacares(Diagnostico.A), true);
            pontosTimeB(Diagnostico.setContext(this).getPlacares(Diagnostico.B), true);
            Jogadores.setJogadorA(Diagnostico.setContext(this).getNames(Diagnostico.A), this);
            Jogadores.setJogadorB(Diagnostico.setContext(this).getNames(Diagnostico.B), this);
            edit_paly_a.setText(Diagnostico.setContext(this).getNames(Diagnostico.A));
            edit_paly_b.setText(Diagnostico.setContext(this).getNames(Diagnostico.B));
            if (placarA != 0 || placarB != 0)
                zerar.setEnabled(true);
            else zerar.setEnabled(false);

            if (placarA >= 20 || placarB >= 20) check_20pontos.setEnabled(false);
            else check_20pontos.setEnabled(true);
            check_20pontos.setText(loader.get(this, R.string.isvinte) + " " + Service.isMaximoPontos(this) + " " + loader.get(this, R.string.pontos));

            view();
        } catch (Exception c) {
            messageBox(c.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private MenuItem narrador;
    private boolean isNarraicon = false;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        narrador = menu.findItem(R.id.action_narrar);
        isNarraicon = true;
        narrarOnOff();

        return true;
    }

    private void narrarOnOff() {
        if (isNarraicon)
            if (Service.isNarradorAtivado(this)) narrador.setVisible(true);
            else narrador.setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_narrar) {
            narrador(Speek.narrador);
        }
        if (id == R.id.action_share) {
            String book = Jogadores.getJogadorA(this) + ": " + placarA + " " + r(R.string.pontos) + "\n" + Jogadores.getJogadorB(this) + ": " + placarB + " " + r(R.string.pontos);
            Action.findBy(this).goShare(book, r(R.string.app_name));
        }
        return super.onOptionsItemSelected(item);
    }


    private String carinhaA, carinhaB;

    private void carasEmoji() {

        if (placarA == placarB) {
            carinhaA = "\uD83D\uDE42";
            carinhaB = "\uD83D\uDE42";
        }
        if (check_20pontos.isChecked()) {
            if (placarA > placarB) {
                if (placarA > placarB + 16) {
                    carinhaA = "\uD83D\uDE0D";
                    carinhaB = "\uD83D\uDE24";
                } else if (placarA > placarB + 14) {
                    carinhaA = "\uD83D\uDE0D";
                    carinhaB = "\uD83D\uDE31";
                } else if (placarA > placarB + 12) {
                    carinhaA = "\uD83D\uDE01";
                    carinhaB = "\uD83D\uDE1E";
                } else if (placarA > placarB + 8) {
                    carinhaA = "\uD83D\uDE04";
                    carinhaB = "\uD83D\uDE2D";
                } else if (placarA > placarB + 6) {
                    carinhaA = "\uD83D\uDE0C";
                    carinhaB = "\uD83D\uDE29";
                } else if (placarA > placarB + 3) {
                    carinhaA = "\uD83D\uDE09";
                    carinhaB = "\uD83D\uDE16";
                } else {
                    carinhaA = "\uD83D\uDE42";
                    carinhaB = "\uD83D\uDE42";
                }
            } else {
                if (placarB > placarA + 16) {
                    carinhaB = "\uD83D\uDE0D";
                    carinhaA = "\uD83D\uDE24";
                } else if (placarB > placarA + 14) {
                    carinhaB = "\uD83D\uDE0D";
                    carinhaA = "\uD83D\uDE31";
                } else if (placarB > placarA + 12) {
                    carinhaB = "\uD83D\uDE01";
                    carinhaA = "\uD83D\uDE1E";
                } else if (placarB > placarA + 8) {
                    carinhaB = "\uD83D\uDE04";
                    carinhaA = "\uD83D\uDE2D";
                } else if (placarB > placarA + 6) {
                    carinhaB = "\uD83D\uDE0C";
                    carinhaA = "\uD83D\uDE29";
                } else if (placarB > placarA + 3) {
                    carinhaB = "\uD83D\uDE09";
                    carinhaA = "\uD83D\uDE16";
                } else {
                    carinhaB = "\uD83D\uDE42";
                    carinhaA = "\uD83D\uDE42";
                }
            }
        } else {
            if (placarA > placarB) {
                if (placarA > placarB + 100) {
                    carinhaA = "\uD83D\uDE0D";
                    carinhaB = "\uD83D\uDE30";
                } else if (placarA > placarB + 60) {
                    carinhaA = "\uD83D\uDE01";
                    carinhaB = "\uD83D\uDE28";
                } else if (placarA > placarB + 50) {
                    carinhaA = "\uD83D\uDE0D";
                    carinhaB = "\uD83D\uDE24";
                } else if (placarA > placarB + 40) {
                    carinhaA = "\uD83D\uDE18";
                    carinhaB = "\uD83D\uDE31";
                } else if (placarA > placarB + 30) {
                    carinhaA = "\uD83D\uDE02";
                    carinhaB = "\uD83D\uDE20";
                } else if (placarA > placarB + 20) {
                    carinhaA = "\uD83D\uDE07";
                    carinhaB = "\uD83D\uDE1E";
                } else if (placarA > placarB + 10) {
                    carinhaA = "\uD83D\uDE01";
                    carinhaB = "\uD83D\uDE1F";
                } else if (placarA > placarB + 6) {
                    carinhaA = "\uD83D\uDE0A";
                    carinhaB = "\uD83D\uDE42";
                } else {
                    carinhaA = "\uD83D\uDE42";
                    carinhaB = "\uD83D\uDE42";
                }
            } else {
                if (placarB > placarA + 100) {
                    carinhaB = "\uD83D\uDE0D";
                    carinhaA = "\uD83D\uDE30";
                } else if (placarB > placarA + 60) {
                    carinhaB = "\uD83D\uDE01";
                    carinhaA = "\uD83D\uDE28";
                } else if (placarB > placarA + 50) {
                    carinhaB = "\uD83D\uDE0D";
                    carinhaA = "\uD83D\uDE24";
                } else if (placarB > placarA + 40) {
                    carinhaB = "\uD83D\uDE18";
                    carinhaA = "\uD83D\uDE31";
                } else if (placarB > placarA + 30) {
                    carinhaB = "\uD83D\uDE02";
                    carinhaA = "\uD83D\uDE20";
                } else if (placarB > placarA + 20) {
                    carinhaB = "\uD83D\uDE07";
                    carinhaA = "\uD83D\uDE1E";
                } else if (placarB > placarA + 10) {
                    carinhaB = "\uD83D\uDE01";
                    carinhaA = "\uD83D\uDE1F";
                } else if (placarB > placarA + 6) {
                    carinhaB = "\uD83D\uDE0A";
                    carinhaA = "\uD83D\uDE42";
                } else {
                    carinhaB = "\uD83D\uDE42";
                    carinhaA = "\uD83D\uDE42";
                }
            }

        }
        emojiA.setText(carinhaA);
        emojiB.setText(carinhaB);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_diagnostico) {
            MenuHamburgerAction.go(this).diagnostico();
        } else if (id == R.id.nav_names) {
            MenuHamburgerAction.go(this).nomes(getSupportFragmentManager());
        } else if (id == R.id.nav_shareapp) {
            MenuHamburgerAction.go(this).compartilharApp();
        } else if (id == R.id.nav_settings) {
          try{  MenuHamburgerAction.go(this).comfiguracoes();
          }catch (Exception x){
              Toast.makeText(this, x.getMessage(), Toast.LENGTH_SHORT).show();
          }
        } else if (id == R.id.nav_manual) {
            MenuHamburgerAction.go(this).manual();
        } else if (id == R.id.nav_support) {
            MenuHamburgerAction.go(this).support();
        } else if (id == R.id.nav_sobre) {
            MenuHamburgerAction.go(this).sobre();
        } else if (id == R.id.nav_rateapp) {
            MenuHamburgerAction.go(this).rate();
        } else if (id == R.id.nav_proapp) {
            MenuHamburgerAction.go(this).pro();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void vibrador() {
        if (Service.isVibrar(this)) {
            Vibrator vibra = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibra.vibrate(Long.valueOf(Service.isMaximoVibration(this)));
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.som);
            mediaPlayer.start();
        }
    }

    private void pontosTimeA(long pontos, boolean zera) {
        if (zera) {
            placarA = pontos;
        } else {
            placarA += pontos;
        }
        pontosA.setText(String.valueOf(placarA));
        editor_placar_A.setText(pontosA.getText().toString());
    }

    private void pontosTimeB(long pontos, boolean zera) {
        if (zera) {
            placarB = pontos;
        } else {
            placarB += pontos;
        }
        pontosB.setText(String.valueOf(placarB));
        editor_placar_B.setText(pontosB.getText().toString());
    }

    private AlertDialog dialog;
    boolean isZero = false;

    private void checkedMaximoPontosFinish() {
        if (check_20pontos.isChecked()) {
            if (placarA >= maximo() || placarB >= maximo()) {
                vibrador();
                falaVitoria();
                String fim = "";
                if (inconsciente)
                    fim = placarA > placarB ? r(R.string.fimdejogo) + " " + Jogadores.getJogadorA(this) + " " + r(R.string.venceram) + " " + r(R.string.inco) + " " + Jogadores.getJogadorB(this) : r(R.string.fimdejogo) + " " + Jogadores.getJogadorB(this) + " " + r(R.string.venceram) + " " + r(R.string.inco) + " " + Jogadores.getJogadorA(this);
                else
                    fim = placarA > placarB ? r(R.string.fimdejogo) + " " + Jogadores.getJogadorA(this) + " " + r(R.string.venceram) : r(R.string.fimdejogo) + " " + Jogadores.getJogadorB(this) + " " + r(R.string.venceram);
                dialog = new AlertDialog.Builder(this).create();
                dialog.setTitle(Vencedores.context(this).vencedor(placarA, placarB));
                dialog.setMessage(fim);
                dialog.setButton(Dialog.BUTTON_POSITIVE, loader.get(this, R.string.reinicir), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isZero = true;
                        zerarTudo();
                    }
                });
                dialog.setButton(Dialog.BUTTON_NEGATIVE, loader.get(this, R.string.Continue), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        if (Service.isGeralIncFinaliza(mContext) && inconsciente) {
                            long valorMaior = placarA > placarB ? placarA - Long.valueOf(Service.isMaximoPontos(mContext)) : placarB - Long.valueOf(Service.isMaximoPontos(mContext));

                            if (check_partida_dobrada.isChecked()) valorMaior += 12;
                            else valorMaior += 6;

                            if (placarA > placarB) pontosTimeA(valorMaior, true);
                            else pontosTimeB(valorMaior, true);
                        }
                        if (placarA >= maximo() || placarB >= maximo()) {
                            check_20pontos.setChecked(false);
                            check_20pontos.setEnabled(false);
                        } else {
                            check_20pontos.setEnabled(true);
                            check_20pontos.setChecked(false);
                        }
                    }
                });

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (!isZero) {
                            if (check_20pontos.isChecked()) {
                                zerarTudo();
                            }
                        }
                    }
                });

                if (!dialog.isShowing()) dialog.show();
            }
        }
    }

    private void falaVitoria() {
        if (Service.isNarraFinalizar(this)) {
            String fim = "";
            if (inconsciente && Service.isGeralIncFinaliza(mContext))
                fim = placarA > placarB ? r(R.string.fimdejogo) + " " + Jogadores.getJogadorA(this) + " " + r(R.string.venceram) + " " + r(R.string.inco) + " " + Jogadores.getJogadorB(this) : r(R.string.fimdejogo) + " " + Jogadores.getJogadorB(this) + " " + r(R.string.venceram) + " " + r(R.string.inco) + " " + Jogadores.getJogadorA(this);
            else
                fim = placarA > placarB ? r(R.string.fimdejogo) + " " + Jogadores.getJogadorA(this) + " " + r(R.string.venceram) : r(R.string.fimdejogo) + " " + Jogadores.getJogadorB(this) + " " + r(R.string.venceram);

            falar(fim);
        }
    }

    private boolean inconsciente = false;
    public View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long ponto = 0;
            inconsciente = false;
            switch (v.getId()) {
                case R.id.Abtn_passe:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.passe, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.passe);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.passe);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe, Diagnostico.A);
                    narrarClicks(Speek.passe);
                    break;
                case R.id.Abtn_passe2:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe2);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.passe2, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.passe2);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.passe2);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe2, Diagnostico.A);
                    narrarClicks(Speek.passe2);
                    break;
                case R.id.Abtn_passesaida:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe_saida);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.passe_saida, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.passe_saida);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.passe_saida);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe_saida, Diagnostico.A);
                    narrarClicks(Speek.passe_saida);
                    break;
                case R.id.Abtn_passe2saida:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe_saida2);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.passe_saida2, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.passe_saida2);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.passe_saida2);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe_saida2, Diagnostico.A);
                    narrarClicks(Speek.passe_saida2);
                    break;
                case R.id.Abtn_geral:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.geral);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.geral, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.geral);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.geral);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.geral, Diagnostico.A);
                    narrarClicks(Speek.geral);
                    break;
                case R.id.Abtn_geralinsco:
                    if (Service.isGeralIncFinaliza(v.getContext()) && check_20pontos.isChecked())
                        ponto = Long.valueOf(Service.isMaximoPontos(v.getContext()));
                    else
                        ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.geral_inconsciente);

                    inconsciente = true;

                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.geral_inconsciente, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.geral_inconsciente);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.geral_inconsciente);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.geral_inconsciente, Diagnostico.B);
                    narrarClicks(Speek.geral_inconsciente);

                    break;
                case R.id.Abtn_batida:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.batida);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.batida, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.batida);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.batida);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.batida, Diagnostico.A);
                    narrarClicks(Speek.batida);
                    break;
                case R.id.Abtn_batidalascada:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.batida_lascada);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.batida_lascada, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.batida_lascada);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.batida_lascada);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.batida_lascada, Diagnostico.A);
                    narrarClicks(Speek.batida_lascada);
                    break;
                case R.id.Abtn_batidacamburao:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.batida_camburao);
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.batida_camburao, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.batida_camburao);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.batida_camburao);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.batida_camburao, Diagnostico.A);
                    narrarClicks(Speek.batida_camburao);
                    break;
                case R.id.Bbtn_passe:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.passe, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.passe);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.passe);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe, Diagnostico.B);
                    narrarClicks(Speek.passe);
                    break;
                case R.id.Bbtn_passe2:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe2);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.passe2, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.passe2);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.passe2);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe2, Diagnostico.B);
                    narrarClicks(Speek.passe2);
                    break;
                case R.id.Bbtn_passesaida:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe_saida);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.passe_saida, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.passe_saida);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.passe_saida);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe_saida, Diagnostico.B);
                    narrarClicks(Speek.passe_saida);
                    break;
                case R.id.Bbtn_passe2saida:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.passe_saida2);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.passe_saida2, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.passe_saida2);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.passe_saida2);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.passe_saida2, Diagnostico.B);
                    narrarClicks(Speek.passe_saida2);
                    break;
                case R.id.Bbtn_geral:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.geral);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.geral, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.geral);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.geral);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.geral, Diagnostico.B);
                    narrarClicks(Speek.geral);
                    break;
                case R.id.Bbtn_geralinsco:
                    if (Service.isGeralIncFinaliza(v.getContext()) && check_20pontos.isChecked())
                        ponto = Long.valueOf(Service.isMaximoPontos(v.getContext()));
                    else
                        ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.geral_inconsciente);

                    inconsciente = true;
                    pontosTimeA(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.A, Pontos.geral_inconsciente, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.A, Pontos.geral_inconsciente);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.A, Pontos.geral_inconsciente);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.geral_inconsciente, Diagnostico.A);
                    narrarClicks(Speek.geral_inconsciente);
                    break;
                case R.id.Bbtn_batida:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.batida);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.batida, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.batida);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.batida);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.batida, Diagnostico.B);
                    narrarClicks(Speek.batida);
                    break;
                case R.id.Bbtn_batidalascada:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.batida_lascada);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.batida_lascada, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.batida_lascada);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.batida_lascada);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.batida_lascada, Diagnostico.B);
                    narrarClicks(Speek.batida_lascada);
                    break;
                case R.id.Bbtn_batidacamburao:
                    ponto = Pontuador.dobrado(check_partida_dobrada.isChecked()).placar(Pontos.batida_camburao);
                    pontosTimeB(ponto, false);
                    Diagnostico.setContext(v.getContext()).setPontos(Diagnostico.B, Pontos.batida_camburao, ponto);
                    if (check_partida_dobrada.isChecked())
                        Diagnostico.setContext(v.getContext()).setDobrado(Diagnostico.B, Pontos.batida_camburao);
                    Diagnostico.setContext(v.getContext()).setVezes(Diagnostico.B, Pontos.batida_camburao);
                    Diagnostico.setContext(v.getContext()).setTelhado(Pontos.batida_camburao, Diagnostico.B);
                    narrarClicks(Speek.batida_camburao);
                    break;
            }
            view();
        }
    };

    private void view() {
        if (placarA == 0 && placarB == 0) {
            diagnostico_btn.setEnabled(false);
            zerar.setEnabled(false);
        } else {
            diagnostico_btn.setEnabled(true);
            zerar.setEnabled(true);
        }
        if (placarA >= maximo() || placarB >= maximo()) {
            check_20pontos.setEnabled(false);
        } else check_20pontos.setEnabled(true);
        carasEmoji();
        if (placarA != 0 || placarB != 0) {
            bar1.setIndeterminate(false);
            bar2.setIndeterminate(false);
            bar1.setMax((int) placarA + (int) placarB);
            bar1.setProgress((int) placarA);
            bar2.setMax((int) placarA + (int) placarB);
            bar2.setProgress((int) placarB);
        }
        checkedMaximoPontosFinish();
    }

    public View.OnClickListener click_editor = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.floating_editA:
                    layout_editorA.setVisibility(View.VISIBLE);
                    salva_A.setVisibility(View.VISIBLE);
                    editor_A.setVisibility(View.GONE);
                    narrarClicks(Speek.editor_open);
                    break;
                case R.id.floating_editB:
                    layout_editorB.setVisibility(View.VISIBLE);
                    salva_B.setVisibility(View.VISIBLE);
                    editor_B.setVisibility(View.GONE);
                    narrarClicks(Speek.editor_open);
                    break;
                case R.id.floating_saveA:
                    salvar_placarA();
                    break;
                case R.id.floating_saveB:
                    salvar_placarB();
                    break;
            }
        }
    };

    private void salvar_placarA() {
        if (editor_placar_A.getText().toString().isEmpty() || editor_placar_A.getText().toString().length() == 0)
            messageBox(loader.get(this, R.string.editor_limpo));
        else if (editor_placar_A.getText().toString().startsWith("0") && editor_placar_A.getText().toString().length() > 1)
            messageBox(loader.get(this, R.string.editor_zero));
        else if (editor_placar_A.getText().toString().endsWith("1") || editor_placar_A.getText().toString().endsWith("3") || editor_placar_A.getText().toString().endsWith("5") || editor_placar_A.getText().toString().endsWith("7") || editor_placar_A.getText().toString().endsWith("9"))
            messageBox(loader.get(this, R.string.editor_impa));
        else {
            layout_editorA.setVisibility(View.GONE);
            salva_A.setVisibility(View.GONE);
            editor_A.setVisibility(View.VISIBLE);
            valorAntgo = placarA;
            valorNovo = Long.valueOf(editor_placar_A.getText().toString());
            pontosTimeA(valorNovo, true);
            Diagnostico.setContext(this).setTelhado(Diagnostico.A, valorAntgo, valorNovo);
            checkedMaximoPontosFinish();
            if (valorNovo == valorAntgo) narrarClicks(Speek.editor_close);
            else if (!Service.isDedurar(this)) narrarClicks(Speek.editor_modify);
            else {
                narrarPlacarModify(1);
            }

            view();

        }
    }

    private void narrarPlacarModify(int i) {
        falar(result(valorAntgo, valorNovo, i));
    }

    @Override
    public void onResume() {
        try {
            iniciar();
            narrarOnOff();
        } catch (Exception c) {
            messageBox(c.getMessage());
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        try {
            Diagnostico.setContext(this).setPlacares(Diagnostico.A, placarA);
            Diagnostico.setContext(this).setPlacares(Diagnostico.B, placarB);
            Diagnostico.setContext(this).setNames(Diagnostico.A, Jogadores.getJogadorA(this));
            Diagnostico.setContext(this).setNames(Diagnostico.B, Jogadores.getJogadorB(this));
        } catch (Exception c) {
            messageBox(c.getMessage());
        }
        super.onPause();
    }

    private void salvar_placarB() {
        if (editor_placar_B.getText().toString().isEmpty() || editor_placar_B.getText().toString().length() == 0)
            messageBox(loader.get(this, R.string.editor_limpo));
        else if (editor_placar_B.getText().toString().startsWith("0") && editor_placar_B.getText().toString().length() > 1)
            messageBox(loader.get(this, R.string.editor_zero));
        else if (editor_placar_B.getText().toString().endsWith("1") || editor_placar_B.getText().toString().endsWith("3") || editor_placar_B.getText().toString().endsWith("5") || editor_placar_B.getText().toString().endsWith("7") || editor_placar_B.getText().toString().endsWith("9"))
            messageBox(loader.get(this, R.string.editor_impa));
        else {
            layout_editorB.setVisibility(View.GONE);
            salva_B.setVisibility(View.GONE);
            editor_B.setVisibility(View.VISIBLE);
            valorAntgo = placarB;
            valorNovo = Long.valueOf(editor_placar_B.getText().toString());
            pontosTimeB(valorNovo, true);
            Diagnostico.setContext(this).setTelhado(Diagnostico.B, valorAntgo, valorNovo);
            checkedMaximoPontosFinish();
            if (valorNovo == valorAntgo) narrarClicks(Speek.editor_close);
            else if (!Service.isDedurar(this)) narrarClicks(Speek.editor_modify);
            else {
                narrarPlacarModify(2);
            }
            view();
        }
    }

    private long valorAntgo, valorNovo;

    private void messageBox(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private long maximo() {
        return Long.valueOf(Service.isMaximoPontos(this));
    }

    private TextToSpeech locutor;

    public void falar(String dialogo) {
        locutor.speak(dialogo, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void parar() {
        if (locutor != null) {
            locutor.stop();
            locutor.shutdown();
            locutorLoader();
        }
    }

    private void locutorLoader() {
        locutor = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    locutor.setLanguage(Locale.getDefault());
                    locutor.setSpeechRate(0);
                }
            }
        });
    }

    private String r(int res) {
        return loader.get(this, res);
    }

    private void narrador(Speek voice) {
        if (voice == Speek.narrador) {
            falar(falarPlacar());
        }
    }

    private String falarPlacar() {
        String fala = "";
        if (placarA == placarB) {
            fala = r(R.string.jogo_empate) + " " + placarA + " " + r(R.string.pontos) + " " + r(R.string.a) + " " + placarB + " " + r(R.string.pontos);
        } else {
            fala = placarA > placarB ? Jogadores.getJogadorA(this) + " " + r(R.string.vencendo) + " " + placarA + " " + r(R.string.pontos) + " " + r(R.string.a) + " " + placarB + " " + r(R.string.pontos) : Jogadores.getJogadorB(this) + " " + r(R.string.vencendo) + " " + placarB + " " + r(R.string.pontos) + " " + r(R.string.a) + " " + placarA + " " + r(R.string.pontos);
        }
        return fala;
    }

    private void narrarClicks(Speek voice) {
        if (Service.isNarraClicks(this)) {
            String fala = "";

            switch (voice) {
                case passe:
                    fala = r(R.string.passe);
                    break;
                case passe2:
                    fala = r(R.string.passe_de_dois);
                    break;
                case passe_saida:
                    fala = r(R.string.passe_de_saida);
                    break;
                case passe_saida2:
                    fala = r(R.string.passe_de_saida2);
                    break;
                case geral:
                    fala = r(R.string.geral);
                    break;
                case geral_inconsciente:
                    fala = r(R.string.geral_inc);
                    break;
                case batida:
                    fala = r(R.string.batida);
                    break;
                case batida_lascada:
                    fala = r(R.string.batida_lascada);
                    break;
                case batida_camburao:
                    fala = r(R.string.batida_camburo);
                    break;
                case zera:
                    fala = r(R.string.new_game);
                    break;
                case editor_open:
                    fala = r(R.string.editor_open);
                    break;
                case editor_close:
                    fala = r(R.string.editor_clase);
                    break;
                case editor_modify:
                    fala = r(R.string.editor_modify);
                    break;
                case max_pontos:
                    fala = check_20pontos.getText().toString() + " " + on_off(check_20pontos.isChecked());
                    break;
                case dobrada:
                    fala = check_partida_dobrada.getText().toString() + " " + on_off(check_partida_dobrada.isChecked());
                    break;
            }
            falar(fala);
        }
    }

    private String on_off(boolean a) {
        return a ? r(R.string.ativado) : r(R.string.desativado);
    }


    private String result(long a, long b, int play) {
        String maior = a > b ? r(R.string.removeu) : r(R.string.adicionou);
        if (a == b) maior = r(R.string.empate);

        long re = a - b;
        String valor = String.valueOf(re);
        if (valor.startsWith("-")) valor = valor.replace("-", "");
        if (play == 1) maior = Jogadores.getJogadorA(this) + " " + maior;
        else maior = Jogadores.getJogadorB(this) + " " + maior;
        return maior + " " + valor + " " + r(R.string.pontos);
    }


    public static class DialogNameFragment extends DialogFragment {


        private EditText inputJogadoresA;
        private TextInputLayout inputJogadoresALayout;
        private EditText inputJogadoresB;
        private TextInputLayout inputJogadoresBLayout;
        private Toolbar toolbar;
        private View viewDialog;

        private void animateDialogIn(Dialog dialog) {
            if (Build.VERSION.SDK_INT >= 14) {
                View view = dialog.getWindow().getDecorView();
                int n = view.getLeft() + view.getRight();
                int n2 = view.getTop() + view.getBottom();
                Math.max((int) view.getWidth(), (int) view.getHeight());
                AnimatorSet animatorSet = new AnimatorSet();
                Property property = View.X;
                float[] arrf = new float[]{(float) n / 2.0f, 0.0f};
                AnimatorSet.Builder builder = animatorSet.play((Animator) ObjectAnimator.ofFloat((Object) view, (Property) property, (float[]) arrf));
                Property property2 = View.Y;
                float[] arrf2 = new float[]{(float) n / 2.0f, 0.0f};
                AnimatorSet.Builder builder2 = animatorSet.play((Animator) ObjectAnimator.ofFloat((Object) view, (Property) property2, (float[]) arrf2)).with((Animator) ObjectAnimator.ofFloat((Object) view, (Property) View.SCALE_X, (float[]) new float[]{0.0f, 1.0f})).with((Animator) ObjectAnimator.ofFloat((Object) view, (Property) View.SCALE_Y, (float[]) new float[]{0.0f, 1.0f}));
                animatorSet.setDuration(250L);
                animatorSet.setInterpolator((TimeInterpolator) new DecelerateInterpolator());
                animatorSet.setStartDelay(250L);
                animatorSet.start();
            }
        }

        private void animateDialogOut() {
            final Dialog dialog = this.getDialog();
            if (Build.VERSION.SDK_INT >= 21) {
                View view = dialog.getWindow().getDecorView();
                int n = view.getLeft() + view.getRight();
                int n2 = view.getTop() + view.getBottom();
                Math.max((int) view.getWidth(), (int) view.getHeight());
                AnimatorSet animatorSet = new AnimatorSet();
                Property property = View.X;
                float[] arrf = new float[]{0.0f, (float) n / 2.0f};
                AnimatorSet.Builder builder = animatorSet.play((Animator) ObjectAnimator.ofFloat((Object) view, (Property) property, (float[]) arrf));
                Property property2 = View.Y;
                float[] arrf2 = new float[]{0.0f, (float) n2 / 2.0f};
                builder.with((Animator) ObjectAnimator.ofFloat((Object) view, (Property) property2, (float[]) arrf2)).with((Animator) ObjectAnimator.ofFloat((Object) view, (Property) View.SCALE_X, (float[]) new float[]{1.0f, 0.0f})).with((Animator) ObjectAnimator.ofFloat((Object) view, (Property) View.SCALE_Y, (float[]) new float[]{1.0f, 0.0f}));
                animatorSet.setDuration(250L);
                animatorSet.setInterpolator((TimeInterpolator) new DecelerateInterpolator());
                animatorSet.addListener(new Animator.AnimatorListener() {

                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        dialog.dismiss();
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
                animatorSet.start();
                return;
            }
            dialog.dismiss();
        }

        String A, B;

        private void initDialog(final Dialog dialog) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    animateDialogIn(dialog);
                }
            });
            dialog.setCanceledOnTouchOutside(false);
            ((AppCompatButton) viewDialog.findViewById(R.id.btn_salvarnomes)).setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    try {
                        if (inputJogadoresA.getText().toString().isEmpty() || inputJogadoresA.getText().toString().equals(""))
                            A = view.getContext().getString(R.string.jogador_a);
                        else
                            A = inputJogadoresA.getText().toString();

                        if (A.startsWith(" ")) A = A.replace(" ", "");

                        Jogadores.setJogadorA(A, view.getContext());

                        if (inputJogadoresB.getText().toString().isEmpty() || inputJogadoresB.getText().toString().equals(""))
                            B = view.getContext().getString(R.string.jogador_b);
                        else
                            B = inputJogadoresB.getText().toString();

                        if (B.startsWith(" ")) B = B.replace(" ", "");

                        Jogadores.setJogadorB(B, view.getContext());
                        edit_paly_a.setText(Diagnostico.setContext(viewDialog.getContext()).getNames(Diagnostico.A));
                        edit_paly_b.setText(Diagnostico.setContext(viewDialog.getContext()).getNames(Diagnostico.B));
                        animateDialogOut();
                    } catch (Exception x) {
                        Toast.makeText(view.getContext(), x.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            this.inputJogadoresA = (EditText) this.viewDialog.findViewById(R.id.jogadoresA);
            this.inputJogadoresB = (EditText) this.viewDialog.findViewById(R.id.jogadoresB);
            this.inputJogadoresALayout = (TextInputLayout) this.viewDialog.findViewById(R.id.jogadoresALayout);
            this.inputJogadoresBLayout = (TextInputLayout) this.viewDialog.findViewById(R.id.jogadoresBLayout);
            this.toolbar = (Toolbar) this.viewDialog.findViewById(R.id.toolbar_nomes);
            this.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (R.id.cancel == menuItem.getItemId()) {
                        animateDialogOut();
                        return true;
                    }
                    return false;
                }
            });
            this.inputJogadoresA.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View view, boolean bl) {
                    if (bl) {
                        inputJogadoresA.setError(null);
                    }
                }
            });
            this.inputJogadoresB.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View view, boolean bl) {
                    inputJogadoresB.setError(null);
                }
            });

            if (!Jogadores.getJogadorA(viewDialog.getContext()).equals(getString(R.string.jogador_a)))
                this.inputJogadoresA.setText(Jogadores.getJogadorA(viewDialog.getContext()));

            if (!Jogadores.getJogadorB(viewDialog.getContext()).equals(getString(R.string.jogador_b)))
                this.inputJogadoresB.setText(Jogadores.getJogadorB(viewDialog.getContext()));

        }


        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            View view = this.getDialog().getWindow().getDecorView();
            if (Build.VERSION.SDK_INT >= 14) {
                ViewCompat.setScaleX((View) view, (float) 0.0f);
                ViewCompat.setScaleY((View) view, (float) 0.0f);
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            this.viewDialog = LayoutInflater.from((Context) this.getActivity()).inflate(R.layout.fragment_dialog_name, null);
            this.setHasOptionsMenu(true);
            AlertDialog.Builder builder = new AlertDialog.Builder((Context) this.getActivity());
            builder.setView(this.viewDialog);
            alertDialog = builder.create();
            initDialog((Dialog) alertDialog);
            return alertDialog;
        }

        AlertDialog alertDialog;

        public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
            this.toolbar.inflateMenu(R.menu.menu_nome);
        }

        public void onResume() {
            super.onResume();
        }

    }
}