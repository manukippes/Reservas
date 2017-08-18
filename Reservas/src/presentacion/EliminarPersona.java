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



public class EliminarPersona extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscaDni;
	private JTextField txtBuscaApellido;
	private JTextField txtBuscaNombre;
	private JTextField txtEliminaDni;
	private JTextField txtEliminaNombre;
	private JTextField txtEliminaUsuario;
	private JTextField txtEliminaApellido;
	private JTextField txtEliminaCategoria;
	private JTextField txtEliminaID;
	private JPasswordField passContra;
	private JCheckBox checkEliminaHabilitado;
	private ControladorDePersona ctrlPersona;

	public EliminarPersona() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Eliminar Persona");
		setBounds(100, 100, 766, 631);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_16520377997344");
		
		JLabel lblEliminarLaPersona = new JLabel("Eliminar la Persona");
		lblEliminarLaPersona.setBounds(15, 211, 244, 20);
		desktopPane.add(lblEliminarLaPersona);
		
		JLabel lblBusqueALa = new JLabel("Busque a la Persona que desea eliminar");
		lblBusqueALa.setBounds(15, 16, 333, 20);
		desktopPane.add(lblBusqueALa);
		
////////DNI DE BUSQUEDA/////////
		JLabel label = new JLabel("DNI");
		label.setBounds(15, 58, 69, 20);
		desktopPane.add(label);
		txtBuscaDni = new JTextField();
		txtBuscaDni.setColumns(10);
		txtBuscaDni.setBounds(80, 55, 253, 26);
		desktopPane.add(txtBuscaDni);
		
////////NOMBRE DE BUSQUEDA/////////
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(15, 99, 69, 20);
		desktopPane.add(label_1);
		txtBuscaNombre = new JTextField();
		txtBuscaNombre.setColumns(10);
		txtBuscaNombre.setBounds(80, 94, 253, 26);
		desktopPane.add(txtBuscaNombre);
		
////////APELLIDO DE BUSQUEDA/////////
		JLabel label_2 = new JLabel("Apellido");
		label_2.setBounds(15, 138, 69, 20);
		desktopPane.add(label_2);
		txtBuscaApellido = new JTextField();
		txtBuscaApellido.setColumns(10);
		txtBuscaApellido.setBounds(80, 135, 253, 26);
		desktopPane.add(txtBuscaApellido);
		
////////BOTON DE BUSQUEDA POR DNI/////////
		JButton BtnBuscaDni = new JButton("Buscar");
		BtnBuscaDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorDni();
			}

		});
		BtnBuscaDni.setBounds(367, 54, 115, 29);
		desktopPane.add(BtnBuscaDni);
		
////////BOTON DE BUSQUEDA POR NOMBRE Y APELLIDO/////////
		JButton BtnBuscarPorNYA = new JButton("Buscar");
		BtnBuscarPorNYA.setBounds(367, 115, 115, 29);
		desktopPane.add(BtnBuscarPorNYA);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 193, 713, 2);
		desktopPane.add(separator);
		
////////DNI/////////
		JLabel label_3 = new JLabel("Dni");
		label_3.setBounds(339, 241, 69, 20);
		desktopPane.add(label_3);
		txtEliminaDni = new JTextField();
		txtEliminaDni.setEditable(false);
		txtEliminaDni.setColumns(10);
		txtEliminaDni.setBounds(424, 238, 230, 26);
		desktopPane.add(txtEliminaDni);
		
////////NOMBRE/////////	
		JLabel label_4 = new JLabel("Nombre");
		label_4.setBounds(15, 279, 69, 20);
		desktopPane.add(label_4);
		txtEliminaNombre = new JTextField();
		txtEliminaNombre.setEditable(false);
		txtEliminaNombre.setColumns(10);
		txtEliminaNombre.setBounds(78, 279, 230, 26);
		desktopPane.add(txtEliminaNombre);
		
////////APELLIDO/////////
		JLabel label_5 = new JLabel("Apellido");
		label_5.setBounds(339, 279, 69, 20);
		desktopPane.add(label_5);
		txtEliminaApellido = new JTextField();
		txtEliminaApellido.setEditable(false);
		txtEliminaApellido.setColumns(10);
		txtEliminaApellido.setBounds(424, 276, 230, 26);
		desktopPane.add(txtEliminaApellido);
		
////////USUARIO/////////
		JLabel label_6 = new JLabel("Usuario");
		label_6.setBounds(15, 315, 69, 20);
		desktopPane.add(label_6);
		txtEliminaUsuario = new JTextField();
		txtEliminaUsuario.setEditable(false);
		txtEliminaUsuario.setColumns(10);
		txtEliminaUsuario.setBounds(77, 315, 230, 26);
		desktopPane.add(txtEliminaUsuario);
		
////////CONTRASEÑA/////////
		JLabel label_7 = new JLabel("Contrase\u00F1a");
		label_7.setBounds(339, 315, 101, 20);
		desktopPane.add(label_7);
				passContra = new JPasswordField();
		passContra.setEditable(false);
		passContra.setBounds(424, 312, 230, 23);
		desktopPane.add(passContra);
		
////////CATEGORIA/////////
		JLabel label_8 = new JLabel("Categoria");
		label_8.setBounds(339, 351, 69, 20);
		desktopPane.add(label_8);
		txtEliminaCategoria = new JTextField();
		txtEliminaCategoria.setEditable(false);
		txtEliminaCategoria.setColumns(10);
		txtEliminaCategoria.setBounds(423, 348, 230, 26);
		desktopPane.add(txtEliminaCategoria);
		
////////HABILITADO/////////
		checkEliminaHabilitado = new JCheckBox("Habilitado");
		checkEliminaHabilitado.setEnabled(false);
		checkEliminaHabilitado.setBounds(15, 351, 139, 29);
		desktopPane.add(checkEliminaHabilitado);

////////ID/////////
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(15, 241, 69, 20);
		desktopPane.add(lblId);
		txtEliminaID = new JTextField();
		txtEliminaID.setEditable(false);
		txtEliminaID.setColumns(10);
		txtEliminaID.setBounds(80, 238, 230, 26);
		desktopPane.add(txtEliminaID);

////////BOTON ELIMINAR/////////
		JButton BtnEliminar = new JButton("Eliminar");
		BtnEliminar.setBounds(293, 457, 115, 29);
		BtnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}

		});
		desktopPane.add(BtnEliminar);
	}
	
////////METODO QUE BUSCA POR DNI/////////
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
		txtEliminaID.setText(String.valueOf(pers.getId()));
		txtEliminaDni.setText(pers.getDni());
		txtEliminaNombre.setText(pers.getNombre());
		txtEliminaApellido.setText(pers.getApellido());
		txtEliminaUsuario.setText(pers.getUsuario());
		passContra.setText(pers.getContrasena());
		checkEliminaHabilitado.setSelected(pers.isHabilitado());
		txtEliminaCategoria.setText(pers.getCategoria());
				
	}
	
////////METODO QUE ELIMINA PERSONA/////////
	public void eliminar() {
		Persona personaeliminar = new Persona();
		ctrlPersona = new ControladorDePersona();
		personaeliminar.setId(Integer.parseInt(txtEliminaID.getText()));
		try {
			ctrlPersona.borrarPersona(personaeliminar);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		
	}

}
