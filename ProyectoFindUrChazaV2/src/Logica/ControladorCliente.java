/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.HashCliente;
import Modelo.Cliente;

/**
 *
 * @author kelly
 */
public class ControladorCliente {
    //private ArregloDinamicoConColaCliente ArregloDinamicoClientes;
    private HashCliente hashCliente;
    
    public ControladorCliente(){
        //ArregloDinamicoClientes = new ArregloDinamicoConColaCliente();
        hashCliente = new HashCliente(1000000);
    }

    /*
    public ArregloDinamicoConColaCliente getArregloDinamicoClientes() {
        return ArregloDinamicoClientes;
    }
    */
    public HashCliente getHashCliente(){
        return hashCliente;
    }

    public Cliente iniciarSesionCliente(String correo, String contrasena) {
        Cliente clienteIngreso = new Cliente();
        Cliente clienteRetorno = new Cliente();
        //long time_start, time_end;
        //time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoClientes.getConteo(); i++) {
            clienteIngreso = ArregloDinamicoClientes.getElement(i);
            if (clienteIngreso.getCorreo().equals(correo) && clienteIngreso.getContrasena().equals(contrasena)) {
                clienteRetorno = clienteIngreso;
            } else {
                System.out.println("¡El cliente no existe!");
                clienteRetorno = null;
            }
        }
        */
        try{
            clienteIngreso = hashCliente.get(correo);
            if(clienteIngreso != null){
                if(clienteIngreso.getContrasena().equals(contrasena)){
                    clienteRetorno = clienteIngreso;
                }
            }else{
                System.out.println("¡El cliente no existe!");
                clienteRetorno = null;
            }
            
        }catch(Exception e){
            System.err.println("Se ha presentado una excepcion");
        }
        //time_end = System.nanoTime();
        //System.out.println("IniciarSesión con hash table tomo " + (time_end - time_start) + " milliseconds");
        return clienteRetorno;
    }
    
    public void agregarNuevoCliente(String correo, String nombre, String apellido, String telefono, String contrasena) {
        Cliente nuevoCliente = new Cliente(correo, nombre, apellido, telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        //ArregloDinamicoClientes.pushBack(nuevoCliente);
        hashCliente.insert(correo, nuevoCliente);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoCliente con hash table tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    
    public Cliente eliminarCliente(String correo) {
        Cliente clienteAEliminar = new Cliente();
        try {
            clienteAEliminar = buscarClientePorCorreo(correo);
            long time_start, time_end;
            time_start = System.nanoTime();
            //ArregloDinamicoClientes.delete(clienteAEliminar);
            hashCliente.remove(correo);
            time_end = System.nanoTime();
            System.out.println("eliminarCliente con hash table tomo " + (time_end - time_start) + " milliseconds");

        } catch (Exception e) {
            System.out.println("El cliente no se encontró");
        }
        return clienteAEliminar;
    }
    
    public void eliminarCliente() {
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            hashCliente.makeEmpty();
            time_end = System.nanoTime();
            System.out.println("eliminarCliente con hash table tomo " + (time_end - time_start) + " milliseconds");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
    }
    
    public Cliente actualizarCategoriaCliente(Cliente clienteActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Nombre":
                clienteActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                clienteActualizar.setApellido(datoModificado);
                break;
            case "Telefono":
                clienteActualizar.setTelefono(datoModificado);
                break;
            case "Correo":
                clienteActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                clienteActualizar.setContrasena(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return clienteActualizar;
    }
    
    public void actualizarCliente(String correoClienteAntiguo, String categoria, String datoModificado) {
        Cliente clienteAntiguo = new Cliente();
        try {
            clienteAntiguo = buscarClientePorCorreo(correoClienteAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el cliente, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Cliente clienteActualizado = actualizarCategoriaCliente(clienteAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaCliente con hash table tomo " + (time_end - time_start) + " milliseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        //ArregloDinamicoClientes.update(clienteAntiguo, clienteActualizado);
        if(categoria.equals("Correo")){
            hashCliente.remove(correoClienteAntiguo);
            hashCliente.insert(datoModificado, clienteActualizado);
        }else{
            hashCliente.insert(correoClienteAntiguo, clienteActualizado);
        }
        
        time_end2 = System.nanoTime();
        System.out.println("actualizarCliente con hash table tomo " + (time_end2 - time_start2) + " milliseconds");

    }
    
    public void imprimirClientes() {
        long time_start, time_end;
        time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoClientes.getConteo(); i++) {
            clienteIterado = (Cliente) ArregloDinamicoClientes.getElement(i);
            System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo() + " " + clienteIterado.getTelefono());
        }
        */
        hashCliente.printHashTable();
        time_end = System.nanoTime();
        System.out.println("imprimirClientes con hash table tomo " + (time_end - time_start) + " milliseconds");
    }
    
    public void buscarCliente(String nombre, String apellido) {
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoClientes.getConteo(); i++) {
            clienteIterado = (Cliente) ArregloDinamicoClientes.getElement(i);
            if (clienteIterado.getNombre().equals(nombre) && clienteIterado.getApellido().equals(apellido)) {
                System.out.println("El cliente se ha encontrado: ");
                System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo() + " " + clienteIterado.getTelefono());
            } else {
                System.out.println("El cliente no se ha encontrado");
            }
        }
        */
        try{
            clienteIterado = hashCliente.getNA(nombre, apellido);
            if(clienteIterado != null){
                System.out.println("El cliente se ha encontrado: ");
                System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo() + " " + clienteIterado.getTelefono());
            }
        }catch(Exception e){
            System.err.println("El cliente no se ha encontrado");
        }
        time_end = System.nanoTime();
        System.out.println("buscarCliente con hash table tomo " + (time_end - time_start) + " milliseconds");
    }

    public Cliente buscarClientePorCorreo(String correo) {
        Cliente clienteEncontrado = new Cliente();
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoClientes.getConteo(); i++) {
            clienteIterado = (Cliente) ArregloDinamicoClientes.getElement(i);
            if (clienteIterado.getCorreo().equals(correo)) {
                clienteEncontrado = clienteIterado;
            }
        }
        if (clienteEncontrado.getNombre().length() == 0) {
            System.out.println("No se encontro");
        }
        */
        try{
            clienteIterado = hashCliente.get(correo);
            if(clienteIterado != null){
                clienteEncontrado = clienteIterado;
            }
        }catch(Exception e){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarClientePorCorreo con hash table tomo " + (time_end - time_start) + " milliseconds");
        return clienteEncontrado;
    }
    
}
