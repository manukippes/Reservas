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
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
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
	private JTextField txtId;

	public AgregarPersona() 
	{
		setTitle("Agregar Persona");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 761, 441);
		
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
		
//////////ID////////////	
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 52, 69, 20);
		desktopPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(103, 52, 208, 26);
		desktopPane.add(txtId);
		txtId.setColumns(10);
		
//////////DNI////////////
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(365, 58, 24, 20);
		desktopPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(458, 58, 208, 26);
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
		lblApellido_1.setBounds(365, 97, 58, 20);
		desktopPane.add(lblApellido_1);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(458, 104, 210, 26);
		desktopPane.add(txtApellido);
		txtApellido.setColumns(10);
		
//////////CATEGORIA////////////
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(365, 206, 67, 20);
		desktopPane.add(lblCategoria);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(456, 203, 208, 26);
		desktopPane.add(comboBoxCategoria);
		llenarCombo();
		
		
//////////HABILITADO////////////		
		checkHabilitado = new JCheckBox("Habilitado");
		checkHabilitado.setBounds(8, 203, 139, 29);
		desktopPane.add(checkHabilitado);

//////////USUARIO////////////
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 149, 69, 20);
		desktopPane.add(lblUsuario);
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(101, 146, 210, 26);
		desktopPane.add(txtUsuario);
		
//////////CONTRASEÑA////////////
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(365, 146, 113, 20);
		desktopPane.add(lblContrasea);
		passContrasena = new JPasswordField();
		passContrasena.setBounds(456, 143, 208, 26);
		desktopPane.add(passContrasena);
		
/////////BOTON Aceptar////////////		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gestionDepersona();
			}
		});
		btnAceptar.setBounds(440, 308, 113, 29);
		desktopPane.add(btnAceptar);
		
/////////BOTON Cancelar////////////
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(288, 308, 115, 29);
		desktopPane.add(btnCancelar);
		
/////////BOTON Limpiar////////////
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(133, 308, 115, 29);
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
	public void gestionDepersona() 
	{
		if(txtId.getText().isEmpty()){altaPersona();}
		else{modificarPersona();}
	}


////////////////METODO PARA ALTA DE PERSONA///////////////////
	private void altaPersona() 
		{ 
		Persona pers = mapearDeFormulario();
		try
		{
			ctrlPersona.crearPersona(pers);
			JOptionPane.showMessageDialog(this, "La persona se agregó correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al crear la persona");
		}
	
	}


////////////////METODO PARA MODIFICAR DE ELEMENTO///////////////////
	private void modificarPersona() 
	{
		Persona pers = mapearDeFormulario();
		try
		{
			ctrlPersona.modificarPersona(pers);
			JOptionPane.showMessageDialog(this, "La persona se modificó correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al modificar la persona");
		}
	
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
		txtId.setText(String.valueOf(pers.getId()));
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
	
	public Persona mapearDeFormulario()
	{
		Persona pers = new Persona();
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
		if(!this.txtId.getText().isEmpty())
		{
			pers.setId(Integer.parseInt(this.txtId.getText()));
		}
		return pers;
	}

////////////////METODO PARA LIMPIAR LOS CAMPOS DEL FORMULARIO///////////////////
	private void limpiarCampos() 
	{
		txtId.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		passContrasena.setText("");
		checkHabilitado.setSelected(false);
		comboBoxCategoria.setSelectedIndex(-1);
	}

}
