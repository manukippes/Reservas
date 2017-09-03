package presentacion;

//import java.awt.CardLayout;     ///////////////////////////////FUERON COMENTADOS TODOS LOS IMPORT NO UTILIZADOS///////////////////////////////
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
//import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import entidades.Elemento;
import entidades.TipoElemento;
//import logica.ControladorDeElemento;
import logica.ControladorDeTipoElemento;
import utilidades.ExcepcionEspecial;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class AgregarTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textCantMaxReservas;
	private ControladorDeTipoElemento ctrlTipoElemento = new ControladorDeTipoElemento();

	public AgregarTipoElemento(int idTipoElemento) {
		setIconifiable(true);
		setClosable(true);
		setTitle("Completar datos del tipo de elemento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 410, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del tipo de elemento");
				
///////////////NOMBRE/////////////////////////////
				JLabel lblNewLabel = new JLabel("Nombre");
				txtNombre = new JTextField();
				txtNombre.setToolTipText("Ingrese el nombre del elemento");
				txtNombre.setColumns(10);
				
///////////////CANTIDAD MAXIMA DE RESERVAS/////////////////////////////
				JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes");
				lblCantidadMaximaDe.setFont(new Font("Tahoma", Font.BOLD, 11));
				textCantMaxReservas = new JTextField();
				textCantMaxReservas.setColumns(10);
				
///////////////BOTON DE ACEPTAR/////////////////////////////
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setToolTipText("");
				
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
									.addGap(4)
									.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCantidadMaximaDe, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textCantMaxReservas, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNombre)))
							.addContainerGap())
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidadMaximaDe, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCantMaxReservas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
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
					public void actionPerformed(ActionEvent e) {
							try{
								gestionDeTipoElemento(idTipoElemento);}
							catch (Exception exc){
								JOptionPane.showMessageDialog(AgregarTipoElemento.this,"La cantidad máxima de reservas debe ser un número entero positivo","Error al intentar crear el elemento",JOptionPane.WARNING_MESSAGE);
							}
							}
				});
		
}
	
///////////////METODO PARA VERIFICAR SI ES UN ALTA O UNA MODIFICACION/////////////////////////////
	public void gestionDeTipoElemento(int idTipoElemento) 
	{
			if(idTipoElemento==-1){
				altaTipoElemento();
				}
			else{
				modificarTipoElemento(idTipoElemento);
				}
	}


////////////////METODO PARA ALTA DE ELEMENTO///////////////////
	private void altaTipoElemento() 
	{ 
		TipoElemento tipoEle = mapearDeFormulario();
		try
		{	
			ctrlTipoElemento.crearTipoElemento(tipoEle);
			JOptionPane.showMessageDialog(this,"El nuevo Tipo de Elemento se agregó correctamente."," Agregar Tipo de Elemento",JOptionPane.PLAIN_MESSAGE);
			limpiarCampos();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"El valor ingresado en "+e.getMessage()+" no es válido","Error al intentar crear el elemento",JOptionPane.WARNING_MESSAGE);
		}
	
	}


////////////////METODO PARA MODIFICAR DE ELEMENTO///////////////////
	private void modificarTipoElemento(int idTipoElemento) 
	{
		TipoElemento tipoEle = mapearDeFormulario();
		tipoEle.setId(idTipoElemento);
		try
		{
			ctrlTipoElemento.modificarTipoElemento(tipoEle);
			JOptionPane.showMessageDialog(this,"El Tipo de Elemento se modificó correctamente."," Modificar Tipo de Elemento",JOptionPane.PLAIN_MESSAGE);
			limpiarCampos();
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"El valor ingresado en "+e.getMessage()+" no es válido","Error al intentar modificar el elemento",JOptionPane.WARNING_MESSAGE);
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
		txtNombre.setText(tipoEle.getNombre());
		textCantMaxReservas.setText(String.valueOf(tipoEle.getCant_max_reservas()));
	}

////////////////METODO PARA TOMAR LOS DATOS DEL FORMULARIO Y AGREGARLO EN LA BASE DE DATOS///////////////////
	public TipoElemento mapearDeFormulario()
	{
		TipoElemento tipoEle = new TipoElemento();
		tipoEle.setNombre(txtNombre.getText());
		
		if (textCantMaxReservas.getText().isEmpty()){
			tipoEle.setCant_max_reservas(-1);}
		else{ 
			tipoEle.setCant_max_reservas(Integer.parseInt(textCantMaxReservas.getText()));
		}				
		return tipoEle;
	}

////////////////METODO PARA LIMPIAR LOS CAMPOS DEL FORMULARIO///////////////////
	private void limpiarCampos() 
		{
		txtNombre.setText("");
		textCantMaxReservas.setText("");
		}
	
}
