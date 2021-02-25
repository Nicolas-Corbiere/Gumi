package com.pa.gumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NbOpeFrag extends Fragment {
    private Button mB1;
    private Button mB2;
    private Button mB3;
    private Bundle arguments;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View retView = inflater.inflate(R.layout.nbope_frag, container,false);
            return retView;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            getActivity().setTitle("Nombre d'opérations");
        ((MainActivity)getActivity()).getBottomNavigationView().getMenu().getItem(0).setChecked(true);
        arguments = this.getArguments();
        mB1 = getView().findViewById(R.id.ope10);
        mB2= getView().findViewById(R.id.ope20);
        mB3= getView().findViewById(R.id.ope30);

        mB1.setOnClickListener(switchButton);
        mB2.setOnClickListener(switchButton);
        mB3.setOnClickListener(switchButton);
    }
    View.OnClickListener switchButton = new View.OnClickListener() {
        public void onClick(View v) {
            Bundle args = new Bundle(arguments);
            Intent intent = new Intent(getActivity(), ExoActivity.class);
            System.out.println(args.toString());
            switch(v.getId()) {
                case R.id.ope10:
                    args.putInt("nbOperator", 10);
                    intent.putExtras(args); //Put your id to your next Intent
                    startActivity(intent);
                    getActivity().finish();
                    break;
                case R.id.ope20:
                    args.putInt("nbOperator", 20);
                    intent.putExtras(args); //Put your id to your next Intent
                    startActivity(intent);
                    getActivity().finish();
                    break;
                case R.id.ope30:
                    args.putInt("nbOperator", 30);
                    intent.putExtras(args); //Put your id to your next Intent
                    startActivity(intent);
                    getActivity().finish();
                    break;
                default:
                    System.out.println("Erreur");
            }
        }
    };
}
