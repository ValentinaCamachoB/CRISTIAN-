import javax.swing.JOptionPane;

public class EjmeploTres {

	public static void main(String[] args) {
		// TOTAL VENTAS DE LA SEMANA 
		
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos días de ventas va a ingresar?"));
        int[] ventas = new int[cantidad];

       
        for (int i = 0; i < ventas.length; i++) {
            ventas[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la venta del día " + (i + 1) + ":"));
        }

        
        int total = 0;
        String mensaje = "Ventas por día:\n\n";

        for (int i = 0; i < ventas.length; i++) {
            total += ventas[i];
            mensaje += "Día " + (i + 1) + ": $" + ventas[i] + "\n";
        }

        mensaje += "\nTOTAL DIAS: $" + total;

        JOptionPane.showMessageDialog(null, mensaje);

	}

}
