/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author kelly
 */
public class Chaza {
    
    private int idChaza;
    private String nombreChaza;
    private String ubicacion;
    private String descripcion;
    private Vendedor vendedor;

    public Chaza(int idChaza, String nombreChaza, String ubicacion, String descripcion, Vendedor vendedor) {
        this.idChaza = idChaza;
        this.nombreChaza = nombreChaza;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.vendedor = vendedor;
    }

    public int getIdChaza() {
        return idChaza;
    }

    public void setIdChaza(int idChaza) {
        this.idChaza = idChaza;
    }

    public String getNombreChaza() {
        return nombreChaza;
    }

    public void setNombreChaza(String nombreChaza) {
        this.nombreChaza = nombreChaza;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    
    
    
    
    
}
