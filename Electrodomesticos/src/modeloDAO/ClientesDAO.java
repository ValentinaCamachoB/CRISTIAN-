package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexion.Conexion;
import controlador.Coordinador;
import modeloDTO.ClientesDTO;

public class ClientesDAO {
	
	private Coordinador miCoordinador;
	 
    public void setCoordinador(Coordinador miCoordinador) {
        this.setMiCoordinador(miCoordinador);
    }
 
    public String registrarCliente(ClientesDTO cliente) {
        // Si ya existe no se registra
        if (consultarClientePorDocumento(cliente.getDocumento()) != null) {
            return "no";
        }
        String sql = "INSERT INTO Cliente (documento, nombre, apellido, edad, telefono, tipo) VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setInt(4, cliente.getEdad());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getTipo());
            ps.executeUpdate();
            conn.close();
            return "si";
        } catch (Exception e) {
            System.out.println("Error registrarCliente: " + e.getMessage());
            return "no";
        }
    }
 
    public ClientesDTO consultarClientePorDocumento(String documento) {
        String sql = "SELECT * FROM Cliente WHERE documento = ?";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ClientesDTO c = new ClientesDTO(
                    rs.getString("documento"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("telefono"),
                    rs.getString("tipo")
                );
                conn.close();
                return c;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error consultarCliente: " + e.getMessage());
        }
        return null;
    }
 
    public ArrayList<ClientesDTO> consultarListaClientes() {
        ArrayList<ClientesDTO> lista = new ArrayList<ClientesDTO>();
        String sql = "SELECT * FROM Cliente";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClientesDTO c = new ClientesDTO(
                    rs.getString("documento"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("telefono"),
                    rs.getString("tipo")
                );
                lista.add(c);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error consultarListaClientes: " + e.getMessage());
        }
        return lista;
    }
 
    public String actualizarCliente(ClientesDTO cliente) {
        String sql = "UPDATE Cliente SET nombre=?, apellido=?, edad=?, telefono=?, tipo=? WHERE documento=?";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getEdad());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getTipo());
            ps.setString(6, cliente.getDocumento());
            int filas = ps.executeUpdate();
            conn.close();
            if (filas > 0) {
                return "ok";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println("Error actualizarCliente: " + e.getMessage());
            return "error";
        }
    }
 
    public String eliminarCliente(String documento) {
        String sql = "DELETE FROM Cliente WHERE documento=?";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, documento);
            int filas = ps.executeUpdate();
            conn.close();
            if (filas > 0) {
                return "ok";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println("Error eliminarCliente: " + e.getMessage());
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


