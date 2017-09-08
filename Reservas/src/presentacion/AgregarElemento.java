package presentacion;

//import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
//import javax.swing.JDesktopPane;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
//import javax.swing.ComboBoxModel;

import entidades.Elemento;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
//import logica.ControladorDeTipoElemento;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.UIManager;
//import java.awt.SystemColor;

import presentacion.ListadoElemento;

public class AgregarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private ControladorDeElemento ctrlElemento = new ControladorDeElemento();
	private JComboBox comboBoxTipoElemento;

	
	public AgregarElemento(int idElemento) {
		setIconifiable(true);
		setClosable(true);
		setTitle("Completar los datos del elemento");
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(25, 25, 410, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		

		JLabel lblAltaTipoDe = new JLabel("Ingrese los datos del elemento");
		
////////////////NOMBRE////////////////////////////////
		JLabel lblNewLabel = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
////////////////TIPO DE ELEMENTO////////////////////////////////		
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		comboBoxTipoElemento = new JComboBox();
		comboBoxTipoElemento.setBackground(Color.WHITE);
		
		
////////////////BOTON DE ACEPTAR////////////////////////////////
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionDeElemento(idElemento);
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCantidadMaximaDe)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxTipoElemento, 0, 282, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAltaTipoDe, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadMaximaDe)
						.addComponent(comboBoxTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(230, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		llenarCombo();
	}

///////////////METODO PARA VERIFICAR SI ES UN ALTA O UNA MODIFICACION/////////////////////////////
	public void gestionDeElemento(int idElemento) 
	{
		if(idElemento == -1){altaElemento();}
		else{modificarElemento(idElemento);}
	}
		

////////////////METODO PARA ALTA DE ELEMENTO///////////////////
	private void altaElemento() 
	{ 
		Elemento ele = mapearDeFormulario();
		try
		{
			ctrlElemento.crearElemento(ele);
			JOptionPane.showMessageDialog(this,"El Elemento se agregó correctamente."," Agregar Elemento",JOptionPane.PLAIN_MESSAGE);
			limpiarCampos();
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"El valor ingresado en "+e.getMessage()+" no es válido","Error al intentar crear el elemento",JOptionPane.WARNING_MESSAGE);
		}
	
	}


////////////////METODO PARA MODIFICAR DE ELEMENTO///////////////////
	private void modificarElemento(int idElemento) 
	{
		Elemento ele = mapearDeFormulario();
		ele.setId(idElemento);
		try
		{
			ctrlElemento.modificarElemento(ele);
			JOptionPane.showMessageDialog(this, "El elemento se modificó correctamente.","Modificar elemento",JOptionPane.PLAIN_MESSAGE);
			limpiarCampos();
			ListadoElemento menuEle = new ListadoElemento();
			this.getDesktopPane().add(menuEle);
			menuEle.setVisible(true);
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"El valor ingresado en "+e.getMessage()+" no es válido","Error al intentar modificar el elemento",JOptionPane.WARNING_MESSAGE);
		}
		
		
		//ListadoElemento menuLisEl = new ListadoElemento();
		//this.getDesktopPane().remove(getLayer());
		//this.getDesktopPane().add(menuLisEl);
		//menuLisEl.setVisible(true);
		//dispose();
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
			JOptionPane.showMessageDialog(this,"No hay tipos de elementos para mostrar"); //ESTE CARTEL SALE NO VISIBLE
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
		txtNombre.setText("");
		comboBoxTipoElemento.setSelectedIndex(-1);
	}
}
