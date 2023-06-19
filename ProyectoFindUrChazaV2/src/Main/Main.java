/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import EstructurasDeDatos.MinHeapOrden;
import Logica.ControladorCliente;
import Ventanas.*;

import Modelo.Chaza;
import Modelo.Cliente;
import Modelo.Orden;
import Modelo.Vendedor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Ventanas.App;


/**
 *
 * @author kelly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //App.main(args);

        
        //Aplicacion miAplicacion = new Aplicacion();
        //miAplicacion.iniciarSistema();
        
        //ControladorArregloDinamico miControlador = new ControladorArregloDinamico();
        /*
        miControlador.agregarNuevoCliente("Hola1", "Hola2", "Hola3", "Hola3", "Hola4");
        miControlador.actualizarCliente("Hola1", "Correo", "CORREOO");
        miControlador.imprimirClientes();
        miControlador.eliminarCliente("CORREOO");
        miControlador.imprimirClientes();
        
         */
        /*
        Cliente cliente = new Cliente("lola@gmail.com", "lola", "gomez", "3010001234", "1234");
        Vendedor vendedor = new Vendedor("pepe@gmail.com", "pepe", "lopez", "3135671222", "1235");
        Chaza chaza = new Chaza("chaza", "bogota", "descripcion1", vendedor);

        Orden orden1 = new Orden(1, StringToDate("23-02-2023 10:30:45"), cliente, chaza);
        Orden orden2 = new Orden(2, StringToDate("24-01-2023 10:30:45"), cliente, chaza);
        Orden orden3 = new Orden(3, StringToDate("24-01-2023 10:40:00"), cliente, chaza);
        Orden orden4 = new Orden(4, StringToDate("24-01-2023 11:30:45"), cliente, chaza);
        Orden orden5 = new Orden(5, StringToDate("25-01-2023 10:30:45"), cliente, chaza);
        Orden orden6 = new Orden(6, StringToDate("29-01-2023 10:30:45"), cliente, chaza);
        Orden orden7 = new Orden(7, StringToDate("27-01-2023 10:30:45"), cliente, chaza);
        Orden orden8 = new Orden(8, StringToDate("27-01-2023 10:30:45"), cliente, chaza);
        Orden orden9 = new Orden(9, StringToDate("28-02-2023 10:30:45"), cliente, chaza);
        Orden orden10 = new Orden(10, StringToDate("28-02-2023 12:30:45"), cliente, chaza);
        

        MinHeapOrden cola = new MinHeapOrden(50);
        cola.insert(orden1);
        cola.insert(orden2);
        cola.insert(orden3);
        cola.insert(orden4);
        cola.insert(orden5);
        cola.insert(orden6);
        cola.insert(orden7);
        cola.insert(orden8);
        cola.insert(orden9);
        cola.insert(orden10);

        cola.printHeap2();
        */
        ControladorCliente conCliente = new ControladorCliente();
        conCliente.agregarNuevoCliente("Hola1", "Hola2", "Hola3", "Hola3", "Hola4");
        conCliente.actualizarCliente("Hola1", "Correo", "CORREOO");
        conCliente.imprimirClientes();
        conCliente.eliminarCliente("CORREOO");
        conCliente.imprimirClientes();
        
}
    static public Date StringToDate(String s) {

        Date result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            result = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return result;
    }

}
