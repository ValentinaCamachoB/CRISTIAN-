package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;


public class VentanaFactura extends JDialog {

	private static VentanaFactura instanciaActual = null;

    public static void mostrar(JDialog ventanaPadre, String factura) {

        if (instanciaActual != null && instanciaActual.isVisible()) {
            instanciaActual.dispose();
        }

        instanciaActual = new VentanaFactura(ventanaPadre, factura);
        instanciaActual.setVisible(true);
    }

    private VentanaFactura(JDialog ventanaPadre, String factura) {

        super(ventanaPadre, "Factura de Compra", ModalityType.MODELESS); 

        setSize(420, 380);
        setLocationRelativeTo(ventanaPadre); 
        setLayout(null);

        JLabel lblTitulo = new JLabel("FACTURA DE COMPRA");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBounds(90, 10, 280, 25);
        add(lblTitulo);

        JTextArea areaFactura = new JTextArea();
        areaFactura.setText(factura);
        areaFactura.setEditable(false);
        areaFactura.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(areaFactura);
        scrollPane.setBounds(20, 58, 370, 270);
        add(scrollPane);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
