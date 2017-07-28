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

import entidades.TipoElemento;

import javax.swing.JComboBox;

import javax.swing.JInternalFrame;

public class ModificarElemento extends JInternalFrame {
	private JTextField txtNombreBuscar;
	private JTextField TxtidModificar;
	private JTextField txtNombreModificar;
	
	public ModificarElemento() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Modificaci\u00F3n de Elemento");
		setBounds(100, 100, 588, 359);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1028718731849");
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Elemento a modificar");
		lblIngreseTipoDe.setBounds(10, 11, 321, 14);
		desktopPane.add(lblIngreseTipoDe);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 111, 14);
		desktopPane.add(lblNombre);
		
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(122, 33, 286, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(423, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 535, 2);
		desktopPane.add(separator);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 115, 96, 14);
		desktopPane.add(lblNombre_1);
		
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		lblCantidadMaximaDe.setBounds(10, 143, 214, 14);
		desktopPane.add(lblCantidadMaximaDe);
		
		TxtidModificar = new JTextField();
		TxtidModificar.setEnabled(false);
		TxtidModificar.setEditable(false);
		TxtidModificar.setBounds(122, 89, 86, 20);
		desktopPane.add(TxtidModificar);
		TxtidModificar.setColumns(10);
		
		txtNombreModificar = new JTextField();
		txtNombreModificar.setBounds(121, 112, 287, 20);
		desktopPane.add(txtNombreModificar);
		txtNombreModificar.setColumns(10);
		
		JButton btnEliminar = new JButton("Modificar");
		btnEliminar.setBounds(161, 190, 190, 23);
		desktopPane.add(btnEliminar);
		
		JComboBox<TipoElemento> comboBoxTipoElemento = new JComboBox<TipoElemento>();
		comboBoxTipoElemento.setBounds(147, 140, 261, 20);
		desktopPane.add(comboBoxTipoElemento);

	}

}
