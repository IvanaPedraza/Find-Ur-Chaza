/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.ArregloDinamicoConCola;
import Modelo.Vendedor;

/**
 *
 * @author kelly
 */
public class ControladorVendedor {
    
    private ArregloDinamicoConCola ArregloDinamicoVendedor;
    
    public ControladorVendedor(){
        ArregloDinamicoVendedor = new ArregloDinamicoConCola();
    }

    public ArregloDinamicoConCola getArregloDinamicoVendedor() {
        return ArregloDinamicoVendedor;
    }
    
    public Vendedor iniciarSesionVendedor(String correo, String contrasena) {
        Vendedor vendedorIngreso = new Vendedor();
        Vendedor vendedorRetorno = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIngreso = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            if (vendedorIngreso.getCorreo().equals(correo) && vendedorIngreso.getContrasena().equals(contrasena)) {
                vendedorRetorno = vendedorIngreso;
            } else {
                System.out.println("¡El cliente no existe!");
                vendedorRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorRetorno;
    }
    
    public void agregarNuevoVendedor(String correo, String nombre, String apellido, String telefono, String contrasena) {
        Vendedor nuevoVendedor = new Vendedor(correo, nombre, apellido, telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        ArregloDinamicoVendedor.pushBack(nuevoVendedor);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    
    public Vendedor eliminarVendedor(String correo) {
        Vendedor vendedorAEliminar = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            vendedorAEliminar = buscarVendedorPorCorreo(correo);
            ArregloDinamicoVendedor.delete(vendedorAEliminar);

        } catch (Exception e) {
            System.out.println("El cliente no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorAEliminar;
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
        System.out.println("actualizarCategoriaVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ArregloDinamicoVendedor.update(vendedorAntiguo, vendedorActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarVendedor con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");

    }
    
    public void imprimirVendedor() {
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIterado = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirVendedores con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }
    
    public void buscarVendedor(String nombre, String apellido) {
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIterado = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            if (vendedorIterado.getNombre().equals(nombre) && vendedorIterado.getApellido().equals(apellido)) {
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo());
            } else {
                System.out.println("El vendedor no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Vendedor buscarVendedorPorCorreo(String correo) throws Exception {
        Vendedor vendedorEncontrado = new Vendedor();
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ArregloDinamicoVendedor.getConteo(); i++) {
            vendedorIterado = (Vendedor) ArregloDinamicoVendedor.getElement(i);
            if (vendedorIterado.getCorreo().equals(correo)) {
                vendedorEncontrado = vendedorIterado;
            } else {
                throw new Exception("No existe el cliente");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedorPorCorreo con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorEncontrado;
    }
    
}
