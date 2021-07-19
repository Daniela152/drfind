package com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.Pacientes;
import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsMedico.CitasmedicoFragment;

import java.util.List;

public class Adaptadorlistcitamed extends RecyclerView.Adapter<Adaptadorlistcitamed.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView usuamed,usuariopa,nombrepac,apellidopac,fechaci,horaci;
        Button citaatendi;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            usuamed=(TextView)itemView.findViewById(R.id.usualist);
            nombrepac=(TextView)itemView.findViewById(R.id.nombrepa);
            usuariopa=(TextView)itemView.findViewById(R.id.usuapac);
            apellidopac=(TextView)itemView.findViewById(R.id.apellidospa);
            fechaci=(TextView)itemView.findViewById(R.id.fechapa);
            horaci=(TextView)itemView.findViewById(R.id.horapa);
            citaatendi=(Button)itemView.findViewById(R.id.citaaten);
        }
        public  void setOnClickListeners(){citaatendi.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Pacientes elimci=new Pacientes();
            elimci.eliminarcitapac(usuamed.getText().toString(),fechaci.getText().toString(),horaci.getText().toString(),usuariopa.getText().toString());
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuarme",usuamed.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new CitasmedicoFragment();
            fragment.setArguments(datosAEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
    public List<citaslistmodelo> citaslistmodeloList;
    public Adaptadorlistcitamed(List<citaslistmodelo> citaslistmodeloList){
        this.citaslistmodeloList=citaslistmodeloList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listacitamed,parent,false);
        Adaptadorlistcitamed.ViewHolder viewHolder= new Adaptadorlistcitamed.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuamed.setText(citaslistmodeloList.get(position).getUsuariomed());
        holder.usuariopa.setText(citaslistmodeloList.get(position).getUsuariopac());
        holder.nombrepac.setText(citaslistmodeloList.get(position).getNombepac());
        holder.apellidopac.setText(citaslistmodeloList.get(position).getApellidopac());
        holder.fechaci.setText(citaslistmodeloList.get(position).getFechaci());
        holder.horaci.setText(citaslistmodeloList.get(position).getHoraci());
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
            return citaslistmodeloList.size();
    }

}
