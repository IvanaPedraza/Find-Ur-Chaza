/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import EstructurasDeDatos.ArregloDinamicoConCola;
import Logica.ArchivoArregloDinamico;
import Logica.ControladorArregloDinamico;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposArregloDinamico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        ControladorArregloDinamico miControlador = new ControladorArregloDinamico();
        ArregloDinamicoConCola arregloActualCliente = miControlador.getArregloDinamicoClientes();
        String archivoClientes = "datosClientePrueba10000.txt";
        
        /*Agregar Cliente*/
        
        ArchivoArregloDinamico miArchivo = new ArchivoArregloDinamico();
        BufferedReader buffer = miArchivo.leerArchivo(archivoClientes);
        try
        {
            BufferedReader buffer1 = buffer;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer.readLine())!=null){
                String[] objeto = linea.split(",");
                miControlador.agregarNuevoCliente(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4]);
            }
            time_end = System.nanoTime();
            System.out.println("Agregar 10.000 elementos con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        }
        catch(Exception e)
        {
            System.out.println("Ha ocurrido un error");
        }
        
        /*Eliminar todos los clientes*/
        try{
            BufferedReader buffer2 = buffer;
            String linea; 
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer.readLine())!=null){
                miControlador.eliminarCliente();
            }
            time_end = System.nanoTime();
            System.out.println("Eliminar 10.000 elementos con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
            
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error");
        }
    }
    
    
    public static void escribirArchivo(ArregloDinamicoConCola arreglo, String archivo){
        File archivoAntiguo = new File(archivo);
        archivoAntiguo.delete();
        File nuevoArchivo = new File(archivo);
        String objectoIterado = "";
        for(int i = 0; i < arreglo.getConteo();i++){
            
        }
        
    }
    
    
    
}
