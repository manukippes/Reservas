package presentacion;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollBar;

import javax.swing.JInternalFrame;

public class ConsultarTipoElemento extends JInternalFrame {
	private JTextField txtNombreBuscar;

	public ConsultarTipoElemento() {
		setTitle("Consulta de Tipo de Elemento");
		setBounds(100, 100, 619, 440);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1954078469190");
		
		JLabel lblNewLabel = new JLabel("Ingrese Nombre del tipo de Elemento");
		lblNewLabel.setBounds(10, 11, 326, 14);
		desktopPane.add(lblNewLabel);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(305, 8, 203, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(249, 50, 89, 23);
		desktopPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 89, 564, 2);
		desktopPane.add(separator);
		
		JButton btnListadoDeTodos = new JButton("Listado de todos los Tipos de Elementos");
		btnListadoDeTodos.setBounds(199, 107, 231, 23);
		desktopPane.add(btnListadoDeTodos);

	}
}
