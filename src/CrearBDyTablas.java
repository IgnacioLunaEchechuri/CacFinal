package com.webapp;

//Importacion de librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBDyTablas {

    public static void main(String[] args) {
        // Declaramos variables que nos ayudan con la conexion
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1234";

        // Declaramos objetos que nos ayudan con la conexion y sentencias SQL
        Connection connection = null;
        Statement statement = null;

        try {
            // Este bloque de codigo contiene lo que queremos hacer
            // Cargamos el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Nos conectamos al server 
            connection = DriverManager.getConnection(url, user, password);
            //Inicializamos el objeto statement
            statement = connection.createStatement(); // statement nos ayuda con las "declaraciones" SQL

            // Creamos la base de datos si no existe
            String sql = "CREATE DATABASE IF NOT EXISTS mis_usuarios";
            // Ejecutamos la sentencia
            statement.executeUpdate(sql);
            // Aviso que todo fue ok
            System.out.println("La base de datos mis_usuarios fue creada o existe");

            // Nos conectamos a la base de datos mis_usuarios
            connection = DriverManager.getConnection(url + "mis_usuarios", user, password);
            statement = connection.createStatement();

            // Creamos la tabla paises, SI no existe
            // Clausula SQL
            String crearTablaSQL = "CREATE TABLE IF NOT EXISTS paises ("
                    + "idPais INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombrePais VARCHAR(150) NOT NULL"
                    + ")";

            //Ejecutamos la clausula SQL
            statement.executeUpdate(crearTablaSQL);
            //Aviso de tabla creada
            System.out.println("Tabla creada o existente");

            // Creamos la segunda tabla usuarios (SI NO EXISTE) si existe la deja como está
            // Clausula SQL
            String crearTablaSQL2 = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "idUsuario INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "apellido VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(100) NOT NULL, "
                    + "fkPais INT, "
                    + "FOREIGN KEY (fkPais) REFERENCES paises(idPais)"
                    + ")";

            //Ejecutamos la sentencia SQL
            statement.executeUpdate(crearTablaSQL2);
            //Aviso de todo ok
            System.out.println("Tabla usuarios creada o existente");

            //  tabla productos (SI NO EXISTE) si existe la deja como está
            // Clausula SQL
            String crearTablaSQL3 = "CREATE TABLE IF NOT EXISTS productos ("
                    + "idProducto INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "detalle VARCHAR(255) NOT NULL, "
                    + "precio VARCHAR(100) NOT NULL, "
                    + "cantidad VARCHAR(100) NOT NULL "
                    + ")";

            //Ejecutamos la sentencia SQL
            statement.executeUpdate(crearTablaSQL3);
            //Aviso de todo ok
            System.out.println("Tabla productos creada o existente");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // Cerrar los recursos
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
