package modeloDTO;

public class ClientesDTO {
	
	private String documento;
	private String nombre;
	private String apellido;
	private int edad;
	private String telefono;
	private String tipo;
	
	public ClientesDTO() {
	}
	
	public ClientesDTO(String documento, String nombre, String apellido, int edad, String telefono, String tipo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.tipo = tipo;
    }

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "ClientesDTO [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", edad="
				+ edad + ", telefono=" + telefono + ", tipo=" + tipo + "]";
	}
	
	
	
	

}
