/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.AVLChaza;
import Modelo.Chaza;
import Modelo.Vendedor;

/**
 *
 * @author kelly
 */
public class ControladorChaza {
    private AVLChaza AVLChaza;
    
    public ControladorChaza(){
        AVLChaza = new AVLChaza();
    }

    public AVLChaza getAVLChaza() {
        return AVLChaza;
    }
    
    public void agregarNuevaChaza(String nombreChaza, String ubicacion, String descripcion, Vendedor vendedor) {
        Chaza nuevaChaza = new Chaza(nombreChaza, ubicacion, descripcion, vendedor);
        long time_start, time_end;
        time_start = System.nanoTime();
        AVLChaza.insert(nuevaChaza);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaChaza con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente " + nuevaChaza.getNombreChaza());
    }
    
    public Chaza eliminarChaza(String nombreChaza) {
        Chaza chazaAEliminar = new Chaza();
        try {
            //long time_start, time_end;
            //time_start = System.nanoTime();
            chazaAEliminar = buscarChazaPorNombre(nombreChaza);
            AVLChaza.remove(chazaAEliminar);
            //time_end = System.nanoTime();
            //System.out.println("eliminarChaza con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        } catch (Exception e) {
            System.out.println("La chaza no se encontró " + e);
        }

        return chazaAEliminar;
    }
    
    
    public Chaza actualizarCategoriaChaza(Chaza chazaActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Nombre":
                chazaActualizar.setNombreChaza(datoModificado);
                break;
            case "Ubicacion":
                chazaActualizar.setUbicacion(datoModificado);
                break;
            case "Descripcion":
                chazaActualizar.setDescripcion(datoModificado);
                break;
            case "Estado de chaza":
                chazaActualizar.setEstadoChaza(Integer.parseInt(datoModificado));
            default:
                System.out.println("La categoria no es válida");
        }
        return chazaActualizar;
    }
    
    public void actualizarChaza(String nombreChazaAntiguo, String categoria, String datoModificado) {
        Chaza chazaAntigua = new Chaza();

        try {
            chazaAntigua = buscarChazaPorNombre(nombreChazaAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la chaza, porque no existe");
        }
        //long time_start, time_end;
        //time_start = System.nanoTime();
        Chaza chazaActualizada = actualizarCategoriaChaza(chazaAntigua, categoria, datoModificado);
        //time_end = System.nanoTime();
        //System.out.println("actualizarCategoriaChaza con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        //long time_start2, time_end2;
        //time_start2 = System.nanoTime();
        AVLChaza.update(chazaAntigua, chazaActualizada);
        //time_end2 = System.nanoTime();
        //System.out.println("actualizarChaza con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");
    }
    
    public void imprimirChazas() {
        Chaza chazaIterado = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        AVLChaza.levelTraversal();
        time_end = System.nanoTime();
        System.out.println("imprimirChazas con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
    }
    
    public Chaza buscarChazaPorNombre(String nombreChaza) throws Exception {
        Chaza chazaEncontrada = new Chaza();
        //long time_start, time_end;
        //time_start = System.nanoTime();
        try{
            chazaEncontrada = AVLChaza.findByName(nombreChaza);
            System.out.println("La chaza es: " + chazaEncontrada.getNombreChaza()+ " "+chazaEncontrada.getUbicacion()+" "+chazaEncontrada.getDescripcion());
            
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        if (chazaEncontrada.getNombreChaza().length() == 0) {
            System.out.println("No se encontro");
        }
        //time_end = System.nanoTime();
        //System.out.println("buscarChazaPorNombre con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return chazaEncontrada;
    }
    
    public Chaza buscarChazaPorId(int idChaza) throws Exception {
        Chaza chazaEncontrada = new Chaza();
        //long time_start, time_end;
        //time_start = System.nanoTime();
        try{
            chazaEncontrada = AVLChaza.findById(idChaza);
            System.out.println("La chaza es: " + chazaEncontrada.getNombreChaza());
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        if (chazaEncontrada.getNombreChaza().length() == 0) {
            System.out.println("No se encontro");
        }
        //time_end = System.nanoTime();
        //System.out.println("buscarChazaPorNombre con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return chazaEncontrada;
    }
    
    
    
    public void buscarChazasPorVendedor(Vendedor vendedor) {
        //Chaza chazaEncontrada = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            Chaza[] chazas = AVLChaza.findByVendedor(vendedor);
            if(chazas.length != 0){
                for(int i = 0;i<chazas.length;i++){
                    System.out.println("La chaza es: " + chazas[i].getNombreChaza() + " "+ chazas[i].getUbicacion()+" "+chazas[i].getDescripcion());
                }
            }else{
                System.out.println("No hay chazas");
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido " + e);
        }
        
        time_end = System.nanoTime();
        System.out.println("buscarChazaPorVendedor con arbol AVL tomo " + (time_end - time_start) + " milliseconds");
        
    }
    
    public int numeroChazasPorVendedor(Vendedor vendedor) {
        int numeroChazas = AVLChaza.numChazaVendedor(AVLChaza.getRoot(),vendedor);
        if(numeroChazas == 0){
            System.out.println("Ninguna chaza");
        }
        return numeroChazas;
    }
    
    
    
}
