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
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDeTipoElemento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreBuscar;
	private JTextField TxtidModificar;
	private JTextField txtNombreModificar;
	private JTextField txtCantMaxModificar;
	private ControladorDeTipoElemento ctrlTipoElemento;
	
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
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 79, 583, 2);
		desktopPane.add(separator);
		
		JLabel lblIngreseTipoDe = new JLabel("Ingrese Tipo de Elemento a modificar");
		lblIngreseTipoDe.setBounds(10, 11, 357, 14);
		desktopPane.add(lblIngreseTipoDe);
		
///////////////NOMBRE A BUSCAR/////////////////////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 95, 14);
		desktopPane.add(lblNombre);
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(120, 33, 303, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
///////////////BOTON BUSCAR/////////////////////////////
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarTipoElemento();
			}
		});
		btnBuscar.setBounds(438, 32, 89, 23);
		desktopPane.add(btnBuscar);
		
///////////////ID MODIFICAR/////////////////////////////
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 92, 46, 14);
		desktopPane.add(lblId);
		TxtidModificar = new JTextField();
		TxtidModificar.setEnabled(false);
		TxtidModificar.setEditable(false);
		TxtidModificar.setBounds(91, 88, 86, 20);
		desktopPane.add(TxtidModificar);
		TxtidModificar.setColumns(10);
		
///////////////NOMBRE A MODIFICAR/////////////////////////////
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 113, 76, 14);
		desktopPane.add(lblNombre_1);
		txtNombreModificar = new JTextField();
		txtNombreModificar.setBounds(91, 110, 332, 20);
		desktopPane.add(txtNombreModificar);
		txtNombreModificar.setColumns(10);
		
///////////////CANTIDAD DE RESERVAS MAXIMAS A MODIFICAR/////////////////////////////
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes: ");
		lblCantidadMaximaDe.setBounds(10, 135, 312, 14);
		desktopPane.add(lblCantidadMaximaDe);
		txtCantMaxModificar = new JTextField();
		txtCantMaxModificar.setColumns(10);
		txtCantMaxModificar.setBounds(337, 132, 86, 20);
		desktopPane.add(txtCantMaxModificar);

///////////////BOTON MODIFICAR TIPO DE ELEMENTO/////////////////////////////
		JButton btnEliminar = new JButton("Modificar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarTipoElemento();
			}
		});
		btnEliminar.setBounds(224, 194, 128, 23);
		desktopPane.add(btnEliminar);

	}

///////////////METODO PARA BUSCAR UN TIPO DE ELEMENTO///////////////////////////
	private void buscarTipoElemento() {
		TipoElemento tipoele = new TipoElemento();
		TipoElemento tipoelenuevo = new TipoElemento();
		ctrlTipoElemento = new ControladorDeTipoElemento();
		tipoele.setNombre(txtNombreBuscar.getText());
		try {
			tipoelenuevo = ctrlTipoElemento.consultaPorNombre(tipoele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		txtNombreModificar.setText(tipoelenuevo.getNombre());
		TxtidModificar.setText(String.valueOf(tipoelenuevo.getId()));
		txtCantMaxModificar.setText(String.valueOf(tipoelenuevo.getCant_max_reservas()));
	}
	
///////////////METODO PARA MODIFICAR UN TIPO DE ELEMENTO/////////////////////////////
	private void modificarTipoElemento() {
		TipoElemento tipoele = new TipoElemento();
		ctrlTipoElemento = new ControladorDeTipoElemento();
		tipoele.setId(Integer.parseInt(TxtidModificar.getText()));
		try {
			ctrlTipoElemento.modificarTipoElemento(tipoele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}

}
