package com.pa.gumi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class AffichageOperationAdapter extends BaseAdapter {

    private ArrayList<AffichageOperation> maListeDeAO;
    private ArrayList<String> listeDeResult;
    private LayoutInflater mInflater;
    private IAffichageOperationAdapterListener ecouteur;
    private Context context;


    public AffichageOperationAdapter(Context context, ArrayList<AffichageOperation> maListeDeAO,  ArrayList<String> listeDeResult){
        this.maListeDeAO = maListeDeAO;
        this.context = context;
        this.listeDeResult = listeDeResult;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return maListeDeAO.size();
    }

    @Override
    public Object getItem(int position) {
        return maListeDeAO.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout layoutItem;

        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML ""
            layoutItem = (ConstraintLayout) mInflater.inflate(R .layout.layout_affichageoperation, parent, false);
        } else {
            layoutItem = (ConstraintLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tvOperator = layoutItem.findViewById(R.id.textOperator);
        TextView tvOperatorResult = layoutItem.findViewById(R.id.textOperatorResult);
        TextView tvOperatorIsReussit = layoutItem.findViewById(R.id.textOperatorReusitOuNon);

        //(3) : Renseignement des valeurs
        tvOperator.setText(maListeDeAO.get(position).getOperation());
        tvOperatorResult.setText(maListeDeAO.get(position).getOperationResultat());

        tvOperatorIsReussit.setText(listeDeResult.get(position));

        //(4) Changement de la couleur du fond de notre item

        tvOperator.setTag(position);
        tvOperatorResult.setTag(position);
        tvOperatorIsReussit.setTag(position);

        //(6)On retourne l'item créé.
        return layoutItem;
    }

    void addListener(IAffichageOperationAdapterListener elementAEcouter) {
        ecouteur = elementAEcouter;
    }


}
