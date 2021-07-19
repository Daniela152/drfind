package com.example.drfind.Vista.paciente;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.CitasPacienteFragment;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.InicioPacienteFragment;
import com.google.android.material.navigation.NavigationView;

public class menupaciente extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle da,das,dap;
    TextView juju,usermenu;
    boolean cerrar = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupaciente);
        toolbar=findViewById(R.id.toolbari);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        //toolpac.show(this,"",true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        da=getIntent().getExtras();
        String datos=da.getString("usu");
        juju=(TextView)findViewById(R.id.juju);
        juju.setText(datos);

        Bundle datosAEnviar = new Bundle();
        datosAEnviar.putString("usuar",juju.getText().toString());
        Fragment fragmenti=new InicioPacienteFragment();
        fragmenti.setArguments(datosAEnviar);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmenti);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("SALIR");
        builder.setMessage("Esta seguro que desea cerrar la aplicacion");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cerrar = true;
                salirApp(cerrar);
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cerrar = false;
                salirApp(cerrar);
            }
        });
        builder.create();
        builder.show();
    }

    private void salirApp(boolean cerrar) {
        if(cerrar==true){
            Toast.makeText(this,"Vuelva pronto", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }else{
            Toast.makeText(this,"Use el menu para mas opciones", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        das=getIntent().getExtras();
        String datin=das.getString("usu");
        usermenu=(TextView)findViewById(R.id.textnombreusermen);
        usermenu.setText(datin);
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId()==R.id.inicio){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuar",juju.getText().toString());
            Fragment fragmentis=new InicioPacienteFragment();
            fragmentis.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragmentis);
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.citas){
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuar",juju.getText().toString());
            Fragment fragment=new CitasPacienteFragment();
            fragment.setArguments(datosAEnviar);
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

        return false;
    }
}
