package com.pa.gumi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.navigation_sports:
                                Fragment exo = new ExoFrag();
                                replaceFragment(exo);
                                break;
                            case R.id.navigation_favoris:
                                Fragment stat = new StatFrag();
                                replaceFragment(stat);
                                break;
                        }

                        return true;
                    }
                });
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ExoFrag()).commit();


    }
    // REMPLACEMENT DE FRAGMENT
    public void replaceFragment(Fragment destFragment) {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.frameLayout, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.addToBackStack(null).commit();
    }
    public BottomNavigationView getBottomNavigationView() {
        return bottomNavigationView;
    }
}
