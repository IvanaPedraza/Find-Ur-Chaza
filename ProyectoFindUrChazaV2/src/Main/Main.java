/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Logica.ControladorArregloDinamico;

/**
 *
 * @author kelly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ControladorArregloDinamico miControlador = new ControladorArregloDinamico();
        
        
        miControlador.agregarNuevoCliente("Hola1", "Hola2", "Hola3", "Hola3", "Hola4");
        miControlador.actualizarCliente("Hola1", "Correo", "CORREOO");
        miControlador.imprimirClientes();
        miControlador.eliminarCliente("CORREOO");
        miControlador.imprimirClientes();
        
        
       
    }
    
}
