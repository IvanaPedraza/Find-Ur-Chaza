/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelly
 */
public class bdCliente {
    private static ControladorCliente controladorCliente = new ControladorCliente();

    public static ControladorCliente getControladorCliente() {
        return controladorCliente;
    }
    
    public bdCliente(){
        iniciarBdCliente();
    }
    
    

    public void iniciarBdCliente() {
        try {
            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(
                    "select correoCliente, nombreCliente, apellidoCliente, telefonoCliente, contrasenaCliente from cliente");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                /*
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
                 */
                controladorCliente.agregarNuevoCliente(rs.getString("correoCliente"), rs.getString("nombreCliente"), rs.getString("apellidoCliente"), rs.getString("telefonoCliente"), rs.getString("contrasenaCliente"));
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la estructura.");
        }
    }
}
