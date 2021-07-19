package com.example.drfind.Vista.Fragments.FragmentsMedico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos.Adaptadorcomentariosmed;
import com.example.drfind.R;

public class ComentariosFragment extends Fragment {
    private RecyclerView.Adapter Adaptadorcome;
    private RecyclerView recyclerViewcomePacientes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_comentarios, container, false);
        recyclerViewcomePacientes = view.findViewById(R.id.recyclercomenmedico);
        Pacientes come = new Pacientes();
        Bundle userRecuperados = getArguments();
        String useroi = userRecuperados.getString("usuarme");
        recyclerViewcomePacientes.setLayoutManager(new LinearLayoutManager(getContext()));
        Adaptadorcome = new Adaptadorcomentariosmed(come.comentariosmodeloList(useroi));
        recyclerViewcomePacientes.setAdapter(Adaptadorcome);
        return view;
    }
}
