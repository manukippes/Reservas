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
import javax.swing.JComboBox;

import entidades.Elemento;
import entidades.TipoElemento;
import logica.ControladorDeElemento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModificarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreBuscar;
	private JTextField TxtidModificar;
	private JTextField txtNombreModificar;
	private ControladorDeElemento ctrlElemento;
	private JComboBox<String> comboBoxTipoElemento;
	
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
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 535, 2);
		desktopPane.add(separator);
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Elemento a modificar");
		lblIngreseTipoDe.setBounds(10, 11, 321, 14);
		desktopPane.add(lblIngreseTipoDe);
		
///////////////NOMBRE A BUSCAR/////////////////////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 111, 14);
		desktopPane.add(lblNombre);
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(122, 33, 286, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
///////////////BOTON BUSCAR/////////////////////////////
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarElemento();
			}
		});
		btnBuscar.setBounds(423, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
///////////////MODIFICAR ID/////////////////////////////
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		TxtidModificar = new JTextField();
		TxtidModificar.setEnabled(false);
		TxtidModificar.setEditable(false);
		TxtidModificar.setBounds(122, 89, 86, 20);
		desktopPane.add(TxtidModificar);
		TxtidModificar.setColumns(10);
		
///////////////MODIFICAR NOMBRE////////////////////////////
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 115, 96, 14);
		desktopPane.add(lblNombre_1);
		txtNombreModificar = new JTextField();
		txtNombreModificar.setBounds(121, 112, 287, 20);
		desktopPane.add(txtNombreModificar);
		txtNombreModificar.setColumns(10);
		
///////////////MODIFICAR TIPO DE ELEMENTO/////////////////////////////
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		lblCantidadMaximaDe.setBounds(10, 143, 214, 14);
		desktopPane.add(lblCantidadMaximaDe);
		comboBoxTipoElemento = new JComboBox<String>();
		comboBoxTipoElemento.setBounds(147, 140, 261, 20);
		desktopPane.add(comboBoxTipoElemento);
	

///////////////BOTON MODIFICAR/////////////////////////////
		JButton btnEliminar = new JButton("Modificar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarElemento();
			}
		});
		btnEliminar.setBounds(161, 190, 190, 23);
		desktopPane.add(btnEliminar);

	}

///////////////METODO PARA BUSCAR UN ELEMENTO/////////////////////////////
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
		txtNombreModificar.setText(elenuevo.getNombre());
		TxtidModificar.setText(String.valueOf(elenuevo.getId()));
		comboBoxTipoElemento.setSelectedItem(elenuevo.getTipo());
	}
	
///////////////METODO PARA MODIFICAR UN ELEMENTO/////////////////////////////
	private void modificarElemento() {
		Elemento ele = new Elemento();
		ctrlElemento = new ControladorDeElemento();
		ele.setId(Integer.parseInt(TxtidModificar.getText()));
		try {
			ctrlElemento.modificarElemento(ele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}

}
