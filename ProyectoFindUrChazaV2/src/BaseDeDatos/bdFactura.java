/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorFactura;
import Modelo.Orden;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kelly
 */
public class bdFactura {
    private static ControladorFactura controladorFactura = new ControladorFactura();
    
    public static ControladorFactura getControladorFactura(){
        return controladorFactura;
    }
    
    public bdFactura(){
        iniciarBdFactura();
    }
    
    public void iniciarBdFactura(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select numReferenciaProd, fechaFactura, idProducto, numOrden, cantidad, costoTotal from factura");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                    Orden ordenActual = bdOrden.getControladorOrden().buscarOrdenPorId(rs.getLong("numOrden"));
                    Producto productoActual = bdProducto.getControladorProducto().buscarProductoPorCodigo(rs.getLong("idProducto"));
                    controladorFactura.agregarNuevaFactura(rs.getLong("numReferenciaProd"), rs.getDate("fechaFactura"), productoActual, ordenActual, rs.getInt("cantidad"), productoActual.getPrecio());
                }catch(Exception d){
                    System.err.println("Error en la asignacion de un producto y una orden");
                }
            }
        }
        catch(SQLException e){
            System.err.println("Error en el llenado de la estructura.");
        }
    }
    
}
