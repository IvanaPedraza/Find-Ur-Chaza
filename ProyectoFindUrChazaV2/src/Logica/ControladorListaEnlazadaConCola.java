/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import EstructurasDeDatos.*;
import Modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kelly
 */
public class ControladorListaEnlazadaConCola {

    private ListaEnlazadaConCola ListaEnlazadaConColaClientes;
    private ListaEnlazadaConCola ListaEnlazadaConColaVendedor;
    private ListaEnlazadaConCola ListaEnlazadaConColaChaza;
    private ListaEnlazadaConCola ListaEnlazadaConColaProducto;
    private ListaEnlazadaConCola ListaEnlazadaConColaComentario;
    private ListaEnlazadaConCola ListaEnlazadaConColaFactura;
    private ListaEnlazadaConCola ListaEnlazadaConColaOrden;

    public ControladorListaEnlazadaConCola() {
        ListaEnlazadaConColaClientes = new ListaEnlazadaConCola();
        ListaEnlazadaConColaVendedor = new ListaEnlazadaConCola();
        ListaEnlazadaConColaChaza = new ListaEnlazadaConCola();
        ListaEnlazadaConColaProducto = new ListaEnlazadaConCola();
        ListaEnlazadaConColaComentario = new ListaEnlazadaConCola();
        ListaEnlazadaConColaFactura = new ListaEnlazadaConCola();
        ListaEnlazadaConColaOrden = new ListaEnlazadaConCola();
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaClientes() {
        return ListaEnlazadaConColaClientes;
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaVendedor() {
        return ListaEnlazadaConColaVendedor;
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaChaza() {
        return ListaEnlazadaConColaChaza;
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaProducto() {
        return ListaEnlazadaConColaProducto;
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaComentario() {
        return ListaEnlazadaConColaComentario;
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaFactura() {
        return ListaEnlazadaConColaFactura;
    }

    public ListaEnlazadaConCola getListaEnlazadaConColaOrden() {
        return ListaEnlazadaConColaOrden;
    }

    /*Cliente*/
    public Cliente iniciarSesionCliente(String correo, String contrasena) {
        Cliente clienteIngreso = new Cliente();
        Cliente clienteRetorno = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaClientes.cantidad(); i++) {
            clienteIngreso = (Cliente) ListaEnlazadaConColaClientes.getElement(i);
            if (clienteIngreso.getCorreo().equals(correo) && clienteIngreso.getContrasena().equals(contrasena)) {
                clienteRetorno = clienteIngreso;
            } else {
                System.out.println("¡El cliente no existe!");
                clienteRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("IniciarSesión con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return clienteRetorno;
    }

    public void agregarNuevoCliente(String correo, String nombre, String apellido, String telefono, String contrasena) {
        Cliente nuevoCliente = new Cliente(correo, nombre, apellido, telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaClientes.pushBack(nuevoCliente);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoCliente con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }

    //Devuelve el cliente borrado
    public Cliente eliminarCliente(String correo) {
        Cliente clienteAEliminar = new Cliente();
        try {
            clienteAEliminar = buscarClientePorCorreo(correo);
            long time_start, time_end;
            time_start = System.nanoTime();
            ListaEnlazadaConColaClientes.delete(clienteAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarCliente con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        } catch (Exception e) {
            System.out.println("El cliente no se encontró");
        }
        return clienteAEliminar;
    }

    public Cliente actualizarCategoriaCliente(Cliente clienteActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Nombre":
                clienteActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                clienteActualizar.setApellido(datoModificado);
                break;
            case "Telefono":
                clienteActualizar.setTelefono(datoModificado);
                break;
            case "Correo":
                clienteActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                clienteActualizar.setContrasena(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return clienteActualizar;
    }

    public void actualizarCliente(String correoClienteAntiguo, String categoria, String datoModificado) {
        Cliente clienteAntiguo = new Cliente();
        try {
            clienteAntiguo = buscarClientePorCorreo(correoClienteAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el cliente, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Cliente clienteActualizado = actualizarCategoriaCliente(clienteAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaCliente con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaClientes.ActualizarData(clienteAntiguo, clienteActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarCliente con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");

    }

    public void imprimirClientes() {
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaClientes.cantidad(); i++) {
            clienteIterado = (Cliente) ListaEnlazadaConColaClientes.getElement(i);
            System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirClientes con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public void buscarCliente(String nombre, String apellido) {
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaClientes.cantidad(); i++) {
            clienteIterado = (Cliente) ListaEnlazadaConColaClientes.getElement(i);
            if (clienteIterado.getNombre().equals(nombre) && clienteIterado.getApellido().equals(apellido)) {
                System.out.println("El cliente se ha encontrado: ");
                System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo());
            } else {
                System.out.println("El cliente no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarCliente con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Cliente buscarClientePorCorreo(String correo) throws Exception {
        Cliente clienteEncontrado = new Cliente();
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaClientes.cantidad(); i++) {
            clienteIterado = (Cliente) ListaEnlazadaConColaClientes.getElement(i);
            if (clienteIterado.getCorreo().equals(correo)) {
                clienteEncontrado = clienteIterado;
            } else {
                throw new Exception("No existe el cliente");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarClientePorCorreo con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return clienteEncontrado;
    }

    /*Productos*/
    public void agregarNuevoProducto(int codigo, String nombre, double precio, String detalle, Date fechaIngreso, Date fechaExpiracion, Chaza chaza) {
        Producto nuevoProducto = new Producto(codigo, nombre, precio, detalle, fechaIngreso, fechaExpiracion, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaProducto.pushBack(nuevoProducto);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoProducto con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente " + nuevoProducto.getNombre());
    }

    public Producto eliminarProducto(int codigoProducto) {
        Producto productoAEliminar = new Producto();
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            productoAEliminar = buscarProductoPorCodigo(codigoProducto);
            ListaEnlazadaConColaProducto.delete(productoAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarProducto con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        } catch (Exception e) {
            System.out.println("El producto no se encontró");
        }
        return productoAEliminar;
    }

    public Producto actualizarCategoriaProducto(Producto productoActualizar, String categoria, String datoModificado) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        switch (categoria) {
            case "Nombre":
                productoActualizar.setNombre(datoModificado);
                break;
            case "Precio":
                productoActualizar.setPrecio(Double.parseDouble(datoModificado));
                break;
            case "Detalle":
                productoActualizar.setDetalle(datoModificado);
                break;
            case "Fecha ingreso":
                Date fecha = formato.parse(datoModificado);
                productoActualizar.setFechaIngreso(fecha);
                break;
            case "Fecha expiracion":
                Date fecha2 = formato.parse(datoModificado);
                productoActualizar.setFechaIngreso(fecha2);
                break;
            case "Fecha egreso":
                Date fecha3 = formato.parse(datoModificado);
                productoActualizar.setFechaIngreso(fecha3);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return productoActualizar;
    }

    public void actualizarProducto(int codigoProducto, String categoria, String datoModificado) {
        Producto productoAntiguo = new Producto();
        try {
            productoAntiguo = buscarProductoPorCodigo(codigoProducto);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el producto, porque no existe");
        }
        Producto productoActualizado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            productoActualizado = actualizarCategoriaProducto(productoAntiguo, categoria, datoModificado);
        } catch (ParseException ex) {
            System.out.println("Error " + ex);
        }
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaProducto con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaProducto.ActualizarData(productoAntiguo, productoActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarProducto con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");
    }

    public void imprimirProductos() {
        Producto productoIterado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaChaza.cantidad(); i++) {
            productoIterado = (Producto) ListaEnlazadaConColaProducto.getElement(i);
            System.out.println(productoIterado.getCodigo() + " " + productoIterado.getNombre() + " " + productoIterado.getDetalle() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirProductos con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        Producto productoEncontrada = new Producto();
        Producto productoIterado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaProducto.cantidad(); i++) {
            productoIterado = (Producto) ListaEnlazadaConColaProducto.getElement(i);
            if (productoIterado.getCodigo() == codigo) {
                productoEncontrada = productoIterado;
            } else {
                throw new Exception("No existe el producto");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarProductoPorCodigo con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return productoEncontrada;
    }

    /*Chaza*/
    public void agregarNuevaChaza(String nombreChaza, String ubicacion, String descripcion, Vendedor vendedor) {
        Chaza nuevaChaza = new Chaza(nombreChaza, ubicacion, descripcion, vendedor);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaChaza.pushBack(nuevaChaza);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaChaza con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente " + nuevaChaza.getNombreChaza());
    }

    public Chaza eliminarChaza(String nombreChaza) {
        Chaza chazaAEliminar = new Chaza();
        try {
            //long time_start, time_end;
            //time_start = System.nanoTime();
            chazaAEliminar = buscarChazaPorNombre(nombreChaza);
            ListaEnlazadaConColaChaza.delete(chazaAEliminar);
            //time_end = System.nanoTime();
            //System.out.println("eliminarChaza con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        } catch (Exception e) {
            System.out.println("La chaza no se encontró " + e);
        }

        return chazaAEliminar;
    }

    public void eliminarChaza() {
        try {
            long time_start, time_end;
            time_start = System.nanoTime();
            ListaEnlazadaConColaChaza.popFront();
            time_end = System.nanoTime();
            System.out.println("eliminarChaza con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        } catch (Exception e) {
            System.out.println("La chaza no se encontró" + e);
        }
    }

    public Chaza actualizarCategoriaChaza(Chaza chazaActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Nombre":
                chazaActualizar.setNombreChaza(datoModificado);
                break;
            case "Ubicacion":
                chazaActualizar.setUbicacion(datoModificado);
                break;
            case "Descripcion":
                chazaActualizar.setDescripcion(datoModificado);
                break;
            case "Estado de chaza":
                chazaActualizar.setEstadoChaza(Integer.parseInt(datoModificado));
            default:
                System.out.println("La categoria no es válida");
        }
        return chazaActualizar;
    }

    public void actualizarChaza(String nombreChazaAntiguo, String categoria, String datoModificado) {
        Chaza chazaAntigua = new Chaza();

        try {
            chazaAntigua = buscarChazaPorNombre(nombreChazaAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la chaza, porque no existe");
        }
        //long time_start, time_end;
        //time_start = System.nanoTime();
        Chaza chazaActualizada = actualizarCategoriaChaza(chazaAntigua, categoria, datoModificado);
        //time_end = System.nanoTime();
        //System.out.println("actualizarCategoriaChaza con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        //long time_start2, time_end2;
        //time_start2 = System.nanoTime();
        ListaEnlazadaConColaChaza.ActualizarData(chazaAntigua, chazaActualizada);
        //time_end2 = System.nanoTime();
        //System.out.println("actualizarChaza con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");
    }

    public void imprimirChazas() {
        Chaza chazaIterado = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaChaza.cantidad(); i++) {
            chazaIterado = (Chaza) ListaEnlazadaConColaChaza.getElement(i);
            System.out.println(chazaIterado.getNombreChaza() + " " + chazaIterado.getUbicacion() + " " + chazaIterado.getDescripcion() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirChazas con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Chaza buscarChazaPorNombre(String nombreChaza) throws Exception {
        Chaza chazaEncontrada = new Chaza();
        Chaza chazaIterado = new Chaza();
        //long time_start, time_end;
        //time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaChaza.cantidad(); i++) {
            chazaIterado = (Chaza) ListaEnlazadaConColaChaza.getElement(i);
            if (chazaIterado.getNombreChaza().equals(nombreChaza)) {
                chazaEncontrada = chazaIterado;
            }
        }
        if (chazaEncontrada.getNombreChaza().length() == 0) {
            System.out.println("No se encontro");
        }
        //time_end = System.nanoTime();
        //System.out.println("buscarChazaPorNombre con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return chazaEncontrada;
    }

    public Chaza buscarChazaPorVendedor(Vendedor vendedor) {
        Chaza chazaEncontrada = new Chaza();
        Chaza chazaIterado = new Chaza();
        //long time_start, time_end;
        //time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaChaza.cantidad(); i++) {
            chazaIterado = (Chaza) ListaEnlazadaConColaChaza.getElement(i);
            if (chazaIterado.getVendedor().getCorreo().equals(vendedor.getCorreo())) {
                chazaEncontrada = chazaIterado;
                System.out.println(chazaEncontrada.getIdChaza() + " " + chazaEncontrada.getNombreChaza() + " " + chazaEncontrada.getUbicacion() + " " + chazaEncontrada.getDescripcion());
            }
        }
        if (chazaEncontrada.getNombreChaza().length() == 0) {
            System.out.println("No se encontro");
        }
        return chazaEncontrada;
    }

    public int numeroChazasPorVendedor(Vendedor vendedor) {
        int numChazas = 0;
        Chaza chazaIterado = new Chaza();
        for (int i = 0; i < ListaEnlazadaConColaChaza.cantidad(); i++) {
            chazaIterado = (Chaza) ListaEnlazadaConColaChaza.getElement(i);
            if (chazaIterado == null) {
                System.out.println("No hay chazas por el momento");
                break;
            } else {
                if (chazaIterado.getVendedor().getCorreo().equals(vendedor.getCorreo())) {
                    numChazas++;
                }
            }

        }
        return numChazas;
    }

    /*Comentario*/
    public void agregarNuevoComentario(long idComentario, Date fechaComentario, String contenido, Cliente cliente, Chaza chaza) {
        Comentario nuevoComentario = new Comentario(idComentario, fechaComentario, contenido, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaComentario.pushBack(nuevoComentario);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoComentario con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + idComentario + " " + contenido);

    }

    public Comentario actualizarCategoriaComentario(Comentario comentarioActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Contenido":
                comentarioActualizar.setContenido(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return comentarioActualizar;
    }

    public void actualizarComentario(String idComentarioAntiguo, String categoria, String datoModificado) {
        Comentario comentarioAntiguo = new Comentario();
        try {
            comentarioAntiguo = buscarComentarioPorId(Long.parseLong(idComentarioAntiguo));
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el comentario, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Comentario comentarioActualizado = actualizarCategoriaComentario(comentarioAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaComentario con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaComentario.ActualizarData(comentarioAntiguo, comentarioActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarComentario con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");

    }

    public void imprimirComentario() {
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaComentario.cantidad(); i++) {
            comentarioIterado = (Comentario) ListaEnlazadaConColaComentario.getElement(i);
            System.out.println(comentarioIterado.getIdComentario() + " " + comentarioIterado.getContenido() + " " + comentarioIterado.getFechaComentario() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirComentarios con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Comentario buscarComentarioPorId(long idComentario) throws Exception {
        Comentario comentarioEncontrado = new Comentario();
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaComentario.cantidad(); i++) {
            comentarioIterado = (Comentario) ListaEnlazadaConColaComentario.getElement(i);
            if (comentarioIterado.getIdComentario() == idComentario) {
                comentarioEncontrado = comentarioIterado;
            } else {
                throw new Exception("No existe el comentario");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarComentarioPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return comentarioEncontrado;
    }

    /*Factura*/
    public void agregarNuevaFactura(long numReferencia, Date fechaFactura, Producto producto, Orden orden, int cantidad, double costoTotal) {
        Factura nuevaFactura = new Factura(numReferencia, fechaFactura, producto, orden, cantidad, costoTotal);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaFactura.pushBack(nuevaFactura);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaFactura con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + numReferencia + " " + orden + " " + producto);
    }

    public Factura eliminarFactura(long numReferencia) {
        Factura facturaAEliminar = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            facturaAEliminar = buscarFacturaPorId(numReferencia);
            ListaEnlazadaConColaFactura.delete(facturaAEliminar);

        } catch (Exception e) {
            System.out.println("La factura no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarFactura con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return facturaAEliminar;
    }

    public Factura actualizarCategoriaFactura(Factura facturaActualizar, String categoria, Object datoModificado) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        switch (categoria) {
            case "Fecha factura":
                try {
                Date fecha = formato.parse(datoModificado.toString());
                facturaActualizar.setFechaFactura(fecha);
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error en el ingreso de la fecha, vuelve a intentar");
            }

            break;
            case "Producto":
                facturaActualizar.setProducto((Producto) datoModificado);
                break;
            case "Orden":
                facturaActualizar.setOrden((Orden) datoModificado);
                break;
            case "Costo total":
                facturaActualizar.setCostoTotal(Double.parseDouble(datoModificado.toString()));
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return facturaActualizar;
    }

    public void actualizarFactura(long referenciaFacturaAntiguo, String categoria, String datoModificado) {
        Factura facturaAntigua = new Factura();
        try {
            facturaAntigua = buscarFacturaPorId(referenciaFacturaAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la factura, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Factura facturaActualizada = actualizarCategoriaFactura(facturaAntigua, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaFactura con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaFactura.ActualizarData(facturaAntigua, facturaActualizada);
        time_end2 = System.nanoTime();
        System.out.println("ListaEnlazadaConColaFactura con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");
    }

    public void imprimirFactura() {
        Factura facturaIterada = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaFactura.cantidad(); i++) {
            facturaIterada = (Factura) ListaEnlazadaConColaFactura.getElement(i);
            System.out.println(facturaIterada.getNumReferencia() + " " + facturaIterada.getFechaFactura() + " " + facturaIterada.getOrden() + " " + facturaIterada.getProducto());
        }
        time_end = System.nanoTime();
        System.out.println("imprimirFacturas con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Factura buscarFacturaPorId(long referencia) throws Exception {
        Factura facturaEncontrado = new Factura();
        Factura facturaIterado = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaFactura.cantidad(); i++) {
            facturaIterado = (Factura) ListaEnlazadaConColaFactura.getElement(i);
            if (facturaIterado.getNumReferencia() == referencia) {
                facturaEncontrado = facturaIterado;
            } else {
                throw new Exception("No existe la factura");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return facturaEncontrado;
    }

    /*Orden*/
    public void agregarNuevaOrden(long numOrden, Date fechaOrden, Cliente cliente, Chaza chaza) {
        Orden nuevaOrden = new Orden(numOrden, fechaOrden, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaOrden.pushBack(nuevaOrden);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaOrden con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        System.out.println("Se ha ingresado correctamente: " + numOrden + " " + fechaOrden + " " + cliente + " " + chaza);
    }

    public Orden eliminarOrden(long numOrden) {
        Orden ordenAEliminar = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            ordenAEliminar = buscarOrdenPorId(numOrden);
            ListaEnlazadaConColaOrden.delete(ordenAEliminar);

        } catch (Exception e) {
            System.out.println("La orden no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarOrden con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return ordenAEliminar;
    }

    public Orden actualizarCategoriaOrden(Orden ordenActualizar, String categoria, Object datoModificado) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        switch (categoria) {
            case "Fecha orden":
                try {
                Date fecha = formato.parse(datoModificado.toString());
                ordenActualizar.setFechaOrden(fecha);
            } catch (Exception e) {
                System.out.println("Error en la fecha ingresada");
            }
            break;
            case "Cliente":
                ordenActualizar.setCliente((Cliente) datoModificado);
                break;
            case "Chaza":
                ordenActualizar.setChaza((Chaza) datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return ordenActualizar;
    }

    public void actualizarOrden(long numOrdenAntigua, String categoria, Object datoModificado) {
        Orden ordenAntiguo = new Orden();

        try {
            ordenAntiguo = buscarOrdenPorId(numOrdenAntigua);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar la orden, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Orden ordenActualizado = actualizarCategoriaOrden(ordenAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaOrden con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaOrden.ActualizarData(ordenAntiguo, ordenActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarOrden con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");

    }

    public void imprimirOrden() {
        Orden ordenIterado = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaOrden.cantidad(); i++) {
            ordenIterado = (Orden) ListaEnlazadaConColaOrden.getElement(i);
            System.out.println(ordenIterado.getNumOrden() + " " + ordenIterado.getFechaOrden() + " " + ordenIterado.getCliente() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirOrdenes con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Orden buscarOrdenPorId(long numOrden) throws Exception {
        Orden ordenEncontrada = new Orden();
        Orden ordenIterada = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaOrden.cantidad(); i++) {
            ordenIterada = (Orden) ListaEnlazadaConColaOrden.getElement(i);
            if (ordenIterada.getNumOrden() == numOrden) {
                ordenEncontrada = ordenIterada;
            } else {
                throw new Exception("No existe la orden");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarOrdenPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return ordenEncontrada;
    }

    /*Vendedor*/
    public Vendedor iniciarSesionVendedor(String correo, String contrasena) {
        Vendedor vendedorIngreso = new Vendedor();
        Vendedor vendedorRetorno = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaVendedor.cantidad(); i++) {
            vendedorIngreso = (Vendedor) ListaEnlazadaConColaVendedor.getElement(i);
            if (vendedorIngreso.getCorreo().equals(correo) && vendedorIngreso.getContrasena().equals(contrasena)) {
                vendedorRetorno = vendedorIngreso;
            } else {
                System.out.println("¡El vendedor no existe!");
                vendedorRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorRetorno;
    }

    public void agregarNuevoVendedor(String correo, String nombre, String apellido, String telefono, String contrasena) {
        Vendedor nuevoVendedor = new Vendedor(correo, nombre, apellido, telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaConColaVendedor.pushBack(nuevoVendedor);
        time_end = System.nanoTime();
        //System.out.println("agregarNuevoVendedor con Lista Enlazada Con Cola tomo " + (time_end - time_start) + " milliseconds");
        //System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }

    //Devuelve el cliente borrado
    public Vendedor eliminarVendedor(String correo) {
        Vendedor vendedorAEliminar = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            vendedorAEliminar = buscarVendedorPorCorreo(correo);
            ListaEnlazadaConColaVendedor.delete(vendedorAEliminar);

        } catch (Exception e) {
            System.out.println("El cliente no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorAEliminar;
    }

    public Vendedor actualizarCategoriaVendedor(Vendedor vendedorActualizar, String categoria, String datoModificado) {
        switch (categoria) {
            case "Nombre":
                vendedorActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                vendedorActualizar.setApellido(datoModificado);
                break;
            case "Telefono":
                vendedorActualizar.setTelefono(datoModificado);
                break;
            case "Correo":
                vendedorActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                vendedorActualizar.setContrasena(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return vendedorActualizar;
    }

    public void actualizarVendedor(String correoVendedorAntiguo, String categoria, String datoModificado) {
        Vendedor vendedorAntiguo = new Vendedor();

        try {
            vendedorAntiguo = buscarVendedorPorCorreo(correoVendedorAntiguo);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el vendedor, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Vendedor vendedorActualizado = actualizarCategoriaVendedor(vendedorAntiguo, categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");

        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaConColaVendedor.ActualizarData(vendedorAntiguo, vendedorActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarVendedor con arreglo dinamico tomo " + (time_end2 - time_start2) + " milliseconds");

    }

    public void imprimirVendedor() {
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaVendedor.cantidad(); i++) {
            vendedorIterado = (Vendedor) ListaEnlazadaConColaClientes.getElement(i);
            System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirVendedores con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public void buscarVendedor(String nombre, String apellido) {
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaVendedor.cantidad(); i++) {
            vendedorIterado = (Vendedor) ListaEnlazadaConColaVendedor.getElement(i);
            if (vendedorIterado.getNombre().equals(nombre) && vendedorIterado.getApellido().equals(apellido)) {
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo());
            } else {
                System.out.println("El vendedor no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedor con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
    }

    public Vendedor buscarVendedorPorCorreo(String correo) throws Exception {
        Vendedor vendedorEncontrado = new Vendedor();
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for (int i = 0; i < ListaEnlazadaConColaVendedor.cantidad(); i++) {
            vendedorIterado = (Vendedor) ListaEnlazadaConColaVendedor.getElement(i);
            if (vendedorIterado.getCorreo().equals(correo)) {
                vendedorEncontrado = vendedorIterado;
            }
        }
        if (vendedorEncontrado.getNombre().length() == 0) {
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedorPorCorreo con arreglo dinamico tomo " + (time_end - time_start) + " milliseconds");
        return vendedorEncontrado;
    }

}
