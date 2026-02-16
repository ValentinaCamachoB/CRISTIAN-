import javax.swing.JOptionPane;
import java.util.HashMap;

public class EjercDos {

	public static void main(String[] args) {
		// PERMITA REGISTRAR USUARIOS NUEVO, MUESTRE TODOS LOS QUE ESTAN REGISTRADOS , INICIAR SESION PARA QUE SALGA  BIENVENIDO
		HashMap<String, String> usuarios = new HashMap<>();
		
        usuarios.put("ana2025",   "clave123");
        usuarios.put("luisdev",   "java2025");
        usuarios.put("maria_dev", "sena2025");

        int opcion = 0;

        while (opcion != 4) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
            	" USUARIOS  \n\n" +
                "1. Iniciar sesión\n" +
                "2. Registrar usuario\n" +
                "3. Ver usuarios\n" +
                "4. Salir"));

            if (opcion == 1) {
                String usuario = JOptionPane.showInputDialog("Usuario:");
                String clave   = JOptionPane.showInputDialog("Clave:");

                if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(clave)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + usuario );
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos.");
                }

            } else if (opcion == 2) {
                String nuevoUsuario = JOptionPane.showInputDialog("Nuevo usuario:");
                String nuevaClave   = JOptionPane.showInputDialog("Nueva clave:");

                if (usuarios.containsKey(nuevoUsuario)) {
                    JOptionPane.showMessageDialog(null, "Ese usuario ya existe.");
                } else {
                    usuarios.put(nuevoUsuario, nuevaClave);
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
                }

            } else if (opcion == 3) {
                String mensaje = "Usuarios registrados:\n\n";
                for (String u : usuarios.keySet()) {
                    mensaje += "- " + u + "\n";
                }
                JOptionPane.showMessageDialog(null, mensaje);

            } else if (opcion == 4) {
                JOptionPane.showMessageDialog(null, "ADIOS");
            }
        }

	}
}
