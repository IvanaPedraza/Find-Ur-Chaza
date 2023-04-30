/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import DataStructures.*;

/**
 *
 * @author kelly
 */
public class EstructuraDeDatos2 <T>{
    
    private ArregloDinamicoConCola<T> arregloDinamicoConCola;
    private ListaEnlazada<T> listaEnlazada;
    private ListaEnlazadaConCola<T> listaEnlazadaConCola;

    public EstructuraDeDatos2() {
        this.arregloDinamicoConCola = new ArregloDinamicoConCola<>();
        this.listaEnlazada = new ListaEnlazada<>();
        this.listaEnlazadaConCola = new ListaEnlazadaConCola<>();
    }
    
    public void agregarElemento(T elemento){
        
        /*Arreglo Dinamico Con Cola*/
        /*
        long tiemIniArrDina = System.nanoTime();
        // Ejecutamos el código
        arregloDinamicoConCola.pushBack(elemento);
        long tiemFinArrDina = System.nanoTime();
        long tiempoTotalArrDina = tiemFinArrDina - tiemIniArrDina;
        System.out.println("Tiempo total arreglo dinámico con cola: " + tiempoTotalArrDina + " nanosegundos");
        */
        
        /*Lista enlazada*/
        /*
        long tiemIniListaEnla = System.nanoTime();
        // Ejecutamos el código
        listaEnlazada.pushBack(elemento);
        long tiemFinListaEnla = System.nanoTime();
        long tiempoTotalListaEnla = tiemFinListaEnla - tiemIniListaEnla;
        System.out.println("Tiempo total lista enlazado simple: " + tiempoTotalListaEnla + " nanosegundos");
        */
        /*Lista Enlazada con Cola*/
        /*
        long tiemIniListaEnlaCola = System.nanoTime();
        // Ejecutamos el código
        listaEnlazadaConCola.pushBack(elemento);
        long tiemFinListaEnlaCola = System.nanoTime();
        long tiempoTotalListaEnlaCola = tiemFinListaEnlaCola - tiemIniListaEnlaCola;
        System.out.println("Tiempo total lista enlazada con cola: " + tiempoTotalListaEnlaCola + " nanosegundos");
        */
    }
    
    public void eliminarElemento(T elemento){
        /*Arreglo Dinamico Con Cola*/
        /*
        long tiemIniArrDina = System.nanoTime();
        // Ejecutamos el código
        arregloDinamicoConCola.delete(elemento);
        long tiemFinArrDina = System.nanoTime();
        long tiempoTotalArrDina = tiemFinArrDina - tiemIniArrDina;
        System.out.println("Tiempo total lista arreglo dinámico con cola: " + tiempoTotalArrDina + " nanosegundos");
        */
        /*Lista enlazada*/
        /*
        long tiemIniListaEnla = System.nanoTime();
        // Ejecutamos el código
        listaEnlazada.delete(elemento);
        long tiemFinListaEnla = System.nanoTime();
        long tiempoTotalListaEnla = tiemFinListaEnla - tiemIniListaEnla;
        System.out.println("Tiempo total lista enlazada: " + tiempoTotalListaEnla + " nanosegundos");
        
        /*Lista Enlazada con Cola*/
        /*
        long tiemIniListaEnlaCola = System.nanoTime();
        // Ejecutamos el código
        listaEnlazadaConCola.delete(elemento);
        long tiemFinListaEnlaCola = System.nanoTime();
        long tiempoTotalListaEnlaCola = tiemFinListaEnlaCola - tiemIniListaEnlaCola;
        System.out.println("Tiempo total lista enlazada con cola: " + tiempoTotalListaEnlaCola + " nanosegundos");
        */
    }
    
    public T visualizarElemento(T elemento){
        T elementoRetornado = null;
        /*Arreglo Dinamico Con Cola*/ 
        /*
        long tiemIniArrDina = System.nanoTime();
        // Ejecutamos el código
        elementoRetornado = (T) arregloDinamicoConCola.getElement((int) elemento);
        long tiemFinArrDina = System.nanoTime();
        long tiempoTotalArrDina = tiemFinArrDina - tiemIniArrDina;
        System.out.println("Tiempo total arreglo dinámico con cola: " + tiempoTotalArrDina + " nanosegundos");
        */
        /*Lista enlazada*/
        long tiemIniListaEnla = System.nanoTime();
        // Ejecutamos el código
        elementoRetornado = (T) listaEnlazada.getElement();
        long tiemFinListaEnla = System.nanoTime();
        long tiempoTotalListaEnla = tiemFinListaEnla - tiemIniListaEnla;
        System.out.println("Tiempo total lista enlazada: " + tiempoTotalListaEnla + " nanosegundos");
        
        /*Lista Enlazada con Cola*/
        long tiemIniListaEnlaCola = System.nanoTime();
        // Ejecutamos el código
        elementoRetornado = (T) listaEnlazadaConCola.getElement();
        long tiemFinListaEnlaCola = System.nanoTime();
        long tiempoTotalListaEnlaCola = tiemFinListaEnlaCola - tiemIniListaEnlaCola;
        System.out.println("Tiempo total lista enlazada con cola: " + tiempoTotalListaEnlaCola + " nanosegundos");
        
        return elementoRetornado;
    }
    
    public void ActualizarElemento(T elementoViejo, T elementoNuevo){
        
        /*Arreglo Dinamico Con Cola*/
        /*
        long tiemIniArrDina = System.nanoTime();
        // Ejecutamos el código
        arregloDinamicoConCola.update(elementoViejo, elementoNuevo);
        long tiemFinArrDina = System.nanoTime();
        long tiempoTotalArrDina = tiemFinArrDina - tiemIniArrDina;
        System.out.println("Tiempo total arreglo dinamico con cola: " + tiempoTotalArrDina + " nanosegundos");
        */
        /*Lista enlazada*/
        /*
        long tiemIniListaEnla = System.nanoTime();
        // Ejecutamos el código
        listaEnlazada.ActualizarData(elementoViejo, elementoViejo);
        long tiemFinListaEnla = System.nanoTime();
        long tiempoTotalListaEnla = tiemFinListaEnla - tiemIniListaEnla;
        System.out.println("Tiempo total lista enlazada: " + tiempoTotalListaEnla + " nanosegundos");
        */
        /*Lista Enlazada con Cola*/
        /*
        long tiemIniListaEnlaCola = System.nanoTime();
        // Ejecutamos el código
        listaEnlazadaConCola.ActualizarData(elementoViejo, elementoViejo);
        long tiemFinListaEnlaCola = System.nanoTime();
        long tiempoTotalListaEnlaCola = tiemFinListaEnlaCola - tiemIniListaEnlaCola;
        System.out.println("Tiempo total lista enlazada con cola: " + tiempoTotalListaEnlaCola + " nanosegundos");
        */
    }
    
    public int getConteo(){
        int conteo = 0;
        /*Arreglo Dinamico Con Cola*/
        /*
        long tiemIniArrDina = System.nanoTime();
        // Ejecutamos el código
        conteo = arregloDinamicoConCola.getConteo();
        long tiemFinArrDina = System.nanoTime();
        long tiempoTotalArrDina = tiemFinArrDina - tiemIniArrDina;
        System.out.println("Tiempo total arreglo dinamico con cola: " + tiempoTotalArrDina + " nanosegundos");
        */
        /*Lista enlazada*/
        /*
        long tiemIniListaEnla = System.nanoTime();
        // Ejecutamos el código
        conteo = listaEnlazada.size();
        long tiemFinListaEnla = System.nanoTime();
        long tiempoTotalListaEnla = tiemFinListaEnla - tiemIniListaEnla;
        System.out.println("Tiempo total lista enlazada: " + tiempoTotalListaEnla + " nanosegundos");
        */
        /*Lista Enlazada con Cola*/
        /*
        long tiemIniListaEnlaCola = System.nanoTime();
        // Ejecutamos el código
        conteo = listaEnlazadaConCola.getCantidad();
        long tiemFinListaEnlaCola = System.nanoTime();
        long tiempoTotalListaEnlaCola = tiemFinListaEnlaCola - tiemIniListaEnlaCola;
        System.out.println("Tiempo total lista enlazada con cola: " + tiempoTotalListaEnlaCola + " nanosegundos");
        */
        return conteo;
        
    }
}