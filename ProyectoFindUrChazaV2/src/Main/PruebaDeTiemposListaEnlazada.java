/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import EstructurasDeDatos.*;
import Logica.*;
import Modelo.Cliente;
import Modelo.Vendedor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposListaEnlazada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        ControladorListaEnlazada miControlador = new ControladorListaEnlazada();
        ListaEnlazada listaActualVendedor = miControlador.getListaEnlazadaVendedor();
        int numElementos;

        /*Archivo de 1 dato de Vendedor*/
        String archivoVendedor = "datos100KVendedor.csv";
        String archivoCorreosVendedores = "dato100KVendedorCorreo.csv";
        numElementos = 100000;

        /*Archivo de 10k datos de cliente*/
 /*
        String archivoClientes = "datos10KCliente.csv";
        String archivoCorreosClientes = "dato10KClienteCorreo.csv";
        numElementos = 10000;
         */
 /*Archivo de 100k dato de cliente*/
        //   String archivoClientes = "datos100KCliente.csv";
        //  String archivoCorreosClientes = "dato100KClienteCorreo.csv";
        //  numElementos = 100000;

        /*---------------------------------------------- INSERCIONES ----------------------------------------------*/
 /*Agregar Vendedor*/
        ArchivoListaEnlazada miArchivoVendedor = new ArchivoListaEnlazada();
        ArchivoListaEnlazada miArchivoCorreoVendedor = new ArchivoListaEnlazada();
        BufferedReader buffer = miArchivoVendedor.leerArchivo(archivoVendedor);
        BufferedReader bufferCorreos = miArchivoCorreoVendedor.leerArchivo(archivoCorreosVendedores);

         try {
            BufferedReader buffer1 = buffer;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine()) != null) {
                String[] objeto = linea.split(";");
                miControlador.agregarNuevoVendedor(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4]);
            }
            buffer1.close();
            time_end = System.nanoTime();
            System.out.println("Agregar " + numElementos + " elementos con Lista enlazada - Vendedores - tomo " + (time_end - time_start) + " nanoseconds");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        } 
        
        /*---------------------------------------------- INSERCIONES ----------------------------------------------*/

 /*Eliminar todas las Vendedor*/
 /*
     try {
            BufferedReader buffer3 = miArchivoVendedor.leerArchivo(archivoVendedor);
            String linea3;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea3 = buffer3.readLine()) != null) {
                miControlador.eliminarVendedor();
            }

            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con Lista enlazada - Vendedor - tomo " + (time_end - time_start) + " nanoseconds");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            buffer3.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error" + e.toString());
        }

        /*Actualizar Vendedor*/
        
        try{
            BufferedReader buffer4 = miArchivoVendedor.leerArchivo(archivoVendedor);
            BufferedReader buffer5 = buffer4;
            BufferedReader buffer5Nombres = bufferCorreos;
            String linea; 
            String lineaCorreo;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaCorreo = buffer5Nombres.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                String correoActual = lineaCorreo;
                //System.out.println(correoActual);
                
                miControlador.actualizarVendedor(correoActual, "Telefono", "0");
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Nombres.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con Lista enlazada - Vendedor - tomoco "+ ( time_end - time_start ) +" nanoseconds");
           // escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        //Cliente clientePrueba = miControlador.buscarClientePorCorreo("ike@mozgi.py");
        //System.out.println(clientePrueba.getNombre()+ " " + clientePrueba.getTelefono());
        //miControlador.actualizarCliente("ike@mozgi.py", "Telefono", "0");
        /*Leer*/
        /*
        miControlador.imprimirVendedor();

        /*---------------------------------------------------------------------------------------------------------------------*/
    }

    /* public static void escribirArchivoCliente(ArregloDinamicoConCola arreglo, String archivo) {
        String ubicacionArchivo = "C:\\Users\\kelly\\OneDrive\\Documentos\\ProyectoEstructuras\\Find-Ur-Chaza\\ProyectoFindUrChazaV2\\data\\" + archivo;
        File archivoAntiguo = new File(ubicacionArchivo);
        archivoAntiguo.delete();
        File nuevoArchivo = new File(ubicacionArchivo);
        FileWriter archivoSobreEscrito = null;
        try {
            archivoSobreEscrito = new FileWriter(nuevoArchivo, false);
            PrintWriter printW = new PrintWriter(archivoSobreEscrito);
            String objectoIterado = "";
            Cliente elementoActual = new Cliente();
            for (int i = 0; i < arreglo.getConteo(); i++) {
                elementoActual = (Cliente) arreglo.getElement(i);
                printW.println(elementoActual.getCorreo() + ";" + elementoActual.getNombre() + ";" + elementoActual.getApellido() + ";" + elementoActual.getTelefono() + ";" + elementoActual.getContraseña());
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error " + e.toString());
        } finally {
            try {
                if (archivoSobreEscrito != null) {
                    archivoSobreEscrito.close();
                }
            } catch (Exception e2) {
                System.out.println("Ha ocurrido un error " + e2.toString());
            }

        }

    }*/
}
