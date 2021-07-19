package com.example.drfind.Vista.Fragments.FragmentsPacientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadorcomentarios;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.Adaptadordetallemedico;
import com.example.drfind.R;

public class detallemedico extends Fragment {
    private RecyclerView.Adapter adaptadordetamedico,adaptadorcomen;
    private RecyclerView recyclerViewdetamedico, recyclercomentario;
    private RatingBar ratingBar;
    TextView vara,usame,usuapa;
    EditText comentarios;
    Button publi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detallemedico, container, false);
        recyclerViewdetamedico = view.findViewById(R.id.recyclerdetallemedico);
        recyclercomentario=view.findViewById(R.id.recyclercomentariospac);
        recyclerViewdetamedico.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclercomentario.setLayoutManager(new LinearLayoutManager(getContext()));
        vara=(TextView)view.findViewById(R.id.califica);
        usame=(TextView)view.findViewById(R.id.usuame);
        //recyclercomentario.setNestedScrollingEnabled(false);
        usuapa=(TextView)view.findViewById(R.id.usuapa);
        comentarios=(EditText) view.findViewById(R.id.textcomentarios);
        ratingBar=(RatingBar)view.findViewById(R.id.ratingmedico);
        Bundle bundle=this.getArguments();
        String bu= bundle.getString("user");
        String po=bundle.getString("usupac");
        usame.setText(bu);
        usuapa.setText(po);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
          @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
          vara.setText(""+rating);
          }
         });

        publi=(Button)view.findViewById(R.id.btnpublicar);
        publi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pacientes ratingagreg=new Pacientes();
                ratingagreg.agregratingbar(usame.getText().toString(), vara.getText().toString(),usuapa.getText().toString());
                Pacientes comenagreg=new Pacientes();
                comenagreg.agregarcomentario(usame.getText().toString(), comentarios.getText().toString(),usuapa.getText().toString());
                Bundle datosmedEnviar = new Bundle();
                datosmedEnviar.putString("user",usame.getText().toString());
                datosmedEnviar.putString("usupac",usuapa.getText().toString());
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Fragment fragment=new detallemedico();
                fragment.setArguments(datosmedEnviar);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        Medicos medico = new Medicos();
        Bundle userRecuperados = getArguments();
        String user=userRecuperados.getString("user");
        String usupa=userRecuperados.getString("usupac");
        adaptadordetamedico = new Adaptadordetallemedico(medico.mostrardetallemedi(user,usupa));
        recyclerViewdetamedico.setAdapter(adaptadordetamedico);

        Pacientes pac = new Pacientes();
        Bundle recupe = getArguments();
        String comen=recupe.getString("user");
        adaptadorcomen = new Adaptadorcomentarios(pac.comentariosmodeloList(comen));
        recyclercomentario.setAdapter(adaptadorcomen);
        return view;
    }
}
