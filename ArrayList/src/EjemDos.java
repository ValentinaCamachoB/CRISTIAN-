import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EjemDos {

	public static void main(String[] args) {
		//BUSCAR UN ELEMENTO
		 ArrayList<String> productos = new ArrayList<>();
	        productos.add("Laptop");
	        productos.add("Celular");
	        productos.add("Tablet");
	        productos.add("Audífonos");

	        String buscar = JOptionPane.showInputDialog("¿Qué producto desea buscar?");

	        if (productos.contains(buscar)) {
	            int posicion = productos.indexOf(buscar);
	            JOptionPane.showMessageDialog(null, "\"" + buscar + "\" encontrado en la posición " + (posicion + 1));
	        } else {
	            JOptionPane.showMessageDialog(null, "Ese producto no existe en la lista.");

	   }
    }
}