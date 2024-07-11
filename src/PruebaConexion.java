package com.webapp;

//importamos librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PruebaConexion {

    public static void main(String[] args) {
        // Declaracion e inicalizacion de variables
        String url = "jdbc:mysql://localhost:3306/mis_usuarios_24250";
        String usuario = "root";
        String pass = "1234";

        // Declaramos un objeto connection
        Connection conexion = null;

        // Establecemos al conexion dentro de try-catch
        try {
            // Cargamos el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establecemos la comunicacion
            conexion = DriverManager.getConnection(url, usuario, pass);

            System.out.println("Conexión exitosa a Workbench");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e){
            System.out.println(e);
        } finally {
            // Cerrar los recursos
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexión cerrada");
                }
            } catch (SQLException e) {
                System.out.println("Error:"+e);
                e.printStackTrace();
            }
        }




    }
}
