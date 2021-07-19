package com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.comentariosmodelo;
import com.example.drfind.R;

import java.util.List;

public class Adaptadorcomentariosmed extends RecyclerView.Adapter<Adaptadorcomentariosmed.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView usuariome,nombremed,comentario;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usuariome=(TextView)itemView.findViewById(R.id.usuariomedcom);
            nombremed=(TextView)itemView.findViewById(R.id.nombremedcomen);
            comentario=(TextView)itemView.findViewById(R.id.comentamed);
        }

        @Override
        public void onClick(View view) {

        }
    }
    public List<comentariosmodelo> comentariosmodeloList;
    public Adaptadorcomentariosmed(List<comentariosmodelo> comentariosmodeloList){
        this.comentariosmodeloList=comentariosmodeloList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listcomentariosmed,parent,false);
        Adaptadorcomentariosmed.ViewHolder viewHolder= new Adaptadorcomentariosmed.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuariome.setText(comentariosmodeloList.get(position).getUsuariomed());
        holder.nombremed.setText(comentariosmodeloList.get(position).getNombremed());
        holder.comentario.setText(comentariosmodeloList.get(position).getComentario());
    }

    @Override
    public int getItemCount() {
        return comentariosmodeloList.size();
    }


}
