package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

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
import com.example.drfind.Vista.Fragments.FragmentsPacientes.CitasPacienteFragment;

import java.util.List;

public class Adaptadorsacarcita extends RecyclerView.Adapter<Adaptadorsacarcita.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView id,usuamed,horacita,fechacita,usuapac;
        Button buticit;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            id=(TextView)itemView.findViewById(R.id.txtidcita);
            usuamed = (TextView)itemView.findViewById(R.id.txtusuariomed);
            horacita = (TextView) itemView.findViewById(R.id.txthoracita);
            fechacita=(TextView)itemView.findViewById(R.id.txtfechacita);
            usuapac=(TextView)itemView.findViewById(R.id.txtusuariopac);
            buticit=(Button)itemView.findViewById(R.id.btnhoritacit);
        }
        public void setOnClickLi(){
            buticit.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Pacientes agecit =new Pacientes();
            agecit.agregarcita(Integer.parseInt(id.getText().toString()),usuamed.getText().toString(),horacita.getText().toString(),
                    fechacita.getText().toString(),usuapac.getText().toString());
            Bundle datosmedEnviar = new Bundle();
            datosmedEnviar.putString("usuar",usuapac.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new CitasPacienteFragment();
            fragment.setArguments(datosmedEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        }

    public List<sacarcitamodelo> sacarcitamodeloList;
    public Adaptadorsacarcita(List<sacarcitamodelo> sacarcitamodeloList){
        this.sacarcitamodeloList = sacarcitamodeloList;
    }
    @NonNull
    @Override
    public Adaptadorsacarcita.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listreservacita,parent,false);
        Adaptadorsacarcita.ViewHolder viewHolder= new Adaptadorsacarcita.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(sacarcitamodeloList.get(position).getId());
        holder.usuamed.setText(sacarcitamodeloList.get(position).getUsuarioname());
        holder.horacita.setText(sacarcitamodeloList.get(position).getHoracita());
        holder.fechacita.setText(sacarcitamodeloList.get(position).getFechacita());
        holder.usuapac.setText(sacarcitamodeloList.get(position).getUsuariopac());
        holder.setOnClickLi();
    }
    @Override
    public int getItemCount() {
        return sacarcitamodeloList.size();
    }

}
