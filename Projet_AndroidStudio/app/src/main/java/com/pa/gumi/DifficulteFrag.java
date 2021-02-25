package com.pa.gumi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DifficulteFrag extends Fragment {

    private Button mB1;
    private Button mB2;
    private Button mB3;
    private Bundle arguments;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.difficulte_frag, container,false);
        return retView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Difficulté");
        ((MainActivity)getActivity()).getBottomNavigationView().getMenu().getItem(0).setChecked(true);
        arguments = this.getArguments();
        mB1 = getView().findViewById(R.id.facile);
        mB2= getView().findViewById(R.id.normal);
        mB3= getView().findViewById(R.id.difficile);

        mB1.setOnClickListener(switchButton);
        mB2.setOnClickListener(switchButton);
        mB3.setOnClickListener(switchButton);
    }
    View.OnClickListener switchButton = new View.OnClickListener() {
        public void onClick(View v) {
            Fragment mList = new NbOpeFrag();
            Bundle args = new Bundle(arguments);
            System.out.println(args.toString());
            switch(v.getId()) {
                case R.id.facile:
                    args.putString("difficulté", "Facile");
                    mList.setArguments(args);
                    ((MainActivity) getActivity()).replaceFragment(mList);
                    break;
                case R.id.normal:
                    args.putString("difficulté", "Normal");
                    mList.setArguments(args);
                    ((MainActivity) getActivity()).replaceFragment(mList);
                case R.id.difficile:
                    args.putString("difficulté", "Difficile");
                    mList.setArguments(args);
                    ((MainActivity) getActivity()).replaceFragment(mList);
                    break;
            }
        }
    };
}
