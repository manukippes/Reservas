package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class EliminarTipoElemento extends JInternalFrame {

	private JTextField txtNombreBuscar;
	private JTextField TxtidEliminar;
	private JTextField txtNombreElilminar;
	private JTextField txtCantMaxEliminar;

	public EliminarTipoElemento() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Baja de Tipo de Elemento");
		setBounds(100, 100, 621, 328);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1028718731849");
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Tipo de Elemento a dar de Baja");
		lblIngreseTipoDe.setBounds(10, 11, 343, 14);
		desktopPane.add(lblIngreseTipoDe);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 95, 14);
		desktopPane.add(lblNombre);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(120, 33, 284, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(446, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 580, 2);
		desktopPane.add(separator);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 115, 95, 14);
		desktopPane.add(lblNombre_1);
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes: ");
		lblCantidadMaximaDe.setBounds(10, 137, 307, 14);
		desktopPane.add(lblCantidadMaximaDe);
		
		TxtidEliminar = new JTextField();
		TxtidEliminar.setEnabled(false);
		TxtidEliminar.setEditable(false);
		TxtidEliminar.setBounds(98, 89, 86, 20);
		desktopPane.add(TxtidEliminar);
		TxtidEliminar.setColumns(10);
		
		txtNombreElilminar = new JTextField();
		txtNombreElilminar.setEnabled(false);
		txtNombreElilminar.setEditable(false);
		txtNombreElilminar.setBounds(98, 112, 320, 20);
		desktopPane.add(txtNombreElilminar);
		txtNombreElilminar.setColumns(10);
		
		txtCantMaxEliminar = new JTextField();
		txtCantMaxEliminar.setEditable(false);
		txtCantMaxEliminar.setEnabled(false);
		txtCantMaxEliminar.setColumns(10);
		txtCantMaxEliminar.setBounds(332, 134, 86, 20);
		desktopPane.add(txtCantMaxEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(197, 214, 136, 23);
		desktopPane.add(btnEliminar);

	}


}
