package com.pa.gumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pa.gumi.Exercice.NumberManager;

import java.util.ArrayList;

public class ExoActivity extends AppCompatActivity {
    private Button mValider;
    private TextView mOperation;
    private EditText mReponse;
    private int  nombreOpe;
    private Bundle args;
    private Intent intent;

    private NumberManager Manager;

    private int compteur;
    ArrayList<String> listReponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);

        compteur = 0;

        Intent i = getIntent();
        Manager = new NumberManager(i.getStringExtra("typeEx"),i.getStringExtra("difficulté"),i.getIntExtra("nbOperator",10));
        setTitle("Résolvez les opérations !");

        mOperation = findViewById(R.id.operation);
        mReponse = findViewById(R.id.reponse);
        mValider = findViewById(R.id.envoyer);
        listReponses = new ArrayList<String>();
        nombreOpe = i.getIntExtra("nbOperator",10);

        args = new Bundle();
        intent = new Intent(this, ResultatActi.class);

        System.out.println(getNumberManager().getNbOperator());

        mOperation.setText(getNumberManager().affichage(getCompteur(),false));

        mValider.setOnClickListener(new View.OnClickListener() {

            int nombreVrais = 0;
            int nombreFaux = 0;

            @Override
            public void onClick(View v) {
                if (mReponse.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Rentrez une réponse",Toast.LENGTH_LONG).show();

                }

                else if (Integer.parseInt(mReponse.getText().toString()) == Manager.getReponse(compteur))
                {
                    listReponses.add("Vrai");
                    nombreVrais++;
                    Toast.makeText(getApplicationContext(),"Juste !",Toast.LENGTH_LONG).show();
                    compteur++;
                }
                else
                {
                    listReponses.add("Faux");
                    nombreFaux++;
                    Toast.makeText(getApplicationContext(),"Faux ! La réponse était "+getNumberManager().affichage(compteur,true),Toast.LENGTH_LONG).show();
                    compteur++;

                }
                mReponse.setText("");
                if (compteur == nombreOpe)
                {
                    String nbV = "" + nombreVrais;
                    String nbF = "" + nombreFaux;
                    args.putString("nombreVrais", nbV);
                    args.putString("nombreFaux", nbF);
                    args.putStringArrayList("listRepJoueurs",listReponses);
                    args.putStringArrayList("listOpe",getNumberManager().getListOpe());
                    args.putStringArrayList("listRep",getNumberManager().getListRep());
                    intent.putExtras(args); //Put your id to your next Intent
                    startActivity(intent);
                    finish();
                }
                else {
                    mOperation.setText(getNumberManager().affichage(getCompteur(),false));
                }


            }
        });


    }

    public NumberManager getNumberManager() {
        return Manager;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }
}
