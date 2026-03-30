package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	 JPanel contentPane;
	JButton btnClientes;	
	JButton btnProductos;
	JButton btnCompras;

	Coordinador miCoordinador;

	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
		
		

	}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("BIENVENIDO A LA TIENDA  DE ELECTRODOMESTICOS ");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo.setBounds(41, 22, 433, 50);
		contentPane.add(lblTitulo);
		
		JLabel lblTitulo_2 = new JLabel("“DON APARATO”");
		lblTitulo_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_2.setBounds(192, 82, 143, 21);
		contentPane.add(lblTitulo_2);
		
		JLabel lblSubtitulo = new JLabel("Eliga la seccion a la desea ingresar");
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSubtitulo.setBounds(172, 140, 190, 39);
		contentPane.add(lblSubtitulo);
		
	    btnClientes = new JButton("CLIENTES");
		btnClientes.setBounds(64, 203, 100, 20);
		contentPane.add(btnClientes);
		
		btnProductos = new JButton("PRODUCTOS");
		btnProductos.setBounds(192, 203, 116, 20);
		contentPane.add(btnProductos);
		
		btnCompras = new JButton("COMPRAS");
		btnCompras.setBounds(336, 203, 100, 20);
		contentPane.add(btnCompras);
		
		JTextArea txtClientes = new JTextArea();
		txtClientes.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtClientes.setText("Para registrarse,\r\nactualizar, eliminar \r\ny consultar");
		txtClientes.setBounds(80, 233, 84, 50);
		contentPane.add(txtClientes);
		
		JTextArea txtProductos = new JTextArea();
		txtProductos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtProductos.setText("Registar, consultar \r\nlista ");
		txtProductos.setBounds(218, 233, 84, 37);
		contentPane.add(txtProductos);
		
		JTextArea txtrRealizarCompras = new JTextArea();
		txtrRealizarCompras.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtrRealizarCompras.setText("Realizar compras,\r\nconsultar lista\r\n");
		txtrRealizarCompras.setBounds(352, 233, 84, 37);
		contentPane.add(txtrRealizarCompras);
		
		btnClientes.addActionListener(this);
		btnProductos.addActionListener(this);
		btnCompras.addActionListener(this);
		
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnClientes) {
			miCoordinador.mostrarVentanaClientes();
			}else if (e.getSource()==btnProductos) {
			miCoordinador.mostrarVentanaProductos();
			}else if (e.getSource()==btnCompras) {
			miCoordinador.mostrarVentanaCompras();
			}	
		
	}

	
}
