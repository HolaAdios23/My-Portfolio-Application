package com.example.porfolioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Navigation extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView navigationView;

    HomeFragment homeFragment = new HomeFragment();

    ProfileFragment profileFragment = new ProfileFragment();
    SkillFragment skillFragment = new SkillFragment();

    HobbyFragment hobbyFragment = new HobbyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.home);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.profile)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
            return true;
        }
        else if(item.getItemId() == R.id.skill)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, skillFragment).commit();
            return true;
        }
        else if(item.getItemId() == R.id.hobby)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, hobbyFragment).commit();
            return true;
        }
        else if(item.getItemId() == R.id.home)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        }

        return false;
    }
}