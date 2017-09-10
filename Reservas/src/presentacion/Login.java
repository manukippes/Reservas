package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Persona;
import logica.ControladorDePersona;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JDesktopPane desktopPane;
	private ControladorDePersona ctrlPersona = new ControladorDePersona();

	public Login() {
		setTitle("Pantalla de login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 567);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(desktopPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
		);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		txtPass = new JPasswordField();
		
		txtPass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ingresar();
				}
			
		});
		
		txtUsuario = new JTextField();
		
		 
		txtUsuario.setColumns(10);
		
		
		JButton btnSalir = new JButton("Salir");
		
		JButton btnIngresar = new JButton("Ingresar");
		
		JButton btnRegistrarse = new JButton("Registrarse");
		
		JLabel lblIngreseSuUsuario = new JLabel("Ingrese su Usuario y Contrase\u00F1a");
		
		JSeparator separator = new JSeparator();
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(172)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_desktopPane.createSequentialGroup()
											.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblContrasea)
												.addComponent(lblUsuario))
											.addGap(9))
										.addGroup(gl_desktopPane.createSequentialGroup()
											.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(5)
									.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_desktopPane.createSequentialGroup()
											.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
											.addGap(62)
											.addComponent(btnRegistrarse))
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtPass, Alignment.TRAILING)
											.addComponent(txtUsuario, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addComponent(lblIngreseSuUsuario)
									.addGap(125))))
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(147)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(219, Short.MAX_VALUE))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(78)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIngreseSuUsuario)
					.addGap(65)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(lblUsuario)
							.addGap(18)
							.addComponent(lblContrasea))
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)))
					.addGap(58)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir)
						.addComponent(btnIngresar)
						.addComponent(btnRegistrarse))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		desktopPane.setLayout(gl_desktopPane);
				
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		contentPane.setLayout(gl_contentPane);
		txtUsuario.requestFocusInWindow();
		
	}

	protected void registrar() 
	{
		AgregarPersona menuAlta = new AgregarPersona(-1);
		menuAlta.setVisible(true);
		
		desktopPane.add(menuAlta);
		menuAlta.toFront();
		
		
	}

	protected void ingresar() 
	{		
			Persona pers = new Persona();
			pers.setUsuario(txtUsuario.getText());
			pers.setContrasena(dameClave());
			Persona persBaseDatos = new Persona();
			
			try {
				persBaseDatos = ctrlPersona.buscarPersonaPorUsuyClave(pers);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se encontraron los datos de la persona");
			}
			if (persBaseDatos !=null)
			{
				PrincipalEscritorio menu = new PrincipalEscritorio(persBaseDatos);
				menu.setVisible(true);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Datos incorrectos. Por favor vuelva a ingresar Usuario y Contraseña");
			}
			
			
	}
	
//////////METODO CAMBIAR PASS POR STRING////////////
	private String dameClave() 
	{
		char passArray[] = txtPass.getPassword();
		String pass = new String(passArray);
		return pass;
	}
}
