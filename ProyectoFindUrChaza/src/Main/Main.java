/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Logica.Controlador2;
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
        
        //Prueba prueba = new Prueba();
        Controlador2 miControlador = new Controlador2();
        miControlador.agregarNuevoCliente("correo1", "nombre1", "apellido1", "telefono1", "contrasena1");
        /*
        Archivo miArchivo = new Archivo<>();
        try
        {
            BufferedReader buffer = miArchivo.leerArchivo("datosClientePrueba.txt");
            String linea;
            while ((linea = buffer.readLine())!=null){
                String[] objeto = linea.split(",");
                miControlador.agregarNuevoCliente(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4]);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Ha ocurrido un error");
        }
*/
        
        //miControlador.imprimirClientes();
        
        
    }
    
}
