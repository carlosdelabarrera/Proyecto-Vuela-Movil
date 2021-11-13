package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.FragmentNavigator;

import com.example.myapplication.R;
import com.example.myapplication.administrador.AgregarFragment;
import com.example.myapplication.administrador.ModificarFragment;
import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class Main_Activity_admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_admin ;
    NavigationView navigationView_admin;
    Toolbar toolbar_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_admin);
        Intent intent = getIntent();

        drawerLayout_admin = findViewById(R.id.drawer_layout_admin);
        toolbar_admin = findViewById(R.id.toolbar_admin);
        navigationView_admin= findViewById(R.id.nav_view_admin);

        getSupportFragmentManager().beginTransaction().add(R.id.content,new AgregarFragment()).commit();
        setTitle("home");


        //setSupportActionBar(toolbar_admin);
        navigationView_admin.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    private void selectItemNav(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()){
            case R.id.nav_agregar:
                ft.replace(R.id.content,new AgregarFragment()).commit();
                break;
            case R.id.nav_modificar:
                ft.replace(R.id.content,new ModificarFragment()).commit();
                break;

        }
        setTitle(item.getTitle());
        drawerLayout_admin.closeDrawers();
    }
}
