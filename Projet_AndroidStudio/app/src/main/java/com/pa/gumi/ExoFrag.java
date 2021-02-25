package com.pa.gumi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pa.gumi.R;

public class ExoFrag extends Fragment {
    private ListView listeViewEquipement;
    private String[] listeEquipeExt;
    private ListView ope;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.exo_frag, container,false);
        return retView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Exercices");
        ((MainActivity)getActivity()).getBottomNavigationView().getMenu().getItem(0).setChecked(true);
        listeViewEquipement = getView().findViewById(R.id.listeOpe);
        ope = getView().findViewById(R.id.listeOpe);

        listeEquipeExt = new String[]{"+", "-"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, listeEquipeExt);
        listeViewEquipement.setAdapter(adapter);

        listeViewEquipement.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View AdapterView, int position, long id) {
                String item = adapter.getItem(position);
                Bundle args = new Bundle();
                switch (item) {
                    case "+":
                        Fragment mList1 = new DifficulteFrag();
                        args.putString("typeEx", "Addition");
                        mList1.setArguments(args);
                        ((MainActivity) getActivity()).replaceFragment(mList1);
                        break;
                    case "-":
                        Fragment mList2 = new DifficulteFrag();
                        args.putString("typeEx", "Soustraction");
                        mList2.setArguments(args);
                        ((MainActivity) getActivity()).replaceFragment(mList2);
                        break;
                }
            }
        });


    }


}
