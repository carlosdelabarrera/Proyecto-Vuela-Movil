package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.administrador.EliminarFragment;
import com.example.myapplication.administrador.ListaFragment;
import com.example.myapplication.administrador.ModificarFragment;
import com.example.myapplication.administrador.UsuariosFragment;
import com.google.android.material.navigation.NavigationView;

public class Main_Activity_admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_admin ;
    NavigationView navigationView_admin;
    Toolbar toolbar_admin;

    ActionBarDrawerToggle Toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_admin);
        Intent intent = getIntent();

        drawerLayout_admin = findViewById(R.id.drawer_layout_admin);
        toolbar_admin = findViewById(R.id.toolbar);
        navigationView_admin= findViewById(R.id.nav_view_admin);

        getSupportFragmentManager().beginTransaction().add(R.id.content,new AgregarFragment()).commit();
        setTitle("home");


        //setSupportActionBar(toolbar_admin);


        Toggle = setUpDrawerToggle();
        drawerLayout_admin.addDrawerListener(Toggle);



         // Toggle = new ActionBarDrawerToggle(this,drawerLayout_admin,toolbar_admin,R.string.drawer_open,R.string.drawer_open);
        navigationView_admin.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setUpDrawerToggle() {
        return new ActionBarDrawerToggle(this,drawerLayout_admin,toolbar_admin,R.string.drawer_open,R.string.drawer_open);
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
            case R.id.nav_eliminar:
                ft.replace(R.id.content,new EliminarFragment()).commit();
                break;
            case R.id.nav_usuarios:
                ft.replace(R.id.content,new UsuariosFragment()).commit();
                break;
            case R.id.nav_lista:
                ft.replace(R.id.content,new ListaFragment()).commit();
                break;
        }
        setTitle(item.getTitle());
        drawerLayout_admin.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (Toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
