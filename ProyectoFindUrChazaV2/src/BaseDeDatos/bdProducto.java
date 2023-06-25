/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorProducto;
import Modelo.Chaza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelly
 */
public class bdProducto {
    private static ControladorProducto controladorProducto = new ControladorProducto();
    
    public static ControladorProducto getControladorProducto(){
        return controladorProducto;
    }
    
    public bdProducto(){
        iniciarBdProducto();
    }
    
    public void iniciarBdProducto(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select codigoProducto, nombreProducto, precioProducto, detalleProducto, fechaIngresoProd, fechaEgresoProd, fechaExpiracionProd, idChaza from producto");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                    Chaza chazaNueva = bdChaza.getControladorChaza().buscarChazaPorId(rs.getInt("idChaza"));
                    controladorProducto.agregarNuevoProducto(rs.getLong("codigoProducto"), rs.getString("nombreProducto"), rs.getDouble("precioProducto"), rs.getString("detalleProducto"), rs.getTimestamp("fechaIngresoProd"), rs.getTimestamp("fechaExpiracionProd"), chazaNueva);
                }
                catch(Exception e){
                    System.err.println("Error en la asignacion de una chaza");
                }
            }
        }catch (SQLException e){
            System.err.println("Error en el llenado de la estructura.");
        }
    }
}
