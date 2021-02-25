package com.pa.gumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pa.gumi.SMSManager.SMSManager;
import com.pa.gumi.lectureFichier.StringManager;

import java.io.IOException;
import java.util.ArrayList;

public class StatFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.stat_frag, container, false);
        return retView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Statistiques");
        ((MainActivity)getActivity()).getBottomNavigationView().getMenu().getItem(1).setChecked(true);

        TextView nbOperation = getActivity().findViewById(R.id.NbOperation);
        TextView nbOperationV = getActivity().findViewById(R.id.NbOperationVrais);
        TextView nbOperationF = getActivity().findViewById(R.id.NbOperationFaux);

        try {
            StringManager stringManager = new StringManager(getContext());
            ArrayList<String> rst = stringManager.readStat();
            nbOperation.setText(rst.get(0));
            nbOperationV.setText(rst.get(1));
            nbOperationF.setText(rst.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final EditText inputNum =  getActivity().findViewById(R.id.inputSms);
        Button btenvoi = getActivity().findViewById(R.id.envoiSMS);

        btenvoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numTel = inputNum.getText().toString();
                int duration = Toast.LENGTH_LONG;

                Toast toastMessErr = Toast.makeText(getContext(), "message envoper à : " + numTel, duration);
                toastMessErr.setGravity(0, 0, 0);
                toastMessErr.show();

                inputNum.setText("");
                SMSManager smsManager = new SMSManager(getContext(),numTel);

            }
        });

    }
}
