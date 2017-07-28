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

public class ModificarTipoElemento extends JInternalFrame {

	private JTextField txtNombreBuscar;
	private JTextField TxtidModificar;
	private JTextField txtNombreModificar;
	private JTextField txtCantMaxModificar;
	
	public ModificarTipoElemento() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Modificaci\u00F3n de Tipo de Elemento");
		setBounds(100, 100, 624, 315);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1028718731849");
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Tipo de Elemento a modificar");
		lblIngreseTipoDe.setBounds(10, 11, 357, 14);
		desktopPane.add(lblIngreseTipoDe);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 95, 14);
		desktopPane.add(lblNombre);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(120, 33, 303, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(438, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 583, 2);
		desktopPane.add(separator);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 113, 76, 14);
		desktopPane.add(lblNombre_1);
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes: ");
		lblCantidadMaximaDe.setBounds(10, 135, 312, 14);
		desktopPane.add(lblCantidadMaximaDe);
		
		TxtidModificar = new JTextField();
		TxtidModificar.setEnabled(false);
		TxtidModificar.setEditable(false);
		TxtidModificar.setBounds(91, 88, 86, 20);
		desktopPane.add(TxtidModificar);
		TxtidModificar.setColumns(10);
		
		txtNombreModificar = new JTextField();
		txtNombreModificar.setBounds(91, 110, 332, 20);
		desktopPane.add(txtNombreModificar);
		txtNombreModificar.setColumns(10);
		
		txtCantMaxModificar = new JTextField();
		txtCantMaxModificar.setColumns(10);
		txtCantMaxModificar.setBounds(337, 132, 86, 20);
		desktopPane.add(txtCantMaxModificar);
		
		JButton btnEliminar = new JButton("Modificar");
		btnEliminar.setBounds(224, 194, 128, 23);
		desktopPane.add(btnEliminar);

	}


}
