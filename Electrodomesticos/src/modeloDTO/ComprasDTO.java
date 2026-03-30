package modeloDTO;

public class ComprasDTO {
	
	private int    idCompra;
    private String documentoCliente;
    private int    codigoProducto;
    private int    cantidad;
    private double total;
 
    public ComprasDTO() {
    }
 
    public ComprasDTO(int idCompra, String documentoCliente,
                      int codigoProducto, int cantidad, double total) {
        this.idCompra         = idCompra;
        this.documentoCliente = documentoCliente;
        this.codigoProducto   = codigoProducto;
        this.cantidad         = cantidad;
        this.total            = total;
    }

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ComprasDTO [idCompra=" + idCompra + ", documentoCliente=" + documentoCliente + ", codigoProducto="
				+ codigoProducto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
    
    

}
