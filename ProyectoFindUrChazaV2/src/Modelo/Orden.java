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
public class Orden {
    
    private long numOrden;
    private Date fechaOrden;
    private Cliente cliente;
    private Chaza chaza;

    public Orden() {
    }

    public Orden(long numOrden, Date fechaOrden, Cliente cliente, Chaza chaza) {
        this.numOrden = numOrden;
        this.fechaOrden = fechaOrden;
        this.cliente = cliente;
        this.chaza = chaza;
    }
    
    

    public long getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(long numOrden) {
        this.numOrden = numOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Chaza getChaza() {
        return chaza;
    }

    public void setChaza(Chaza chaza) {
        this.chaza = chaza;
    }
    
    
}
