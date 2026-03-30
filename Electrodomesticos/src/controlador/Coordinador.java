package controlador;

import java.util.ArrayList;
import modelo.Procesos;
import modeloDAO.ClientesDAO;
import modeloDAO.ComprasDAO;
import modeloDAO.ProductosDAO;
import modeloDTO.ClientesDTO;
import modeloDTO.ComprasDTO;
import modeloDTO.ProductosDTO;
import gui.VentanaClientes;
import gui.VentanaCompras;
import gui.VentanaPrincipal;
import gui.VentanaProductos;

public class Coordinador {
	
	 // Vistas
    private VentanaPrincipal ventanaPrincipal;
    private VentanaClientes  ventanaClientes;
    private VentanaCompras   ventanaCompras;
    private VentanaProductos ventanaProductos;
 
    
    private Procesos     misProcesos;
    private ClientesDAO  clientesDAO;
    private ProductosDAO productosDAO;
    private ComprasDAO   comprasDAO;
 
    // ── Setters ───────────────────────────────────────────────────────────────
 
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
 
    public void setVentanaClientes(VentanaClientes ventanaClientes) {
        this.ventanaClientes = ventanaClientes;
    }
 
    public void setVentanaCompras(VentanaCompras ventanaCompras) {
        this.ventanaCompras = ventanaCompras;
    }
 
    public void setVentanaProductos(VentanaProductos ventanaProductos) {
        this.ventanaProductos = ventanaProductos;
    }
 
    public void setMisProcesos(Procesos misProcesos) {
        this.misProcesos = misProcesos;
    }
 
    public void setClientesDAO(ClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
 
    public void setProductosDAO(ProductosDAO productosDAO) {
        this.productosDAO = productosDAO;
    }
 
    public void setComprasDAO(ComprasDAO comprasDAO) {
        this.comprasDAO = comprasDAO;
    }
 
    
 
    public void mostrarVentanaPrincipal() {
        ventanaPrincipal.setVisible(true);
    }
 
    public void mostrarVentanaClientes() {
        ventanaClientes.limpiar();
        ventanaClientes.setVisible(true);
    }
 
    public void mostrarVentanaCompras() {
        ventanaCompras.limpiar();
        ventanaCompras.setVisible(true);
    }
 
    public void mostrarVentanaProductos() {
        ventanaProductos.limpiar();
        ventanaProductos.setVisible(true);
    }
 
    
 
    public boolean validarTexto(String valor) {
        return misProcesos.validarTexto(valor);
    }
 
    public boolean validarEnteroPositivo(String valor) {
        return misProcesos.validarEnteroPositivo(valor);
    }
 
    public boolean validarDecimal(String valor) {
        return misProcesos.validarDecimal(valor);
    }
 
    public boolean validarTipo(String valor) {
        return misProcesos.validarTipo(valor);
    }
 
    public double[] calcularCompra(String tipo, double valorUnitario, int cantidad) {
        return misProcesos.calcularCompra(tipo, valorUnitario, cantidad);
    }
 
    public String textoDescuento(String tipo) {
        return misProcesos.textoDescuento(tipo);
    }
 
    
 
    public String registrarCliente(ClientesDTO cliente) {
        return clientesDAO.registrarCliente(cliente);
    }
 
    public ClientesDTO consultarCliente(String documento) {
        return clientesDAO.consultarClientePorDocumento(documento);
    }
 
    public ArrayList<ClientesDTO> consultarListaClientes() {
        return clientesDAO.consultarListaClientes();
    }
 
    public String actualizarCliente(ClientesDTO cliente) {
        return clientesDAO.actualizarCliente(cliente);
    }
 
    public String eliminarCliente(String documento) {
        return clientesDAO.eliminarCliente(documento);
    }
 
   
 
    public String registrarProducto(ProductosDTO producto) {
        return productosDAO.registrarProducto(producto);
    }
 
    public ProductosDTO consultarProducto(int codigo) {
        return productosDAO.consultarProductoPorCodigo(codigo);
    }
 
    public ArrayList<ProductosDTO> consultarListaProductos() {
        return productosDAO.consultarListaProductos();
    }
 
    public String actualizarProducto(ProductosDTO producto) {
        return productosDAO.actualizarProducto(producto);
    }
 
    public String eliminarProducto(int codigo) {
        return productosDAO.eliminarProducto(codigo);
    }
 
    
 
    public String registrarCompra(ComprasDTO compra) {
        return comprasDAO.registrarCompra(compra);
    }
 
    public ArrayList<ComprasDTO> consultarTodasLasCompras() {
        return comprasDAO.consultarTodasLasCompras();
    }
 
}


