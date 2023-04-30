/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Logica.ArchivoArregloDinamico;
import Logica.ControladorArregloDinamico;
import java.io.BufferedReader;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposArregloDinamico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorArregloDinamico miControlador = new ControladorArregloDinamico();
        
        /*Agregar Cliente*/
        
        ArchivoArregloDinamico miArchivo = new ArchivoArregloDinamico();
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
    }
    
}
