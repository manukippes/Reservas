package presentacion;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import javax.swing.JInternalFrame;

public class ConsultarElemento extends JInternalFrame {
	private JTextField txtNombreBuscar;

	public ConsultarElemento() {
		setTitle("Consulta de Elemento");
		setBounds(100, 100, 637, 410);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1954078469190");
		
		JLabel lblNewLabel = new JLabel("Ingrese Nombre del Elemento");
		lblNewLabel.setBounds(10, 11, 289, 14);
		desktopPane.add(lblNewLabel);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(271, 8, 246, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(210, 50, 89, 23);
		desktopPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 89, 596, 2);
		desktopPane.add(separator);
		
		JButton btnListadoDeTodos = new JButton("Listado de todos los Elementos");
		btnListadoDeTodos.setBounds(131, 99, 316, 23);
		desktopPane.add(btnListadoDeTodos);

	}

}
