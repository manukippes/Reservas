package presentacion;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entidades.Persona;
import entidades.Persona;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDePersona;
import javax.swing.JComboBox;



public class AgregarPersona extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JDesktopPane desktopPane;
	private JTextField txtUsuario;
	private JCheckBox checkHabilitado;
	private JPasswordField passContrasena;
	private ControladorDePersona ctrlPersona = new ControladorDePersona();
	private JComboBox comboBoxCategoria;

	public AgregarPersona(int idActual) 
	{
		setTitle("Completar los datos de la persona");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 619, 270);
		
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(desktopPane, "name_18158845987003");

//////////TITULO////////////
		JLabel lblAltaDeUna = new JLabel("Ingrese los datos de la persona");
		lblAltaDeUna.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAltaDeUna.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltaDeUna.setBounds(10, 16, 468, 20);
		desktopPane.add(lblAltaDeUna);
		
//////////DNI////////////
		JLabel lblDni = new JLabel("Dni");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setBounds(44, 50, 24, 20);
		desktopPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(78, 47, 208, 26);
		desktopPane.add(txtDni);
		txtDni.setColumns(10);
		
//////////NOMBRE////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(20, 87, 48, 20);
		desktopPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(78, 84, 208, 26);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
//////////APELLIDO////////////		
		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setBounds(296, 87, 58, 20);
		desktopPane.add(lblApellido_1);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(364, 84, 210, 26);
		desktopPane.add(txtApellido);
		txtApellido.setColumns(10);
		
//////////CATEGORIA////////////
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(287, 50, 67, 20);
		desktopPane.add(lblCategoria);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBackground(Color.WHITE);
		comboBoxCategoria.setBounds(364, 47, 210, 26);
		desktopPane.add(comboBoxCategoria);
		llenarCombo();
		
		
//////////HABILITADO////////////		
		checkHabilitado = new JCheckBox("Habilitado");
		checkHabilitado.setSelected(true);
		checkHabilitado.setBackground(Color.WHITE);
		checkHabilitado.setBounds(78, 154, 139, 29);
		desktopPane.add(checkHabilitado);

//////////USUARIO////////////
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(20, 124, 48, 20);
		desktopPane.add(lblUsuario);
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(78, 121, 208, 26);
		desktopPane.add(txtUsuario);
		
//////////CONTRASEÑA////////////
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setBounds(287, 124, 67, 20);
		desktopPane.add(lblContrasena);
		passContrasena = new JPasswordField();
		passContrasena.setBounds(364, 121, 210, 26);
		desktopPane.add(passContrasena);
		
/////////BOTON ACEPTAR ////////////		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gestionDepersona(idActual);
			}
		});
		btnAceptar.setBounds(391, 190, 113, 29);
		desktopPane.add(btnAceptar);
		
/////////BOTON CANCELAR ////////////
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(239, 190, 115, 29);
		desktopPane.add(btnCancelar);
		
/////////BOTON LIMPIAR ////////////
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(88, 190, 115, 29);
		desktopPane.add(btnLimpiar);		
	}
	
//////////METODO CAMBIAR PASS POR STRING////////////
	private String dameClave() 
	{
		char passArray[] = passContrasena.getPassword();
		String pass = new String(passArray);
	   return pass;
	}

///////////////METODO PARA VERIFICAR SI ES UN ALTA O UNA MODIFICACION/////////////////////////////
	public void gestionDepersona(int id) 
	{
		if(id == -1){altaPersona();}    ///EL VALOR -1 ES UN ID IMPOSIBLE, POR ESO ES UN ALTA
		else{modificarPersona(id);}
	}


////////////////METODO PARA ALTA DE PERSONA///////////////////
	private void altaPersona() 
		{ 
		Persona pers = mapearDeFormulario(-1);
		try
		{
			ctrlPersona.crearPersona(pers);
			JOptionPane.showMessageDialog(this, "La persona se agregó correctamente.","Agregar persona",JOptionPane.PLAIN_MESSAGE);
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"El valor ingresado en "+e.getMessage()+" no es válido","Error al intentar crear la persona",JOptionPane.WARNING_MESSAGE);
		}
	}

////////////////METODO PARA MODIFICAR DE ELEMENTO///////////////////
	private void modificarPersona(int id) 
	{
		Persona pers = mapearDeFormulario(id);
		try
		{
			ctrlPersona.modificarPersona(pers);
			JOptionPane.showMessageDialog(this, "La persona se modificó correctamente.","Modificar persona",JOptionPane.PLAIN_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"El valor ingresado en "+e.getMessage()+" no es válido","Error al intentar crear la persona",JOptionPane.WARNING_MESSAGE);
		}
		
		ListadoPersona menuLis = new ListadoPersona();
		this.getDesktopPane().add(menuLis);
		menuLis.setVisible(true);
		dispose();
		
	}

////////////////METODO PARA LLENAR CON DATOS DE LA BASE DE DATOS EL COMBO DE TIPO DE ELEMENTO///////////////////
	public void llenarCombo() 
	{
		comboBoxCategoria.addItem("Administrador");
		comboBoxCategoria.addItem("Encargado");
		comboBoxCategoria.addItem("Online");
		comboBoxCategoria.setSelectedIndex(-1);
	}

////////////////METODO PARA MOSTRAR EL ELEMENTO QUE VIENE DEL LISTADO///////////////////
	public void showPersona(Persona pers)
	{
		this.mapearAFormulario(pers);
	}

////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO///////////////////
	
	public void mapearAFormulario(Persona pers)
	{
		txtDni.setText(pers.getDni());
		txtNombre.setText(pers.getNombre());
		txtApellido.setText(pers.getApellido());
		txtUsuario.setText(pers.getUsuario());
		passContrasena.setText(pers.getContrasena());
		checkHabilitado.setSelected(pers.isHabilitado());
		if (pers.getCategoria()!=null)
		{
			comboBoxCategoria.setSelectedItem(pers.getCategoria());
		}
	}

////////////////METODO PARA TOMAR LOS DATOS DEL FORMULARIO Y AGREGARLO EN LA BASE DE DATOS///////////////////
	
	public Persona mapearDeFormulario(int id)
	{
		Persona pers = new Persona();
		
		if (id!=-1){pers.setId(id);}           ///////////////////SI ES -1 ES UN ALTA Y EL ID ES AUTOINCREMENTAL
		pers.setDni(txtDni.getText());
		pers.setNombre(txtNombre.getText());
		pers.setApellido(txtApellido.getText());
		pers.setUsuario(txtUsuario.getText());
		pers.setContrasena(dameClave());
		if (comboBoxCategoria.getSelectedIndex()!= -1)
		{
			pers.setCategoria((String)comboBoxCategoria.getSelectedItem());
		}
		pers.setHabilitado(checkHabilitado.isSelected());
		return pers;
	}

////////////////METODO PARA LIMPIAR LOS CAMPOS DEL FORMULARIO///////////////////
	private void limpiarCampos() 
	{
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		passContrasena.setText("");
		checkHabilitado.setSelected(false);
		comboBoxCategoria.setSelectedIndex(-1);
	}

}
