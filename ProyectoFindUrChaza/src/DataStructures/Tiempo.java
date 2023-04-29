/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author kelly
 */
public class Tiempo {

    public static void medirTiempo(Runnable runnable) {
        long tiempoInicio = System.nanoTime();
        
        // Ejecutamos el código
        runnable.run();
        
        long tiempoFin = System.nanoTime();
        long tiempoTotal = tiempoFin - tiempoInicio;
        System.out.println("Tiempo total: " + tiempoTotal + " nanosegundos");
    }

    
}
