package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaLista extends JDialog {
	
	private static VentanaLista instanciaActual = null;
	 
    public static void mostrar(JDialog ventanaPadre, String titulo, String lista) {  // Añade ventanaPadre
        if (instanciaActual != null && instanciaActual.isVisible()) {
            instanciaActual.dispose();
        }
        instanciaActual = new VentanaLista(ventanaPadre, titulo, lista);  // Pasa ventanaPadre
        instanciaActual.setVisible(true);
    }
 
    private VentanaLista(JDialog ventanaPadre, String titulo, String lista) {
        super(ventanaPadre, titulo, ModalityType.APPLICATION_MODAL);  // Modal y encima del padre
        setSize(400, 318);
        setLocationRelativeTo(ventanaPadre);  // Centrado respecto a la ventana padre
        getContentPane().setLayout(null);
 
        JTextArea area = new JTextArea();
        area.setText(lista);
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));  // Fuente monoespaciada para mejor legibilidad
 
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(0, 0, 392, 290);
        getContentPane().add(scrollPane);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}