/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import Logica.ControladorComentario;
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
public class bdComentario {
    private static ControladorComentario controladorComentario = new ControladorComentario();
    
    public static ControladorComentario getControladorComentario(){
        return controladorComentario;
    }
    
    public bdComentario(){
        iniciarBdComentario();
    }
    
    public void iniciarBdComentario(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
            "select idComentario, fechaComentario, contenidoComentario, correoCliente, idChaza from comentario");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                    Cliente clienteNuevo = bdCliente.getControladorCliente().buscarClientePorCorreo(rs.getString("correoCliente"));
                    Chaza chazaNueva = bdChaza.getControladorChaza().buscarChazaPorId(rs.getInt("idChaza"));
                    controladorComentario.agregarNuevoComentario(rs.getLong("idComentario"), rs.getDate("fechaComentario"), rs.getString("contenidoComentario"), clienteNuevo, chazaNueva);
                }catch(Exception d){
                    System.err.println("Error en la asignacion de un cliente y una chaza");
                }
            }
        }catch(SQLException e){
            System.err.println("Error en el llenado de la estructura.");
        }
    }
    
}
