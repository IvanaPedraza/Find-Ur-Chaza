/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EstructurasDeDatos.HashCliente;
import Logica.ControladorCliente;
import java.io.BufferedReader;
import Logica.ArchivoCliente;
import java.io.FileNotFoundException;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposCliente {
    public static void main(String[] args) throws FileNotFoundException {
        ControladorCliente miControlador = new ControladorCliente();
        HashCliente hashCliente = miControlador.getHashCliente();
        
        int numElementos;
        
        /*Archivo de 1 datos de Cliente*/
        
        String archivoCliente = "datos1Cliente.csv";
        String archivoClienteCorreo = "dato1ClienteCorreo.csv";
        numElementos = 1;
        
        /*-----------------INSERCIONES------------------------*/
        
        ArchivoCliente miArchivoCliente = new ArchivoCliente();
        ArchivoCliente miArchivoClienteCorreo = new ArchivoCliente();
        BufferedReader bufferCliente = miArchivoCliente.leerArchivo(archivoCliente);
        BufferedReader bufferClienteCorreo = miArchivoClienteCorreo.leerArchivo(archivoClienteCorreo);
        
        try {
            BufferedReader buffer1 = bufferCliente;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine()) != null) {
                String[] objeto = linea.split(";");
                miControlador.agregarNuevoCliente(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4]);
            }
            time_end = System.nanoTime();
            System.out.println("Agregar " + numElementos + " elementos con Hash Table Cliente - tomo " + (time_end - time_start) + " nanosegundos");
            buffer1.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*-------------ELIMINAR TODAS LOS CLIENTES-------------------*/
        /*
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            miControlador.eliminarCliente();
            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con Hash Table Cliente - tomo " + (time_end - time_start) + " nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        /*----------------ACTUALIZAR CLIENTES----------------------*/
        /*
        try{
            BufferedReader buffer4 = miArchivoCliente.leerArchivo(archivoCliente);
            BufferedReader buffer5Correo = miArchivoClienteCorreo.leerArchivo(archivoClienteCorreo);
            String linea; 
            String lineaCorreo;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaCorreo = buffer5Correo.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                String correoActual = lineaCorreo;
                //System.out.println(correoActual);
                
                miControlador.actualizarCliente(correoActual, "Telefono", "0");
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Correo.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con Hash Table Cliente - tomó "+ ( time_end - time_start ) +" nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        /*------------------BUSCAR--------------------------*/
        /*
        try {
            BufferedReader buffer6Correo = miArchivoClienteCorreo.leerArchivo(archivoClienteCorreo);
            String linea6;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea6 = buffer6Correo.readLine()) != null) {
                miControlador.buscarClientePorCorreo(linea6);
            }
            time_end = System.nanoTime();
            System.out.println("Buscar " + numElementos + " elementos con Hash Table Cliente - tomo " + (time_end - time_start) + " nanosegundos");
            buffer6Correo.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        
    }
    
}
