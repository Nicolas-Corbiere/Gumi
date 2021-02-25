package com.pa.gumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pa.gumi.lectureFichier.StringManager;

import java.io.IOException;
import java.util.ArrayList;

public class ResultatActi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat_frag);

        TextView nbVrais = findViewById(R.id.NbVrais);
        TextView nbfaux = findViewById(R.id.Nbfaux);



        Intent intent = getIntent();

        String nombreVrais = intent.getStringExtra("nombreVrais");
        String nombreFaux = intent.getStringExtra("nombreFaux");

        nbVrais.setText(nombreVrais);
        nbfaux.setText(nombreFaux);

        try {
            StringManager stringM = new StringManager(this);
            ArrayList<String> list = stringM.readStat();
            int nbOp = Integer.parseInt(list.get(0)) + Integer.parseInt(nombreVrais) + Integer.parseInt(nombreFaux);
            int nbOpV = Integer.parseInt(list.get(1)) + Integer.parseInt(nombreVrais);
            int nbOpF = Integer.parseInt(list.get(2)) + Integer.parseInt(nombreFaux);
            stringM.writeStat(nbOp, nbOpV,nbOpF);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //récupération des éléments du layout
        ListView list = findViewById(R.id.listView);

        //création de maListe
        ArrayList<String> listeOp = intent.getStringArrayListExtra("listOpe");
        ArrayList<String> listeOpRes = intent.getStringArrayListExtra("listRep");
        ArrayList<AffichageOperation> listeAff = new ArrayList<>();

        for(int i = 0; i < listeOp.size(); i++) {
            listeAff.add(new AffichageOperation(listeOp.get(i),listeOpRes.get(i)));
        }


        ArrayList<String> listeVraisFaux = intent.getStringArrayListExtra("listRepJoueurs");

        AffichageOperationAdapter adapter = new AffichageOperationAdapter(this,listeAff,listeVraisFaux);

        //Initialisation de la liste avec les données
        list.setAdapter(adapter);


        Button boutonRet = findViewById(R.id.retourMenu);


        boutonRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultatActi.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }



}
