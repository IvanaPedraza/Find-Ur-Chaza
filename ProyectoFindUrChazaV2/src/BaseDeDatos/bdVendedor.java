/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorVendedor;
import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author kelly
 */
public class bdVendedor {

    private static ControladorVendedor controladorVendedor = new ControladorVendedor();

    public static ControladorVendedor getControladorVendedor() {
        return controladorVendedor;
    }
    
    public bdVendedor(){
        iniciarBdVendedor();
    }
    
    

    public void iniciarBdVendedor() {
        try {
            Connection cn = Conexion.conectar();

            PreparedStatement pst = cn.prepareStatement(
                    "select correoVendedor, nombreVendedor, apellidoVendedor, telefonoVendedor, contrasenaVendedor from vendedor");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                /*
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
                 */
                controladorVendedor.agregarNuevoVendedor(rs.getString("correoVendedor"), rs.getString("nombreVendedor"), rs.getString("apellidoVendedor"), rs.getString("telefonoVendedor"), rs.getString("contrasenaVendedor"));
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la estructura.");
        }
    }

    

}
