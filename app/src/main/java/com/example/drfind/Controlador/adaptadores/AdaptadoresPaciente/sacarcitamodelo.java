package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class sacarcitamodelo {
    String id, usuarioname,horacita,fechacita,usuariopac;
    public sacarcitamodelo(){
    }
    public sacarcitamodelo(String id, String usuarioname,String horacita,String fechacita, String usuariopac){
        this.id=id;
        this.usuarioname=usuarioname;
        this.horacita=horacita;

        this.fechacita=fechacita;
        this.usuariopac=usuariopac;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUsuarioname() {
        return usuarioname;
    }

    public void setUsuarioname(String usuarioname) {
        this.usuarioname = usuarioname;
    }

    public String getHoracita() {
        return horacita;
    }

    public void setHoracita(String horacita) {
        this.horacita = horacita;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public String getUsuariopac() {
        return usuariopac;
    }

    public void setUsuariopac(String usuariopac) {
        this.usuariopac = usuariopac;
    }
}
