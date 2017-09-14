package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import entidades.Elemento;
import entidades.Persona;
import entidades.Reserva;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDeReserva;
import logica.ControladorDeTipoElemento;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ReservarElemento extends JInternalFrame {
	private JTextField txtFechaHoraDesde;
	private JTextField txtFechaHoraHasta;
	private JTextField txtObservacion;
	private JComboBox comboBoxTipoElemento;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	private ControladorDeReserva ctrlReserva = new ControladorDeReserva();
	private ControladorDeTipoElemento ctrlTipoElemento;
	private ControladorDeElemento ctrlElemento = new ControladorDeElemento();
	private JTextField txtSeleccioneUnElemento;
	private JComboBox comboBoxElementos = new JComboBox();

	public ReservarElemento(Persona pers) {
		setTitle("Reservar Elemento");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(25, 25, 686, 561);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_40315080594877");
		
/////////////USUARIO ACTUAL SELECCIONADO///////////////////////
		JLabel lblUsuario = new JLabel("Reserva para usuario: "+pers.getNombre()+", "+pers.getApellido());
		lblUsuario.setFont (lblUsuario.getFont ().deriveFont (14.0f));
		lblUsuario.setBounds(15, 11, 544, 14);
		desktopPane.add(lblUsuario);
		
		
		
///////////// Combo Tipo de Elemento///////////////////
		JLabel lblSeleccioneTipoDe = new JLabel("Tipo de Elemento a reservar:");
		lblSeleccioneTipoDe.setBounds(15, 52, 208, 20);
		desktopPane.add(lblSeleccioneTipoDe);
		comboBoxTipoElemento = new JComboBox();
		comboBoxTipoElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxElementos.setSelectedIndex(-1);
				txtSeleccioneUnElemento.setText("Seleccione un Elemento");
			}
		});
		
//		comboBoxTipoElemento.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TipoElemento tipoElegido = new TipoElemento();
//				if (comboBoxTipoElemento.getSelectedIndex()!= -1) {tipoElegido =(TipoElemento)comboBoxTipoElemento.getSelectedItem();}
//				llenarComboElemento(tipoElegido);
//			}
//		});
		
		
		comboBoxTipoElemento.setBounds(255, 49, 393, 26);
		desktopPane.add(comboBoxTipoElemento);
		
		
///////////// txt Fecha Hora Desde///////////////////
		txtFechaHoraDesde = new JTextField();
		txtFechaHoraDesde.setText("AAAA-MM-DD HH:MM:SS");
		txtFechaHoraDesde.setBounds(255, 105, 393, 26);
		desktopPane.add(txtFechaHoraDesde);
		txtFechaHoraDesde.setColumns(10);
		JLabel lblFecha = new JLabel("Fecha y Hora desde de la reserva");
		lblFecha.setBounds(15, 108, 214, 20);
		desktopPane.add(lblFecha);
		
///////////// txt Fecha Hora Hasta///////////////////
		txtFechaHoraHasta = new JTextField();
		txtFechaHoraHasta.setText("AAAA-MM-DD HH:MM:SS");
		txtFechaHoraHasta.setBounds(255, 165, 393, 26);
		desktopPane.add(txtFechaHoraHasta);
		txtFechaHoraHasta.setColumns(10);
		JLabel lblHora = new JLabel("Fecha y hora hasta de la reserva");
		lblHora.setBounds(15, 168, 221, 20);
		desktopPane.add(lblHora);

///////////// Combo Elemento///////////////////		
		JLabel lblSeleccioneElementoA = new JLabel("Elemento a Reservar:");
		lblSeleccioneElementoA.setBounds(15, 231, 263, 20);
		desktopPane.add(lblSeleccioneElementoA);
		
	
		
///////////// txt Observacion///////////////////		
		txtObservacion = new JTextField();
		txtObservacion.setBounds(15, 333, 638, 79);
		desktopPane.add(txtObservacion);
		txtObservacion.setColumns(10);
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(15, 297, 121, 20);
		desktopPane.add(lblObservaciones);
		
///////////// Boton Reservar///////////////////		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reservar(pers);
			}
		});
		btnReservar.setBounds(298, 447, 115, 29);
		desktopPane.add(btnReservar);
		
/////////////////Boton buscar elementos disponibles/////////////////////////		
		JButton btnBuscarElementosDisponibles = new JButton("BUSCAR ELEMENTOS DISPONIBLES");
		btnBuscarElementosDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarElemento();
				} catch (Exception e1) {
					// 
					e1.printStackTrace();
				}
			}
		});
		btnBuscarElementosDisponibles.setBounds(255, 253, 393, 23);
		desktopPane.add(btnBuscarElementosDisponibles);
		
		txtSeleccioneUnElemento = new JTextField();
		txtSeleccioneUnElemento.setBackground(Color.WHITE);
		txtSeleccioneUnElemento.setText("Seleccione un elemento");
		txtSeleccioneUnElemento.setEnabled(false);
		txtSeleccioneUnElemento.setEditable(false);
		txtSeleccioneUnElemento.setBounds(255, 231, 393, 20);
		desktopPane.add(txtSeleccioneUnElemento);
		txtSeleccioneUnElemento.setColumns(10);
		

		
		llenarComboTipo(pers);
		
	}
	

////////////////LLENA EL COMBO DE TIPO DE ELEMENTO///////////
	private void llenarComboTipo(Persona pers) 
	{
		try 
		{	
			this.comboBoxTipoElemento.setModel(new DefaultComboBoxModel(ctrlReserva.getTipoElemento(pers).toArray()));
			this.comboBoxTipoElemento.setSelectedIndex(-1);

		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this,"No hay tipos de elementos para mostrar");
		}
		
	}
	
	
	
////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO//////////////////
	private void reservar(Persona pers) 
	{
		Reserva res = new Reserva();
		res = mapearDeFormulario(pers);
		try {
			ctrlReserva.crearReserva(res);
			JOptionPane.showMessageDialog(this, "Se realizó correctamente la reserva","Reserva exitosa",JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Verifique los datos de la reserva","La reserva no se pudo realizar",JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	

////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO///////////////////
	public void mapearAFormulario(Reserva res)
	{
		if (res.getTipo()!=null){comboBoxTipoElemento.setSelectedItem(res.getTipo());}
		txtFechaHoraDesde.setText(String.valueOf(res.getFechaHoraDesde()));
		txtFechaHoraHasta.setText(String.valueOf(res.getFechaHoraHasta()));
		txtObservacion.setText(res.getObservacion());
	}

////////////////METODO PARA TOMAR LOS DATOS DEL FORMULARIO Y AGREGARLO EN LA BASE DE DATOS///////////////////
	public Reserva mapearDeFormulario(Persona pers)
	{
		Reserva res = new Reserva();
		if (comboBoxTipoElemento.getSelectedIndex()!= -1) {res.setTipo((TipoElemento)comboBoxTipoElemento.getSelectedItem());}
		if (comboBoxElementos.getSelectedIndex()!= -1) {res.setElemento((Elemento)comboBoxElementos.getSelectedItem());}
		try {
			res.setFechaHoraDesde(txtFechaHoraDesde.getText());
			res.setFechaHoraHasta(txtFechaHoraHasta.getText());
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Formato fecha y hora invalido");
		}
		res.setObservacion(txtObservacion.getText());
		res.setPersona(pers);
		return res;
	}
	
////////////////BORRA DATOS INGRESADOS EN LOS CAMPOS DEL FORMULARIO///////////////////
	private void limpiarCampos() 
	{
		comboBoxTipoElemento.setSelectedIndex(-1);
		txtFechaHoraDesde.setText("");
		txtFechaHoraHasta.setText("");
		txtObservacion.setText("");
		
	}
	
	public void seleccionarElemento() throws Exception {
		
		 
		 try {
			 comboBoxElementos.setModel(new DefaultComboBoxModel(ctrlElemento.getElementosDisponibles((TipoElemento)comboBoxTipoElemento.getSelectedItem(),txtFechaHoraDesde.getText(),txtFechaHoraHasta.getText()).toArray()));
			 Object[] options = new Object[] {};
			 JOptionPane jop = new JOptionPane("Por favor seleccione el elemento", JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE,null,options, null);
			 jop.add(comboBoxElementos);
			 JOptionPane.showMessageDialog(getContentPane(),jop,"Seleccione el elemento", EXIT_ON_CLOSE, frameIcon);
			 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de elemento","Error de selección",JOptionPane.WARNING_MESSAGE);
			
		}
		   
		 try {
			this.txtSeleccioneUnElemento.setText(comboBoxElementos.getSelectedItem().toString());
		} catch (Exception e) {
			this.txtSeleccioneUnElemento.setText("Seleccione un elemento");
		}
		 
		 
		 
    }
}
