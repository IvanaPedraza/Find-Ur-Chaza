/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.ListaEnlazadaConCola;
import Modelo.Factura;
import Modelo.Orden;
import Modelo.Producto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class ControladorFactura {
    
    private ListaEnlazadaConCola ListaEnlazadaConColaFactura;
    
    public ControladorFactura(){
        ListaEnlazadaConColaFactura = new ListaEnlazadaConCola();
    }
    
    public Factura agregarNuevaFactura(long numReferencia, Date fechaFactura, Producto producto, Orden orden, int cantidad, double costoTotal) {
        Factura nuevaFactura = new Factura(numReferencia, fechaFactura, producto, orden, cantidad, costoTotal);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaFactura.pushBack(nuevaFactura);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaFactura con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + numReferencia + " " + orden + " " + producto);
        return nuevaFactura;
    }
    
    public Factura eliminarFactura(long numReferencia) {
        Factura facturaAEliminar = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            facturaAEliminar = buscarFacturaPorId(numReferencia);
            ListaEnlazadaConColaFactura.delete(facturaAEliminar);

        } catch (Exception e) {
            System.out.println("La factura no se encontró" + e);
        }
        time_end = System.nanoTime();
        System.out.println("eliminarFactura con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return facturaAEliminar;
    }
    
    public Factura actualizarCategoriaFactura(Factura facturaActualizar, String categoria, Object datoModificado) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        switch (categoria) {
            case "Fecha factura":
                try {
                Date fecha = formato.parse(datoModificado.toString());
                facturaActualizar.setFechaFactura(fecha);
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error en el ingreso de la fecha, vuelve a intentar");
            }
            break;
            case "Producto":
                facturaActualizar.setProducto((Producto) datoModificado);
                break;
            case "Orden":
                facturaActualizar.setOrden((Orden) datoModificado);
                break;
            case "Cantidad":
                facturaActualizar.setCantidad(Integer.parseInt((String) datoModificado));
                break;
            case "Costo total":
                facturaActualizar.setCostoTotal(Double.parseDouble(datoModificado.toString()));
                break;
             
            default:
                System.out.println("La categoria no es válida");
        }
        return facturaActualizar;
    }
    
    public void actualizarFactura(long referenciaFacturaAntiguo, String categoria, String datoModificado) {
        Factura facturaAntigua = new Factura();
        try {
            facturaAntigua = buscarFacturaPorId(referenciaFacturaAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la factura, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Factura facturaActualizada = actualizarCategoriaFactura(facturaAntigua, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaFactura con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaFactura.ActualizarData(facturaAntigua, facturaActualizada);
        time_end2 = System.nanoTime();
        System.out.println("ListaEnlazadaConColaFactura con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");
    }
    
    

    public void imprimirFactura() {
        Factura facturaIterada = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaFactura.cantidad(); i++) {
            facturaIterada = (Factura) ListaEnlazadaConColaFactura.getElement(i);
            System.out.println(facturaIterada.getNumReferencia() + " " + facturaIterada.getFechaFactura() + " " + facturaIterada.getOrden() + " " + facturaIterada.getProducto());
        }
        time_end = System.nanoTime();
        System.out.println("imprimirFacturas con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Factura buscarFacturaPorId(long referencia) throws Exception {
        Factura facturaEncontrado = new Factura();
        Factura facturaIterado = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaFactura.cantidad(); i++) {
            facturaIterado = (Factura) ListaEnlazadaConColaFactura.getElement(i);
            if (facturaIterado.getNumReferencia() == referencia) {
                facturaEncontrado = facturaIterado;
                break;
            }
        }
        if(facturaEncontrado == null){
            System.out.println("No se encontro la factura");
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return facturaEncontrado;
    }
    
    public boolean existeFactura(long referencia){
        boolean existe = false;
        Factura facturaIterado = new Factura();
        for (int i = 0; i < ListaEnlazadaConColaFactura.cantidad(); i++) {
            facturaIterado = (Factura) ListaEnlazadaConColaFactura.getElement(i);
            if (facturaIterado.getNumReferencia() == referencia) {
                existe = true;
            }
        }
        return existe;
    }
    
    public Factura[] buscarFacturasPorOrden(Orden orden){
        Factura[] facturas = new Factura[cantidadFacturasPorOrden(orden)];
        int iterado = 0;
        Factura facturaIterado = new Factura();
        try{
            for(int i = 0;i < ListaEnlazadaConColaFactura.cantidad();i++){
                facturaIterado = (Factura) ListaEnlazadaConColaFactura.getElement(i);
                if(facturaIterado.getOrden().getNumOrden() == orden.getNumOrden()){
                    facturas[iterado++] = facturaIterado;
                }
            }
            if(facturas.length == 0){
                System.out.println("No hay facturas por la orden");
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        return facturas;
    }
    
    public int cantidadFacturasPorOrden(Orden orden){
        int cantidad = 0;
        Factura facturaIterado = new Factura();
        try{
            for(int i = 0;i < ListaEnlazadaConColaFactura.cantidad();i++){
                facturaIterado = (Factura) ListaEnlazadaConColaFactura.getElement(i);
                if(facturaIterado.getOrden().getNumOrden() == orden.getNumOrden()){
                    cantidad++;
                }
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        return cantidad;
    }
    
    public long cantidadFacturas(){
        return ListaEnlazadaConColaFactura.cantidadLong();
    }
}
