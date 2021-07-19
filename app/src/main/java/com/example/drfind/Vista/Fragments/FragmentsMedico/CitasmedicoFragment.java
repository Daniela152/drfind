package com.example.drfind.Vista.Fragments.FragmentsMedico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos.Adaptadorlistcitamed;
import com.example.drfind.R;

public class CitasmedicoFragment extends Fragment {
    private RecyclerView.Adapter adaptadorciPacientes;
    private RecyclerView recyclerViewciPacientes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.citasmedicofragment,container,false);
        recyclerViewciPacientes=view.findViewById(R.id.recyclercitasmedico);
        recyclerViewciPacientes.setLayoutManager(new LinearLayoutManager(getContext()));
        Medicos medi=new Medicos();
        Bundle userRecuperados = getArguments();
        String useroi=userRecuperados.getString("usuarme");
        adaptadorciPacientes=new Adaptadorlistcitamed(medi.citaslistmodeloList(useroi));
        recyclerViewciPacientes.setAdapter(adaptadorciPacientes);
        return view;
    }
}
