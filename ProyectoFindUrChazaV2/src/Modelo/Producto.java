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
public class Producto {
    
    private long codigo;
    private String nombre;
    private double precio;
    private String detalle;
    private Date fechaIngreso;
    private Date fechaExpiracion;
    private Date fechaEgreso;
    
    public Producto(){
        
    }

    public Producto(long codigo, String nombre, double precio, String detalle, Date fechaIngreso, Date fechaExpiracion, Date fechaEgreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle = detalle;
        this.fechaIngreso = fechaIngreso;
        this.fechaExpiracion = fechaExpiracion;
        this.fechaEgreso = fechaEgreso;
    }
    
    

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
    
    
    
    
}
