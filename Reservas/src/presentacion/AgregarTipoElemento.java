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
		setBounds(100, 100, 472, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, "name_525680675616");
		
		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del Tipo de Elemento");
		lblAltaTipoDe.setBounds(10, 11, 307, 14);
		desktopPane.add(lblAltaTipoDe);

///////////////ID/////////////////////////////
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 41, 64, 20);
		desktopPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(83, 41, 302, 20);
		desktopPane.add(txtId);
		txtId.setColumns(10);
		
///////////////NOMBRE/////////////////////////////
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 80, 81, 14);
		desktopPane.add(lblNewLabel);
		txtNombre = new JTextField();
		txtNombre.setBounds(83, 77, 302, 20);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
///////////////CANTIDAD MAXIMA DE RESERVAS/////////////////////////////
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes");
		lblCantidadMaximaDe.setBounds(10, 117, 330, 14);
		desktopPane.add(lblCantidadMaximaDe);
		textCantMaxReservas = new JTextField();
		textCantMaxReservas.setColumns(10);
		textCantMaxReservas.setBounds(321, 111, 64, 20);
		desktopPane.add(textCantMaxReservas);
		
///////////////BOTON DE ACEPTAR/////////////////////////////
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionDeTipoElemento();
			}
		});
		btnAceptar.setBounds(282, 189, 113, 29);
		desktopPane.add(btnAceptar);
		
///////////////BOTON DE CANCELAR/////////////////////////////
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(142, 189, 115, 29);
		desktopPane.add(btnCancelar);
		
///////////////BOTON DE LIMPIAR/////////////////////////////
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(12, 189, 115, 29);
		desktopPane.add(btnLimpiar);
		
}
	
///////////////METODO PARA VERIFICAR SI ES UN ALTA O UNA MODIFICACION/////////////////////////////
	public void gestionDeTipoElemento() 
	{
		if(txtId.getText()==""){altaTipoElemento();}
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
