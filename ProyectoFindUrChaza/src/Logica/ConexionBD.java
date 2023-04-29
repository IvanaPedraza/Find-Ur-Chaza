/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kelly
 */
public class ConexionBD {

    private Controlador controlador;
    private static String user;
    private static String password;
    private static String bd = "findurchaza";
    private static String host = "localhost";
    private static String server = "jdbc:mysql://" + host + "/" + bd + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode  = false & serverTimezone = UTC";

    Connection conexion = null;

    public void definirUsuarioContra(String user, String password) {
        this.user = user;
        this.password = password;
        System.out.println("Se define: " + user + " " + password);
    }

    public String devolverUsuario() {
        return this.user;
    }

    public void ConexionBD() {
        try {
            //obtener el driver
            Class.forName("com.mysql.jdbc.Driver");
//			//obtener la conexion
            conexion = DriverManager.getConnection(server, user, password);
            if (conexion != null) {
                System.out.println("Conexion Exitosa  a la BD: " + bd);

            }
        } catch (ClassNotFoundException e) {
            System.out.println("ocurre una ClassNotFoundException : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("ocurre una SQLException: " + e.getMessage());
        }

    }

    public Connection getConnection() {
        return conexion;
    }

    public void desconectar() {
        conexion = null;
    }

    public void setCoordinador(Controlador miControlador) {
        this.controlador = miControlador;
    }

}
