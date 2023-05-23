/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EstructurasDeDatos.AVLChaza;
import Logica.ArchivoChaza;
import Logica.ControladorChaza;
import Modelo.Vendedor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposChaza {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        ControladorChaza miControlador = new ControladorChaza();
        AVLChaza avlChaza = miControlador.getAVLChaza();
        int numElementos;
        
        /*Vendedor Único*/
        Vendedor vendedorActual = new Vendedor("paula@gmail.com", "Paula", "Ramirez", "3103456576", "1234");
        
        /*Archivo de 1 dato de Chaza*/
        /*
        String archivoChaza = "datos1Chaza.csv";
        String archivoNombresChazas = "dato1ChazaNombres.csv";
        numElementos = 1;
        
        /*Archivo de 1K datos de Chaza*/
        /*
        String archivoChaza = "datos1KChaza.csv";
        String archivoNombresChazas = "dato1KChazaNombres.csv";
        numElementos = 10000;
        
        /*Archivo de 10K datos de Chaza*/
        /*
        String archivoChaza = "datos10KChaza.csv";
        String archivoNombresChazas = "dato10KChazaNombres.csv";
        numElementos = 10000;
        
        /*Archivo de 100K datos de Chaza*/
        /*
        String archivoChaza = "datos100KChaza.csv";
        String archivoNombresChazas = "dato100KChazaNombres.csv";
        numElementos = 100000;
        
        /*Archivo de 1M datos de Chaza*/
        
        String archivoChaza = "datos1MChaza.csv";
        String archivoNombresChazas = "dato1MChazaNombres.csv";
        numElementos = 1000000;
        
        /*-----------------INSERCIONES------------------------*/
        
        ArchivoChaza miArchivoChaza = new ArchivoChaza();
        ArchivoChaza miArchivoNombresChaza = new ArchivoChaza();
        BufferedReader bufferChaza = miArchivoChaza.leerArchivo(archivoChaza);
        BufferedReader bufferNombresChaza = miArchivoNombresChaza.leerArchivo(archivoNombresChazas);
        
        try {
            BufferedReader buffer1 = bufferChaza;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine()) != null) {
                String[] objeto = linea.split(";");
                miControlador.agregarNuevaChaza(objeto[0], objeto[1], objeto[2], vendedorActual);
            }
            time_end = System.nanoTime();
            System.out.println("Agregar " + numElementos + " elementos con Arbol AVL - Chazas - tomo " + (time_end - time_start) + " nanosegundos");
            buffer1.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        
        /*-------------ELIMINAR TODAS LAS CHAZAS-------------------*/
        
        try {
            BufferedReader buffer2 = miArchivoChaza.leerArchivo(archivoChaza);
            BufferedReader buffer3 = bufferNombresChaza;
            String linea2;
            String linea3;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea2 = buffer2.readLine()) != null && (linea3 = buffer3.readLine()) != null) {
                String nombreChaza = linea3;
                miControlador.eliminarChaza(nombreChaza);
            }

            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con Arbol AVL - Chazas - tomo " + (time_end - time_start) + " nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            buffer3.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        
        /*----------------ACTUALIZAR CHAZAS----------------------*/
        /*
        try{
            BufferedReader buffer4 = miArchivoChaza.leerArchivo(archivoChaza);
            BufferedReader buffer5Nombres = miArchivoChaza.leerArchivo(archivoNombresChazas);
            String linea; 
            String lineaNombre;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaNombre = buffer5Nombres.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                String nombreActual = lineaNombre;
                //System.out.println(correoActual);
                
                miControlador.actualizarChaza(nombreActual, "Descripcion", "0");
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Nombres.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con Arbol AVL - Chazas - tomó "+ ( time_end - time_start ) +" nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        
        /*---------------------LEER------------------------*/
        //miControlador.imprimirChazas();
        
        /*------------------BUSCAR--------------------------*/
        /*
        try {
            BufferedReader buffer6Nombres = miArchivoChaza.leerArchivo(archivoNombresChazas);
            String linea6;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea6 = buffer6Nombres.readLine()) != null) {
                miControlador.buscarChazaPorNombre(linea6);
            }
            time_end = System.nanoTime();
            System.out.println("Buscar " + numElementos + " elementos con Arbol AVL - Chazas - tomo " + (time_end - time_start) + " nanosegundos");
            buffer6Nombres.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        
    }
    
}
