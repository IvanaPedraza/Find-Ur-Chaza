/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.AVLProducto;
import Modelo.Chaza;
import Modelo.Producto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class ControladorProducto {
    private AVLProducto AVLProducto;
    
    public ControladorProducto(){
        AVLProducto = new AVLProducto();
    }

    public AVLProducto getALVProducto() {
        return AVLProducto;
    }
    
    public void agregarNuevoProducto(long codigo, String nombre, double precio, String detalle, Date fechaIngreso, Date fechaExpiracion, Chaza chaza) {
        Producto nuevoProducto = new Producto(codigo, nombre, precio, detalle, fechaIngreso, fechaExpiracion, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        AVLProducto.insert(nuevoProducto);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoProducto con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente " + nuevoProducto.getNombre());
    }
    
    public Producto eliminarProducto(long codigoProducto) {
        Producto productoAEliminar = new Producto();
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            productoAEliminar = buscarProductoPorCodigo(codigoProducto);
            AVLProducto.remove(productoAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarProducto con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        } catch (Exception e) {
            System.out.println("El producto no se encontró");
        }
        return productoAEliminar;
    }
    
    
    
    public Producto actualizarCategoriaProducto(Producto productoActualizar, String categoria, String datoModificado) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        switch (categoria) {
            case "Nombre":
                productoActualizar.setNombre(datoModificado);
                break;
            case "Precio":
                productoActualizar.setPrecio(Double.parseDouble(datoModificado));
                break;
            case "Detalle":
                productoActualizar.setDetalle(datoModificado);
                break;
            case "Fecha ingreso":
                Date fecha = formato.parse(datoModificado);
                productoActualizar.setFechaIngreso(fecha);
                break;
            case "Fecha expiracion":
                Date fecha2 = formato.parse(datoModificado);
                productoActualizar.setFechaIngreso(fecha2);
                break;
            case "Fecha egreso":
                Date fecha3 = formato.parse(datoModificado);
                productoActualizar.setFechaIngreso(fecha3);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return productoActualizar;
    }
    
    public void actualizarProducto(long codigoProducto, String categoria, String datoModificado) {
        Producto productoAntiguo = new Producto();
        try {
            productoAntiguo = buscarProductoPorCodigo(codigoProducto);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el producto, porque no existe");
        }
        Producto productoActualizado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            productoActualizado = actualizarCategoriaProducto(productoAntiguo, categoria, datoModificado);
        } catch (ParseException ex) {
            System.out.println("Error " + ex);
        }
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaProducto con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        AVLProducto.update(productoAntiguo, productoActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarProducto con arbol AVL tomo " + (time_end2 - time_start2) + " milliseconds");
    }
    
    public void imprimirProductos() {
        long time_start, time_end;
        time_start = System.nanoTime();
        AVLProducto.levelTraversal();
        time_end = System.nanoTime();
        System.out.println("imprimirProductos con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
    }
    
    public Producto buscarProductoPorCodigo(long codigo) throws Exception {
        Producto productoEncontrado= new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            productoEncontrado = AVLProducto.findByCode(codigo);
            System.out.println("El producto es: " + productoEncontrado.getCodigo()+ " "+productoEncontrado.getNombre());
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        if(productoEncontrado.getNombre().length() == 0){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarProductoPorCodigo con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
        return productoEncontrado;
    }
    
    public Producto[] buscarProductosPorChaza(Chaza chaza){
        Producto[] productos = new Producto[0];
        try{
            productos = AVLProducto.findByChaza(chaza);
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        return productos;
    }
    
    public int numeroProductosPorChaza(Chaza chaza){
        int numeroProductos = AVLProducto.numProductoChaza(AVLProducto.getRoot(), chaza);
        if(numeroProductos == 0){
            System.out.println("Ningún producto");
        }
        return numeroProductos;
    }
    
    public int numeroTotalProductos(){
        return AVLProducto.numtotalProducto();
    }
    
    
}
