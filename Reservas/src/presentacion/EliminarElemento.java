package presentacion;


import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import entidades.Elemento;
import logica.ControladorDeElemento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EliminarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreBuscar;
	private JTextField TxtidEliminar;
	private JTextField txtNombreElilminar;
	private JTextField txtTipoElementoEliminar;
	private ControladorDeElemento ctrlElemento;

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
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 511, 2);
		desktopPane.add(separator);
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Elemento a dar de Baja");
		lblIngreseTipoDe.setBounds(10, 11, 309, 14);
		desktopPane.add(lblIngreseTipoDe);
		
///////////////NOMBRE BUSCARs///////////////////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 89, 14);
		desktopPane.add(lblNombre);
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(98, 33, 256, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
///////////////BOTON BUSCAR///////////////////////////
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarElemento();
			}
		});
		btnBuscar.setBounds(383, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
///////////////ID ELIMINAR///////////////////////////
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		TxtidEliminar = new JTextField();
		TxtidEliminar.setEnabled(false);
		TxtidEliminar.setEditable(false);
		TxtidEliminar.setBounds(90, 89, 86, 20);
		desktopPane.add(TxtidEliminar);
		TxtidEliminar.setColumns(10);
		
///////////////NOMBRE ELIMINAR///////////////////////////
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 115, 73, 14);
		desktopPane.add(lblNombre_1);
		txtNombreElilminar = new JTextField();
		txtNombreElilminar.setEnabled(false);
		txtNombreElilminar.setEditable(false);
		txtNombreElilminar.setBounds(98, 112, 235, 20);
		desktopPane.add(txtNombreElilminar);
		txtNombreElilminar.setColumns(10);
		
///////////////TIPO DE ELEMENTO ELIMINAR///////////////////////////
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		lblCantidadMaximaDe.setBounds(10, 137, 214, 14);
		desktopPane.add(lblCantidadMaximaDe);
		txtTipoElementoEliminar = new JTextField();
		txtTipoElementoEliminar.setEditable(false);
		txtTipoElementoEliminar.setEnabled(false);
		txtTipoElementoEliminar.setColumns(10);
		txtTipoElementoEliminar.setBounds(150, 134, 183, 20);
		desktopPane.add(txtTipoElementoEliminar);
		
///////////////BOTON ELIMINAR///////////////////////////
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarElemento();
			}
		});
		btnEliminar.setBounds(161, 190, 130, 23);
		desktopPane.add(btnEliminar);

	}

///////////////METODO PARA BUSCAR UN ELEMENTO///////////////////////////
	private void buscarElemento() {
		Elemento ele = new Elemento();
		Elemento elenuevo = new Elemento();
		ctrlElemento = new ControladorDeElemento();
		ele.setNombre(txtNombreBuscar.getText());
		try {
			elenuevo = ctrlElemento.consultaPorNombre(ele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		txtNombreElilminar.setText(elenuevo.getNombre());
		TxtidEliminar.setText(String.valueOf(elenuevo.getId()));
		txtTipoElementoEliminar.setText(String.valueOf(elenuevo.getTipo()));
	}
	

///////////////METODO PARA ELIMINAR///////////////////////////
	private void eliminarElemento() {
		Elemento ele = new Elemento();
		ctrlElemento = new ControladorDeElemento();
		ele.setNombre(TxtidEliminar.getText());
		try {
			ctrlElemento.borrarElemento(ele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}

}
