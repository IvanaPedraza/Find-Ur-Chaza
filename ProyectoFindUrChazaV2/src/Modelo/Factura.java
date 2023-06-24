/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author kelly
 */
public class Factura {
    
    private long numReferencia;
    private Date fechaFactura;
    private Producto producto;
    private Orden orden;
    private int cantidad;
    private double costoTotal;

    public Factura() {
    }

    public Factura(long numReferencia, Date fechaFactura, Producto producto, Orden orden, int cantidad, double costoTotal) {
        this.numReferencia = numReferencia;
        this.fechaFactura = fechaFactura;
        this.producto = producto;
        this.orden = orden;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
    }

    public long getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(long numReferencia) {
        this.numReferencia = numReferencia;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
