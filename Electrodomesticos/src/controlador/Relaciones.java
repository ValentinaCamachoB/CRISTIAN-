package controlador;

import modelo.Procesos;
import modeloDAO.ClientesDAO;
import modeloDAO.ComprasDAO;
import modeloDAO.ProductosDAO;
import gui.VentanaClientes;
import gui.VentanaCompras;
import gui.VentanaPrincipal;
import gui.VentanaProductos;

public class Relaciones {
	
	public Relaciones() {
		 
        // 1. Instanciar vistas
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        VentanaClientes  ventanaClientes  = new VentanaClientes(ventanaPrincipal, true);
        VentanaProductos ventanaProductos = new VentanaProductos(ventanaPrincipal, true);
        VentanaCompras   ventanaCompras   = new VentanaCompras(ventanaPrincipal, true);
 
        // 2. Instanciar modelo
        Procesos     misProcesos  = new Procesos();
        ClientesDAO  clientesDAO  = new ClientesDAO();
        ProductosDAO productosDAO = new ProductosDAO();
        ComprasDAO   comprasDAO   = new ComprasDAO();
 
        // 3. Instanciar coordinador
        Coordinador miCoordinador = new Coordinador();
 
        // 4. Inyectar coordinador en vistas
        ventanaPrincipal.setCoordinador(miCoordinador);
        ventanaClientes.setCoordinador(miCoordinador);
        ventanaProductos.setCoordinador(miCoordinador);
        ventanaCompras.setCoordinador(miCoordinador);
 
        // 5. Inyectar coordinador en modelo
        misProcesos.setCoordinador(miCoordinador);
        clientesDAO.setCoordinador(miCoordinador);
        productosDAO.setCoordinador(miCoordinador);
        comprasDAO.setCoordinador(miCoordinador);
 
        // 6. Inyectar vistas y modelo en coordinador
        miCoordinador.setVentanaPrincipal(ventanaPrincipal);
        miCoordinador.setVentanaClientes(ventanaClientes);
        miCoordinador.setVentanaProductos(ventanaProductos);
        miCoordinador.setVentanaCompras(ventanaCompras);
        miCoordinador.setMisProcesos(misProcesos);
        miCoordinador.setClientesDAO(clientesDAO);
        miCoordinador.setProductosDAO(productosDAO);
        miCoordinador.setComprasDAO(comprasDAO);
 
        // 7. Mostrar ventana principal
        miCoordinador.mostrarVentanaPrincipal();
    }

}
