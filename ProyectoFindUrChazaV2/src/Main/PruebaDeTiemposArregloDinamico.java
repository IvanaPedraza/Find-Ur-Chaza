/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import EstructurasDeDatos.ArregloDinamicoConCola;
import Logica.ArchivoArregloDinamico;
import Logica.ControladorArregloDinamico;
import Modelo.Cliente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author kelly
 */
public class PruebaDeTiemposArregloDinamico <T>{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        ControladorArregloDinamico miControlador = new ControladorArregloDinamico();
        ArregloDinamicoConCola arregloActualCliente = miControlador.getArregloDinamicoClientes();
        int numElementos;
        
        /*Archivo de 1 dato de cliente*/
        /*
        String archivoClientes = "datos1Cliente.csv";
        String archivoCorreosClientes = "dato1ClienteCorreo.csv";
        numElementos = 1;
        */
        
        /*Archivo de 10k datos de cliente*/
        /*
        String archivoClientes = "datos10KCliente.csv";
        String archivoCorreosClientes = "dato10KClienteCorreo.csv";
        numElementos = 10000;
        */
        
        /*Archivo de 100k datos de cliente*/
        /*
        String archivoClientes = "datos100KCliente.csv";
        String archivoCorreosClientes = "dato100KClienteCorreo.csv";
        numElementos = 100000;
        */
        
        /*Archivo de 1M datos de cliente*/
        String archivoClientes = "datos1MCliente.csv";
        String archivoCorreosClientes = "dato1MClienteCorreo.csv";
        numElementos = 100000;
        
        /*---------------------------------------------- INSERCIONES ----------------------------------------------*/
        
        /*Agregar Cliente*/
        
        ArchivoArregloDinamico miArchivo = new ArchivoArregloDinamico();
        ArchivoArregloDinamico miArchivoCorreo = new ArchivoArregloDinamico();
        BufferedReader buffer = miArchivo.leerArchivo(archivoClientes);
        
        BufferedReader bufferCorreos = miArchivoCorreo.leerArchivo(archivoCorreosClientes);
        
        try
        {
            BufferedReader buffer1 = buffer;
            String linea;
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea = buffer1.readLine())!=null){
                String[] objeto = linea.split(";");
                miControlador.agregarNuevoCliente(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4]);
            }
            buffer1.close();
            time_end = System.nanoTime();
            System.out.println("Agregar "+ numElementos+ " elementos con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        }
        catch(Exception e)
        {
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        
        /*Eliminar todos los clientes*/
        /*
        try{
            BufferedReader buffer2 = miArchivo.leerArchivo(archivoClientes);
            String linea2; 
            long time_start, time_end;
            time_start = System.nanoTime();
            while ((linea2 = buffer2.readLine())!=null){
                miControlador.eliminarCliente();
            }
            
            time_end = System.nanoTime();
            System.out.println("Eliminar " + numElementos + " elementos con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
            //escribirArchivoCliente(arregloActualCliente, archivoClientes);
            buffer2.close();
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        */
        
        /*Actualizar*/
        /*
        try{
            BufferedReader buffer3 = miArchivo.leerArchivo(archivoClientes);
            BufferedReader buffer4 = buffer3;
            BufferedReader buffer5Correos = bufferCorreos;
            String linea; 
            String lineaCorreos;
            //long telefonoACambiar = 0;
            long time_start, time_end;
            time_start = System.nanoTime();
            
            while ((lineaCorreos = buffer5Correos.readLine())!= null && (linea = buffer4.readLine())!= null){
                //System.out.println(lineaCorreos);
                
                String correoActual = lineaCorreos;
                //System.out.println(correoActual);
                
                miControlador.actualizarCliente(correoActual, "Telefono", String.valueOf(0));
                //telefonoACambiar++;
            }
            buffer4.close();
            buffer5Correos.close();
            
            time_end = System.nanoTime();
            System.out.println("Actualizar "+ numElementos +" elementos con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
            //escribirArchivoCliente(arregloActualCliente, archivoClientes);
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error" + e.toString());
        }
        
        
        
        
        //Cliente clientePrueba = miControlador.buscarClientePorCorreo("ike@mozgi.py");
        //System.out.println(clientePrueba.getNombre()+ " " + clientePrueba.getTelefono());
        
        //miControlador.actualizarCliente("ike@mozgi.py", "Telefono", "0");
        
        /*Leer*/
        miControlador.imprimirClientes();
        
        /*---------------------------------------------------------------------------------------------------------------------*/
        
    }
    
    
    public static void escribirArchivoCliente(ArregloDinamicoConCola arreglo, String archivo){
        String ubicacionArchivo = "C:\\Users\\kelly\\OneDrive\\Documentos\\ProyectoEstructuras\\Find-Ur-Chaza\\ProyectoFindUrChazaV2\\data\\"+archivo;
        File archivoAntiguo = new File(ubicacionArchivo);
        archivoAntiguo.delete();
        File nuevoArchivo = new File(ubicacionArchivo);
        FileWriter archivoSobreEscrito = null;
        try{
            archivoSobreEscrito = new FileWriter(nuevoArchivo, false);
            PrintWriter printW = new PrintWriter(archivoSobreEscrito);
            String objectoIterado = "";
            Cliente elementoActual = new Cliente();
            for(int i = 0; i < arreglo.getConteo();i++){
                elementoActual = (Cliente) arreglo.getElement(i);
                printW.println(elementoActual.getCorreo()+ ";"+elementoActual.getNombre()+";"+elementoActual.getApellido()+";"+elementoActual.getTelefono()+";"+elementoActual.getContraseña());
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido un error " + e.toString());
        }finally{
            try{
                if(archivoSobreEscrito != null){
                    archivoSobreEscrito.close();
                }
            }catch(Exception e2){
                System.out.println("Ha ocurrido un error " + e2.toString());
            }
            
        }
        
    }
    
    
    
    
}
