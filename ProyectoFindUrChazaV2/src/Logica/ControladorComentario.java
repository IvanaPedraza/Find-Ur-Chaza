/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.MinHeapComentario;
import Modelo.Chaza;
import Modelo.Cliente;
import Modelo.Comentario;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class ControladorComentario {
    private MinHeapComentario minHeapComentario;
    
    public ControladorComentario() {
        minHeapComentario = new MinHeapComentario(1000000);
    }

    public MinHeapComentario getMinHeapComentario() {
        return minHeapComentario;
    }
    
    public void agregarNuevoComentario(long idComentario, Date fechaComentario, String contenido, Cliente cliente, Chaza chaza) {
        Comentario nuevoComentario = new Comentario(idComentario, fechaComentario, contenido, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        minHeapComentario.insert(nuevoComentario);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoComentario con min heap tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + idComentario + " " + contenido);

    }
    
    public Comentario actualizarCategoriaComentario(Comentario comentarioActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Contenido":
                comentarioActualizar.setContenido(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return comentarioActualizar;
    }

    public void actualizarComentario(String idComentarioAntiguo, String categoria, String datoModificado) {
        Comentario comentarioAntiguo = new Comentario();
        try {
            comentarioAntiguo = buscarComentarioPorId(Long.parseLong(idComentarioAntiguo));
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el comentario, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Comentario comentarioActualizado = actualizarCategoriaComentario(comentarioAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaComentario con min heap tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        minHeapComentario.update(comentarioAntiguo, comentarioActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarComentario con min heap tomo " + (time_end2 - time_start2) + " milliseconds");

    }

    public void imprimirComentario() {
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        minHeapComentario.printHeap2();
        time_end = System.nanoTime();
        System.out.println("imprimirComentarios con min heap tomo " + (time_end - time_start) + " milliseconds");
    }

    public Comentario buscarComentarioPorId(long idComentario) throws Exception {
        Comentario comentarioEncontrado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            comentarioEncontrado = minHeapComentario.findByIdComentario(idComentario);
            System.out.println("El comentario es: " + comentarioEncontrado.hashCode()+" "+comentarioEncontrado.getFechaComentario()+" "+comentarioEncontrado.getChaza().getNombreChaza());
        }catch(Exception e){
            System.out.println("Ha ocurrido "+e);
        }
        
        if(String.valueOf(comentarioEncontrado.getIdComentario()).length()==0){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarComentarioPorId con min heap tomo " + (time_end - time_start) + " milliseconds");
        return comentarioEncontrado;
    }
}
