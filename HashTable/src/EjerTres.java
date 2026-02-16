import javax.swing.JOptionPane;
import java.util.Hashtable;

public class EjerTres {

	public static void main(String[] args) {
		
		Hashtable<String, String> tablaVehiculos = new Hashtable<String, String>();
		//PERMITE REGISTRAR LOS VEHICULOS QUE QUIERA Y AL FINAL MUESTRA  Y EL TOTAL DE VEHICULOS REGISTRADOS

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos vehículos va a registrar?"));

        for (int i = 0; i < cantidad; i++) {
            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo " + (i + 1) + ":");
            String dueno = JOptionPane.showInputDialog("Ingrese el nombre del dueño:");
            tablaVehiculos.put(placa, dueno);
        }

       
        String mensaje = "VEHICULOS \n\n";
        for (String placa : tablaVehiculos.keySet()) {
            mensaje += "Placa: " + placa + " | Dueño: " + tablaVehiculos.get(placa) + "\n";
        }
        mensaje += "\nTotal de vehículos: " + tablaVehiculos.size();
        JOptionPane.showMessageDialog(null, mensaje);

        

	}

}
