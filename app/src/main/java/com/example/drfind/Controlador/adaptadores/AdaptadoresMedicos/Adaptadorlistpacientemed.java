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

import com.example.drfind.Controlador.Medicos;
import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsMedico.IniciomedicoFragment;

import java.util.List;

public class Adaptadorlistpacientemed extends RecyclerView.Adapter<Adaptadorlistpacientemed.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView usuamed,usuapac,nombrepac,apellidopac,direccionpac,telefonopac,emailpac;
        Button elimpac;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            usuamed=(TextView)itemView.findViewById(R.id.usualistmed);
            usuapac=(TextView)itemView.findViewById(R.id.usuapacmed);
            nombrepac=(TextView)itemView.findViewById(R.id.nombrepac);
            apellidopac=(TextView)itemView.findViewById(R.id.apellidospac);
            direccionpac=(TextView)itemView.findViewById(R.id.direccionpa);
            telefonopac=(TextView)itemView.findViewById(R.id.telefonopa);
            emailpac=(TextView)itemView.findViewById(R.id.e_mailpa);
            elimpac=(Button)itemView.findViewById(R.id.eliminpac);
        }
        public  void setOnClickListeners(){elimpac.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Medicos elimpa=new Medicos();
            elimpa.eliminarpac(usuapac.getText().toString());
            Bundle datosAEnviar = new Bundle();
            datosAEnviar.putString("usuarme",usuamed.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new IniciomedicoFragment();
            fragment.setArguments(datosAEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
    public List<pacientemodelo> pacientemodeloList;
    public Adaptadorlistpacientemed(List<pacientemodelo> pacientemodeloList){
        this.pacientemodeloList=pacientemodeloList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listapacientesmed,parent,false);
        Adaptadorlistpacientemed.ViewHolder viewHolder= new Adaptadorlistpacientemed.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuamed.setText(pacientemodeloList.get(position).getUsuamed());
        holder.usuapac.setText(pacientemodeloList.get(position).getUsuariopac());
        holder.nombrepac.setText(pacientemodeloList.get(position).getNombrepa());
        holder.apellidopac.setText(pacientemodeloList.get(position).getApellidopa());
        holder.direccionpac.setText(pacientemodeloList.get(position).getDireccionpa());
        holder.telefonopac.setText(pacientemodeloList.get(position).getTelfonopa());
        holder.emailpac.setText(pacientemodeloList.get(position).getE_mailpa());
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return pacientemodeloList.size();
    }

}
