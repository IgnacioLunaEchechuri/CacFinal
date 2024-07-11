package com.webapp;

//importacion de librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class AltaUsuarios {

    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "1234";

        // Declaracion de los objetos que ayudan con conexion y clausulas SQL
        Connection conexion = null;
        PreparedStatement declaracion = null;
        
        try {
            // Cargamos el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexión
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion a la base de datos: EXITOSA");

            // Creamos la sentencia para cargar datos dentro de la tabla
            String sqlUsuarios = "INSERT INTO usuarios (nombre, apellido,email,fkPais)"+
            "VALUES (?, ?, ?, ?)";

            // Cargamos los datos en la tabla
            declaracion = conexion.prepareStatement(sqlUsuarios);
            declaracion.setString(1, "Nombre 2");
            declaracion.setString(2, "Apellido 2");
            declaracion.setString(3,"email@email2.com");
            declaracion.setInt(4, 3); // 1 es el código de Argentina

            // Ejecutamos la inserción
            int filasInsertadas = declaracion.executeUpdate();

            // Mediante una estructura if comunicamos de la inserción exitosa
            if(filasInsertadas>0){
                System.out.println("Insercion exitosa de datos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
