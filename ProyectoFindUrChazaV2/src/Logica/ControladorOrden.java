/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.MinHeapOrden;
import EstructurasDeDatos.PriorityQueueOrden;
import Modelo.Chaza;
import Modelo.Cliente;
import Modelo.Orden;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class ControladorOrden {

    private MinHeapOrden minHeapOrden;
    private static long cantidad = 0;

    public ControladorOrden() {
        minHeapOrden = new MinHeapOrden(1000000);
    }

    public MinHeapOrden getMinHeapOrden() {
        return minHeapOrden;
    }
    
    public Orden agregarNuevaOrden(long numOrden, Date fechaOrden, Cliente cliente, Chaza chaza) {
        Orden nuevaOrden = new Orden(numOrden, fechaOrden, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        minHeapOrden.insert(nuevaOrden);
        cantidad++;
        time_end = System.nanoTime();
        System.out.println("agregarNuevaOrden con min heap tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + numOrden + " " + fechaOrden + " " + cliente + " " + chaza);
        return nuevaOrden;
    }

    public Orden eliminarOrden(long numOrden) {
        Orden ordenAEliminar = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            ordenAEliminar = buscarOrdenPorId(numOrden);
            minHeapOrden.remove(ordenAEliminar);
            cantidad--;
            //System.out.println("la orden es: " + ordenAEliminar.getNumOrden());

        } catch (Exception e) {
            System.out.println("La orden " + numOrden +"no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarOrden con min heap tomo " + (time_end - time_start) + " milliseconds");
        return ordenAEliminar;
    }
    
    public Orden eliminarOrden() {
        Orden ordenAEliminar = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            minHeapOrden.remove();
            cantidad--;
        } catch (Exception e) {
            System.out.println("La orden no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarOrden con min heap tomo " + (time_end - time_start) + " milliseconds");
        return ordenAEliminar;
    }
    
    public Orden actualizarCategoriaOrden(Orden ordenActualizar, String categoria, Object datoModificado) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        switch (categoria) {
            case "Fecha orden":
                try {
                Date fecha = formato.parse(datoModificado.toString());
                ordenActualizar.setFechaOrden(fecha);
            } catch (Exception e) {
                System.out.println("Error en la fecha ingresada");
            }
            break;
            case "Cliente":
                ordenActualizar.setCliente((Cliente) datoModificado);
                break;
            case "Chaza":
                ordenActualizar.setChaza((Chaza) datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return ordenActualizar;
    }
    
    public void actualizarOrden(long numOrdenAntigua, String categoria, Object datoModificado) {
        Orden ordenAntiguo = new Orden();

        try {
            ordenAntiguo = buscarOrdenPorId(numOrdenAntigua);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la orden, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Orden ordenActualizado = actualizarCategoriaOrden(ordenAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaOrden con min heap tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        minHeapOrden.update(ordenAntiguo, ordenActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarOrden con min heap tomo " + (time_end2 - time_start2) + " milliseconds");

    }
    
    public void imprimirOrdenes() {
        long time_start, time_end;
        time_start = System.nanoTime();
        minHeapOrden.printHeap2();
        time_end = System.nanoTime();
        System.out.println("imprimirOrdenes con min heap tomo " + (time_end - time_start) + " milliseconds");
    }

    public Orden buscarOrdenPorId(long numOrden) throws Exception {
        Orden ordenEncontrada = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            ordenEncontrada = minHeapOrden.findByNumOrden(numOrden);
            System.out.println("La orden es: "+numOrden +" "+ordenEncontrada.getNumOrden()+" "+ordenEncontrada.getFechaOrden()+" "+ordenEncontrada.getFechaOrden());
        }catch(Exception e){
            System.out.println("Ha ocurrido aqui "+numOrden + e);
        }
        if(String.valueOf(ordenEncontrada.getNumOrden()).length() == 0){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarOrdenPorId con min heap tomo " + (time_end - time_start) + " milliseconds");
        return ordenEncontrada;
    }
    
    public Orden[] buscarOrdenesPorCliente(Cliente cliente){
        Orden[] ordenes = new Orden[0];
        try{
            ordenes = minHeapOrden.findByCliente(cliente);
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        return ordenes;
    }
    
    public Orden[] buscarOrdenPorFecha(Date fecha) throws Exception {
        Orden[] ordenesEncontrada = new Orden[0];
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            ordenesEncontrada = minHeapOrden.findByFecha(fecha);
            for(int i = 0; i < ordenesEncontrada.length; i++){
                System.out.println("La orden es: "+ordenesEncontrada[i].getNumOrden()+" "+ordenesEncontrada[i].getFechaOrden()+" "+ordenesEncontrada[i].getCliente().getCorreo());
            }
            
        }catch(Exception e){
            System.out.println("Ha ocurrido "+ e);
        }
        if(ordenesEncontrada.length == 0){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarOrdenPorFecha con min heap tomo " + (time_end - time_start) + " milliseconds");
        return ordenesEncontrada;
    }
    
    public Orden[] buscarOrdenPorChaza(Chaza chaza) {
        Orden[] ordenesEncontrada = new Orden[0];
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            ordenesEncontrada = minHeapOrden.findByChaza(chaza);
            for(int i = 0; i < ordenesEncontrada.length; i++){
                System.out.println("La orden es: "+ordenesEncontrada[i].getNumOrden()+" "+ordenesEncontrada[i].getFechaOrden()+" "+ordenesEncontrada[i].getCliente().getCorreo());
            }
            
        }catch(Exception e){
            System.out.println("Ha ocurrido "+ e);
        }
        if(ordenesEncontrada.length == 0){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarOrdenPorChaza con min heap tomo " + (time_end - time_start) + " milliseconds");
        return ordenesEncontrada;
    }
    
    public int numeroOrdenesChaza(Chaza chaza){
        return minHeapOrden.numOrdenChaza(chaza);
    }
    
    public long numeroOrden(){
        return cantidad + 1;
    }
    
    

}
