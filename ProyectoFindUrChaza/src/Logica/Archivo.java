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
 * @author kelly
 */
public class Archivo <T>{
    public BufferedReader leerArchivo(String nombreArchivo) throws FileNotFoundException{
    
        File documento = new File("C:\\Users\\kelly\\OneDrive\\Documentos\\ProyectoEstructuras\\Find-Ur-Chaza\\ProyectoFindUrChaza\\data\\" + nombreArchivo);
        BufferedReader objecto = new BufferedReader(new FileReader(documento));
        return objecto;
    }
    
    
    
}
