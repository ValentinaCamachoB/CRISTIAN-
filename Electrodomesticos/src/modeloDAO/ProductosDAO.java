package modeloDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexion.Conexion;
import controlador.Coordinador;
import modeloDTO.ProductosDTO;

public class ProductosDAO {
	
	private Coordinador miCoordinador;
	 
    public void setCoordinador(Coordinador miCoordinador) {
        this.setMiCoordinador(miCoordinador);
    }
 
    public String registrarProducto(ProductosDTO producto) {
        if (consultarProductoPorCodigo(producto.getCodigo()) != null) {
            return "no";
        }
        String sql = "INSERT INTO Productos (codigo, nombre, precio, stock) VALUES (?,?,?,?)";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.executeUpdate();
            conn.close();
            return "si";
        } catch (Exception e) {
            System.out.println("Error registrarProducto: " + e.getMessage());
            return "no";
        }
    }
 
    public ProductosDTO consultarProductoPorCodigo(int codigo) {
        String sql = "SELECT * FROM Productos WHERE codigo = ?";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProductosDTO p = new ProductosDTO(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                conn.close();
                return p;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error consultarProducto: " + e.getMessage());
        }
        return null;
    }
 
    public ArrayList<ProductosDTO> consultarListaProductos() {
        ArrayList<ProductosDTO> lista = new ArrayList<ProductosDTO>();
        String sql = "SELECT * FROM Productos";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductosDTO p = new ProductosDTO(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                lista.add(p);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error consultarListaProductos: " + e.getMessage());
        }
        return lista;
    }
 
    public String actualizarProducto(ProductosDTO producto) {
        String sql = "UPDATE Productos SET nombre=?, precio=?, stock=? WHERE codigo=?";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getCodigo());
            int filas = ps.executeUpdate();
            conn.close();
            if (filas > 0) {
                return "ok";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println("Error actualizarProducto: " + e.getMessage());
            return "error";
        }
    }
 
    public String eliminarProducto(int codigo) {
        String sql = "DELETE FROM Productos WHERE codigo=?";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            int filas = ps.executeUpdate();
            conn.close();
            if (filas > 0) {
                return "ok";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println("Error eliminarProducto: " + e.getMessage());
            return "error";
        }
    }

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
