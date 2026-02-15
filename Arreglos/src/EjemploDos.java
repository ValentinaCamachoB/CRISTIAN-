import javax.swing.JOptionPane;

public class EjemploDos {

	public static void main(String[] args) {
		
		//Encontrar el numero mayor
		
		int  cantidad =Integer.parseInt(JOptionPane.showInputDialog("Cuantos numero va a ingresar"));
		int  [] n = new int [cantidad];
		
		for (int i=0;i<n.length;i++) {
			n[i] =Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero"));
			System.out.println(n[i]);
		}
		
		
		int mayor = n[0];
        for (int i = 1; i < n.length; i++) {
            if (n[i] > mayor) {
                mayor = n[i];
            }
        }
        String mensaje ="Números ingresados:\n";
        for (int i = 0; i < n.length; i++) {
           mensaje += "  Número: "+ n[i] + "\n";
       }
       
       mensaje += "\nEl número mayor es: " + mayor;

       JOptionPane.showMessageDialog(null, mensaje);
		
				

	}

}
