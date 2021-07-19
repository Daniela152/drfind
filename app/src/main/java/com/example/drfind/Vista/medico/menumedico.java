package com.example.drfind.Vista.medico;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsMedico.CitasmedicoFragment;
import com.example.drfind.Vista.Fragments.FragmentsMedico.ComentariosFragment;
import com.example.drfind.Vista.Fragments.FragmentsMedico.IniciomedicoFragment;
import com.google.android.material.navigation.NavigationView;

public class menumedico extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    TextView usume,usermenu;
    Bundle usu,usus;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menumedico);
        toolbar=findViewById(R.id.toolbari);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        usu=getIntent().getExtras();
        String datos=usu.getString("usume");
        usume=(TextView)findViewById(R.id.usumedi);
        usume.setText(datos);

        Bundle datosAEnviar = new Bundle();
        datosAEnviar.putString("usuarme",usume.getText().toString());
        Fragment fragmentime=new IniciomedicoFragment();
        fragmentime.setArguments(datosAEnviar);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentime);
        fragmentTransaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        usus=getIntent().getExtras();
        String datin=usus.getString("usume");
        usermenu=(TextView)findViewById(R.id.textnombreusermen);
        usermenu.setText(datin);

        drawerLayout.closeDrawer(GravityCompat.START);

        if(item.getItemId()==R.id.inicio){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuarme",usume.getText().toString());
            Fragment fragmentis=new IniciomedicoFragment();
            fragmentis.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragmentis).addToBackStack(null);
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.citas){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuarme",usume.getText().toString());
            Fragment fragmentis=new CitasmedicoFragment();
            fragmentis.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragmentis);
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.comentarios){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuarme",usume.getText().toString());
            Fragment fragmentis=new ComentariosFragment();
            fragmentis.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragmentis);
            fragmentTransaction.commit();
        }
        return false;
    }
}
