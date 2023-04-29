/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DataStructures.*;
import Modelo.*;

/**
 *
 * @author kelly
 */
public class Controlador {
    
    private ArregloDinamicoConCola arregloDinamicoClientes;
    private ArregloDinamicoConCola arregloDinamicoVendedor;
    private Node nodo;
    private ListaEnlazadaConCola listaEnlazadaColaChazas;
    
    
    public Controlador(){
        arregloDinamicoClientes = new ArregloDinamicoConCola();
        arregloDinamicoVendedor = new ArregloDinamicoConCola();
    }
    
    /*Cliente*/
    
    public Cliente iniciarSesionCliente(String correo, String contrasena){
        Cliente clienteIngreso = new Cliente();
        Cliente clienteRetorno = new Cliente();
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
            clienteIngreso = (Cliente) arregloDinamicoClientes.getElement(i);
            if(clienteIngreso.getCorreo().equals(correo) && clienteIngreso.getContraseña().equals(contrasena)){
                clienteRetorno = clienteIngreso;
            }else{
                System.out.println("¡El cliente no existe!");
                clienteRetorno = null;
            }
        }
        return clienteRetorno;
    }
    
    public void agregarNuevoCliente(String correo, String nombre, String apellido,String contrasena){
        Cliente nuevoCliente = new Cliente(correo, nombre, apellido, contrasena);
        arregloDinamicoClientes.pushBack(nuevoCliente);
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
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
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo()+ " ");
        }
    }
    
    public void buscarCliente(String nombre, String apellido){
        Cliente clienteIterado = new Cliente();
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
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
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
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
    
    public void agregarNuevaChaza(String nombreChaza, String ubicacion, String descripcion, Vendedor vendedor){
        Chaza nuevaChaza = new Chaza(nombreChaza,ubicacion,descripcion,vendedor);
        listaEnlazadaColaChazas.pushBack(nuevaChaza);
        System.out.println("Se ha ingresado correctamente "+ nuevaChaza.getNombreChaza());
    }
    
    public void eliminarChaza(){
        
    }
    
    
    
    /*Comentario*/
    
    
    
    /*Factura*/
    
    
    
    /*Orden*/
    
    
    
    /*Producto*/
    
    
    
    /*Usuario*/
    
    
    /*Vendedor*/
    
    public Vendedor iniciarSesionVendedor(String correo, String contrasena){
        Vendedor vendedorIngreso = new Vendedor();
        Vendedor vendedorRetorno = new Vendedor();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIngreso = (Vendedor) arregloDinamicoVendedor.getElement(i);
            if(vendedorIngreso.getCorreo().equals(correo) && vendedorIngreso.getContraseña().equals(contrasena)){
                vendedorRetorno = vendedorIngreso;
            }else{
                System.out.println("¡El cliente no existe!");
                vendedorRetorno = null;
            }
        }
        return vendedorRetorno;
    }
    
    public void agregarNuevoVendedor(String correo, String nombre, String apellido,String contrasena){
        Vendedor nuevoVendedor = new Vendedor(correo, nombre, apellido, contrasena);
        arregloDinamicoVendedor.pushBack(nuevoVendedor);
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    //Devuelve el cliente borrado
    public Vendedor eliminarCVendedor(String correo){
        Vendedor vendedorAEliminar = new Vendedor();
        try{
            vendedorAEliminar = buscarVendedorPorCorreo(correo);
            arregloDinamicoVendedor.delete(vendedorAEliminar);
            
        }catch(Exception e){
            System.out.println("El cliente no se encontró");
        }
        return vendedorAEliminar; 
    }
    
    public Vendedor actualizarCategoriaVendedor(Vendedor vendedorActualizar, String categoria, String datoModificado){
        switch(categoria){
            case "Nombre":
                vendedorActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                vendedorActualizar.setApellido(datoModificado);
                break;
            case "Correo":
                vendedorActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                vendedorActualizar.setContraseña(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return vendedorActualizar;
    }
    
    public void actualizarVendedor(String correoVendedorAntiguo, String categoria, String datoModificado){
        Vendedor vendedorAntiguo = new Vendedor();
        try{
            vendedorAntiguo = buscarVendedorPorCorreo(correoVendedorAntiguo);
        }catch(Exception e){
            System.out.println("No se pudo actualizar el vendedor, porque no existe");
        }
        Vendedor vendedorActualizado = actualizarCategoriaVendedor(vendedorAntiguo,categoria, datoModificado);
       
        arregloDinamicoClientes.update(vendedorAntiguo, vendedorActualizado);
        
    }
        
    public void imprimirVendedor(){
        Vendedor vendedorIterado = new Vendedor();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIterado = (Vendedor) arregloDinamicoClientes.getElement(i);
            System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo()+ " ");
        }
    }
    
    public void buscarVendedor(String nombre, String apellido){
        Vendedor vendedorIterado = new Vendedor();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIterado = (Vendedor) arregloDinamicoVendedor.getElement(i);
            if(vendedorIterado.getNombre().equals(nombre) && vendedorIterado.getApellido().equals(apellido)){
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo());
            }else{
                System.out.println("El vendedor no se ha encontrado");
            }
        }
    }
    
    public Vendedor buscarVendedorPorCorreo(String correo) throws Exception{
        Vendedor vendedorEncontrado = new Vendedor();
        Vendedor vendedorIterado = new Vendedor();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIterado = (Vendedor) arregloDinamicoClientes.getElement(i);
            if(vendedorIterado.getCorreo().equals(correo)){
                vendedorEncontrado = vendedorIterado;
            }else{
                throw new Exception("No existe el cliente");
            }
        }
        return vendedorEncontrado;
    }
    
    
    
    
    
    
}
