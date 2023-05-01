/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Cata
 */
public class ArchivoListaEnlazadaConCola {
        public BufferedReader leerArchivo(String nombreArchivo) throws FileNotFoundException{
    
        File documento = new File("C:\\Users\\Cata\\Desktop\\FindUrChaza\\Find-Ur-Chaza\\ProyectoFindUrChazaV2\\data\\" + nombreArchivo);
        BufferedReader objecto = new BufferedReader(new FileReader(documento));
        return objecto;
    }
    
}
