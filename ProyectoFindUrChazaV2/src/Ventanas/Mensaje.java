/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kelly
 */
public class Mensaje {
    
    
    public void mensajeAdvertencia(String mensaje){
        Image icono = new ImageIcon(getClass().getResource("../Imagenes/advertencia.png")).getImage();
        ImageIcon img2 = new ImageIcon(icono.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,mensaje, "ADVERTENCIA",JOptionPane.WARNING_MESSAGE,img2);
    }
    
    public void mensajeError(String mensaje){
        Image icono = new ImageIcon(getClass().getResource("../Imagenes/error.png")).getImage();
        ImageIcon img2 = new ImageIcon(icono.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,mensaje, "ERROR",JOptionPane.ERROR_MESSAGE,img2);
    }
    
    public void mensajeInformacion(String mensaje){
        Image icono = new ImageIcon(getClass().getResource("../Imagenes/informacion.png")).getImage();
        ImageIcon img2 = new ImageIcon(icono.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null,mensaje, "INFORMACIÓN",JOptionPane.INFORMATION_MESSAGE,img2);
    }
    
}
