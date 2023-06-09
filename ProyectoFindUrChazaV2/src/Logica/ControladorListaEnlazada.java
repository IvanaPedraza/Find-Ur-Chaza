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
public class ControladorListaEnlazada {
    
    private ListaEnlazada ListaEnlazadaClientes;
    private ListaEnlazada ListaEnlazadaVendedor;
    private ListaEnlazada ListaEnlazadaChaza;
    private ListaEnlazada ListaEnlazadaProducto;
    private ListaEnlazada ListaEnlazadaComentario;
    private ListaEnlazada ListaEnlazadaFactura;
    private ListaEnlazada ListaEnlazadaOrden;
    
    public ControladorListaEnlazada(){
        ListaEnlazadaClientes = new ListaEnlazada();
        ListaEnlazadaVendedor = new ListaEnlazada();
        ListaEnlazadaChaza = new ListaEnlazada();
        ListaEnlazadaProducto = new ListaEnlazada();
        ListaEnlazadaComentario = new ListaEnlazada();
        ListaEnlazadaFactura = new ListaEnlazada();
        ListaEnlazadaOrden = new ListaEnlazada();
    }

    public ListaEnlazada getListaEnlazadaClientes() {
        return ListaEnlazadaClientes;
    }

    public ListaEnlazada getListaEnlazadaVendedor() {
        return ListaEnlazadaVendedor;
    }

    public ListaEnlazada getListaEnlazadaChaza() {
        return ListaEnlazadaChaza;
    }

    public ListaEnlazada getListaEnlazadaProducto() {
        return ListaEnlazadaProducto;
    }

    public ListaEnlazada getListaEnlazadaComentario() {
        return ListaEnlazadaComentario;
    }

    public ListaEnlazada getListaEnlazadaFactura() {
        return ListaEnlazadaFactura;
    }

    public ListaEnlazada getListaEnlazadaOrden() {
        return ListaEnlazadaOrden;
    }
    
    
    /*Cliente*/
    
    public Cliente iniciarSesionCliente(String correo, String contrasena){
        Cliente clienteIngreso = new Cliente();
        Cliente clienteRetorno = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaClientes.size();i++){
            clienteIngreso = (Cliente) ListaEnlazadaClientes.getElement(i);
            if(clienteIngreso.getCorreo().equals(correo) && clienteIngreso.getContrasena().equals(contrasena)){
                clienteRetorno = clienteIngreso;
            }else{
                System.out.println("¡El cliente no existe!");
                clienteRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("IniciarSesión con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return clienteRetorno;
    }
    
    public void agregarNuevoCliente(String correo, String nombre, String apellido, String telefono, String contrasena){
        Cliente nuevoCliente = new Cliente(correo, nombre, apellido,telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaClientes.pushBack(nuevoCliente);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoCliente con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    //Devuelve el cliente borrado
    public Cliente eliminarCliente(String correo){
        Cliente clienteAEliminar = new Cliente();
        try{
            clienteAEliminar = buscarClientePorCorreo(correo);
            long time_start, time_end;
            time_start = System.nanoTime();
            ListaEnlazadaClientes.delete(clienteAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarCliente con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
            
        }catch(Exception e){
            System.out.println("El cliente no se encontró");
        }
        return clienteAEliminar; 
    }
    
    public Cliente actualizarCategoriaCliente(Cliente clienteActualizar, String categoria, String datoModificado){
        switch(categoria){
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
    
    public void actualizarCliente(String correoClienteAntiguo, String categoria, String datoModificado){
        Cliente clienteAntiguo = new Cliente();
        try{
            clienteAntiguo = buscarClientePorCorreo(correoClienteAntiguo);
        }catch(Exception e){
            System.out.println("No se pudo actualizar el cliente, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Cliente clienteActualizado = actualizarCategoriaCliente(clienteAntiguo,categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaCliente con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaClientes.ActualizarData(clienteAntiguo, clienteActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarCliente con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
        
    }
        
    public void imprimirClientes(){
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaClientes.size();i++){
            clienteIterado = (Cliente) ListaEnlazadaClientes.getElement(i);
            System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo()+ " "+clienteIterado.getTelefono());
        }
        time_end = System.nanoTime();
        System.out.println("imprimirClientes con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public void buscarCliente(String nombre, String apellido){
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaClientes.size();i++){
            clienteIterado = (Cliente) ListaEnlazadaClientes.getElement(i);
            if(clienteIterado.getNombre().equals(nombre) && clienteIterado.getApellido().equals(apellido)){
                System.out.println("El cliente se ha encontrado: ");
                System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo());
            }else{
                System.out.println("El cliente no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarCliente con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Cliente buscarClientePorCorreo(String correo) throws Exception{
        Cliente clienteEncontrado = new Cliente();
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaClientes.size();i++){
            clienteIterado = (Cliente) ListaEnlazadaClientes.getElement(i);
            if(clienteIterado.getCorreo().equals(correo)){
                clienteEncontrado = clienteIterado;
            }else{
                throw new Exception("No existe el cliente");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarClientePorCorreo con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return clienteEncontrado;
    }
    
    /*Productos*/
    
    public void agregarNuevoProducto(int codigo, String nombre, double precio, String detalle, Date fechaIngreso, Date fechaExpiracion, Chaza chaza){
        Producto nuevoProducto = new Producto(codigo,nombre,precio,detalle,fechaIngreso,fechaExpiracion, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaProducto.pushBack(nuevoProducto);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoProducto con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente "+ nuevoProducto.getNombre());
    }
    
    public Producto eliminarProducto(int codigoProducto){
        Producto productoAEliminar = new Producto();
        try{
            long time_start, time_end;
            time_start = System.nanoTime();
            productoAEliminar = buscarProductoPorCodigo(codigoProducto);
            ListaEnlazadaProducto.delete(productoAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarProducto con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        }catch(Exception e){
            System.out.println("El producto no se encontró");
        }
        return productoAEliminar;
    }
    
    public Producto actualizarCategoriaProducto(Producto productoActualizar, String categoria, String datoModificado) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        switch(categoria){
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
    
    public void actualizarProducto(int codigoProducto, String categoria, String datoModificado){
        Producto productoAntiguo = new Producto();
        try{
            productoAntiguo = buscarProductoPorCodigo(codigoProducto);
        }catch(Exception e){
            System.out.println("No se pudo actualizar el producto, porque no existe");
        }
        Producto productoActualizado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        try {
            productoActualizado = actualizarCategoriaProducto(productoAntiguo,categoria, datoModificado);
        } catch (ParseException ex) {
            System.out.println("Error "+ex);
        }
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaProducto con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaProducto.ActualizarData(productoAntiguo, productoActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarProducto con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
    }
    
    public void imprimirProductos(){
        Producto productoIterado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaChaza.size();i++){
            productoIterado = (Producto) ListaEnlazadaProducto.getElement(i);
            System.out.println(productoIterado.getCodigo()+ " " + productoIterado.getNombre()+ " " + productoIterado.getDetalle()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirProductos con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        Producto productoEncontrada = new Producto();
        Producto productoIterado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaProducto.size();i++){
            productoIterado = (Producto) ListaEnlazadaProducto.getElement(i);
            if(productoIterado.getCodigo() == codigo){
                productoEncontrada = productoIterado;
            }else{
                throw new Exception("No existe el producto");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarProductoPorCodigo con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return productoEncontrada;
    }
    
    
    /*Chaza*/
    
    public void agregarNuevaChaza(String nombreChaza, String ubicacion, String descripcion, Vendedor vendedor){
        Chaza nuevaChaza = new Chaza(nombreChaza,ubicacion,descripcion,vendedor);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaChaza.pushBack(nuevaChaza);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaChaza con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente "+ nuevaChaza.getNombreChaza());
    }
    
    public Chaza eliminarChaza(String nombreChaza){
        Chaza chazaAEliminar = new Chaza();
        try{
            long time_start, time_end;
            time_start = System.nanoTime();
            chazaAEliminar = buscarChazaPorNombre(nombreChaza);
            ListaEnlazadaChaza.delete(chazaAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarChaza con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        }catch(Exception e){
            System.out.println("La chaza no se encontró");
        }
        
        return chazaAEliminar; 
    }
    
    public Chaza actualizarCategoriaChaza(Chaza chazaActualizar, String categoria, String datoModificado){
        switch(categoria){
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
    
    public void actualizarChaza(String nombreChazaAntiguo, String categoria, String datoModificado){
        Chaza chazaAntigua = new Chaza();
        
        try{
            chazaAntigua = buscarChazaPorNombre(nombreChazaAntiguo);
        }catch(Exception e){
            System.out.println("No se pudo actualizar la chaza, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Chaza chazaActualizada = actualizarCategoriaChaza(chazaAntigua,categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaChaza con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaChaza.ActualizarData(chazaAntigua, chazaActualizada);
        time_end2 = System.nanoTime();
        System.out.println("actualizarChaza con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
    }
    
    public void imprimirChazas(){
        Chaza chazaIterado = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaChaza.size();i++){
            chazaIterado = (Chaza) ListaEnlazadaChaza.getElement(i);
            System.out.println(chazaIterado.getNombreChaza()+ " " + chazaIterado.getUbicacion() + " " + chazaIterado.getDescripcion() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirChazas con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Chaza buscarChazaPorNombre(String nombreChaza) throws Exception{
        Chaza chazaEncontrada = new Chaza();
        Chaza chazaIterado = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaChaza.size();i++){
            chazaIterado = (Chaza) ListaEnlazadaChaza.getElement(i);
            if(chazaIterado.getNombreChaza().equals(nombreChaza)){
                chazaEncontrada = chazaIterado;
            }else{
                throw new Exception("No existe la chaza");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarChazaPorNombre con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return chazaEncontrada;
    }
    
    
    
    /*Comentario*/
    
    public void agregarNuevoComentario(long idComentario, Date fechaComentario, String contenido, Cliente cliente, Chaza chaza){
        Comentario nuevoComentario = new Comentario(idComentario, fechaComentario, contenido, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaComentario.pushBack(nuevoComentario);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoComentario con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente: " + idComentario + " " + contenido);
        
    }
    
    public Comentario actualizarCategoriaComentario(Comentario comentarioActualizar, String categoria, String datoModificado){
        switch(categoria){
            case "Contenido":
                comentarioActualizar.setContenido(datoModificado);
                break;
            default:
                System.out.println("La categoria no es válida");
        }
        return comentarioActualizar;
    }
    
    public void actualizarComentario(String idComentarioAntiguo, String categoria, String datoModificado){
        Comentario comentarioAntiguo = new Comentario();
        try{
            comentarioAntiguo = buscarComentarioPorId(Long.parseLong(idComentarioAntiguo));
        }catch(Exception e){
            System.out.println("No se pudo actualizar el comentario, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Comentario comentarioActualizado = actualizarCategoriaComentario(comentarioAntiguo,categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaComentario con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaComentario.ActualizarData(comentarioAntiguo, comentarioActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarComentario con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
        
    }
    
    public void imprimirComentario(){
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaComentario.size();i++){
            comentarioIterado = (Comentario) ListaEnlazadaComentario.getElement(i);
            System.out.println(comentarioIterado.getIdComentario() + " " + comentarioIterado.getContenido() + " " + comentarioIterado.getFechaComentario()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirComentarios con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Comentario buscarComentarioPorId(long idComentario) throws Exception{
        Comentario comentarioEncontrado = new Comentario();
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaComentario.size();i++){
            comentarioIterado = (Comentario) ListaEnlazadaComentario.getElement(i);
            if(comentarioIterado.getIdComentario()==idComentario){
                comentarioEncontrado = comentarioIterado;
            }else{
                throw new Exception("No existe el comentario");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarComentarioPorId con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return comentarioEncontrado;
    }
    
    /*Factura*/
    public void agregarNuevaFactura(long numReferencia, Date fechaFactura, Producto producto, Orden orden, int cantidad, double costoTotal){
        Factura nuevaFactura = new Factura(numReferencia, fechaFactura, producto, orden, cantidad, costoTotal);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaFactura.pushBack(nuevaFactura);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaFactura con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente: " + numReferencia + " " + orden + " " + producto);
    }
    public Factura eliminarFactura(long numReferencia){
        Factura facturaAEliminar = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            facturaAEliminar = buscarFacturaPorId(numReferencia);
            ListaEnlazadaFactura.delete(facturaAEliminar);
            
        }catch(Exception e){
            System.out.println("La factura no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarFactura con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return facturaAEliminar; 
    }
    
    public Factura actualizarCategoriaFactura(Factura facturaActualizar, String categoria, Object datoModificado){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        switch(categoria){
            case "Fecha factura":
                try{
                    Date fecha = formato.parse(datoModificado.toString());
                    facturaActualizar.setFechaFactura(fecha);
                }catch(Exception e){
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
    
    public void actualizarFactura(long referenciaFacturaAntiguo, String categoria, String datoModificado){
        Factura facturaAntigua = new Factura();
        try{
            facturaAntigua = buscarFacturaPorId(referenciaFacturaAntiguo);
        }catch(Exception e){
            System.out.println("No se pudo actualizar la factura, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Factura facturaActualizada = actualizarCategoriaFactura(facturaAntigua,categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaFactura con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaFactura.ActualizarData(facturaAntigua, facturaActualizada);
        time_end2 = System.nanoTime();
        System.out.println("ListaEnlazadaFactura con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
    }
    
    public void imprimirFactura(){
        Factura facturaIterada = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaFactura.size();i++){
            facturaIterada = (Factura) ListaEnlazadaFactura.getElement(i);
            System.out.println(facturaIterada.getNumReferencia() + " " + facturaIterada.getFechaFactura() + " " + facturaIterada.getOrden()+ " " + facturaIterada.getProducto());
        }
        time_end = System.nanoTime();
        System.out.println("imprimirFacturas con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Factura buscarFacturaPorId(long referencia) throws Exception{
        Factura facturaEncontrado = new Factura();
        Factura facturaIterado = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaFactura.size();i++){
            facturaIterado = (Factura) ListaEnlazadaFactura.getElement(i);
            if(facturaIterado.getNumReferencia()== referencia){
                facturaEncontrado = facturaIterado;
            }else{
                throw new Exception("No existe la factura");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return facturaEncontrado;
    }
    
    /*Orden*/
    
    public void agregarNuevaOrden(long numOrden, Date fechaOrden, Cliente cliente,Chaza chaza){
        Orden nuevaOrden = new Orden(numOrden, fechaOrden, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaOrden.pushBack(nuevaOrden);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaOrden con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente: " + numOrden + " " + fechaOrden + " " + cliente + " " + chaza);
    }
    
    public Orden eliminarOrden(long numOrden){
        Orden ordenAEliminar = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            ordenAEliminar = buscarOrdenPorId(numOrden);
            ListaEnlazadaOrden.delete(ordenAEliminar);
            
        }catch(Exception e){
            System.out.println("La orden no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarOrden con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return ordenAEliminar; 
    }
    
    public Orden actualizarCategoriaOrden(Orden ordenActualizar, String categoria, Object datoModificado){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        switch(categoria){
            case "Fecha orden":
                try{
                Date fecha = formato.parse(datoModificado.toString());
                ordenActualizar.setFechaOrden(fecha);
                }catch(Exception e ){
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
    
    public void actualizarOrden(long numOrdenAntigua, String categoria, Object datoModificado){
        Orden ordenAntiguo = new Orden();
        
        try{
            ordenAntiguo = buscarOrdenPorId(numOrdenAntigua);
        }catch(Exception e){
            System.out.println("No se pudo actualizar la orden, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Orden ordenActualizado = actualizarCategoriaOrden(ordenAntiguo,categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaOrden con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaOrden.ActualizarData(ordenAntiguo, ordenActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarOrden con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
        
    }
    
    public void imprimirOrden(){
        Orden ordenIterado = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaOrden.size();i++){
            ordenIterado = (Orden) ListaEnlazadaOrden.getElement(i);
            System.out.println(ordenIterado.getNumOrden() + " " + ordenIterado.getFechaOrden() + " " + ordenIterado.getCliente()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirOrdenes con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Orden buscarOrdenPorId(long numOrden) throws Exception{
        Orden ordenEncontrada = new Orden();
        Orden ordenIterada= new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaOrden.size();i++){
            ordenIterada = (Orden) ListaEnlazadaOrden.getElement(i);
            if(ordenIterada.getNumOrden()== numOrden){
                ordenEncontrada = ordenIterada;
            }else{
                throw new Exception("No existe la orden");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarOrdenPorId con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return ordenEncontrada;
    }
    
    
    /*Vendedor*/
    
    public Vendedor iniciarSesionVendedor(String correo, String contrasena){
        Vendedor vendedorIngreso = new Vendedor();
        Vendedor vendedorRetorno = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaVendedor.size();i++){
            vendedorIngreso = (Vendedor) ListaEnlazadaVendedor.getElement(i);
            if(vendedorIngreso.getCorreo().equals(correo) && vendedorIngreso.getContrasena().equals(contrasena)){
                vendedorRetorno = vendedorIngreso;
            }else{
                System.out.println("¡El cliente no existe!");
                vendedorRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return vendedorRetorno;
    }
    
    public void agregarNuevoVendedor(String correo, String nombre, String apellido, String telefono, String contrasena){
        Vendedor nuevoVendedor = new Vendedor(correo, nombre, apellido,telefono, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        ListaEnlazadaVendedor.pushBack(nuevoVendedor);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoVendedor con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    //Devuelve el cliente borrado
    public Vendedor eliminarVendedor(String correo){
        Vendedor vendedorAEliminar = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            vendedorAEliminar = buscarVendedorPorCorreo(correo);
            ListaEnlazadaVendedor.delete(vendedorAEliminar);
            
        }catch(Exception e){
            System.out.println("El cliente no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarVendedor con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return vendedorAEliminar; 
    }
    
    public void eliminarVendedor(){
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            ListaEnlazadaVendedor.popFront();
            
        }catch(Exception e){
            System.out.println("El Vendedor no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarVendedor con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Vendedor actualizarCategoriaVendedor(Vendedor vendedorActualizar, String categoria, String datoModificado){
        switch(categoria){
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
    
    public void actualizarVendedor(String correoVendedorAntiguo, String categoria, String datoModificado){
        Vendedor vendedorAntiguo = new Vendedor();
        
        try{
            vendedorAntiguo = buscarVendedorPorCorreo(correoVendedorAntiguo);
        }catch(Exception e){
            System.out.println("No se pudo actualizar el vendedor, porque no existe");
        }
        long time_start, time_end;
        time_start = System.nanoTime();
        Vendedor vendedorActualizado = actualizarCategoriaVendedor(vendedorAntiguo,categoria, datoModificado);
        time_end = System.nanoTime();
        System.out.println("actualizarCategoriaVendedor con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        ListaEnlazadaVendedor.ActualizarData(vendedorAntiguo, vendedorActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarVendedor con Lista Enlazada tomo "+ ( time_end2 - time_start2 ) +" nanoseconds");
        
    }
        
    public void imprimirVendedor(){
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaVendedor.size();i++){
            vendedorIterado = (Vendedor) ListaEnlazadaVendedor.getElement(i);
            System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirVendedores con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public void buscarVendedor(String nombre, String apellido){
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaVendedor.size();i++){
            vendedorIterado = (Vendedor) ListaEnlazadaVendedor.getElement(i);
            if(vendedorIterado.getNombre().equals(nombre) && vendedorIterado.getApellido().equals(apellido)){
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo());
            }else{
                System.out.println("El vendedor no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedor con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
    }
    
    public Vendedor buscarVendedorPorCorreo(String correo) throws Exception{
        Vendedor vendedorEncontrado = new Vendedor();
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < ListaEnlazadaVendedor.size();i++){
            vendedorIterado = (Vendedor) ListaEnlazadaClientes.getElement(i);
            if(vendedorIterado.getCorreo().equals(correo)){
                vendedorEncontrado = vendedorIterado;
            }
        }
        if(vendedorEncontrado.getNombre().length()==0){
            System.out.println("No se encontro");
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedorPorCorreo con Lista Enlazada tomo "+ ( time_end - time_start ) +" nanoseconds");
        return vendedorEncontrado;
    }
    
    
}
