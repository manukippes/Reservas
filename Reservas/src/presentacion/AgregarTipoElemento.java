package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import entidades.Elemento;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDeTipoElemento;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AgregarTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textCantMaxReservas;
	private ControladorDeTipoElemento ctrlTipoElemento = new ControladorDeTipoElemento();
	private JTextField txtId;

	public AgregarTipoElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Menu Tipo de Elemento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 499, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del Tipo de Elemento");
		
		///////////////ID/////////////////////////////
				JLabel lblId = new JLabel("Id");
				
				txtId = new JTextField();
				txtId.setEditable(false);
				txtId.setColumns(10);
				
///////////////NOMBRE/////////////////////////////
				JLabel lblNewLabel = new JLabel("Nombre");
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				
///////////////CANTIDAD MAXIMA DE RESERVAS/////////////////////////////
				JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes");
				textCantMaxReservas = new JTextField();
				textCantMaxReservas.setColumns(10);
				
///////////////BOTON DE ACEPTAR/////////////////////////////
				JButton btnAceptar = new JButton("Aceptar");
				
///////////////BOTON DE CANCELAR/////////////////////////////
				JButton btnCancelar = new JButton("Cancelar");
				
///////////////BOTON DE LIMPIAR/////////////////////////////
				JButton btnLimpiar = new JButton("Limpiar");
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtId)
										.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCantidadMaximaDe, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(23)
											.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
											.addGap(44)
											.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCantMaxReservas, 0, 0, Short.MAX_VALUE))))
							.addGap(2147483186)
							.addContainerGap())
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidadMaximaDe, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCantMaxReservas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar))
							.addGap(141))
				);
				contentPane.setLayout(gl_contentPane);
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiarCampos();
					}
				});
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						gestionDeTipoElemento();
					}
				});
		
}
	
///////////////METODO PARA VERIFICAR SI ES UN ALTA O UNA MODIFICACION/////////////////////////////
	public void gestionDeTipoElemento() 
	{
		if(txtId.getText().isEmpty()){altaTipoElemento();}
		else{modificarTipoElemento();}
	}


////////////////METODO PARA ALTA DE ELEMENTO///////////////////
	private void altaTipoElemento() 
	{ 
		TipoElemento tipoEle = mapearDeFormulario();
		try
		{
			ctrlTipoElemento.crearTipoElemento(tipoEle);
			JOptionPane.showMessageDialog(this, "El Tipo de Elemento se agregó correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al crear el Tipo de Elemento");
		}
	
	}


////////////////METODO PARA MODIFICAR DE ELEMENTO///////////////////
	private void modificarTipoElemento() 
	{
		TipoElemento tipoEle = mapearDeFormulario();
		try
		{
			ctrlTipoElemento.modificarTipoElemento(tipoEle);
			JOptionPane.showMessageDialog(this, "El Tipo de Elemento se modificó correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al modificar el Tipo de Elemento");
		}
	
	}

////////////////METODO PARA MOSTRAR EL ELEMENTO QUE VIENE DEL LISTADO///////////////////
	public void showTipoElemento(TipoElemento tipoEle)
	{
		this.mapearAFormulario(tipoEle);
	}

////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO///////////////////
	public void mapearAFormulario(TipoElemento tipoEle)
	{
		txtId.setText(String.valueOf(tipoEle.getId()));
		txtNombre.setText(tipoEle.getNombre());
		textCantMaxReservas.setText(String.valueOf(tipoEle.getCant_max_reservas()));
		
	}

////////////////METODO PARA TOMAR LOS DATOS DEL FORMULARIO Y AGREGARLO EN LA BASE DE DATOS///////////////////
	public TipoElemento mapearDeFormulario()
	{
		TipoElemento tipoEle = new TipoElemento();
		if(!this.txtId.getText().isEmpty())
		{
			tipoEle.setId(Integer.parseInt(this.txtId.getText()));
		}
		tipoEle.setNombre(txtNombre.getText());
		tipoEle.setCant_max_reservas(Integer.parseInt(textCantMaxReservas.getText()));
				
		return tipoEle;
	}

////////////////METODO PARA LIMPIAR LOS CAMPOS DEL FORMULARIO///////////////////
	private void limpiarCampos() 
		{
		txtId.setText("");
		txtNombre.setText("");
		textCantMaxReservas.setText("");
		
		}
	
}
