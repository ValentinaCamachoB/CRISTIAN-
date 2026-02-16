import java.util.Hashtable;
import javax.swing.JOptionPane;

public class EjercUno {

	public static void main(String[] args) {
		Hashtable<String, String> capitales = new Hashtable<>();

		//PERMITE GUARDAR , BUSCAR LA CAPITAL,Y QUE MUESTRE TODO
        capitales.put("Colombia",  "Bogotá");
        capitales.put("México",    "Ciudad de México");
        capitales.put("Argentina", "Buenos Aires");
        capitales.put("Brasil",    "Brasilia");

        int opcion = 0;

        while (opcion != 3) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "CAPITALES \n\n" +
                "1. Buscar capital de un país\n" +
                "2. Ver todos los países\n" +
                "3. Salir\n\n" +
                "Seleccione una opción:"));

            if (opcion == 1) {
                String pais = JOptionPane.showInputDialog("Ingrese el nombre del país:");

                if (capitales.containsKey(pais)) {
                    JOptionPane.showMessageDialog(null, "Capital de " + pais + ": " + capitales.get(pais));
                } else {
                    JOptionPane.showMessageDialog(null, "El país \"" + pais + "\" no existe.");
                }

            } else if (opcion == 2) {
                String mensaje = "Todos los países y sus capitales:\n\n";
                for (String p : capitales.keySet()) {
                    mensaje += "Capital de "+p + "  es: " + capitales.get(p) + "\n";
                }
                JOptionPane.showMessageDialog(null, mensaje);

            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "ADIOS");

            } else {
                JOptionPane.showMessageDialog(null, "Opción no valida, intente de nuevo.");
            }

      
        }
        
	}

}
