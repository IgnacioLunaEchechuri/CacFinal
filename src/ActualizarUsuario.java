package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//Importamos las librerias

public class ActualizarUsuario {
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

            // Creamos la sentencia SQL para actualizar datos
            String sqlActualizar = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, fkPais = ? WHERE idUsuario = ? ";

            // Preparamos las declaraciones
            declaracion = conexion.prepareStatement(sqlActualizar);

            // Seteamos los valores de cada campo
            declaracion.setString(1, "Nuevo-nombre-01");
            declaracion.setString(2, "Nuevo-apellido-01");
            declaracion.setString(3, "Nuevo-email-01");
            declaracion.setInt(4, 2);

            // Identificamos al usuario que será actualizado
            declaracion.setInt(5, 2);

            // Ejecutamos la actualización
            int filasActualizadas = declaracion.executeUpdate();

            // Comunicamos que la actualizacion fue o no exitosa con un if-else
            if (filasActualizadas > 0) {
                System.out.println("Actualización realizada con éxito");
            } else {
                System.out.println("No se pudo actualizar la tabla");
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
