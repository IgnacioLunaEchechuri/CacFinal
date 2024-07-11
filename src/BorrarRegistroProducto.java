package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//importar las librerias

public class BorrarRegistroProducto {

    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "1234";

        // Interfaces de conexion y ejecucion de codigo SQL
        Connection conexion = null;
        PreparedStatement declaracion = null;

        try {
            // Cargamos el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexion
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexión exitosa");

            // Creamos la sentencia SQL para borrar una fila o registro
            String sqlBorrar = "DELETE FROM productos WHERE idProducto = ?";

            // Preparamos la declaración
            declaracion = conexion.prepareStatement(sqlBorrar);

            // Seteamos la declaracion
            declaracion.setInt(1, 1);

            // Ejecutamos la declaración
            int filasEliminadas = declaracion.executeUpdate();

            if (filasEliminadas>0) {
                System.out.println("Fila eliminada con éxito");
            } else {
                System.out.println("No se encontró registro, posible id inválido");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (declaracion != null)
                    declaracion.close();
                if (conexion != null)
                    conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
