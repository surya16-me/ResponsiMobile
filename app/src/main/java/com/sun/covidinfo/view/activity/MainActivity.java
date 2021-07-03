package com.sun.covidinfo.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sun.covidinfo.R;
import com.sun.covidinfo.view.fragment.Hospital;
import com.sun.covidinfo.view.fragment.KasusCovid;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedfragment = new KasusCovid();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.menu_bawah);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        loadFragment(selectedfragment);
    }

    private boolean loadFragment(Fragment selectedfragment) {
        if(selectedfragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainui,selectedfragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()){
            case R.id.kasus_menu:
                selectedfragment = new KasusCovid();
                loadFragment(selectedfragment);
                break;

            case R.id.hospital_menu:
                selectedfragment = new Hospital();
                loadFragment(selectedfragment);
                break;
        }
        return loadFragment(selectedfragment);
    }
}