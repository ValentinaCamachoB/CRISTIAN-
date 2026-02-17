import java.util.HashMap;
import javax.swing.JOptionPane;

public class EjemplooUno {

	public static void main(String[] args) {
		/// MUESTRE LA AGENDA Y OPCION DE BUSCAR UN CONTACTO
        HashMap<String, String> agenda = new HashMap<>();


        agenda.put("Mama",  "310-555-0101");
        agenda.put("Papa",  "311-555-0202");
        agenda.put("Amiga", "321-555-0303");
        agenda.put("Jefe",  "300-555-0404");

        
        String mensaje = "AGENDA \n\n";
        for (String nombre : agenda.keySet()) {
            mensaje += nombre + ": " + agenda.get(nombre) + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);

        
        String buscar = JOptionPane.showInputDialog("¿Qué contacto desea buscar?");

        if (agenda.containsKey(buscar)) {
            JOptionPane.showMessageDialog(null, buscar + ": " + agenda.get(buscar));
        } else {
            JOptionPane.showMessageDialog(null, "El contacto \"" + buscar + "\" no existe.");
        }


	}

}
