/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EstructurasDeDatos.MinHeapOrden;
import Logica.ArchivoOrden;
import Logica.ControladorOrden;
import Modelo.Chaza;
import Modelo.Cliente;
import Modelo.Vendedor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposOrden {
    public static void main(String[] args) throws FileNotFoundException {
        ControladorOrden miControlador = new ControladorOrden();
        MinHeapOrden minHeapOrden = miControlador.getMinHeapOrden();
        int numElementos;
        
        /*Instancias necesarias*/
        Cliente clienteActual = new Cliente("luis@gmail.com", "Luis", "Gonzalez", "3029345656", "321");
        Cliente clienteActual2 = new Cliente("marta@gmail.com", "Luis", "Gonzalez", "3029345656", "321");
        Vendedor vendedorActual = new Vendedor("paula@gmail.com", "Paula", "Ramirez", "3103456576", "1234");        
        Chaza chazaActual = new Chaza("ChacitaDelBarrio", "Ingenieria", "Comida rapida", vendedorActual);

        /*Archivo de 1 dato de Orden*/
        /*
        String archivoOrden = "datos1Orden.csv";
        String archivoIdOrden = "dato1OrdenId.csv";
        numElementos = 1;
        */
        /*Archivo de 1K datos de Orden*/
        
        String archivoOrden = "datos1KOrden.csv";
        String archivoIdOrden = "dato1KOrdenId.csv";
        numElementos = 1;

        /*-----------------INSERCIONES------------------------*/
        
        ArchivoOrden miArchivoOrden = new ArchivoOrden();
        ArchivoOrden miArchivoIdOrden = new ArchivoOrden();
        BufferedReader bufferOrden = miArchivoOrden.leerArchivo(archivoOrden);
        BufferedReader bufferIdOrden = miArchivoIdOrden.leerArchivo(archivoIdOrden);
        
        try {
            BufferedReader buffer1 = bufferOrden;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine()) != null) {
                String[] objeto = linea.split(";");
                miControlador.agregarNuevaOrden(Long.parseLong(objeto[0]), StringToDate(objeto[1]), clienteActual, chazaActual);
            }
            time_end = System.nanoTime();
            System.out.println("Agregar " + numElementos + " elementos con Min Heap - Orden - tomo " + (time_end - time_start) + " nanosegundos");
            buffer1.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*-------------ELIMINAR TODAS LAS ORDENES-------------------*/
        
        try {
            BufferedReader buffer2 = miArchivoOrden.leerArchivo(archivoOrden);
            BufferedReader buffer3 = bufferIdOrden;
            String linea2;
            String linea3;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea2 = buffer2.readLine()) != null && (linea3 = buffer3.readLine()) != null) {
                String idChaza = linea3;
                miControlador.eliminarOrden(Long.parseLong(idChaza));
            }

            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con Min Heap - Orden - tomo " + (time_end - time_start) + " nanosegundos");
           
            buffer3.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*----------------ACTUALIZAR ORDENES----------------------*/
        /*
        try{
            BufferedReader buffer4 = miArchivoOrden.leerArchivo(archivoOrden);
            BufferedReader buffer5Ids = miArchivoOrden.leerArchivo(archivoIdOrden);
            String linea; 
            String lineaId;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaId = buffer5Ids.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                String idActual = lineaId;
                //System.out.println(correoActual);
                
                miControlador.actualizarOrden(Long.parseLong(idActual), "Cliente", clienteActual2);
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Ids.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con Min Heap - Orden - tomó "+ ( time_end - time_start ) +" nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        
        /*------------------BUSCAR--------------------------*/
        /*
        try {
            BufferedReader buffer6Ids = miArchivoOrden.leerArchivo(archivoIdOrden);
            String linea6;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea6 = buffer6Ids.readLine()) != null) {
                miControlador.buscarOrdenPorId(Long.parseLong(linea6));
            }
            time_end = System.nanoTime();
            System.out.println("Buscar " + numElementos + " elementos con Min Heap - Orden - tomo " + (time_end - time_start) + " nanosegundos");
            buffer6Ids.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        
        
    }
    
    static public Date StringToDate(String s) {

        Date result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            result = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return result;
    }
    
}
