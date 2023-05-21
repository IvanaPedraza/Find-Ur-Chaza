/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author kelly
 */
public class Cliente extends Usuario{
    
    public Cliente(){
        
    }

    public Cliente(String correo, String nombre, String apellido, String telefono, String contrasena) {
        super(correo, nombre, apellido, telefono, contrasena);
    }
    
    
}
