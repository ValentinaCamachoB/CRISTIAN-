package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import entidades.Estudiante;
import clases.Procesos;
import clases.ModeloDatos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaPromedio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	 JPanel contentPane;
	 JLabel etiTitulo;
	 JLabel etiNombre;
	 JLabel etiMateria;
	 JLabel etiN1 ;
	 JLabel etiN2 ;
	 JLabel etiN3 ;
	 JLabel etiRes ;
	 JTextField textNombre;
	 JTextField textMateria;
	 JTextField textN1;
	 JTextField textN2;
	 JTextField textN3;
	 
	 JButton btnCalcular, btnLimpiar, btnConsultar, btnLista,btnEliminar,btnActualizar;
	 JLabel etiDocumento;
	 JTextField textDocumento;

	    JTextArea areaLista;
	    

	    Procesos procesos;
	    ModeloDatos modelo;
	    

	
	public VentanaPromedio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Promedio estudiantes");
		setBounds(100, 100, 656, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		procesos = new Procesos();    
        modelo = new ModeloDatos();
		
	}


	private void iniciarComponentes() {
		
		etiTitulo = new JLabel("SISTEMA CONTROL DE NOTAS");
		etiTitulo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		etiTitulo.setBounds(209, 10, 242, 13);
		contentPane.add(etiTitulo);
		
		etiNombre = new JLabel("Nombre");
		etiNombre.setBounds(212, 49, 57, 12);
		contentPane.add(etiNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(301, 46, 96, 18);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		etiMateria = new JLabel("Materia");
		etiMateria.setBounds(407, 49, 64, 12);
		contentPane.add(etiMateria);
		
		textMateria = new JTextField();
		textMateria.setBounds(481, 46, 96, 18);
		contentPane.add(textMateria);
		textMateria.setColumns(10);
		
		etiN1 = new JLabel("NOTA 1");
		etiN1.setBounds(41, 76, 44, 12);
		contentPane.add(etiN1);
		
		textN1 = new JTextField();
		textN1.setBounds(95, 73, 32, 18);
		contentPane.add(textN1);
		textN1.setColumns(10);
		
		etiN2 = new JLabel("NOTA 2");
		etiN2.setBounds(155, 76, 44, 12);
		contentPane.add(etiN2);
		
		textN2 = new JTextField();
		textN2.setBounds(209, 73, 30, 18);
		contentPane.add(textN2);
		textN2.setColumns(10);
		
		textN3 = new JTextField();
		textN3.setColumns(10);
		textN3.setBounds(311, 73, 36, 18);
		contentPane.add(textN3);
		
		etiN3 = new JLabel("NOTA 3");
		etiN3.setBounds(257, 76, 44, 12);
		contentPane.add(etiN3);
		
		etiRes = new JLabel("");
		etiRes.setBounds(66, 118, 385, 38);
		contentPane.add(etiRes);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(32, 177, 84, 20);
		contentPane.add(btnCalcular);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(126, 177, 84, 20);
		contentPane.add(btnLimpiar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(220, 177, 96, 20);
		contentPane.add(btnConsultar);
		
		btnLista = new JButton("Lista");
		btnLista.setBounds(326, 177, 84, 20);
		contentPane.add(btnLista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 228, 587, 241);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		areaLista = new JTextArea();
		scrollPane.setViewportView(areaLista);
		areaLista.setEditable(false);
		
		etiDocumento = new JLabel("Documento");
		etiDocumento.setBounds(10, 49, 75, 12);
		contentPane.add(etiDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setBounds(97, 46, 96, 18);
		contentPane.add(textDocumento);
		textDocumento.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(420, 177, 84, 20);
		contentPane.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(514, 177, 96, 20);
		contentPane.add(btnActualizar);
		
		btnCalcular.addActionListener(this);
		btnLimpiar.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnLista.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnActualizar.addActionListener(this);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCalcular) calcular();
        if (e.getSource() == btnLimpiar) limpiar();
        if (e.getSource() == btnConsultar) consultar();
        if (e.getSource() == btnLista) {
            VentanaLista v = new VentanaLista(modelo.listar());
            v.setVisible(true);
        }
        if (e.getSource() == btnEliminar) eliminar();
        if (e.getSource() == btnActualizar) actualizar();
    }

    private void calcular() {

        if (textNombre.getText().equals("") ||
            textN1.getText().equals("") ||
            textN2.getText().equals("") ||
            textN3.getText().equals("")) {

            etiRes.setText("Complete todos los campos");
            etiRes.setForeground(Color.RED);
            return;
        }

        double n1 = Double.parseDouble(textN1.getText());
        double n2 = Double.parseDouble(textN2.getText());
        double n3 = Double.parseDouble(textN3.getText());

        Estudiante est = new Estudiante();
        est.setDocumento(textDocumento.getText());
        est.setNombre(textNombre.getText());
        est.setMateria(textMateria.getText());
        est.setNota1(n1);
        est.setNota2(n2);
        est.setNota3(n3);

        double prom = procesos.calcularPromedio(n1, n2, n3);
        est.setPromedio(prom);
        
        if (prom == -1) {
            etiRes.setText("Las notas deben estar entre 0 y 5");
            etiRes.setForeground(Color.RED);
            return;
        }
        

        if (prom >= 3.5) {
            est.setResultado("GANA LA MATERIA");
            etiRes.setForeground(Color.BLUE);
        } else {
            est.setResultado("PIERDE LA MATERIA");
            etiRes.setForeground(Color.RED);
        }

        etiRes.setText("El promedio es: " + prom);

        modelo.registrar(est);
    }

    private void consultar() {

    	if (textDocumento.getText().equals("")) {
            etiRes.setText("Ingrese el documento para consultar");
            etiRes.setForeground(Color.RED);
            return;
        }

        Estudiante e = modelo.consultar(textDocumento.getText());

        if (e != null) {

            areaLista.setText(
            		"DATOS ESTUDIANTES" +
                    "\n Documento: " + e.getDocumento() +" "+","+" Nombre: " + e.getNombre() +" "+","+  " Materia: " + e.getMateria() +                                     
                    "\nNota 1: " + e.getNota1()+"  "+"," +"Nota 2: " + e.getNota2()+ "  "+","+"Nota 3: " + e.getNota3() +
                    "\nPromedio: " + e.getPromedio() +
                    "\nResultado: " + e.getResultado()
            );

            etiRes.setText("Estudiante encontrado");
            etiRes.setForeground(Color.BLUE);

        } else {

            areaLista.setText("");
            etiRes.setText("No existe estudiante con ese documento");
            etiRes.setForeground(Color.RED);
        }
    }

    private void limpiar() {

        textDocumento.setText("");
        textNombre.setText("");
        textMateria.setText("");
        textN1.setText("");
        textN2.setText("");
        textN3.setText("");
        etiRes.setText("");
        areaLista.setText("");
    }
    private void eliminar() {

        if (textDocumento.getText().equals("")) {
            etiRes.setText("Ingrese el documento para eliminar");
            etiRes.setForeground(Color.RED);
            return;
        }

        String mensaje = modelo.eliminar(textDocumento.getText());

        etiRes.setText(mensaje);

        if (mensaje.equals("Estudiante eliminado")) {
            etiRes.setForeground(Color.BLUE);
            limpiar();
        } else {
            etiRes.setForeground(Color.RED); }
        }
        
        private void actualizar() {

            if (textDocumento.getText().equals("")) {
                etiRes.setText("Ingrese el documento para actualizar");
                etiRes.setForeground(Color.RED);
                return;
            }

            double n1 = Double.parseDouble(textN1.getText());
            double n2 = Double.parseDouble(textN2.getText());
            double n3 = Double.parseDouble(textN3.getText());

            double prom = procesos.calcularPromedio(n1, n2, n3);

            if (prom == -1) {
                etiRes.setText("Las notas deben estar entre 0 y 5");
                etiRes.setForeground(Color.RED);
                return;
            }

            Estudiante est = new Estudiante();
            est.setDocumento(textDocumento.getText());
            est.setNombre(textNombre.getText());
            est.setMateria(textMateria.getText());
            est.setNota1(n1);
            est.setNota2(n2);
            est.setNota3(n3);
            est.setPromedio(prom);

            if (prom >= 3.5) {
                est.setResultado("GANA LA MATERIA");
            } else {
                est.setResultado("PIERDE LA MATERIA");
            }

            String mensaje = modelo.actualizar(est);

            etiRes.setText(mensaje);

            if (mensaje.equals("Actualizado correctamente")) {
                etiRes.setForeground(Color.BLUE);
            } else {
                etiRes.setForeground(Color.RED);
            }
        
    }      
		
	}

