package com.pa.gumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OpeFrag extends Fragment {

    private Button mValider;
    private TextView mOperation;
    private EditText mReponse;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.ope_frag, container,false);
        return retView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Résolvez cette opération !");

        mOperation = getView().findViewById(R.id.operation);
        mReponse = getView().findViewById(R.id.reponse);
        mValider = getView().findViewById(R.id.envoyer);

        mOperation.setText(((ExoActivity)getActivity()).getNumberManager().affichage(((ExoActivity)getActivity()).getCompteur(),false));

        mValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
