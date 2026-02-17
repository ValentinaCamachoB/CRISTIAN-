import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Iterator;

public class EjemplooDos {

	public static void main(String[] args) {
		/// INGRESO ESTUDIANTES Y LUEGO MUESTRA LOS RESULTADOS DE LO AGREGADO
		
		HashMap<String, Integer> notas = new HashMap<>();

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos estudiantes va a ingresar?"));

        for (int i = 0; i < cantidad; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1) + ":");
            Integer nota  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota de " + nombre + ":"));
            notas.put(nombre, nota);
        }

        
        String mensaje = " Resultados Finales \n\n";
        
        Iterator<String> iterator = notas.keySet().iterator();
        while (iterator.hasNext()) {
            String est = iterator.next();
            int nota = notas.get(est);
            String estado;
            
            if (nota >= 6) {
                estado = "APROBO";
            } else {
                estado = "REPROBO";
            }
            
            mensaje += est + " | " + nota + " | " + estado + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

	

}

