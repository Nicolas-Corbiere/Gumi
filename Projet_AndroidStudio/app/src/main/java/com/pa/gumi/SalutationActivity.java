package com.pa.gumi;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pa.gumi.Exercice.NumberManager;

public class SalutationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salutation);
        final Button bFon = findViewById(R.id.entrer);
        final TextView t2 = findViewById(R.id.Bienvenue);
        final TextView t1 = findViewById(R.id.phrase1);

        bFon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(
                        SalutationActivity.this, R.anim.fondue));
                t1.startAnimation(AnimationUtils.loadAnimation(
                        SalutationActivity.this, R.anim.fondueagrand));
                t2.startAnimation(AnimationUtils.loadAnimation(
                        SalutationActivity.this, R.anim.fondueagrand));

                Intent intent = new Intent(SalutationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
