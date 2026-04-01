package gui;

import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import controlador.Coordinador;
import modeloDTO.ClientesDTO;
import javax.swing.SwingConstants;


public class VentanaClientes extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel contentPanel = new JPanel();
	
	JTextField textDocumento;
	JTextField textNombre;
	JTextField textApellido;
	JTextField textEdad;
	JTextField textTelefono;
	JTextField textTipo;
	JButton btnRegistrar;
	JButton btnConsultar;
	JButton btnNewButton;
	JButton btnEliminar;
	JButton btnNLimpiar;
	JButton btnLista;
	JLabel etiRes;
	 
	Coordinador miCoordinador;

	
	public VentanaClientes(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setBounds(100, 100, 657, 380);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 638, 354);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setTitle("Clientes");
		setLocationRelativeTo(null);
		iniciarComponentes();
		
		
			
		}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("SECCIÓN DE CLIENTES");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(115, 10, 350, 34);
		contentPanel.add(lblTitulo);
 
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(29, 74, 96, 12);
		contentPanel.add(lblDocumento);
 
		textDocumento = new JTextField();
		textDocumento.setBounds(127, 73, 96, 18);
		contentPanel.add(textDocumento);
		textDocumento.setColumns(10);
 
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(254, 74, 73, 12);
		contentPanel.add(lblNombre);
 
		textNombre = new JTextField();
		textNombre.setBounds(330, 73, 96, 18);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
 
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(458, 74, 70, 12);
		contentPanel.add(lblApellido);
 
		textApellido = new JTextField();
		textApellido.setBounds(526, 73, 96, 18);
		contentPanel.add(textApellido);
		textApellido.setColumns(10);
 
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdad.setBounds(29, 115, 44, 12);
		contentPanel.add(lblEdad);
 
		textEdad = new JTextField();
		textEdad.setBounds(83, 114, 35, 18);
		contentPanel.add(textEdad);
		textEdad.setColumns(10);
 
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefono.setBounds(164, 115, 59, 12);
		contentPanel.add(lblTelefono);
 
		textTelefono = new JTextField();
		textTelefono.setBounds(233, 114, 96, 18);
		contentPanel.add(textTelefono);
		textTelefono.setColumns(10);
 
		JLabel lblNewLabel = new JLabel("Tipo (A,B,C)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(356, 111, 96, 20);
		contentPanel.add(lblNewLabel);
 
		textTipo = new JTextField();
		textTipo.setBounds(462, 114, 35, 18);
		contentPanel.add(textTipo);
		textTipo.setColumns(10);
 
		etiRes = new JLabel("");
		etiRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiRes.setBounds(46, 162, 511, 34);
		contentPanel.add(etiRes);
 
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(29, 228, 164, 34);
		contentPanel.add(btnRegistrar);
 
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(209, 228, 164, 34);
		contentPanel.add(btnConsultar);
 
		btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(393, 228, 164, 34);
		contentPanel.add(btnNewButton);
 
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(29, 278, 164, 34);
		contentPanel.add(btnEliminar);
 
		btnLista = new JButton("LISTA");
		btnLista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLista.setBounds(209, 278, 164, 34);
		contentPanel.add(btnLista);
 
		btnNLimpiar = new JButton("LIMPIAR");
		btnNLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNLimpiar.setBounds(393, 278, 164, 34);
		contentPanel.add(btnNLimpiar);
 
		btnRegistrar.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnLista.addActionListener(this);
		btnNLimpiar.addActionListener(this);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) registrar();
		if (e.getSource() == btnConsultar) consultar();
		if (e.getSource() == btnNewButton) actualizar();
		if (e.getSource() == btnEliminar) eliminar();
		if (e.getSource() == btnNLimpiar) limpiar();
		if (e.getSource() == btnLista) {
			VentanaLista.mostrar(this, "Lista de Clientes", listar());
		}
	
	}
	private void registrar() {
		 
		if (!esEnteroPositivo(textDocumento.getText())) {
	        etiRes.setText("El documento debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    	   
	    	    
	    if (!esSoloLetras(textNombre.getText())) {
	        etiRes.setText("El nombre debe contener solo letras");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    	    
	    if (!esSoloLetras(textApellido.getText())) {
	        etiRes.setText("El apellido debe contener solo letras");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    
	    if (!esEnteroPositivo(textEdad.getText())) {
			etiRes.setText("La edad debe ser un numero entero positivo");
			etiRes.setForeground(Color.RED);
			return;
		}
	    
	    if (!esEnteroPositivo(textTelefono.getText())) {
	        etiRes.setText("El teléfono debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    	    
	    if (!esSoloLetras(textTipo.getText())) {
	        etiRes.setText("El tipo debe contener solo letras");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
		
		
		if (textDocumento.getText().equals("") ||
				textNombre.getText().equals("") ||
				textApellido.getText().equals("") ||
				textEdad.getText().equals("") ||
				textTelefono.getText().equals("")) {
	 
				etiRes.setText("Complete todos los campos");
				etiRes.setForeground(Color.RED);
				return;
			}
 
		ClientesDTO cliente = new ClientesDTO();
		cliente.setDocumento(textDocumento.getText());
		cliente.setNombre(textNombre.getText());
		cliente.setApellido(textApellido.getText());
		cliente.setEdad(Integer.parseInt(textEdad.getText()));
		cliente.setTelefono(textTelefono.getText());
		cliente.setTipo(textTipo.getText().toUpperCase());
 
		String resp = miCoordinador.registrarCliente(cliente);
 
		if (resp.equals("si")) {
			etiRes.setText("Cliente registrado correctamente");
			etiRes.setForeground(Color.BLUE);
		} else {
			etiRes.setText("Ya existe un cliente con ese documento");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private void consultar() {
 
		if (textDocumento.getText().equals("")) {
			etiRes.setText("Ingrese el documento para consultar");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		ClientesDTO cliente = miCoordinador.consultarCliente(textDocumento.getText());
 
		if (cliente != null) {
 
			textNombre.setText(cliente.getNombre());
			textApellido.setText(cliente.getApellido());
			textEdad.setText(String.valueOf(cliente.getEdad()));
			textTelefono.setText(cliente.getTelefono());
			textTipo.setText(cliente.getTipo());
 
			etiRes.setText("Cliente encontrado");
			etiRes.setForeground(Color.BLUE);
 
		} else {
 			
			etiRes.setText("No existe cliente con ese documento");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private void actualizar() {
 
		if (textDocumento.getText().equals("")) {
			etiRes.setText("Ingrese el documento para actualizar");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		if (textNombre.getText().equals("") ||
			textApellido.getText().equals("") ||
			textEdad.getText().equals("") ||
			textTelefono.getText().equals("")) {
 
			etiRes.setText("Complete todos los campos para actualizar");
			etiRes.setForeground(Color.RED);
			return;
		}

		if (!esEnteroPositivo(textDocumento.getText())) {
	        etiRes.setText("El documento debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    
	    if (!esEnteroPositivo(textTelefono.getText())) {
	        etiRes.setText("El teléfono debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    
	    if (!esSoloLetras(textNombre.getText())) {
	        etiRes.setText("El nombre debe contener solo letras");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    
	    if (!esSoloLetras(textApellido.getText())) {
	        etiRes.setText("El apellido debe contener solo letras");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    
	    if (!esSoloLetras(textTipo.getText())) {
	        etiRes.setText("El tipo debe contener solo letras");
	        etiRes.setForeground(Color.RED);
	        return;
	    }

		if (!esEnteroPositivo(textEdad.getText())) {
			etiRes.setText("La edad debe ser un numero entero positivo");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		ClientesDTO cliente = new ClientesDTO();
		cliente.setDocumento(textDocumento.getText());
		cliente.setNombre(textNombre.getText());
		cliente.setApellido(textApellido.getText());
		cliente.setEdad(Integer.parseInt(textEdad.getText()));
		cliente.setTelefono(textTelefono.getText());
		cliente.setTipo(textTipo.getText().toUpperCase());
 
		String resp = miCoordinador.actualizarCliente(cliente);
 
		etiRes.setText(resp);
 
		if (resp.equals("ok")) {
			etiRes.setText("Cliente actualizado correctamente");
			etiRes.setForeground(Color.BLUE);
		} else {
			etiRes.setText("No se encontro el cliente para actualizar");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private void eliminar() {
 
		if (textDocumento.getText().equals("")) {
			etiRes.setText("Ingrese el documento para eliminar");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		String resp = miCoordinador.eliminarCliente(textDocumento.getText());
 
		if (resp.equals("ok")) {
			etiRes.setText("Cliente eliminado correctamente");
			etiRes.setForeground(Color.BLUE);
			limpiar();
		} else {
			etiRes.setText("No se encontro el cliente para eliminar");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private String listar() {
 
		ArrayList<ClientesDTO> lista = miCoordinador.consultarListaClientes();
 
		String texto = "";
 
		if (lista.size() > 0) {
			for (ClientesDTO c : lista) {
				texto += "Documento: " + c.getDocumento() +
						 "  Nombre: "   + c.getNombre() +
						 "  Apellido: " + c.getApellido() +
						 "  Edad: "     + c.getEdad() +
						 "  Telefono: " + c.getTelefono() +
						 "  Tipo: "     + c.getTipo() + "\n\n";
			}
		} else {
			texto = "No hay clientes registrados";
		}
 
		return texto;
	}
		public void limpiar() {
			textDocumento.setText("");
			textNombre.setText("");
			textApellido.setText("");
			textEdad.setText("");
			textTelefono.setText("");
			textTipo.setText("");
			etiRes.setText("");
		}

        private boolean esEnteroPositivo(String valor) {
			try {
				int n = Integer.parseInt(valor.trim());
				return n > 0;
			} catch (NumberFormatException e) {
				return false;
			}
		}

	    private boolean esSoloLetras(String valor) {
		    if (valor.trim().isEmpty()) return false;
		    return valor.trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
		}
	}
	


