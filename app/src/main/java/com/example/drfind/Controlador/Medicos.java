package com.example.drfind.Controlador;

import com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos.citaslistmodelo;
import com.example.drfind.Controlador.adaptadores.AdaptadoresMedicos.pacientemodelo;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.medicodetallemodelo;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.medicomodelo;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Medicos {
    public void agregarmedico(String usuamedico, String contramedico, String nombremedico, String apamedico,
                              String amamedico, String listespecialidad, String emailmedico, Integer colegiamed,
                              Integer telefomed, String fechanacimientomed){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("insert_medico ?,?,?,?,?,?,?,?,?,?");
            pst.setString(1,usuamedico);
            pst.setString(2,contramedico);
            pst.setString(3,nombremedico);
            pst.setString(4,apamedico);
            pst.setString(5,amamedico);
            pst.setString(6,listespecialidad);
            pst.setString(7,emailmedico);
            pst.setInt(8,colegiamed);
            pst.setInt(9,telefomed);
            pst.setString(10,fechanacimientomed);

            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }
        public List<medicomodelo> mostrarlistmedi(String idespeci,String usuariopac){
        List<medicomodelo> medicos=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("lista_med ?,?");
            pst.setString(1,idespeci);
            pst.setString(2,usuariopac);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                medicos.add(new medicomodelo(rst.getString("nombremedico"),rst.getString("apellidos"), rst.getString("usuariomed"),rst.getString("usuariopac"),rst.getFloat("calificacion")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return medicos;
    }
    public List<medicodetallemodelo> mostrardetallemedi(String usuariomedico,String usuariopac){
        List<medicodetallemodelo> medicos=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("lista_detallemed ?,?");
            pst.setString(1,usuariomedico);
            pst.setString(2,usuariopac);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                medicos.add(new medicodetallemodelo(rst.getString("usuariomed"),rst.getString("nombremedico"),rst.getString("apellidos"),
                        rst.getString("telefonomed"),rst.getString("e_mailmed"),rst.getString("usuariopac")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return medicos;
    }
    public List<pacientemodelo> pacientemodeloList(String usuariom){
        List<pacientemodelo> paciente=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("list_pacientes_med ?");
            pst.setString(1,usuariom);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                paciente.add(new pacientemodelo(rst.getString("usuariomed"),rst.getString("usuariopac"),rst.getString("nombrepac"),rst.getString("apellidospac"),rst.getString("direccionpac"),
                        rst.getString("telefonopac"),rst.getString("e_mailpac")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return paciente;
    }
    public List<citaslistmodelo> citaslistmodeloList(String usuariom){
        List<citaslistmodelo> citame=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("list_citas_medico ?");
            pst.setString(1,usuariom);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                citame.add(new citaslistmodelo(rst.getString("usuariomed"),rst.getString("usuariopac"),rst.getString("nombrepac"),rst.getString("apellidospac"),rst.getString("fechacita"),
                        rst.getString("horacita")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return citame;
    }
    public void eliminarpac (String usuariopac){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("elim_pac ?");
            pst.setString(1,usuariopac);
            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }
}


