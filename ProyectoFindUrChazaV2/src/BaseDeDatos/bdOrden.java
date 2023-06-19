/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorOrden;
import Modelo.Chaza;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelly
 */
public class bdOrden {
    private static ControladorOrden controladorOrden = new ControladorOrden();
    
    public static ControladorOrden getControladorOrden(){
        return controladorOrden;
    }
    
    public bdOrden(){
        iniciarBdOrden();
    }
    
    public void iniciarBdOrden(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select numOrden, fechaOrden, correoCliente, idChaza from orden");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                Cliente clienteNuevo = bdCliente.getControladorCliente().buscarClientePorCorreo(rs.getString("correoCliente"));
                Chaza chazaNueva = bdChaza.getControladorChaza().buscarChazaPorId(rs.getInt("idChaza"));
                controladorOrden.agregarNuevaOrden(rs.getLong("numOrden"), rs.getDate("fechaOrden"), clienteNuevo, chazaNueva);
                }
                catch(Exception d){
                    System.err.println("Error en la asignacion de un cliente y una chaza");
                }
            }
        }catch(SQLException e){
            System.err.println("Error en el llenado de la estructura.");
        }
    }
    
}
