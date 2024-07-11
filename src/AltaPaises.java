package com.webapp;

//importamos las librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AltaPaises {
public static void main(String[] args) {
            // Información de conexión
            String url = "jdbc:mysql://localhost:3306/mis_usuarios";
            String usuario = "root";
            String pass = "1234";

            //Interfaces de conexion y ejecucion de codigo SQL
            Connection conexion = null;
            Statement statement = null;

            try {
                //Cargamos el controlador 
                Class.forName("com.mysql.cj.jdbc.Driver");

                //Establecemos la conexion
                conexion = DriverManager.getConnection(url, usuario, pass);
                System.out.println("Conexión exitosa");

                //Generamos la consulta SQL
                String insertarPaisesSQL = "INSERT INTO paises (nombrePais) VALUES "
                    + "('Argentina'), "
                    + "('Uruguay'), "
                    + "('Chile'), "
                    + "('Perú'), "
                    + "('Bolivia'), "
                    + "('Paraguay')";

                // Ejecutamos las clausulas SQL
                statement = conexion.createStatement();
                statement.executeUpdate(insertarPaisesSQL);
                System.out.println("Datos cargados correctamente");

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                // Cerrar los recursos
                try {
                    if (conexion != null) conexion.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
}
