package com.example.drfind.modelo;

        import android.os.StrictMode;

        import java.sql.Connection;
        import java.sql.DriverManager;

public class conexion {
    public Connection conexionbd(){
        Connection connection=null;
        try {
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:jtds:sqlserver://sql5061.site4now.net;databaseName=db_a77026_finddoctor_admin;user=finddoctor;password=Cerdito1602;integratedSecurity=true;");
        } catch (Exception e){
            e.getMessage();
        }
        return connection;
    }
}
