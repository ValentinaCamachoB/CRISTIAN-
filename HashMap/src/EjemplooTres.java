import javax.swing.JOptionPane;
import java.util.HashMap;

public class EjemplooTres {
	public static void main(String[] args) {
		//INVENTARIO EN EL QUE SE PUEDXE REGISTRAR PRODUCTOS CON SUS CANTIDADES Y LAS MUESTRA
		
		HashMap<String, Integer> inventario = new HashMap<>();

 
        inventario.put("Arroz", 50);
        inventario.put("Leche", 30);
        inventario.put("Pan", 25);
        inventario.put("Huevos", 40);

        int opcion = 0;

        while (opcion != 4) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "INVENTARIO\n\n" +
                "1. Agregar producto\n" +
                "2. Ver inventario\n" +
                "3. Buscar producto\n" +
                "4. Salir"));

            if (opcion == 1) {
                String producto = JOptionPane.showInputDialog("Nombre del producto:");
                Integer cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
                inventario.put(producto, cantidad);
                JOptionPane.showMessageDialog(null, "Producto agregado.");

            } else if (opcion == 2) {
                String mensaje = "INVENTARIO\n\n";
                for (String prod : inventario.keySet()) {
                    mensaje += prod + ": " + inventario.get(prod) + " unidades\n";
                }
                JOptionPane.showMessageDialog(null, mensaje);

            } else if (opcion == 3) {
                String buscar = JOptionPane.showInputDialog("Producto a buscar:");
                if (inventario.containsKey(buscar)) {
                    JOptionPane.showMessageDialog(null, buscar + ": " + inventario.get(buscar) + " unidades");
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                }

            } else if (opcion == 4) {
                JOptionPane.showMessageDialog(null, "ADIOS");
            }
        }
	}
}
