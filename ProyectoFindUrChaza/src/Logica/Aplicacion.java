/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Cliente;
import Modelo.Usuario;
import Modelo.Vendedor;
import java.util.Scanner;

/**
 *
 * @author kelly
 */
public class Aplicacion {

    Controlador miControlador = new Controlador();
    Scanner escaner = new Scanner(System.in);

    public void iniciarSistema() {
        System.out.println("--------------------------- Bienvenido(a) a Find Ur Chaza ---------------------------");
        System.out.println("Escoja el número de la opción que quiera realizar: ");
        System.out.println("[1] Iniciar sesión");
        System.out.println("[2] Registrarse");
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                inicioSesion();
                break;
            case 2:
                registrarUsuario();
                break;
            default:
                System.out.println("La opcion ingresada no es complatible, vuelva a intentar.");
                iniciarSistema();
                break;
        }

    }

    public void inicioSesion() {
        System.out.println("--------------------------- Bienvenido(a) a Find Ur Chaza ---------------------------");
        System.out.println("Ingrese el número que indica su tipo de usuario: ");
        System.out.println("[1] Vendedor");
        System.out.println("[2] Cliente");
        System.out.println("[3] Regresar");
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                enviarUsuarioVendedor(inicioSesionVendedor());
                break;
            case 2:
                enviarUsuarioCliente(inicioSesionCliente());
                break;
            case 3:
                iniciarSistema();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                inicioSesion();
                break;
        }
    }

    public void registrarUsuario() {

    }

    public Vendedor inicioSesionVendedor() {
        System.out.println("------------------ Bienvenido(a) Vendedor de Find Ur Chaza ------------------");
        System.out.println("Si desea retornar ingrese [2], sino ingrese [1]");
        Vendedor vendedorIngresado = new Vendedor();
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                System.out.println("Ingrese su correo: ");
                String correoIngresado = escaner.next();
                System.out.println("Ingrese su contraseña: ");
                String contrasenaIngresado = escaner.next();
                try {
                    vendedorIngresado = miControlador.iniciarSesionVendedor(correoIngresado, contrasenaIngresado);
                } catch (Exception e) {
                    System.out.println("Ha ocurrido el siguiente error: " + e);
                }
                break;
            case 2:
                inicioSesion();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                inicioSesionCliente();
                break;
        }

        return vendedorIngresado;
    }

    public Cliente inicioSesionCliente() {
        System.out.println("------------------ Bienvenido(a) Cliente de Find Ur Chaza ------------------");
        System.out.println("Si desea retornar ingrese [2], sino ingrese [1]");
        Cliente clienteIngresado = new Cliente();
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                System.out.println("Ingrese su correo: ");
                String correoIngresado = escaner.next();
                System.out.println("Ingrese su contraseña: ");
                String contrasenaIngresado = escaner.next();
                try {
                    clienteIngresado = miControlador.iniciarSesionCliente(correoIngresado, contrasenaIngresado);
                } catch (Exception e) {
                    System.out.println("Ha ocurrido el siguiente error: " + e);
                }
                break;
            case 2:
                inicioSesion();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                inicioSesionCliente();
                break;
        }

        return clienteIngresado;

    }

    public void enviarUsuarioVendedor(Vendedor vendedor) {
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Ingrese la opción que quiere realizar: ");
        System.out.println("[1] Crear chaza");
        System.out.println("[2] Ver mis chazas");
        System.out.println("[3] Salir al inicio");
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                //crearNuevaChaza();
                break;
            case 2:
                visualizarChazasPropias(vendedor);
                break;
            case 3:
                iniciarSistema();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                enviarUsuarioVendedor(vendedor);
                break;
        }
        
    }
    
    public void visualizarChazasPropias(Vendedor vendedor){
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Estas son las chazas que haz creado por el momento");
        
        System.out.println("Ingrese la opción que quiere realizar: ");
        System.out.println("[1] Crear chaza");
        System.out.println("[2] Ver mis chazas");
        System.out.println("[3] Salir al inicio");
    }
    
    /*
        System.out.println("[1] Ver productos");
        System.out.println("[2] Ver ordenes");
        System.out.println("[3] Comentario de tu chaza");
        
        
        switch (opcionIngreso) {
            case 1:
                visualizarProductosVendedor();
                break;
            case 2:
                visualizarOrdenesVendedor();
                break;
            case 3:
                visualizarComentarioChaza();
                break;
            case 4:
                iniciarSistema();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                enviar();
                break;
        }
*/

    public void enviarUsuarioCliente(Cliente cliente) {
        System.out.println("------------------ Bienvenido(a) " + cliente.getNombre() + " " + cliente.getApellido() + " ------------------");
        System.out.println("Ingrese la opción que quiere realizar: ");
        System.out.println("[1] Ver chazas");
        System.out.println("[2] Tus ordenes");
        System.out.println("[3] Tus comentarios");
        System.out.println("[4] Salir al inicio");
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                //visualizarChazas();
                break;
            case 2:
                //visualizarOrdenesCliente();
                break;
            case 3:
                //visualizarComentarioCliente();
                break;
            case 4:
                iniciarSistema();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                enviarUsuarioCliente(cliente);
                break;
        }
    }

}
