package gui;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaLista extends JFrame {

	public VentanaLista(String lista) {

        setTitle("Lista de Estudiantes");
        setSize(400, 318);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JTextArea area = new JTextArea();
        area.setText(lista);

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(0, 30, 386, 230);
        getContentPane().add(scrollPane);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane.setRowHeaderView(scrollPane_1);
	}

}
