package conexion;

public class TestConexion {
	public static void main(String[] args) {
        Conexion c = new Conexion();
        if (c.getConnection() != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("Falló la conexión.");
        }
    }
}

	

