package presentacion;


import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import entidades.Persona;
import logica.ControladorDePersona;


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
	private ControladorDePersona ctrlPersona;

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
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 193, 713, 2);
		desktopPane.add(separator);
		
		JLabel lblModifiqueLosDatos = new JLabel("Modifique los datos de la Persona");
		lblModifiqueLosDatos.setBounds(15, 211, 244, 20);
		desktopPane.add(lblModifiqueLosDatos);
		
		JLabel lblBu = new JLabel("Busque a la Persona que desea modificar");
		lblBu.setBounds(15, 16, 333, 20);
		desktopPane.add(lblBu);
		
///////////////DNI Buscar////////////////////////		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(15, 58, 69, 20);
		desktopPane.add(lblDni);
		txtBuscaDni = new JTextField();
		txtBuscaDni.setBounds(80, 55, 253, 26);
		desktopPane.add(txtBuscaDni);
		txtBuscaDni.setColumns(10);
		
///////////////Nombre Buscar////////////////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 99, 69, 20);
		desktopPane.add(lblNombre);
		txtBuscaNombre = new JTextField();
		txtBuscaNombre.setColumns(10);
		txtBuscaNombre.setBounds(80, 94, 253, 26);
		desktopPane.add(txtBuscaNombre);
		
///////////////Apellido Buscar////////////////////////
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 138, 69, 20);
		desktopPane.add(lblApellido);
		txtBuscaApellido = new JTextField();
		txtBuscaApellido.setBounds(80, 135, 253, 26);
		desktopPane.add(txtBuscaApellido);
		txtBuscaApellido.setColumns(10);

///////////////Boton Buscar por DNI////////////////////////		
		JButton btnBuscarPorDni = new JButton("Buscar");
		btnBuscarPorDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorDni();
			}

		});
		btnBuscarPorDni.setBounds(367, 54, 115, 29);
		desktopPane.add(btnBuscarPorDni);
		
///////////////Boton Buscar por NombreyApellido////////////////////////
		JButton btnBuscarPorNYA = new JButton("Buscar");
		btnBuscarPorNYA.setBounds(367, 115, 115, 29);
		desktopPane.add(btnBuscarPorNYA);
		
		
///////////////Mostrar DNI////////////////////////
		JLabel lblDni_1 = new JLabel("Dni");
		lblDni_1.setBounds(339, 246, 69, 20);
		desktopPane.add(lblDni_1);
		txtMuestraDNI = new JTextField();
		txtMuestraDNI.setBounds(423, 243, 230, 26);
		desktopPane.add(txtMuestraDNI);
		txtMuestraDNI.setColumns(10);

///////////////Mostrar Nombre////////////////////////
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(15, 279, 69, 20);
		desktopPane.add(lblNombre_1);
		txtMuestraNombre = new JTextField();
		txtMuestraNombre.setColumns(10);
		txtMuestraNombre.setBounds(78, 279, 230, 26);
		desktopPane.add(txtMuestraNombre);
		
///////////////Mostrar Apellido////////////////////////
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(339, 279, 69, 20);
		desktopPane.add(lblApellido_1);
		txtMuestraApellido = new JTextField();
		txtMuestraApellido.setColumns(10);
		txtMuestraApellido.setBounds(424, 276, 230, 26);
		desktopPane.add(txtMuestraApellido);
		
///////////////Mostrar Usuario////////////////////////
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(15, 315, 69, 20);
		desktopPane.add(lblNewLabel);
		txtMuestraUsuario = new JTextField();
		txtMuestraUsuario.setColumns(10);
		txtMuestraUsuario.setBounds(77, 315, 230, 26);
		desktopPane.add(txtMuestraUsuario);
		
///////////////Mostrar Contraseña////////////////////////
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(339, 315, 101, 20);
		desktopPane.add(lblContrasea);
		passContra = new JPasswordField();
		passContra.setBounds(423, 312, 230, 26);
		desktopPane.add(passContra);
		
///////////////Mostrar Categoria////////////////////////
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(339, 351, 69, 20);
		desktopPane.add(lblCategoria);
		txtMuestraCategoria = new JTextField();
		txtMuestraCategoria.setColumns(10);
		txtMuestraCategoria.setBounds(423, 348, 230, 26);
		desktopPane.add(txtMuestraCategoria);

///////////////Mostrar Habilitado////////////////////////
		chckbxMuestraHabilitado = new JCheckBox("Habilitado");
		chckbxMuestraHabilitado.setBounds(15, 351, 139, 29);
		desktopPane.add(chckbxMuestraHabilitado);

		
///////////////Mostrar ID////////////////////////
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(15, 246, 69, 20);
		desktopPane.add(lblId);
		txtMuestraID = new JTextField();
		txtMuestraID.setEditable(false);
		txtMuestraID.setColumns(10);
		txtMuestraID.setBounds(78, 243, 230, 26);
		desktopPane.add(txtMuestraID);
		
		
///////////////Boton Modificar////////////////////////
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarPersona();
			}

		});
		btnModificar.setBounds(279, 450, 115, 29);
		desktopPane.add(btnModificar);
		
	}
	

///////////////Metodo buscaPorDNI////////////////////////
	public void buscarPorDni() {
		Persona pers = new Persona();
		ctrlPersona = new ControladorDePersona();
		Persona personanueva = new Persona();
		personanueva.setDni(txtBuscaDni.getText());
		try {
			pers = ctrlPersona.consultaPorDni(personanueva);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		txtMuestraID.setText(String.valueOf(pers.getId()));
		txtMuestraDNI.setText(pers.getDni());
		txtMuestraNombre.setText(pers.getNombre());
		txtMuestraApellido.setText(pers.getApellido());
		txtMuestraUsuario.setText(pers.getUsuario());
		passContra.setText(pers.getContrasena());
		chckbxMuestraHabilitado.setSelected(pers.isHabilitado());
		txtMuestraCategoria.setText(pers.getCategoria());
				
	}

///////////////Metodo modificar persona////////////////////////
	private void modificarPersona() {
		Persona pers = new Persona();
		ctrlPersona = new ControladorDePersona();
		pers.setNombre(txtMuestraNombre.getText());
		pers.setApellido(txtMuestraApellido.getText());
		pers.setUsuario(txtMuestraUsuario.getText());
		pers.setContrasena(dameClave());
		pers.setCategoria(txtMuestraCategoria.getText());
		pers.setHabilitado(chckbxMuestraHabilitado.isSelected());
		pers.setDni(txtMuestraDNI.getText());
		try {
			ctrlPersona.modificarPersona(pers);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		
	}
	
//////////METODO CAMBIAR PASS POR STRING////////////
private String dameClave() 
		{
			char passArray[] = passContra.getPassword();
			String pass = new String(passArray);
		   return pass;
		}
}
