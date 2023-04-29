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
    
    /*Cliente*/
    
    public void agregarNuevoCliente(String nombre, String apellido, String correo, String contrasena){
        Cliente nuevoCliente = new Cliente(nombre, apellido, correo, contrasena);
        arregloDinamicoClientes.pushBack(nuevoCliente);
        System.out.print("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    //Devuelve el cliente borrado
    public Cliente eliminarCliente(String correo){
        Cliente clienteAEliminar = new Cliente();
        try{
            clienteAEliminar = buscarClientePorCorreo(correo);
            arregloDinamicoClientes.delete(clienteAEliminar);
            
        }catch(Exception e){
            System.out.println("El cliente no se encontró");
        }
        return clienteAEliminar; 
    }
    
    public Cliente actualizarCategoriaCliente(Cliente clienteActualizar, String categoria, String datoModificado){
        switch(categoria){
            case "Nombre":
                clienteActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                clienteActualizar.setApellido(datoModificado);
                break;
            case "Correo":
                clienteActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                clienteActualizar.setContraseña(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return clienteActualizar;
    }
    
    public void actualizarCliente(String correoClienteAntiguo, String categoria, String datoModificado){
        Cliente clienteAntiguo = new Cliente();
        try{
            clienteAntiguo = buscarClientePorCorreo(correoClienteAntiguo);
        }catch(Exception e){
            System.out.println("No se pudo actualizar el cliente, porque no existe");
        }
        Cliente clienteActualizado = actualizarCategoriaCliente(clienteAntiguo,categoria, datoModificado);
       
        arregloDinamicoClientes.update(clienteAntiguo, clienteActualizado);
        
    }
        
    public void imprimirClientes(){
        Cliente clienteIterado = new Cliente();
        for(int i = 0;i < arregloDinamicoClientes.getTamano();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo());
        }
    }
    
    public void buscarCliente(String nombre, String apellido){
        Cliente clienteIterado = new Cliente();
        for(int i = 0;i < arregloDinamicoClientes.getTamano();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            if(clienteIterado.getNombre().equals(nombre) && clienteIterado.getApellido().equals(apellido)){
                System.out.println("El cliente se ha encontrado: ");
                System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo());
            }else{
                System.out.println("El cliente no se ha encontrado");
            }
        }
    }
    
    public Cliente buscarClientePorCorreo(String correo) throws Exception{
        Cliente clienteEncontrado = new Cliente();
        Cliente clienteIterado = new Cliente();
        for(int i = 0;i < arregloDinamicoClientes.getTamano();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            if(clienteIterado.getCorreo().equals(correo)){
                clienteEncontrado = clienteIterado;
            }else{
                throw new Exception("No existe el cliente");
            }
        }
        return clienteEncontrado;
    }
    
    /*Productos*/
    
    
    
    /*Chaza*/
    
    
    
    /*Comentario*/
    
    
    
    /*Factura*/
    
    
    
    /*Orden*/
    
    
    
    /*Producto*/
    
    
    
    /*Usuario*/
    
    
    
    /*Vendedor*/
    
    
    
    
    
    
    
}
