package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

import entidades.Elemento;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDeTipoElemento;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AgregarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private ControladorDeElemento ctrlElemento = new ControladorDeElemento();
//	private ControladorDeTipoElemento ctrlTipoElemento;
	private JComboBox comboBoxTipoElemento;
	private JTextField txtId;

	
	public AgregarElemento() {
		setClosable(true);
		setTitle("Menu de Elemento");
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 560, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		

		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del Elemento");
		
////////////////ID////////////////////////////////
		JLabel lblId = new JLabel("Id");
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
////////////////NOMBRE////////////////////////////////
		JLabel lblNewLabel = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
////////////////TIPO DE ELEMENTO////////////////////////////////		
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		comboBoxTipoElemento = new JComboBox();
		
		
////////////////BOTON DE ACEPTAR////////////////////////////////
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionDeelemento();
			}
		});
		
////////////////BOTON DE CANCELAR////////////////////////////////
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();	
				
			}
		});

////////////////BOTON PARA LIMPIAR CAMPOS////////////////////////////////
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(333, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCantidadMaximaDe))
						.addComponent(lblId))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtNombre)
						.addComponent(comboBoxTipoElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(138, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(62, Short.MAX_VALUE)
					.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadMaximaDe)
						.addComponent(comboBoxTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar)
						.addComponent(btnLimpiar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

		llenarCombo();
	}

///////////////METODO PARA VERIFICAR SI ES UN ALTA O UNA MODIFICACION/////////////////////////////
	public void gestionDeelemento() 
	{
		
		if(txtId.getText().isEmpty()){altaElemento();}
		else{modificarElemento();}
	}
		

////////////////METODO PARA ALTA DE ELEMENTO///////////////////
	private void altaElemento() 
	{ 
		Elemento ele = mapearDeFormulario();
		try
		{
			ctrlElemento.crearElemento(ele);
			JOptionPane.showMessageDialog(this, "El elemento se agregó correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al crear el Elemento");
		}
	
	}


////////////////METODO PARA MODIFICAR DE ELEMENTO///////////////////
	private void modificarElemento() 
	{
		Elemento ele = mapearDeFormulario();
		try
		{
			ctrlElemento.modificarElemento(ele);
			JOptionPane.showMessageDialog(this, "El elemento se modificó correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al modificar el Elemento");
		}
	
	}

////////////////METODO PARA LLENAR CON DATOS DE LA BASE DE DATOS EL COMBO DE TIPO DE ELEMENTO///////////////////
	public void llenarCombo() 
	{
		ctrlElemento = new ControladorDeElemento();
		try 
		{
			this.comboBoxTipoElemento.setModel(new DefaultComboBoxModel(ctrlElemento.getTipoElemento().toArray()));
			this.comboBoxTipoElemento.setSelectedIndex(-1);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this,"No hay categorias para mostrar"); //ESTE CARTEL SALE NO VISIBLE
		}
		
	}
	
////////////////METODO PARA MOSTRAR EL ELEMENTO QUE VIENE DEL LISTADO///////////////////
	public void showElemento(Elemento ele)
	{
		this.mapearAFormulario(ele);
	}
	
////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO///////////////////
	public void mapearAFormulario(Elemento ele)
	{
		txtId.setText(String.valueOf(ele.getId()));
		txtNombre.setText(ele.getNombre());
		if (ele.getTipo()!=null)
		{
			comboBoxTipoElemento.setSelectedItem(ele.getTipo());
		}
	}
	
////////////////METODO PARA TOMAR LOS DATOS DEL FORMULARIO Y AGREGARLO EN LA BASE DE DATOS///////////////////
	public Elemento mapearDeFormulario()
	{
		Elemento ele = new Elemento();
		if(!this.txtId.getText().isEmpty())
		{
			ele.setId(Integer.parseInt(this.txtId.getText()));
		}
		ele.setNombre(txtNombre.getText());
		if (comboBoxTipoElemento.getSelectedIndex()!= -1)
		{
			ele.setTipo((TipoElemento)comboBoxTipoElemento.getSelectedItem());
		}
		
		return ele;
	}
	
////////////////METODO PARA LIMPIAR LOS CAMPOS DEL FORMULARIO///////////////////
	private void limpiarCampos() 
	{
		txtId.setText("");
		txtNombre.setText("");
		comboBoxTipoElemento.setSelectedIndex(-1);
	}
}
