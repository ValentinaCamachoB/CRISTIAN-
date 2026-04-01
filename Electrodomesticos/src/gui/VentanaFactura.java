package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;


public class VentanaFactura extends JFrame {

	public VentanaFactura(String factura) {
		 
		setTitle("Factura de Compra");
		setSize(420, 380);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
 
		JLabel lblTitulo = new JLabel("FACTURA DE COMPRA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(90, 10, 280, 25);
		getContentPane().add(lblTitulo);
 

		JTextArea areaFactura = new JTextArea();
		areaFactura.setText(factura);
		areaFactura.setEditable(false);
		areaFactura.setFont(new Font("Tahoma", Font.PLAIN, 13));
 
		JScrollPane scrollPane = new JScrollPane(areaFactura);
		scrollPane.setBounds(20, 58, 370, 270);
		getContentPane().add(scrollPane);

		setVisible(true);
	}
}
