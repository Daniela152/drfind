package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class comentariosmodelo {
    private String usuariomed,nombremed,comentario;
    public comentariosmodelo(){

    }
    public comentariosmodelo(String usuariomed,String nombremed,String comentario){
        this.usuariomed=usuariomed;
        this.nombremed=nombremed;
        this.comentario=comentario;
    }

    public String getUsuariomed() {
        return usuariomed;
    }

    public void setUsuariomed(String usuariomed) {
        this.usuariomed = usuariomed;
    }

    public String getNombremed() {
        return nombremed;
    }

    public void setNombremed(String nombremed) {
        this.nombremed = nombremed;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
