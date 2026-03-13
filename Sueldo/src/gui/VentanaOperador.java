package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.ModeloDatos;
import logica.Operador;
import logica.Procesos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOperador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 JTextField textNombre;
	 JTextField textDocumento;
	 JTextField textSueldo;
	 JTextField textAntiguedad;
     JLabel lblResSueldoNuevo;
	 JLabel lblResAumento;
	 JButton btnRegistrar,btnCancelar;
	 JLabel etiErorres;
	 
	 Procesos miProceso;
	 ModeloDatos miModelo;
	 private JButton btnNConsultar;
	 private JButton btnConsultarLista;

	

	public VentanaOperador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		miProceso =new Procesos();
		miModelo = new ModeloDatos();
		

	}



	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("REGISTRO DE OPERADORES");
		lblTitulo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
		lblTitulo.setBounds(129, 10, 258, 12);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 43, 44, 12);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(105, 40, 152, 18);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDocumento = new JTextField();
		textDocumento.setBounds(356, 40, 96, 18);
		contentPane.add(textDocumento);
		textDocumento.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(280, 43, 66, 12);
		contentPane.add(lblDocumento);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(51, 82, 44, 12);
		contentPane.add(lblSueldo);
		
		textSueldo = new JTextField();
		textSueldo.setBounds(105, 79, 96, 18);
		contentPane.add(textSueldo);
		textSueldo.setColumns(10);
		
		JLabel lblAntiguedad = new JLabel("Antiguedad");
		lblAntiguedad.setBounds(255, 82, 62, 12);
		contentPane.add(lblAntiguedad);
		
		textAntiguedad = new JTextField();
		textAntiguedad.setBounds(327, 79, 44, 18);
		contentPane.add(textAntiguedad);
		textAntiguedad.setColumns(10);
		
		JLabel lblSueldoNuevo = new JLabel("Sueldo Nuevo");
		lblSueldoNuevo.setBounds(51, 123, 71, 12);
		contentPane.add(lblSueldoNuevo);
		
		lblResSueldoNuevo = new JLabel();
		lblResSueldoNuevo.setForeground(new Color(0, 0, 255));
		lblResSueldoNuevo.setBounds(139, 123, 44, 12);
		contentPane.add(lblResSueldoNuevo);
		
		JLabel lblAumento = new JLabel("% Aumento");
		lblAumento.setBounds(208, 123, 62, 12);
		contentPane.add(lblAumento);
		
		lblResAumento = new JLabel();
		lblResAumento.setForeground(new Color(0, 0, 255));
		lblResAumento.setBounds(280, 123, 44, 12);
		contentPane.add(lblResAumento);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(269, 161, 100, 20);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(394, 161, 84, 20);
		contentPane.add(btnCancelar);
		
		etiErorres = new JLabel("");
		etiErorres.setBounds(33, 165, 168, 12);
		contentPane.add(etiErorres);
		
		btnNConsultar = new JButton("...");
		btnNConsultar.setBounds(460, 39, 28, 20);
		contentPane.add(btnNConsultar);
		
		btnConsultarLista = new JButton("Consultar Lista");
		btnConsultarLista.setBounds(153, 161, 84, 20);
		contentPane.add(btnConsultarLista);
		
		btnCancelar.addActionListener(this);
		btnRegistrar.addActionListener(this);
		btnNConsultar.addActionListener(this);
		btnConsultarLista.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnRegistrar) Registrar ();
		if(e.getSource() == btnCancelar)  Cancelar ();
		if(e.getSource()==btnNConsultar) ConsultarIndividual ();
		if(e.getSource()== btnConsultarLista) { miModelo.ConsultarOperadorLista();
		}		
	}



	



	private void ConsultarIndividual() {
		String documento=textDocumento.getText();
		Operador miOpera =miModelo.consultarOperadorPorDocumento(documento);
		
		if (miOpera!= null) {
			System.out.println("Objeto encontrado: "+miOpera);
			textDocumento.setText(miOpera.getDocumento());
			textNombre.setText(miOpera.getNombre());
			textAntiguedad.setText(miOpera.getAntiguedad()+"");
			textSueldo.setText(miOpera.getSueldo()+"");
			lblResAumento.setText(miOpera.getAumento()+"");
			lblResSueldoNuevo.setText(miOpera.getSueldoNuevo()+"");
		}else {
			System.out.println("No existe la persona");
			JOptionPane.showMessageDialog(null, "No existe");
		}
	}



	private void Cancelar() {
		textNombre.setText("");
		textDocumento.setText("");
		textSueldo.setText("");
		textAntiguedad.setText("");
		lblResAumento.setText("");
		lblResSueldoNuevo.setText("");
	}



	private void Registrar() {
		
		 if (textNombre.getText().equals("") ||
		     textDocumento.getText().equals("") ||
		     textSueldo.getText().equals("") ||
		     textAntiguedad.getText().equals("")) {

		     etiErorres.setText("Complete todos los campos");
		     etiErorres.setForeground(Color.RED);
		     return;
		        }
		
		Operador miOperador =new Operador();
		
		miOperador.setDocumento(textDocumento.getText());
		miOperador.setNombre(textNombre.getText());
		miOperador.setSueldo(Double.parseDouble(textSueldo.getText()));
		miOperador.setAntiguedad(Integer.parseInt(textAntiguedad.getText()));
		System.out.println(miOperador);
		
		
		miProceso.calcularSueldoNuevo(miOperador);
		
		System.out.println(miOperador);
		
		lblResSueldoNuevo.setText(miOperador.getSueldoNuevo()+"");
		lblResAumento.setText(miOperador.getAumento()+"");
		
		String respuesta=miModelo.registrarOperador(miOperador);
		
		if (respuesta.equals("si")) {
			JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
		}else {
			JOptionPane.showMessageDialog(null, "No se pudo registrar, ya existe");
		}
				
		
	} 
}
