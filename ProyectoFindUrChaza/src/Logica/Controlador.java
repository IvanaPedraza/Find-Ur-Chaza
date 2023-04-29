/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DataStructures.ArregloDinamicoConCola;
import Modelo.Cliente;

/**
 *
 * @author kelly
 */
public class Controlador {
    
    private ArregloDinamicoConCola arregloDinamicoClientes;
    private ArregloDinamicoConCola arregloDinamicoVendedor;
    
    public Controlador(){
        arregloDinamicoClientes = new ArregloDinamicoConCola();
        arregloDinamicoVendedor = new ArregloDinamicoConCola();
    }
    
    public void agregarNuevoCliente(Cliente cliente){
        arregloDinamicoClientes.pushBack(cliente);
    }
    //Devuelve el cliente borrado
    public Cliente eliminarCliente(Cliente cliente){
        arregloDinamicoClientes.delete(cliente);
        return cliente; 
    }
    
    public void actualizarCliente(Cliente clienteAntiguo, Cliente clienteNuevo){
        arregloDinamicoClientes.update(clienteAntiguo, clienteNuevo);
    }
    
    public void retornarClientes(){
        arregloDinamicoClientes.getElements();
    }
    
    public void retornarCliente(String nombre, String apellido){
        Cliente clientePrueba = new Cliente(nombre, apellido, );
        
    }
    
}
