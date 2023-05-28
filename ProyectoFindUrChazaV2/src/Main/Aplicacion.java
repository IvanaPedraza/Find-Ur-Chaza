/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EstructurasDeDatos.ArregloConCola;
import Logica.*;
import Modelo.*;
import java.util.Scanner;

/**
 *
 * @author kelly
 */
public class Aplicacion {

    //ControladorListaEnlazadaConCola miControlador = new ControladorListaEnlazadaConCola();
    ControladorChaza controladorChaza = new ControladorChaza();
    ControladorCliente controladorCliente = new ControladorCliente();
    ControladorComentario controladorComentario = new ControladorComentario();
    ControladorFactura controladorFactura = new ControladorFactura();
    ControladorOrden controladorOrden = new ControladorOrden();
    ControladorProducto controladorProducto = new ControladorProducto();
    ControladorVendedor controladorVendedor = new ControladorVendedor();
    
    
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
                inicioSesionVendedor();
                break;
            case 2:
                inicioSesionCliente();
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
        System.out.println("--------------------------- Bienvenido(a) a Find Ur Chaza ---------------------------");
        System.out.println("Ingrese que tipo de usuario desea ser: ");
        System.out.println("[1] Vendedor");
        System.out.println("[2] Cliente");
        System.out.println("[3] Regresar");
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                registrarNuevoVendedor();
                break;
            case 2:
                registrarNuevoCliente();
                break;
            case 3:
                iniciarSistema();
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                registrarUsuario();
                break;
        }
    }
    
    public void registrarNuevoCliente(){
        System.out.println("--------------------------- Bienvenido(a) a Find Ur Chaza ---------------------------");
        System.out.println("Ingrese los campos solicitados, separados por comas y sin espacios: ");
        System.out.println("Correo,Nombre,Apellido,Telefono,Contraseña");
        String[] nuevoCliente = escaner.next().split(",");
        controladorCliente.agregarNuevoCliente(nuevoCliente[0], nuevoCliente[1], nuevoCliente[2], nuevoCliente[3], nuevoCliente[4]);
        System.out.println("Se ha agregado correctamente "+nuevoCliente[0]);
        iniciarSistema();
    }
    
    public void registrarNuevoVendedor(){
        System.out.println("--------------------------- Bienvenido(a) a Find Ur Chaza ---------------------------");
        System.out.println("Ingrese los campos solicitados, separados por comas y sin espacios: ");
        System.out.println("Correo,Nombre,Apellido,Telefono,Contraseña");
        String[] nuevoCliente = escaner.next().split(",");
        controladorVendedor.agregarNuevoVendedor(nuevoCliente[0], nuevoCliente[1], nuevoCliente[2], nuevoCliente[3], nuevoCliente[4]);
        System.out.println("Se ha agregado correctamente "+nuevoCliente[0]);
        iniciarSistema();
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
                    vendedorIngresado = controladorVendedor.iniciarSesionVendedor(correoIngresado, contrasenaIngresado);
                    enviarUsuarioVendedor(vendedorIngresado);
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
                    clienteIngresado = controladorCliente.iniciarSesionCliente(correoIngresado, contrasenaIngresado);
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
                crearNuevaChaza(vendedor);
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
    
    public void crearNuevaChaza(Vendedor vendedor){
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Ingrese los campos solicitados, separados por comas y sin espacios: ");
        System.out.println("Nombre de la chaza,Ubicación,Descripcion");
        String[] nuevaChaza = escaner.next().split(",");
        controladorChaza.agregarNuevaChaza(nuevaChaza[0], nuevaChaza[1], nuevaChaza[2], vendedor);
        System.out.println("Se ha agregado correctamento tu chaza: "+nuevaChaza[0]);
        enviarUsuarioVendedor(vendedor);
    }
    
    public void visualizarChazasPropias(Vendedor vendedor){
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Estas son las chazas que haz creado por el momento");
        System.out.println("Usted tiene "+controladorChaza.numeroChazasPorVendedor(vendedor)+" chaza(s)");
        System.out.println("Sus chazas son: ");
        try{
            controladorChaza.buscarChazasPorVendedor(vendedor);
        }catch(NullPointerException e){
            System.out.println("No cuenta con chazas disponibles");
        }
        System.out.println("Ingrese la opción que quiere realizar: ");
        System.out.println("[1] Visualizar una chaza");
        System.out.println("[2] Actualizar una chaza");
        System.out.println("[3] Eliminar una chaza");
        System.out.println("[4] Retornar");
        int opcionIngreso = Integer.parseInt(escaner.next());
        switch (opcionIngreso) {
            case 1:
                visualizarChazaPropia(vendedor);
                break;
            case 2:
                actualizarChazaPropia(vendedor);
                break;
            case 3:
                eliminarChazaPropia(vendedor);
                break;
            case 4:
                enviarUsuarioVendedor(vendedor);
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                visualizarChazasPropias(vendedor);
                break;
        }
    }
    
    public void visualizarChazaPropia(Vendedor vendedor){
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Sus chazas son: ");
        controladorChaza.buscarChazasPorVendedor(vendedor);
        System.out.println("Ingrese el nombre de la chaza que quiere visualizar: ");
        String nombreChaza = escaner.next();
        System.out.println("Esta es la información sobre la chaza: "+nombreChaza);
        try{
            controladorChaza.buscarChazaPorNombre(nombreChaza);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error "+ e.toString());
        }
        
    }
    
    public void actualizarChazaPropia(Vendedor vendedor){
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Ingrese el nombre de la chaza que quiere actualizar: ");
        String nombreChaza = escaner.next();
        System.out.println("Ingrese el la categoria que quiere actualizar, entre estas opciones: ");
        System.out.println("[1] Nombre");
        System.out.println("[2] Ubicacion");
        System.out.println("[3] Descripcion");
        System.out.println("[4] Estado de chaza");
        int opcionIngreso = Integer.parseInt(escaner.next());
        System.out.println("Ingrese el nuevo dato a asignar: ");
        String datoAModificar = escaner.next();
        switch (opcionIngreso) {
            case 1:
                controladorChaza.actualizarChaza(nombreChaza, "Nombre", datoAModificar);
                break;
            case 2:
                controladorChaza.actualizarChaza(nombreChaza, "Ubicacion", datoAModificar);
                break;
            case 3:
                controladorChaza.actualizarChaza(nombreChaza, "Descripcion", datoAModificar);
                break;
            case 4:
                controladorChaza.actualizarChaza(nombreChaza, "Estado de chaza", datoAModificar);
                break;
            default:
                System.out.println("La opcion ingresada no es compatible, vuelva a intentar.");
                actualizarChazaPropia(vendedor);
                break;
        }
        visualizarChazasPropias(vendedor);
    }
    
    public void eliminarChazaPropia(Vendedor vendedor){
        System.out.println("------------------ Bienvenido(a) " + vendedor.getNombre() + " " + vendedor.getApellido() + " ------------------");
        System.out.println("Ingrese el nombre de la chaza que quiere eliminar: ");
        String nombreChaza = escaner.next();
        try{
            Chaza chazaEliminada = controladorChaza.eliminarChaza(nombreChaza);
            System.out.println("Se ha eliminado correctamente " + chazaEliminada.getNombreChaza());
        }catch(Exception e){
            System.out.println("Ha ocurrido un error "+e.toString());
        }
        visualizarChazasPropias(vendedor);
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
