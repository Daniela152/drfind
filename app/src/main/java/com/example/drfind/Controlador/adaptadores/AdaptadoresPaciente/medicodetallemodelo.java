package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class medicodetallemodelo {
    private String  usuariomed, nombremedi, apellidosmed,telefonomed,e_mailmed,usuariopaci;
    public medicodetallemodelo(){

    }
    public medicodetallemodelo(String usuariomed, String nombremedi, String apellidosmed, String telefonomed, String e_mailmed, String usuariopaci){
        this.usuariomed=usuariomed;
        this.nombremedi=nombremedi;
        this.apellidosmed=apellidosmed;
        this.telefonomed=telefonomed;
        this.e_mailmed=e_mailmed;
        this.usuariopaci=usuariopaci;
    }

    public String getUsuariomed() {
        return usuariomed;
    }

    public void setUsuariomed(String usuariomed) {
        this.usuariomed = usuariomed;
    }

    public String getNombremedi() {
        return nombremedi;
    }

    public void setNombremedi(String nombremedi) {
        this.nombremedi = nombremedi;
    }

    public String getApellidosmed() {
        return apellidosmed;
    }

    public void setApellidosmed(String apellidosmed) {
        this.apellidosmed = apellidosmed;
    }

    public String getTelefonomed() {
        return telefonomed;
    }

    public void setTelefonomed(String telefonomed) {
        this.telefonomed = telefonomed;
    }

    public String getE_mailmed() {
        return e_mailmed;
    }

    public void setE_mailmed(String e_mailmed) {
        this.e_mailmed = e_mailmed;
    }

    public String getUsuariopaci() {
        return usuariopaci;
    }

    public void setUsuariopaci(String usuariopaci) {
        this.usuariopaci = usuariopaci;
    }
}
