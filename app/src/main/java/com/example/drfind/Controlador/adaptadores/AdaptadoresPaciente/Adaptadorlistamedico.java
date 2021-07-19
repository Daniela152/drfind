package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.detallemedico;

import java.util.List;

public class Adaptadorlistamedico extends RecyclerView.Adapter<Adaptadorlistamedico.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mediconom,medicoape,usuariomed,usuariopaciente,rat;
        Button btndetalle;
        RatingBar ratver;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            mediconom=(TextView)itemView.findViewById(R.id.nombremedtxt);
            medicoape=(TextView)itemView.findViewById(R.id.apellidostext);
            usuariomed=(TextView)itemView.findViewById(R.id.usuariomedtxt);
            usuariopaciente=(TextView)itemView.findViewById(R.id.usuariopactext);
            ratver=(RatingBar)itemView.findViewById(R.id.ratingmedico);
            btndetalle=(Button)itemView.findViewById(R.id.btndetalle);
            rat=(TextView) itemView.findViewById(R.id.ratin);
            //ratver.setRating(Float.valueOf(rat.getText().toString()));
        }

        public  void setOnClickListeners(){btndetalle.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle datosmedEnviar = new Bundle();
            datosmedEnviar.putString("user",usuariomed.getText().toString());
            datosmedEnviar.putString("usupac",usuariopaciente.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragment=new detallemedico();
            fragment.setArguments(datosmedEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    public List<medicomodelo> medicolista;
    public Adaptadorlistamedico(List<medicomodelo> medicolista){
        this.medicolista=medicolista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listamedicos,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mediconom.setText(medicolista.get(position).getNombremedi());
        holder.medicoape.setText(medicolista.get(position).getApellidosmedi());
        holder.usuariomed.setText(medicolista.get(position).getUsuariomed());
        holder.usuariopaciente.setText(medicolista.get(position).getUsuariopac());
        holder.rat.setText(String.valueOf(medicolista.get(position).getRatin()));
        holder.ratver.setRating(medicolista.get(position).getRatin());
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return medicolista.size();
    }


}
