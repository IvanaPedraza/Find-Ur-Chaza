/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EstructurasDeDatos.HashVendedor;
import Logica.ArchivoVendedor;
import Logica.ControladorVendedor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposVendedor {
    public static void main(String[] args) throws FileNotFoundException {
        ControladorVendedor miControlador = new ControladorVendedor();
        HashVendedor hashVendedor = miControlador.getHashVendedor();
        
        int numElementos;
        
        /*Archivo de 1 datos de Vendedor*/
        
        String archivoVendedor = "datos1Vendedor.csv";
        String archivoVendedorCorreo = "dato1VendedorCorreo.csv";
        numElementos = 1;
        
        /*-----------------INSERCIONES------------------------*/
        
        ArchivoVendedor miArchivoVendedor = new ArchivoVendedor();
        ArchivoVendedor miArchivoVendedorCorreo = new ArchivoVendedor();
        BufferedReader bufferVendedor = miArchivoVendedor.leerArchivo(archivoVendedor);
        BufferedReader bufferVendedorCorreo = miArchivoVendedorCorreo.leerArchivo(archivoVendedorCorreo);
        
        try {
            BufferedReader buffer1 = bufferVendedor;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine()) != null) {
                String[] objeto = linea.split(";");
                miControlador.agregarNuevoVendedor(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4]);
            }
            time_end = System.nanoTime();
            System.out.println("Agregar " + numElementos + " elementos con Hash Table Vendedor - tomo " + (time_end - time_start) + " nanosegundos");
            buffer1.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*-------------ELIMINAR TODAS LOS VENDEDOR-------------------*/
        
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            miControlador.eliminarVendedor();
            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con Hash Table Vendedor - tomo " + (time_end - time_start) + " nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*----------------ACTUALIZAR VENDEDOR----------------------*/
        
        try{
            BufferedReader buffer4 = miArchivoVendedor.leerArchivo(archivoVendedor);
            BufferedReader buffer5Correo = miArchivoVendedorCorreo.leerArchivo(archivoVendedorCorreo);
            String linea; 
            String lineaCorreo;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaCorreo = buffer5Correo.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                String correoActual = lineaCorreo;
                //System.out.println(correoActual);
                
                miControlador.actualizarVendedor(correoActual, "Telefono", "0");
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Correo.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con Hash Table Vendedor - tomó "+ ( time_end - time_start ) +" nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*------------------BUSCAR--------------------------*/
        
        try {
            BufferedReader buffer6Correo = miArchivoVendedorCorreo.leerArchivo(archivoVendedorCorreo);
            String linea6;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea6 = buffer6Correo.readLine()) != null) {
                miControlador.buscarVendedorPorCorreo(linea6);
            }
            time_end = System.nanoTime();
            System.out.println("Buscar " + numElementos + " elementos con Hash Table Vendedor - tomo " + (time_end - time_start) + " nanosegundos");
            buffer6Correo.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        
    }
    
}
