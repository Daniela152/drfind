package com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos;

public class pacientemodelo {
    String usuamed,usuariopac,nombrepa,apellidopa,direccionpa,telfonopa,e_mailpa;
    public pacientemodelo(){

    }
    public pacientemodelo(String usuamed,String usuariopac,String nombrepa,String apellidopa,String direccionpa,String telfonopa,String e_mailpa){
        this.usuamed=usuamed;
        this.usuariopac=usuariopac;
        this.nombrepa=nombrepa;
        this.apellidopa=apellidopa;
        this.direccionpa=direccionpa;
        this.telfonopa=telfonopa;
        this.e_mailpa=e_mailpa;
    }

    public String getUsuamed() {
        return usuamed;
    }

    public void setUsuamed(String usuamed) {
        this.usuamed = usuamed;
    }

    public String getUsuariopac() {
        return usuariopac;
    }

    public void setUsuariopac(String usuariopac) {
        this.usuariopac = usuariopac;
    }

    public String getNombrepa() {
        return nombrepa;
    }

    public void setNombrepa(String nombrepa) {
        this.nombrepa = nombrepa;
    }

    public String getApellidopa() {
        return apellidopa;
    }

    public void setApellidopa(String apellidopa) {
        this.apellidopa = apellidopa;
    }

    public String getDireccionpa() {
        return direccionpa;
    }

    public void setDireccionpa(String direccionpa) {
        this.direccionpa = direccionpa;
    }

    public String getTelfonopa() {
        return telfonopa;
    }

    public void setTelfonopa(String telfonopa) {
        this.telfonopa = telfonopa;
    }

    public String getE_mailpa() {
        return e_mailpa;
    }

    public void setE_mailpa(String e_mailpa) {
        this.e_mailpa = e_mailpa;
    }
}
