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

    public Cliente(String nombre, String apellido,String telefono, String correo, String contraseña) {
        super(nombre, apellido, telefono, correo, contraseña);
    }
}
