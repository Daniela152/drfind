package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class medicomodelo {
    private String   nombremedi, apellidosmedi,usuariomed,usuariopac;
    Float ratin;
    public medicomodelo(){

    }
    public medicomodelo(String nombremedi,  String apellidosmedi, String usuariomed,String usuariopac, Float ratin){
        this.nombremedi=nombremedi;
        this.apellidosmedi=apellidosmedi;
        this.usuariomed=usuariomed;
        this.usuariopac=usuariopac;
        this.ratin=ratin;
    }

    public String getNombremedi() {
        return nombremedi;
    }

    public void setNombremedi(String nombremedi) {
        this.nombremedi = nombremedi;
    }

    public String getApellidosmedi() {
        return apellidosmedi;
    }

    public void setApellidosmedi(String apellidosmedi) {
        this.apellidosmedi = apellidosmedi;
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

    public Float getRatin() {
        return ratin;
    }

    public void setRatin(Float ratin) {
        this.ratin = ratin;
    }
}
