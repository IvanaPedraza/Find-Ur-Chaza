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
public class ControladorArregloDinamico {
    
    private ArregloDinamicoConCola arregloDinamicoClientes;
    private ArregloDinamicoConCola arregloDinamicoVendedor;
    private ArregloDinamicoConCola arregloDinamicoChaza;
    private ArregloDinamicoConCola arregloDinamicoProducto;
    private ArregloDinamicoConCola arregloDinamicoComentario;
    private ArregloDinamicoConCola arregloDinamicoFactura;
    private ArregloDinamicoConCola arregloDinamicoOrden;
    
    public ControladorArregloDinamico(){
        arregloDinamicoClientes = new ArregloDinamicoConCola();
        arregloDinamicoVendedor = new ArregloDinamicoConCola();
        arregloDinamicoChaza = new ArregloDinamicoConCola();
        arregloDinamicoProducto = new ArregloDinamicoConCola();
        arregloDinamicoComentario = new ArregloDinamicoConCola();
        arregloDinamicoFactura = new ArregloDinamicoConCola();
        arregloDinamicoOrden = new ArregloDinamicoConCola();
    }
    
    /*Cliente*/
    
    public Cliente iniciarSesionCliente(String correo, String contrasena){
        Cliente clienteIngreso = new Cliente();
        Cliente clienteRetorno = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
            clienteIngreso = (Cliente) arregloDinamicoClientes.getElement(i);
            if(clienteIngreso.getCorreo().equals(correo) && clienteIngreso.getContraseña().equals(contrasena)){
                clienteRetorno = clienteIngreso;
            }else{
                System.out.println("¡El cliente no existe!");
                clienteRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("IniciarSesión con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return clienteRetorno;
    }
    
    public void agregarNuevoCliente(String correo, String nombre, String apellido,String contrasena){
        Cliente nuevoCliente = new Cliente(correo, nombre, apellido, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoClientes.pushBack(nuevoCliente);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoCliente con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    //Devuelve el cliente borrado
    public Cliente eliminarCliente(String correo){
        Cliente clienteAEliminar = new Cliente();
        try{
            clienteAEliminar = buscarClientePorCorreo(correo);
            long time_start, time_end;
            time_start = System.nanoTime();
            arregloDinamicoClientes.delete(clienteAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarCliente con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
            
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
            case "Correo":
                clienteActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                clienteActualizar.setContraseña(datoModificado);
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
        System.out.println("actualizarCategoriaCliente con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoClientes.update(clienteAntiguo, clienteActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarCliente con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
        
    }
        
    public void imprimirClientes(){
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirClientes con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public void buscarCliente(String nombre, String apellido){
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            if(clienteIterado.getNombre().equals(nombre) && clienteIterado.getApellido().equals(apellido)){
                System.out.println("El cliente se ha encontrado: ");
                System.out.println(clienteIterado.getNombre() + " " + clienteIterado.getApellido() + " " + clienteIterado.getCorreo());
            }else{
                System.out.println("El cliente no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarCliente con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Cliente buscarClientePorCorreo(String correo) throws Exception{
        Cliente clienteEncontrado = new Cliente();
        Cliente clienteIterado = new Cliente();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoClientes.getConteo();i++){
            clienteIterado = (Cliente) arregloDinamicoClientes.getElement(i);
            if(clienteIterado.getCorreo().equals(correo)){
                clienteEncontrado = clienteIterado;
            }else{
                throw new Exception("No existe el cliente");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarClientePorCorreo con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return clienteEncontrado;
    }
    
    /*Productos*/
    
    public void agregarNuevoProducto(int codigo, String nombre, double precio, String detalle, Date fechaIngreso, Date fechaExpiracion, Date fechaEgreso){
        Producto nuevoProducto = new Producto(codigo,nombre,precio,detalle,fechaIngreso,fechaExpiracion, fechaEgreso);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoProducto.pushBack(nuevoProducto);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoProducto con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        System.out.println("Se ha ingresado correctamente "+ nuevoProducto.getNombre());
    }
    
    public Producto eliminarProducto(int codigoProducto){
        Producto productoAEliminar = new Producto();
        try{
            long time_start, time_end;
            time_start = System.nanoTime();
            productoAEliminar = buscarProductoPorCodigo(codigoProducto);
            arregloDinamicoProducto.delete(productoAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarProducto con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
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
        System.out.println("actualizarCategoriaProducto con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoProducto.update(productoAntiguo, productoActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarProducto con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
    }
    
    public void imprimirProductos(){
        Producto productoIterado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoChaza.getConteo();i++){
            productoIterado = (Producto) arregloDinamicoProducto.getElement(i);
            System.out.println(productoIterado.getCodigo()+ " " + productoIterado.getNombre()+ " " + productoIterado.getDetalle()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirProductos con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        Producto productoEncontrada = new Producto();
        Producto productoIterado = new Producto();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoProducto.getConteo();i++){
            productoIterado = (Producto) arregloDinamicoProducto.getElement(i);
            if(productoIterado.getCodigo() == codigo){
                productoEncontrada = productoIterado;
            }else{
                throw new Exception("No existe el producto");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarProductoPorCodigo con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return productoEncontrada;
    }
    
    
    /*Chaza*/
    
    public void agregarNuevaChaza(String nombreChaza, String ubicacion, String descripcion, Vendedor vendedor){
        Chaza nuevaChaza = new Chaza(nombreChaza,ubicacion,descripcion,vendedor);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoChaza.pushBack(nuevaChaza);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaChaza con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        System.out.println("Se ha ingresado correctamente "+ nuevaChaza.getNombreChaza());
    }
    
    public Chaza eliminarChaza(String nombreChaza){
        Chaza chazaAEliminar = new Chaza();
        try{
            long time_start, time_end;
            time_start = System.nanoTime();
            chazaAEliminar = buscarChazaPorNombre(nombreChaza);
            arregloDinamicoChaza.delete(chazaAEliminar);
            time_end = System.nanoTime();
            System.out.println("eliminarChaza con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
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
        System.out.println("actualizarCategoriaChaza con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoChaza.update(chazaAntigua, chazaActualizada);
        time_end2 = System.nanoTime();
        System.out.println("actualizarChaza con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
    }
    
    public void imprimirChazas(){
        Chaza chazaIterado = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoChaza.getConteo();i++){
            chazaIterado = (Chaza) arregloDinamicoChaza.getElement(i);
            System.out.println(chazaIterado.getNombreChaza()+ " " + chazaIterado.getUbicacion() + " " + chazaIterado.getDescripcion() + " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirChazas con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Chaza buscarChazaPorNombre(String nombreChaza) throws Exception{
        Chaza chazaEncontrada = new Chaza();
        Chaza chazaIterado = new Chaza();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoChaza.getConteo();i++){
            chazaIterado = (Chaza) arregloDinamicoChaza.getElement(i);
            if(chazaIterado.getNombreChaza().equals(nombreChaza)){
                chazaEncontrada = chazaIterado;
            }else{
                throw new Exception("No existe la chaza");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarChazaPorNombre con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return chazaEncontrada;
    }
    
    
    
    /*Comentario*/
    
    public void agregarNuevoComentario(long idComentario, Date fechaComentario, String contenido, Cliente cliente, Chaza chaza){
        Comentario nuevoComentario = new Comentario(idComentario, fechaComentario, contenido, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoComentario.pushBack(nuevoComentario);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoComentario con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
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
        System.out.println("actualizarCategoriaComentario con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoComentario.update(comentarioAntiguo, comentarioActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarComentario con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
        
    }
    
    public void imprimirComentario(){
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoComentario.getConteo();i++){
            comentarioIterado = (Comentario) arregloDinamicoComentario.getElement(i);
            System.out.println(comentarioIterado.getIdComentario() + " " + comentarioIterado.getContenido() + " " + comentarioIterado.getFechaComentario()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirComentarios con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Comentario buscarComentarioPorId(long idComentario) throws Exception{
        Comentario comentarioEncontrado = new Comentario();
        Comentario comentarioIterado = new Comentario();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoComentario.getConteo();i++){
            comentarioIterado = (Comentario) arregloDinamicoComentario.getElement(i);
            if(comentarioIterado.getIdComentario()==idComentario){
                comentarioEncontrado = comentarioIterado;
            }else{
                throw new Exception("No existe el comentario");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarComentarioPorId con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return comentarioEncontrado;
    }
    
    /*Factura*/
    public void agregarNuevaFactura(long numReferencia, Date fechaFactura, Producto producto, Orden orden, double costoTotal){
        Factura nuevaFactura = new Factura(numReferencia, fechaFactura, producto, orden, costoTotal);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoFactura.pushBack(nuevaFactura);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaFactura con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        System.out.println("Se ha ingresado correctamente: " + numReferencia + " " + orden + " " + producto);
    }
    public Factura eliminarFactura(long numReferencia){
        Factura facturaAEliminar = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            facturaAEliminar = buscarFacturaPorId(numReferencia);
            arregloDinamicoFactura.delete(facturaAEliminar);
            
        }catch(Exception e){
            System.out.println("La factura no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarFactura con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
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
        System.out.println("actualizarCategoriaFactura con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoFactura.update(facturaAntigua, facturaActualizada);
        time_end2 = System.nanoTime();
        System.out.println("arregloDinamicoFactura con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
    }
    
    public void imprimirFactura(){
        Factura facturaIterada = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoFactura.getConteo();i++){
            facturaIterada = (Factura) arregloDinamicoFactura.getElement(i);
            System.out.println(facturaIterada.getNumReferencia() + " " + facturaIterada.getFechaFactura() + " " + facturaIterada.getOrden()+ " " + facturaIterada.getProducto());
        }
        time_end = System.nanoTime();
        System.out.println("imprimirFacturas con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Factura buscarFacturaPorId(long referencia) throws Exception{
        Factura facturaEncontrado = new Factura();
        Factura facturaIterado = new Factura();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoFactura.getConteo();i++){
            facturaIterado = (Factura) arregloDinamicoFactura.getElement(i);
            if(facturaIterado.getNumReferencia()== referencia){
                facturaEncontrado = facturaIterado;
            }else{
                throw new Exception("No existe la factura");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return facturaEncontrado;
    }
    
    /*Orden*/
    
    public void agregarNuevaOrden(long numOrden, Date fechaOrden, Cliente cliente,Chaza chaza){
        Orden nuevaOrden = new Orden(numOrden, fechaOrden, cliente, chaza);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoOrden.pushBack(nuevaOrden);
        time_end = System.nanoTime();
        System.out.println("agregarNuevaOrden con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        System.out.println("Se ha ingresado correctamente: " + numOrden + " " + fechaOrden + " " + cliente + " " + chaza);
    }
    
    public Orden eliminarOrden(long numOrden){
        Orden ordenAEliminar = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            ordenAEliminar = buscarOrdenPorId(numOrden);
            arregloDinamicoOrden.delete(ordenAEliminar);
            
        }catch(Exception e){
            System.out.println("La orden no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarOrden con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
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
        System.out.println("actualizarCategoriaOrden con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoOrden.update(ordenAntiguo, ordenActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarOrden con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
        
    }
    
    public void imprimirOrden(){
        Orden ordenIterado = new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoOrden.getConteo();i++){
            ordenIterado = (Orden) arregloDinamicoOrden.getElement(i);
            System.out.println(ordenIterado.getNumOrden() + " " + ordenIterado.getFechaOrden() + " " + ordenIterado.getCliente()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirOrdenes con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Orden buscarOrdenPorId(long numOrden) throws Exception{
        Orden ordenEncontrada = new Orden();
        Orden ordenIterada= new Orden();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoOrden.getConteo();i++){
            ordenIterada = (Orden) arregloDinamicoOrden.getElement(i);
            if(ordenIterada.getNumOrden()==){
                vendedorEncontrado = vendedorIterado;
            }else{
                throw new Exception("No existe el cliente");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedorPorCorreo con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return vendedorEncontrado;
    }
    
    
    
    
    
    /*Producto*/
    
    
    
    
    
    
    /*Usuario*/
    
    
    
    
    
    
    /*Vendedor*/
    
    public Vendedor iniciarSesionVendedor(String correo, String contrasena){
        Vendedor vendedorIngreso = new Vendedor();
        Vendedor vendedorRetorno = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIngreso = (Vendedor) arregloDinamicoVendedor.getElement(i);
            if(vendedorIngreso.getCorreo().equals(correo) && vendedorIngreso.getContraseña().equals(contrasena)){
                vendedorRetorno = vendedorIngreso;
            }else{
                System.out.println("¡El cliente no existe!");
                vendedorRetorno = null;
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarFacturaPorId con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return vendedorRetorno;
    }
    
    public void agregarNuevoVendedor(String correo, String nombre, String apellido,String contrasena){
        Vendedor nuevoVendedor = new Vendedor(correo, nombre, apellido, contrasena);
        long time_start, time_end;
        time_start = System.nanoTime();
        arregloDinamicoVendedor.pushBack(nuevoVendedor);
        time_end = System.nanoTime();
        System.out.println("agregarNuevoVendedor con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        System.out.println("Se ha ingresado correctamente: " + nombre + " " + apellido);
    }
    //Devuelve el cliente borrado
    public Vendedor eliminarVendedor(String correo){
        Vendedor vendedorAEliminar = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        try{
            vendedorAEliminar = buscarVendedorPorCorreo(correo);
            arregloDinamicoVendedor.delete(vendedorAEliminar);
            
        }catch(Exception e){
            System.out.println("El cliente no se encontró");
        }
        time_end = System.nanoTime();
        System.out.println("eliminarVendedor con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return vendedorAEliminar; 
    }
    
    public Vendedor actualizarCategoriaVendedor(Vendedor vendedorActualizar, String categoria, String datoModificado){
        switch(categoria){
            case "Nombre":
                vendedorActualizar.setNombre(datoModificado);
                break;
            case "Apellido":
                vendedorActualizar.setApellido(datoModificado);
                break;
            case "Correo":
                vendedorActualizar.setCorreo(datoModificado);
                break;
            case "Contraseña":
                vendedorActualizar.setContraseña(datoModificado);
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
        System.out.println("actualizarCategoriaVendedor con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        
        long time_start2, time_end2;
        time_start2 = System.nanoTime();
        arregloDinamicoVendedor.update(vendedorAntiguo, vendedorActualizado);
        time_end2 = System.nanoTime();
        System.out.println("actualizarVendedor con arreglo dinamico tomo "+ ( time_end2 - time_start2 ) +" milliseconds");
        
    }
        
    public void imprimirVendedor(){
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIterado = (Vendedor) arregloDinamicoClientes.getElement(i);
            System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo()+ " ");
        }
        time_end = System.nanoTime();
        System.out.println("imprimirVendedores con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public void buscarVendedor(String nombre, String apellido){
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIterado = (Vendedor) arregloDinamicoVendedor.getElement(i);
            if(vendedorIterado.getNombre().equals(nombre) && vendedorIterado.getApellido().equals(apellido)){
                System.out.println("El vendedor se ha encontrado: ");
                System.out.println(vendedorIterado.getNombre() + " " + vendedorIterado.getApellido() + " " + vendedorIterado.getCorreo());
            }else{
                System.out.println("El vendedor no se ha encontrado");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedor con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
    }
    
    public Vendedor buscarVendedorPorCorreo(String correo) throws Exception{
        Vendedor vendedorEncontrado = new Vendedor();
        Vendedor vendedorIterado = new Vendedor();
        long time_start, time_end;
        time_start = System.nanoTime();
        for(int i = 0;i < arregloDinamicoVendedor.getConteo();i++){
            vendedorIterado = (Vendedor) arregloDinamicoClientes.getElement(i);
            if(vendedorIterado.getCorreo().equals(correo)){
                vendedorEncontrado = vendedorIterado;
            }else{
                throw new Exception("No existe el cliente");
            }
        }
        time_end = System.nanoTime();
        System.out.println("buscarVendedorPorCorreo con arreglo dinamico tomo "+ ( time_end - time_start ) +" milliseconds");
        return vendedorEncontrado;
    }
    
    
}
