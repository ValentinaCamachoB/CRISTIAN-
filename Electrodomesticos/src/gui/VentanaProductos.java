package gui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import controlador.Coordinador;
import modeloDTO.ProductosDTO;


public class VentanaProductos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	JLabel etiRes;
	JTextField textCodigo;
	JTextField textNombre;
	JTextField textPrecio;
	JButton btnRegistrar;
	JButton btnConsultar;
	JButton btnActualizar;
	JButton btnEliminar;
	JButton btnLimpiarr;
	JButton btnLista;
 
	Coordinador miCoordinador;
	JTextField textStockk;

	


	public VentanaProductos(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setBounds(100, 100, 585, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Productos");
		iniciarComponentes();								
	}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("SECCIÓN PRODUCTOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(134, 21, 325, 40);
		contentPanel.add(lblTitulo);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigo.setBounds(105, 93, 74, 17);
		contentPanel.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(182, 92, 67, 18);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(286, 94, 67, 14);
		contentPanel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(363, 94, 96, 18);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(105, 129, 44, 12);
		contentPanel.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(182, 128, 67, 18);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStock.setBounds(286, 129, 67, 12);
		contentPanel.add(lblStock);
		
		
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(204, 249, 162, 31);
		contentPanel.add(btnRegistrar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(388, 249, 162, 31);
		contentPanel.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(388, 314, 162, 31);
		contentPanel.add(btnEliminar);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(204, 314, 162, 31);
		contentPanel.add(btnConsultar);
		
		
		
		btnLista = new JButton("LISTA");
		btnLista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLista.setBounds(17, 314, 162, 31);
		contentPanel.add(btnLista);
		
		etiRes = new JLabel("");
		etiRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiRes.setBounds(10, 172, 551, 40);
		contentPanel.add(etiRes);
		
		textStockk = new JTextField();
		textStockk.setBounds(363, 128, 44, 18);
		contentPanel.add(textStockk);
		textStockk.setColumns(10);
		
		btnLimpiarr = new JButton("LIMPIAR");
		btnLimpiarr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpiarr.setBounds(17, 248, 162, 32);
		contentPanel.add(btnLimpiarr);
		
		btnRegistrar.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnActualizar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnLimpiarr.addActionListener(this);
		btnLista.addActionListener(this);
		
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) registrar();
		if (e.getSource() == btnConsultar) consultar();
		if (e.getSource() == btnActualizar) actualizar();
		if (e.getSource() == btnEliminar) eliminar();
		if (e.getSource() == btnLimpiarr) limpiar();
		if (e.getSource() == btnLista) {
			VentanaLista.mostrar(this, "Lista de Productos", listar());
		}
		
	}
	
	private void registrar() {
		 
		if (!esEnteroPositivo(textCodigo.getText())) {
	        etiRes.setText("El código debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
			    
	    if (!esEnteroPositivo(textPrecio.getText())) {
	        etiRes.setText("El precio debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    
	    if (!esEnteroPositivo(textStockk.getText())) {
	        etiRes.setText("El stock debe ser un número entero positivo");
	        etiRes.setForeground(Color.RED);
	        return;
	    }
	    	    
	    if (textCodigo.getText().equals("") ||
				textNombre.getText().equals("") ||
				textPrecio.getText().equals("") ||
				textStockk.getText().equals("")) {
	 
				etiRes.setText("Complete todos los campos");
				etiRes.setForeground(Color.RED);
				return;
			}
 
		ProductosDTO producto = new ProductosDTO();
		producto.setCodigo(Integer.parseInt(textCodigo.getText()));
		producto.setNombre(textNombre.getText());
		producto.setPrecio(Double.parseDouble(textPrecio.getText()));
		producto.setStock(Integer.parseInt(textStockk.getText()));
 
		String resp = miCoordinador.registrarProducto(producto);
 
		if (resp.equals("si")) {
			etiRes.setText("Producto registrado correctamente");
			etiRes.setForeground(Color.BLUE);
		} else {
			etiRes.setText("Ya existe un producto con ese codigo");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private void consultar() {
 
		if (textCodigo.getText().equals("")) {
			etiRes.setText("Ingrese el codigo para consultar");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		ProductosDTO producto = miCoordinador.consultarProducto(
				Integer.parseInt(textCodigo.getText()));
 
		if (producto != null) {
 
			// Llena 
			textNombre.setText(producto.getNombre());
			textPrecio.setText(String.valueOf(producto.getPrecio()));
			textStockk.setText(String.valueOf(producto.getStock()));
 
			etiRes.setText("Producto encontrado");
			etiRes.setForeground(Color.BLUE);
 
		} else {
 
			etiRes.setText("No existe producto con ese codigo");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private void actualizar() {
 
		if (textCodigo.getText().equals("")) {
			etiRes.setText("Ingrese el codigo para actualizar");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		if (textNombre.getText().equals("") ||
			textPrecio.getText().equals("") ||
			textStockk.getText().equals("")) {
 
			etiRes.setText("Complete todos los campos para actualizar");
			etiRes.setForeground(Color.RED);
			return;
		}

		if (!esEnteroPositivo(textCodigo.getText())) {
        etiRes.setText("El código debe ser un número entero positivo");
        etiRes.setForeground(Color.RED);
        return;
    }
    
    if (!esEnteroPositivo(textPrecio.getText())) {
        etiRes.setText("El precio debe ser un número entero positivo");
        etiRes.setForeground(Color.RED);
        return;
    }
    
    if (!esEnteroPositivo(textStockk.getText())) {
        etiRes.setText("El stock debe ser un número entero positivo");
        etiRes.setForeground(Color.RED);
        return;
    }
     
		ProductosDTO producto = new ProductosDTO();
		producto.setCodigo(Integer.parseInt(textCodigo.getText()));
		producto.setNombre(textNombre.getText());
		producto.setPrecio(Double.parseDouble(textPrecio.getText()));
		producto.setStock(Integer.parseInt(textStockk.getText()));
 
		String resp = miCoordinador.actualizarProducto(producto);
 
		if (resp.equals("ok")) {
			etiRes.setText("Producto actualizado correctamente");
			etiRes.setForeground(Color.BLUE);
		} else {
			etiRes.setText("No se encontro el producto para actualizar");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private void eliminar() {
 
		if (textCodigo.getText().equals("")) {
			etiRes.setText("Ingrese el codigo para eliminar");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		String resp = miCoordinador.eliminarProducto(
				Integer.parseInt(textCodigo.getText()));
 
		if (resp.equals("ok")) {
			etiRes.setText("Producto eliminado correctamente");
			etiRes.setForeground(Color.BLUE);
			limpiar();
		} else {
			etiRes.setText("No se encontro el producto para eliminar");
			etiRes.setForeground(Color.RED);
		}
	}
 
	private String listar() {
 
		ArrayList<ProductosDTO> lista = miCoordinador.consultarListaProductos();
 
		String texto = "";
 
		if (lista.size() > 0) {
			for (ProductosDTO p : lista) {
				texto += "Codigo: "  + p.getCodigo() +
						 "  Nombre: "  + p.getNombre() +
						 "  Precio: $" + p.getPrecio() +
						 "  Stock: "   + p.getStock() + "\n\n";
			}
		} else {
			texto = "No hay productos registrados";
		}
 
		return texto;
	}
	
	public void limpiar() {
		textCodigo.setText("");
		textNombre.setText("");
		textPrecio.setText("");
		textStockk.setText("");
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

}

