package presentacion;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import datos.DatosPersona;
import entidades.Persona;
import javax.swing.JPasswordField;

public class AgregarPersona extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCategoria;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JDesktopPane desktopPane;
	private JTextField txtUsuario;
	private JCheckBox checkHabilitado;
	private JPasswordField passContrasena;

	public AgregarPersona() 
	{
		setTitle("Agregar Persona");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 513, 511);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(desktopPane, "name_18158845987003");

//////////TITULO////////////
		JLabel lblAltaDeUna = new JLabel("Alta de una Persona");
		lblAltaDeUna.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblAltaDeUna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUna.setBounds(0, 16, 238, 20);
		desktopPane.add(lblAltaDeUna);
		
//////////DNI////////////
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 52, 24, 20);
		desktopPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(103, 52, 208, 26);
		desktopPane.add(txtDni);
		txtDni.setColumns(10);
		
//////////NOMBRE////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(8, 97, 57, 20);
		desktopPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 94, 208, 26);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
//////////APELLIDO////////////		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(10, 143, 58, 20);
		desktopPane.add(lblApellido_1);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(101, 140, 210, 26);
		desktopPane.add(txtApellido);
		txtApellido.setColumns(10);
		
//////////CATEGORIA////////////
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(12, 320, 67, 20);
		desktopPane.add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(99, 317, 211, 26);
		desktopPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
//////////HABILITADO////////////		
		checkHabilitado = new JCheckBox("Habilitado");
		checkHabilitado.setBounds(10, 269, 139, 29);
		desktopPane.add(checkHabilitado);

//////////USUARIO////////////
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 191, 69, 20);
		desktopPane.add(lblUsuario);
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(101, 188, 210, 26);
		desktopPane.add(txtUsuario);
		
//////////CONTRASEÑA////////////
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(12, 239, 113, 20);
		desktopPane.add(lblContrasea);
		passContrasena = new JPasswordField();
		passContrasena.setBounds(103, 236, 208, 26);
		desktopPane.add(passContrasena);
		
/////////BOTON ALTA////////////		
		JButton btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				altaPersona();
			}
		});
		btnDarDeAlta.setBounds(136, 396, 113, 29);
		desktopPane.add(btnDarDeAlta);
		
		
	}
	
//////////METODO ALTA DE PERSONA////////////
	public void altaPersona() 
	{
		Persona pers = new Persona();
		DatosPersona datospersona = new DatosPersona();
		pers.setDni(txtDni.getText());
		pers.setNombre(txtNombre.getText());
		pers.setApellido(txtApellido.getText());
		pers.setUsuario(txtUsuario.getText());
		pers.setContrasena(dameClave());
		pers.setCategoria(txtCategoria.getText());
		pers.setHabilitado(checkHabilitado.isSelected());
		datospersona.agregarPersona(pers);
	}
	
//////////METODO CAMBIAR PASS POR STRING////////////
	private String dameClave() 
	{
		 char passArray[] = passContrasena.getPassword();
		 String pass = new String(passArray);
	     return pass;
	}
}
