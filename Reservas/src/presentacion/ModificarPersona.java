package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import datos.DatosPersona;
import entidades.Persona;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ModificarPersona extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtBuscaDni;
	private JTextField txtBuscaApellido;
	private JTextField txtBuscaNombre;
	private JTextField txtMuestraDNI;
	private JTextField txtMuestraNombre;
	private JTextField txtMuestraUsuario;
	private JTextField txtMuestraApellido;
	private JTextField txtMuestraCategoria;
	private JTextField txtMuestraID;
	private JCheckBox chckbxMuestraHabilitado;
	private JPasswordField passContra;

	public ModificarPersona() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Modificar Persona");
		setBounds(100, 100, 759, 613);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_33682148672596");
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(15, 58, 69, 20);
		desktopPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 99, 69, 20);
		desktopPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 138, 69, 20);
		desktopPane.add(lblApellido);
		
		txtBuscaDni = new JTextField();
		txtBuscaDni.setBounds(80, 55, 253, 26);
		desktopPane.add(txtBuscaDni);
		txtBuscaDni.setColumns(10);
		
		txtBuscaApellido = new JTextField();
		txtBuscaApellido.setBounds(80, 135, 253, 26);
		desktopPane.add(txtBuscaApellido);
		txtBuscaApellido.setColumns(10);
		
		txtBuscaNombre = new JTextField();
		txtBuscaNombre.setColumns(10);
		txtBuscaNombre.setBounds(80, 94, 253, 26);
		desktopPane.add(txtBuscaNombre);
		
		JButton btnBuscarPorDni = new JButton("Buscar");
		btnBuscarPorDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorDni();
			}

		});
		btnBuscarPorDni.setBounds(367, 54, 115, 29);
		desktopPane.add(btnBuscarPorDni);
		
		JButton btnBuscarPorNYA = new JButton("Buscar");
		btnBuscarPorNYA.setBounds(367, 115, 115, 29);
		desktopPane.add(btnBuscarPorNYA);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 193, 713, 2);
		desktopPane.add(separator);
		
		JLabel lblDni_1 = new JLabel("Dni");
		lblDni_1.setBounds(339, 246, 69, 20);
		desktopPane.add(lblDni_1);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(15, 279, 69, 20);
		desktopPane.add(lblNombre_1);
		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(339, 279, 69, 20);
		desktopPane.add(lblApellido_1);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(15, 315, 69, 20);
		desktopPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(339, 315, 101, 20);
		desktopPane.add(lblContrasea);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(339, 351, 69, 20);
		desktopPane.add(lblCategoria);
		
		txtMuestraDNI = new JTextField();
		txtMuestraDNI.setBounds(423, 243, 230, 26);
		desktopPane.add(txtMuestraDNI);
		txtMuestraDNI.setColumns(10);
		
		txtMuestraNombre = new JTextField();
		txtMuestraNombre.setColumns(10);
		txtMuestraNombre.setBounds(78, 279, 230, 26);
		desktopPane.add(txtMuestraNombre);
		
		txtMuestraUsuario = new JTextField();
		txtMuestraUsuario.setColumns(10);
		txtMuestraUsuario.setBounds(77, 315, 230, 26);
		desktopPane.add(txtMuestraUsuario);
		
		txtMuestraApellido = new JTextField();
		txtMuestraApellido.setColumns(10);
		txtMuestraApellido.setBounds(424, 276, 230, 26);
		desktopPane.add(txtMuestraApellido);
		
		txtMuestraCategoria = new JTextField();
		txtMuestraCategoria.setColumns(10);
		txtMuestraCategoria.setBounds(423, 348, 230, 26);
		desktopPane.add(txtMuestraCategoria);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(279, 450, 115, 29);
		desktopPane.add(btnModificar);
		
		JLabel lblModifiqueLosDatos = new JLabel("Modifique los datos de la Persona");
		lblModifiqueLosDatos.setBounds(15, 211, 244, 20);
		desktopPane.add(lblModifiqueLosDatos);
		
		JLabel lblBu = new JLabel("Busque a la Persona que desea modificar");
		lblBu.setBounds(15, 16, 333, 20);
		desktopPane.add(lblBu);
		
		chckbxMuestraHabilitado = new JCheckBox("Habilitado");
		chckbxMuestraHabilitado.setBounds(15, 351, 139, 29);
		desktopPane.add(chckbxMuestraHabilitado);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(15, 246, 69, 20);
		desktopPane.add(lblId);
		
		txtMuestraID = new JTextField();
		txtMuestraID.setEditable(false);
		txtMuestraID.setColumns(10);
		txtMuestraID.setBounds(78, 243, 230, 26);
		desktopPane.add(txtMuestraID);
		
		passContra = new JPasswordField();
		passContra.setBounds(423, 312, 230, 26);
		desktopPane.add(passContra);

	}
	

	public void buscarPorDni() {
		Persona pers = new Persona();
		DatosPersona datospersona = new	DatosPersona();
		Persona personanueva = new Persona();
		personanueva.setDni(txtBuscaDni.getText());
		pers = datospersona.buscarPorDni(personanueva);
		txtMuestraID.setText(String.valueOf(pers.getId()));
		txtMuestraDNI.setText(pers.getDni());
		txtMuestraNombre.setText(pers.getNombre());
		txtMuestraApellido.setText(pers.getApellido());
		txtMuestraUsuario.setText(pers.getUsuario());
		passContra.setText(pers.getContrasena());
		chckbxMuestraHabilitado.setSelected(pers.isHabilitado());
		txtMuestraCategoria.setText(pers.getCategoria());
				
	}
}
