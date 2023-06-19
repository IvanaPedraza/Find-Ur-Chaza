/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorChaza;
import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kelly
 */
public class bdChaza {
    private static ControladorChaza controladorChaza = new ControladorChaza();

    public static ControladorChaza getControladorChaza() {
        return controladorChaza;
    }
    
    public bdChaza(){
        iniciarBdChaza();
    }
    
    public void iniciarBdChaza(){
        try
        {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select idChaza, nombreChaza, ubicacionChaza, descripcionChaza, correoVendedor, estadoChaza from chaza");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                    Vendedor vendedorActual = bdVendedor.getControladorVendedor().buscarVendedorPorCorreo(rs.getString("correoVendedor"));
                    controladorChaza.agregarNuevaChaza(rs.getString("nombreChaza"), rs.getString("ubicacionChaza"), rs.getString("descripcionChaza"), vendedorActual);
                }catch(Exception d){
                    System.err.println("Error en la asignacion de un vendedor");
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error en el llenado de la estructura.");
        }
    }
    
}
