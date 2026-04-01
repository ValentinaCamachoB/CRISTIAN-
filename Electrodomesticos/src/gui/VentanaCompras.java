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
 import javax.swing.JScrollPane;
 import javax.swing.JTextArea;
 import controlador.Coordinador;
 import modeloDTO.ClientesDTO;
 import modeloDTO.ComprasDTO;
 import modeloDTO.ProductosDTO;

public class VentanaCompras extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	JLabel etiRes;
	JTextField textDocCliente,textCodigoProducto,textFCantidad;
	JButton btnRegistrar,btnConsultarLista,btnNCosnultarProductos,btnLimpiar, btnCosnultarClientes ;
	JTextArea areaLista; 
	Coordinador miCoordinador;
	
	public VentanaCompras(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setBounds(100, 100, 643, 473);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Compras");
		iniciarComponentes();		
		{
			
		}
	}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("SECCIÓN COMPRAS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(153, 22, 302, 37);
		contentPanel.add(lblTitulo);
		
		JLabel lblDocumentoCliente = new JLabel("Documento Cliente");
		lblDocumentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumentoCliente.setBounds(36, 82, 154, 12);
		contentPanel.add(lblDocumentoCliente);
		
		textDocCliente = new JTextField();
		textDocCliente.setBounds(192, 81, 96, 18);
		contentPanel.add(textDocCliente);
		textDocCliente.setColumns(10);
		
		JLabel lblCodigoProducto = new JLabel("Codigo Producto");
		lblCodigoProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigoProducto.setBounds(315, 82, 122, 17);
		contentPanel.add(lblCodigoProducto);
		
		textCodigoProducto = new JTextField();
		textCodigoProducto.setBounds(447, 81, 96, 18);
		contentPanel.add(textCodigoProducto);
		textCodigoProducto.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidad.setBounds(36, 114, 88, 17);
		contentPanel.add(lblCantidad);
		
		textFCantidad = new JTextField();
		textFCantidad.setBounds(122, 115, 43, 18);
		contentPanel.add(textFCantidad);
		textFCantidad.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(36, 212, 145, 26);
		contentPanel.add(btnRegistrar);
		
		btnConsultarLista = new JButton("CONSULTAR LISTA ");
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultarLista.setBounds(236, 277, 284, 26);
		contentPanel.add(btnConsultarLista);
		
		etiRes = new JLabel("");
		etiRes.setBounds(36, 155, 516, 47);
		contentPanel.add(etiRes);
		
		btnNCosnultarProductos = new JButton("CONSULTAR PRODUCTOS");
		btnNCosnultarProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNCosnultarProductos.setBounds(236, 241, 284, 26);
		contentPanel.add(btnNCosnultarProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 313, 548, 113);
		contentPanel.add(scrollPane);
		
		areaLista = new JTextArea();
		scrollPane.setViewportView(areaLista);
		areaLista.setEditable(false);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpiar.setBounds(36, 261, 141, 26);
		contentPanel.add(btnLimpiar);
		
		btnCosnultarClientes = new JButton("CONSULTAR CLIENTES");
		btnCosnultarClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCosnultarClientes.setBounds(236, 212, 283, 26);
		contentPanel.add(btnCosnultarClientes);
		
		btnRegistrar.addActionListener(this);
		btnConsultarLista.addActionListener(this);
		btnNCosnultarProductos.addActionListener(this);
		btnLimpiar.addActionListener(this);		
		btnCosnultarClientes.addActionListener(this);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) registrar();
		if (e.getSource() == btnConsultarLista) {
			VentanaLista.mostrar(this, "Lista de Compras", listar());
		}
		if (e.getSource() == btnNCosnultarProductos) consultarProducto();
		if (e.getSource() == btnCosnultarClientes)  consultarClientes(); 
		if (e.getSource() == btnLimpiar) limpiar();
	}
	
	private void registrar() {
		 
		// Validar campos vacios
		if (textDocCliente.getText().equals("") ||
			textCodigoProducto.getText().equals("") ||
			textFCantidad.getText().equals("")) {
 
			etiRes.setText("Complete todos los campos");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		// Buscar el cliente
		ClientesDTO cliente = miCoordinador.consultarCliente(textDocCliente.getText());
 
		if (cliente == null) {
			etiRes.setText("No existe cliente con ese documento");
			etiRes.setForeground(Color.RED);
			return;
		}

		// Validar que el codigo del producto sea un numero entero positivo
		if (!esEnteroPositivo(textCodigoProducto.getText())) {
			etiRes.setText("El codigo del producto debe ser un numero entero positivo");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		// Validar que la cantidad sea un numero entero positivo
		if (!esEnteroPositivo(textFCantidad.getText())) {
			etiRes.setText("La cantidad debe ser un numero entero positivo");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		// Buscar el producto 
		ProductosDTO producto = miCoordinador.consultarProducto(
				Integer.parseInt(textCodigoProducto.getText()));
 
		if (producto == null) {
			etiRes.setText("No existe producto con ese codigo");
			etiRes.setForeground(Color.RED);
			return;
		}
 
		// Obtener la cantidad
		int cantidad = Integer.parseInt(textFCantidad.getText());
		 
		// validar stock
		if (producto.getStock() <= 0) {
			etiRes.setText("No hay más disponibles de ese producto");
			etiRes.setForeground(Color.RED);
			return;
		}
		if (cantidad > producto.getStock()) {
			etiRes.setText("Stock insuficiente. Disponibles: " + producto.getStock());
			etiRes.setForeground(Color.RED);
			return;
		}
		
		// Calcular compra con descuento
		double[] resultado    = miCoordinador.calcularCompra(cliente.getTipo(), producto.getPrecio(), cantidad);
		double totalSin       = resultado[0];
		double montoDescuento = resultado[1];
		double totalCon       = resultado[2];
		String textoDescuento = miCoordinador.textoDescuento(cliente.getTipo());
 
		// Guardar compra
		ComprasDTO compra = new ComprasDTO();
		compra.setDocumentoCliente(cliente.getDocumento());
		compra.setCodigoProducto(producto.getCodigo());
		compra.setCantidad(cantidad);
		compra.setTotal(totalCon);
 
		String resp = miCoordinador.registrarCompra(compra);
 
		if (resp.equals("si")) {
 
			int nuevoStock = producto.getStock() - cantidad;
			producto.setStock(nuevoStock);
			miCoordinador.actualizarProducto(producto);
			
			etiRes.setText("Compra registrada correctamente");
			etiRes.setForeground(Color.BLUE);
 
			String factura =
				"Documento cliente:  " + cliente.getDocumento()  + "\n" +
				"Nombre:             " + cliente.getNombre()      + "\n" +
				"Apellido:           " + cliente.getApellido()    + "\n" +
				"Telefono:           " + cliente.getTelefono()    + "\n" +
				"Tipo:               " + (cliente.getTipo().equals("") ? "Sin tipo" : cliente.getTipo()) + "\n\n" +
				"Producto:           " + producto.getNombre()     + "\n" +
				"Precio unitario:    $" + producto.getPrecio()    + "\n" +
				"Cantidad:           " + cantidad                 + "\n\n" +
				"Precio total:       $" + String.format("%.2f", totalSin)       + "\n" +
				"Descuento:          "  + textoDescuento +
					(montoDescuento > 0 ? "  (-$" + String.format("%.2f", montoDescuento) + ")" : "") + "\n" +
				"TOTAL A PAGAR:      $" + String.format("%.2f", totalCon)       + "\n\n" +
				"Stock restante:     " + nuevoStock;
 
			VentanaFactura ventanaFactura = new VentanaFactura(factura);
			ventanaFactura.setVisible(true);
 
		} else {
			etiRes.setText("No se pudo registrar la compra");
			etiRes.setForeground(Color.RED);
		}
	}
 

	private void consultarProducto() {
 
		ArrayList<ProductosDTO> lista = miCoordinador.consultarListaProductos();
		if (lista.size() > 0) {
			String texto = "";
			for (ProductosDTO p : lista) {
				String disponibilidad = p.getStock() <= 0 ? "  *** SIN STOCK ***" : "";
				texto += "Codigo: "    + p.getCodigo() +
						 "  Nombre: "  + p.getNombre() +
						 "  Precio: $" + p.getPrecio() +
						 "  Stock: "   + p.getStock() +
						 disponibilidad + "\n\n";
			}
			areaLista.setText(texto);
			etiRes.setText("Productos cargados");
			etiRes.setForeground(Color.BLUE);
		} else {
			areaLista.setText("No hay productos registrados");
			etiRes.setText("No hay productos registrados");
			etiRes.setForeground(Color.RED);
		}
	}
 
	
	private void consultarClientes() {
		ArrayList<ClientesDTO> lista = miCoordinador.consultarListaClientes();
		if (lista.size() > 0) {
			String texto = "";
			for (ClientesDTO c : lista) {
				texto += "Documento: " + c.getDocumento() +
						 "  Nombre: "   + c.getNombre() +
						 "  Apellido: " + c.getApellido() +
						 "  Telefono: " + c.getTelefono() +
						 "  Tipo: "     + c.getTipo() + "\n\n";
			}
			areaLista.setText(texto);
			etiRes.setText("Clientes cargados");
			etiRes.setForeground(Color.BLUE);
		} else {
			areaLista.setText("No hay clientes registrados");
			etiRes.setText("No hay clientes registrados");
			etiRes.setForeground(Color.RED);
		}
	}
 
	// Texto de la factura
	private String listar() {
 
		ArrayList<ComprasDTO> lista = miCoordinador.consultarTodasLasCompras();
 
		String texto = "";
 
		if (lista.size() > 0) {
			for (ComprasDTO c : lista) {
				texto += "Compra #"     + c.getIdCompra() +
						 "  Cliente: "  + c.getDocumentoCliente() +
						 "  Producto: " + c.getCodigoProducto() +
						 "  Cantidad: " + c.getCantidad() +
						 "  Total: $"   + String.format("%.2f", c.getTotal()) + "\n\n";
			}
		} else {
			texto = "No hay compras registradas";
		}
 
		return texto;
	}
 
	public void limpiar() {
		textDocCliente.setText("");
		textCodigoProducto.setText("");
		textFCantidad.setText("");
		etiRes.setText("");
		areaLista.setText("");
	}
}

