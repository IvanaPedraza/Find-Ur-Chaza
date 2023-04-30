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
public class Comentario {
    private long idComentario;
    private Date fechaComentario;
    private String contenido;
    private Cliente cliente;
    private Chaza chaza;
    
    public Comentario(){
        
    }

    public Comentario(long idComentario, Date fechaComentario, String contenido, Cliente cliente, Chaza chaza) {
        this.idComentario = idComentario;
        this.fechaComentario = fechaComentario;
        this.contenido = contenido;
        this.cliente = cliente;
        this.chaza = chaza;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(long idComentario) {
        this.idComentario = idComentario;
    }
    
    
    
    
    
}
