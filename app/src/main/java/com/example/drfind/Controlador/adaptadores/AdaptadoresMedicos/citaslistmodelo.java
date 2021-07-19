package com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos;

public class citaslistmodelo {
    String usuariomed,usuariopac,nombepac,apellidopac,fechaci,horaci;
    public citaslistmodelo(){

    }
    public citaslistmodelo(String usuariomed,String usuariopac,String nombepac,String apellidopac,String fechaci,String horaci){
        this.usuariomed=usuariomed;
        this.usuariopac=usuariopac;
        this.nombepac=nombepac;
        this.apellidopac=apellidopac;
        this.fechaci=fechaci;
        this.horaci=horaci;
    }

    public String getUsuariomed() {
        return usuariomed;
    }

    public void setUsuariomed(String usuariomed) {
        this.usuariomed = usuariomed;
    }

    public String getUsuariopac() {
        return usuariopac;
    }

    public void setUsuariopac(String usuariopac) {
        this.usuariopac = usuariopac;
    }

    public String getNombepac() {
        return nombepac;
    }

    public void setNombepac(String nombepac) {
        this.nombepac = nombepac;
    }

    public String getApellidopac() {
        return apellidopac;
    }

    public void setApellidopac(String apellidopac) {
        this.apellidopac = apellidopac;
    }

    public String getFechaci() {
        return fechaci;
    }

    public void setFechaci(String fechaci) {
        this.fechaci = fechaci;
    }

    public String getHoraci() {
        return horaci;
    }

    public void setHoraci(String horaci) {
        this.horaci = horaci;
    }
}
