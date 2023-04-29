/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author kelly
 */
public class EstructuraDeDatos <T>{
    
    private ArregloDinamicoConCola arregloDinamicoConCola;
    private ListaEnlazada listaEnlazada;
    private ListaEnlazadaConCola listaEnlazadaConCola;
    private Node nodo;
    private ArregloConCola arregloConCola;
    private Tiempo tiempo;

    public EstructuraDeDatos() {
        this.arregloConCola = new ArregloConCola(1);
        this.arregloDinamicoConCola = new ArregloDinamicoConCola();
        this.listaEnlazada = new ListaEnlazada();
        this.listaEnlazadaConCola = new ListaEnlazadaConCola();
        this.tiempo = new Tiempo();
    }
    
    public void agregarElemento(T elemento){
        
        /*Arreglo Dinamico Con Cola*/
        long tiemIniArr = System.nanoTime();
        // Ejecutamos el código
        arregloConCola.(elemento);
        long tiemFinArr = System.nanoTime();
        long tiempoTotalArr = tiemFinArr - tiemIniArr;
        System.out.println("Tiempo total: " + tiempoTotalArr + " nanosegundos");
        
        /*Arreglo Dinamico Con Cola*/
        long tiemIniArrDina = System.nanoTime();
        // Ejecutamos el código
        arregloDinamicoConCola.pushBack(elemento);
        long tiemFinArrDina = System.nanoTime();
        long tiempoTotalArrDina = tiemFinArrDina - tiemIniArrDina;
        System.out.println("Tiempo total: " + tiempoTotalArrDina + " nanosegundos");
        
        /*Lista enlazada*/
        long tiemIniListaEnla = System.nanoTime();
        // Ejecutamos el código
        listaEnlazada.pushBack(elemento);
        long tiemFinListaEnla = System.nanoTime();
        long tiempoTotalListaEnla = tiemFinListaEnla - tiemIniListaEnla;
        System.out.println("Tiempo total: " + tiempoTotalListaEnla + " nanosegundos");
        
        /*Lista Enlazada con Cola*/
        long tiemIniListaEnlaCola = System.nanoTime();
        // Ejecutamos el código
        listaEnlazadaConCola.pushBack(elemento);
        long tiemFinListaEnlaCola = System.nanoTime();
        long tiempoTotalListaEnlaCola = tiemFinListaEnlaCola - tiemIniListaEnlaCola;
        System.out.println("Tiempo total: " + tiempoTotalListaEnlaCola + " nanosegundos");
        
        
        
    }

        
        
    }
    
    
    
    
    
    
    
    
}
