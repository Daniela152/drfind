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

import com.example.drfind.R;
import com.example.drfind.Vista.Fragments.FragmentsPacientes.Fragmentreservarcita;

import java.util.List;

public class Adaptadordetallemedico  extends RecyclerView.Adapter<Adaptadordetallemedico.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView usuariomed,nombresmed,apellidosmed,telefonomed,emailmed,usuariopaciente;

        Button reservarcita;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            usuariomed=(TextView)itemView.findViewById(R.id.usuariomedicotxt);
            nombresmed=(TextView)itemView.findViewById(R.id.nombremedtxt);
            apellidosmed=(TextView)itemView.findViewById(R.id.apellidosmedicotext);
            telefonomed=(TextView)itemView.findViewById(R.id.telefonomedtxt);
            emailmed=(TextView)itemView.findViewById(R.id.emailmedtxt);
            usuariopaciente=(TextView)itemView.findViewById(R.id.usuariopacientetext);
            reservarcita=(Button)itemView.findViewById(R.id.btnnuevacita);

        }
        public  void setOnClickListeneris(){reservarcita.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Bundle datoscitEnviar = new Bundle();
            datoscitEnviar.putString("usuario",usuariomed.getText().toString());
            datoscitEnviar.putString("usuariopaciente",usuariopaciente.getText().toString());
            AppCompatActivity activity=(AppCompatActivity)view.getContext();
            Fragment fragments=new Fragmentreservarcita();
            fragments.setArguments(datoscitEnviar);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, fragments).commit();
        }
    }

    public List<medicodetallemodelo> medicodetalista;
    public Adaptadordetallemedico(List<medicodetallemodelo> medicodetalista){
        this.medicodetalista=medicodetalista;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listadetallemedico,parent,false);
        Adaptadordetallemedico.ViewHolder viewHolder= new Adaptadordetallemedico.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuariomed.setText(medicodetalista.get(position).getUsuariomed());
        holder.nombresmed.setText(medicodetalista.get(position).getNombremedi());
        holder.apellidosmed.setText(medicodetalista.get(position).getApellidosmed());
        holder.telefonomed.setText(medicodetalista.get(position).getTelefonomed());
        holder.emailmed.setText(medicodetalista.get(position).getE_mailmed());
        holder.usuariopaciente.setText(medicodetalista.get(position).getUsuariopaci());
        holder.setOnClickListeneris();
    }

    @Override
    public int getItemCount() {
        return medicodetalista.size();
    }

}
