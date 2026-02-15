import javax.swing.JOptionPane;
import java.util.ArrayList;

public class EjemTres {

	public static void main(String[] args) {
		//  MENU , PARA AGREGAR,ELIMINAR,BUSCAR, VER LA LISTA
		
		ArrayList<String> lista = new ArrayList<>();
        int opcion = 0;

        while (opcion != 5) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "MENÚ \n\n" +
                "1. Agregar elemento\n" +
                "2. Eliminar elemento\n" +
                "3. Buscar elemento\n" +
                "4. Ver lista\n" +
                "5. Salir\n\n" +
                "Seleccione una opción:"));

            if (opcion == 1) {
                // AGREGAR
                String nuevo = JOptionPane.showInputDialog("Ingrese el elemento a agregar:");
                lista.add(nuevo);
                JOptionPane.showMessageDialog(null, "\"" + nuevo + "\" agregado correctamente.");

            } else if (opcion == 2) {
                // ELIMINAR
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La lista está vacía.");
                } else {
                    String eliminar = JOptionPane.showInputDialog("Ingrese el elemento a eliminar:");
                    if (lista.contains(eliminar)) {
                        lista.remove(eliminar);
                        JOptionPane.showMessageDialog(null, "\"" + eliminar + "\" eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ese elemento no existe en la lista.");
                    }
                }

            } else if (opcion == 3) {
                // BUSCAR
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La lista está vacía.");
                } else {
                    String buscar = JOptionPane.showInputDialog("Ingrese el elemento a buscar:");
                    if (lista.contains(buscar)) {
                        int posicion = lista.indexOf(buscar);
                        JOptionPane.showMessageDialog(null, "\"" + buscar + "\" encontrado en la posición " + (posicion + 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Ese elemento no existe en la lista.");
                    }
                }

            } else if (opcion == 4) {
                // VER LISTA
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La lista está vacía.");
                } else {
                    String mensaje = "Lista completa:\n\n";
                    for (int i = 0; i < lista.size(); i++) {
                        mensaje += (i + 1) + ". " + lista.get(i) + "\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                }

            } else if (opcion == 5) {
                // SALIR
                JOptionPane.showMessageDialog(null, "ADIOS");

            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo.");
            }
        }
    }
}


