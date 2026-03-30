package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexion.Conexion;
import controlador.Coordinador;
import modeloDTO.ComprasDTO;

public class ComprasDAO {
	
	private Coordinador miCoordinador;
	 
    public void setCoordinador(Coordinador miCoordinador) {
        this.setMiCoordinador(miCoordinador);
    }
 
    public String registrarCompra(ComprasDTO compra) {
        String sql = "INSERT INTO Compras (documento_cliente, codigo_producto, cantidad, total) VALUES (?,?,?,?)";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, compra.getDocumentoCliente());
            ps.setInt(2, compra.getCodigoProducto());
            ps.setInt(3, compra.getCantidad());
            ps.setDouble(4, compra.getTotal());
            ps.executeUpdate();
            conn.close();
            return "si";
        } catch (Exception e) {
            System.out.println("Error registrarCompra: " + e.getMessage());
            return "no";
        }
    }
 
    public ArrayList<ComprasDTO> consultarTodasLasCompras() {
        ArrayList<ComprasDTO> lista = new ArrayList<ComprasDTO>();
        String sql = "SELECT * FROM Compras";
        try {
            Connection conn = new Conexion().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComprasDTO c = new ComprasDTO(
                    rs.getInt("id_compra"),
                    rs.getString("documento_cliente"),
                    rs.getInt("codigo_producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("total")
                );
                lista.add(c);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error consultarCompras: " + e.getMessage());
        }
        return lista;
    }

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
