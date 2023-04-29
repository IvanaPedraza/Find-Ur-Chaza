/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Logica.Archivo;
import Logica.Controlador;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Grupo 2 Estructuras de Datos G5
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here}
        
        Controlador miControlador = new Controlador();
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        
        miControlador.agregarNuevoCliente("correo1", "nombre1", "apellido1", "contrasena1");
        miControlador.agregarNuevoCliente("correo2", "nombre2", "apellido2", "contrasena2");
        miControlador.agregarNuevoCliente("correo3", "nombre3", "apellido3", "contrasena3");
        miControlador.agregarNuevoCliente("correo4", "nombre4", "apellido4", "contrasena4");
        miControlador.agregarNuevoCliente("correo5", "nombre5", "apellido5", "contrasena5");
        miControlador.agregarNuevoCliente("correo6", "nombre6", "apellido6", "contrasena6");
        miControlador.agregarNuevoCliente("correo7", "nombre7", "apellido7", "contrasena7");
       
        Archivo miArchivo = new Archivo<>();
        try
        {
            BufferedReader buffer = miArchivo.leerArchivo("datosClientePrueba.txt");
            String linea;
            while ((linea = buffer.readLine())!=null){
                String[] objeto = linea.split(",");
                miControlador.agregarNuevoCliente(objeto[0], objeto[1], objeto[2], objeto[3]);
            }
            time_end = System.currentTimeMillis();
            System.out.println("La tarea tomo:  "+ ( time_end - time_start ) +" millisegundos");
        }
        catch(Exception e)
        {
            System.out.println("Ha ocurrido un error");
        }
        
        miControlador.imprimirClientes();
        
        
    }
    
}
