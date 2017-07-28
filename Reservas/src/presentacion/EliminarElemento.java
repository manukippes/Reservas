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

public class EliminarElemento extends JInternalFrame {
	private JTextField txtNombreBuscar;
	private JTextField TxtidEliminar;
	private JTextField txtNombreElilminar;
	private JTextField txtTipoElementoEliminar;

	public EliminarElemento() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Baja de Elemento");
		setBounds(100, 100, 537, 336);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1028718731849");
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Elemento a dar de Baja");
		lblIngreseTipoDe.setBounds(10, 11, 309, 14);
		desktopPane.add(lblIngreseTipoDe);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 89, 14);
		desktopPane.add(lblNombre);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(98, 33, 256, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(383, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 511, 2);
		desktopPane.add(separator);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 115, 73, 14);
		desktopPane.add(lblNombre_1);
		
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		lblCantidadMaximaDe.setBounds(10, 137, 214, 14);
		desktopPane.add(lblCantidadMaximaDe);
		
		TxtidEliminar = new JTextField();
		TxtidEliminar.setEnabled(false);
		TxtidEliminar.setEditable(false);
		TxtidEliminar.setBounds(90, 89, 86, 20);
		desktopPane.add(TxtidEliminar);
		TxtidEliminar.setColumns(10);
		
		txtNombreElilminar = new JTextField();
		txtNombreElilminar.setEnabled(false);
		txtNombreElilminar.setEditable(false);
		txtNombreElilminar.setBounds(98, 112, 235, 20);
		desktopPane.add(txtNombreElilminar);
		txtNombreElilminar.setColumns(10);
		
		txtTipoElementoEliminar = new JTextField();
		txtTipoElementoEliminar.setEditable(false);
		txtTipoElementoEliminar.setEnabled(false);
		txtTipoElementoEliminar.setColumns(10);
		txtTipoElementoEliminar.setBounds(150, 134, 183, 20);
		desktopPane.add(txtTipoElementoEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(161, 190, 130, 23);
		desktopPane.add(btnEliminar);

	}

	
}
