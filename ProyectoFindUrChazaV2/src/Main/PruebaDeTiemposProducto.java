/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EstructurasDeDatos.AVLProducto;
import Logica.ArchivoChaza;
import Logica.ArchivoProducto;
import Logica.ControladorProducto;
import Modelo.Chaza;
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
public class PruebaDeTiemposProducto {
    public static void main(String[] args) throws FileNotFoundException {
        ControladorProducto miControlador = new ControladorProducto();
        AVLProducto avlChaza = miControlador.getALVProducto();
        int numElementos;
        /*Vendedor unico*/
        Vendedor vendedorActual = new Vendedor("paula@gmail.com", "Paula", "Ramirez", "3103456576", "1234");
        
        /*Chaza unica*/
        
        Chaza chazaActual = new Chaza("ChacitaDelBarrio", "Ingenieria", "Comida rapida", vendedorActual);
        
        /*Archivo de 1 dato de Producto*/
        
        String archivoProducto = "datos1Chaza.csv";
        String archivoIdProductos = "dato1ChazaNombres.csv";
        numElementos = 1;
        
        /*-----------------INSERCIONES------------------------*/
        
        ArchivoProducto miArchivoProducto = new ArchivoProducto();
        ArchivoProducto miArchivoIdProducto = new ArchivoProducto();
        BufferedReader bufferProducto = miArchivoProducto.leerArchivo(archivoProducto);
        BufferedReader bufferIdProducto = miArchivoIdProducto.leerArchivo(archivoNombresProductos);
        
        try {
            BufferedReader buffer1 = bufferProducto;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine()) != null) {
                String[] objeto = linea.split(";");
                miControlador.agregarNuevoProducto(Long.parseLong(objeto[0]), objeto[1], Double.parseDouble(objeto[2]), objeto[3],StringToDate(objeto[4]),StringToDate(objeto[5]),chazaActual);
            }
            time_end = System.nanoTime();
            System.out.println("Agregar " + numElementos + " elementos con Arbol AVL - Productos - tomo " + (time_end - time_start) + " nanosegundos");
            buffer1.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*-------------ELIMINAR TODAS LAS PRODUCTOS-------------------*/
        
        try {
            BufferedReader buffer2 = miArchivoProducto.leerArchivo(archivoProducto);
            BufferedReader buffer3 = bufferIdProducto;
            String linea2;
            String linea3;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea2 = buffer2.readLine()) != null && (linea3 = buffer3.readLine()) != null) {
                long idProducto = Long.parseLong(linea3);
                miControlador.eliminarProducto(idProducto);
            }

            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con Arbol AVL - Producto - tomo " + (time_end - time_start) + " nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            buffer3.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        /*----------------ACTUALIZAR PRODUCTOS----------------------*/

        try{
            BufferedReader buffer4 = miArchivoProducto.leerArchivo(archivoProducto);
            BufferedReader buffer5Id = miArchivoIdProducto.leerArchivo(archivoIdProductos);
            String linea; 
            String lineaId;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaId = buffer5Id.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                long idActual = Long.parseLong(lineaId);
                //System.out.println(correoActual);
                
                miControlador.actualizarProducto(idActual, "Descripcion", "0");
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Id.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con Arbol AVL - Productos - tomó "+ ( time_end - time_start ) +" nanosegundos");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        /*------------------BUSCAR--------------------------*/
        
        try {
            BufferedReader buffer6Id = miArchivoProducto.leerArchivo(archivoIdProductos);
            String linea6;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea6 = buffer6Id.readLine()) != null) {
                miControlador.buscarProductoPorCodigo(Long.parseLong(linea6));
            }
            time_end = System.nanoTime();
            System.out.println("Buscar " + numElementos + " elementos con Arbol AVL - Chazas - tomo " + (time_end - time_start) + " nanosegundos");
            buffer6Id.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
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
