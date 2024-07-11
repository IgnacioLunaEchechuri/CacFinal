package com.webapp;

//importamos libreria
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerTabla {

    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "1234";

        // Declaramos objetos 
        Connection conexion = null;
        Statement declaracion = null;
        ResultSet resultado = null;

        try {
           // Cargamos el controlador
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           //Establecemos la conexión
           conexion = DriverManager.getConnection(url, usuario, pass);
           System.out.println("Conexión a base de datos: EXITOSA");

           //Creamos una declaracion 
           declaracion = conexion.createStatement();

           // Creamos la consulta
           String sqlTabla = "SELECT * FROM productos";

           // Ejecutamos la sentencia
           resultado = declaracion.executeQuery(sqlTabla);

           //Procesamiento de los resultados mediante un bucle
           while (resultado.next()) {
            // Declaramos variables que nos ayudan con la lectura de la tabla
            int id = resultado.getInt("IdProducto");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("detalle");
            String email = resultado.getString("precio");
            String cantidad = resultado.getString("cantidad");

            // Impresion de los datos obtenidos
            System.out.print(" ID: "+id);
            System.out.print(" nombre: "+nombre);
            System.out.print(" apellido: "+apellido); 
            System.out.print(" email: "+email);
            System.out.println(" Cantidad: "+cantidad);
            System.out.println("-----------------------");
            
           }
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (resultado != null) resultado.close();
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: "+e);
                e.printStackTrace();
            }
        }

    }
}
