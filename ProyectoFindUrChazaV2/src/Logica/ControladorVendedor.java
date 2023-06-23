/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.HashVendedor;
import Modelo.Vendedor;

/**
 *
 * @author kelly
 */
public class ControladorVendedor {
    
    //private ArregloDinamicoConColaVendedor ArregloDinamicoVendedor;
    private HashVendedor hashVendedor;
    
    public ControladorVendedor(){
        //ArregloDinamicoVendedor = new ArregloDinamicoConColaVendedor();
        hashVendedor = new HashVendedor(1000000);
    }

    /*
    public ArregloDinamicoConColaVendedor getArregloDinamicoVendedor() {
        return ArregloDinamicoVendedor;
    }
    */
    public HashVendedor getHashVendedor(){
        return hashVendedor;
    }
    
    public Vendedor iniciarSesionVendedor(String correo, String contrasena) {
        Vendedor vendedorIngreso = new Vendedor();
        Vendedor vendedorRetorno = new Vendedor();
        //long time_start, time_end;
        //time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIngreso = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            if (vendedorIngreso.getCorreo().equals(correo) && vendedorIngreso.getContrasena().equals(contrasena)) {
                vendedorRetorno = vendedorIngreso;
            } else {
                System.out.println("¡El vendedor no existe!");
                vendedorRetorno = null;
            }
        }
        */
        try{
            vendedorIngreso = hashVendedor.get(correo);
            if(vendedorIngreso != null){
                if(vendedorIngreso.getContrasena().equals(contrasena)){
                    vendedorRetorno = vendedorIngreso;
                }
            }else{
                System.out.println("¡El vendedor no existe!");
                vendedorRetorno = null;
            }
        }catch(Exception e){
            System.err.println("Se ha presentado una excepcion");
        }
        //time_end = System.nanoTime();
        //System.out.println("buscarFacturaPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorRetorno;
    }
    
    public void agregarNuevoVendedor(String correo, String nombre, String apellido, String telefono, String contrasena) {
        Vendedor nuevoVendedor = new Vendedor(correo, nombre, apellido, telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        //ArregloDinamicoVendedor.pushBack(nuevoVendedor);
        hashVendedor.insert(correo, nuevoVendedor);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoVendedor con hash table tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    
    public Vendedor eliminarVendedor(String correo) {
        Vendedor vendedorAEliminar = new Vendedor();
        try {
            vendedorAEliminar = buscarVendedorPorCorreo(correo);
            long time_start, time_end;
            time_start = System.nanoTime();
            hashVendedor.remove(correo);
            time_end = System.nanoTime();
            System.out.println("eliminarVendedor con hash table tomo " + (time_end - time_start) + " milliseconds");

        } catch (Exception e) {
            System.out.println("El vendedor no se encontró");
        }
        return vendedorAEliminar;
    }
    
    public void eliminarVendedor() {
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            hashVendedor.makeEmpty();
            time_end = System.nanoTime();
            System.out.println("eliminarVendedor con hash table tomo " + (time_end - time_start) + " milliseconds");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
    }
    
    public Vendedor actualizarCategoriaVendedor(Vendedor vendedorActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Nombre":
                vendedorActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                vendedorActualizar.setApellido(datoModificado);
                break;

            case "Telefono":
                vendedorActualizar.setTelefono(datoModificado);
                break;
            case "Correo":
                vendedorActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                vendedorActualizar.setContrasena(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return vendedorActualizar;
    }
    
    public void actualizarVendedor(String correoVendedorAntiguo, String categoria, String datoModificado) {
        Vendedor vendedorAntiguo = new Vendedor();

        try {
            vendedorAntiguo = buscarVendedorPorCorreo(correoVendedorAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el vendedor, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Vendedor vendedorActualizado = actualizarCategoriaVendedor(vendedorAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaVendedor con hash table tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        //ArregloDinamicoVendedor.update(vendedorAntiguo, vendedorActualizado);
        if(categoria.equals("Correo")){
            hashVendedor.remove(correoVendedorAntiguo);
            hashVendedor.insert(datoModificado, vendedorActualizado);
        }else{
            hashVendedor.insert(correoVendedorAntiguo, vendedorActualizado);
        }
        time_end2 = System.nanoTime();
        System.out.println("actualizarVendedor con hash table tomo " + (time_end2 - time_start2) + " milliseconds");

    }
    
    public void actualizarVendedorCom(String correoVendedor, String nombreVendedor, String apellidoVendedor, String telefonoVendedor){
        Vendedor vendedorAntiguo = new Vendedor();
        try{
            vendedorAntiguo = buscarVendedorPorCorreo(correoVendedor);
        }catch(Exception e){
            System.out.println("No se pudo actualizar el vendedor, porque no existe");
        }
        Vendedor vendedorActualizado = vendedorAntiguo;
        
        vendedorActualizado.setCorreo(correoVendedor);
        vendedorActualizado.setNombre(nombreVendedor);
        vendedorActualizado.setApellido(apellidoVendedor);
        vendedorActualizado.setTelefono(telefonoVendedor);
        
        if(vendedorAntiguo.getCorreo().equals(vendedorActualizado.getCorreo())){
            hashVendedor.remove(correoVendedor);
            hashVendedor.insert(vendedorActualizado.getCorreo(), vendedorActualizado);
        }else{
            hashVendedor.insert(correoVendedor, vendedorActualizado);
        }
    }
    
    public void imprimirVendedor() {
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIterado = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo() + " ");
        }
        */
        hashVendedor.printHashTable();
        time_end = System.nanoTime();
        System.out.println("imprimirVendedores con hash table tomo " + (time_end - time_start) + " milliseconds");
    }
    
    public void buscarVendedor(String nombre, String apellido) {
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIterado = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            if (vendedorIterado.getNombre().equals(nombre) && vendedorIterado.getApellido().equals(apellido)) {
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo());
            } else {
                System.out.println("El vendedor no se ha encontrado");
            }
        }
        */
        try{
            vendedorIterado = hashVendedor.getNA(nombre, apellido);
            if(vendedorIterado != null){
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo() + " " + vendedorIterado.getTelefono());
            }
        }catch(Exception e){
            System.err.println("El vendedor no se ha encontrado");
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedor con hash table tomo " + (time_end - time_start) + " milliseconds");
    }

    public Vendedor buscarVendedorPorCorreo(String correo) throws Exception {
        Vendedor vendedorEncontrado = new Vendedor();
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        /*
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIterado = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            if (vendedorIterado.getCorreo().equals(correo)) {
                vendedorEncontrado = vendedorIterado;
            } else {
                throw new Exception("No existe el cliente");
            }
        }
        */
        try{
            vendedorIterado = hashVendedor.get(correo);
            if(vendedorIterado != null){
                vendedorEncontrado = vendedorIterado;
            }
        }catch(Exception e){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedorPorCorreo con hash table tomo " + (time_end - time_start) + " milliseconds");
        return vendedorEncontrado;
    }
    
}
