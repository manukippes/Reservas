package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
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

public class ReservarElemento extends JInternalFrame {
	private JTextField txtFechaHoraDesde;
	private JTextField txtFechaHoraHasta;
	private JTextField txtObservacion;
	private JComboBox comboBoxElemento;
	private JComboBox comboBoxTipoElemento;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	private ControladorDeReserva ctrlReserva = new ControladorDeReserva();
	private ControladorDeTipoElemento ctrlTipoElemento;
	

	public ReservarElemento(Persona pers) {
		setTitle("Reservar Elemento");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 686, 561);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_40315080594877");
		
///////////// Combo Tipo de Elemento///////////////////
		JLabel lblSeleccioneTipoDe = new JLabel("Tipo de Elemento a reservar:");
		lblSeleccioneTipoDe.setBounds(15, 36, 296, 20);
		desktopPane.add(lblSeleccioneTipoDe);
		comboBoxTipoElemento = new JComboBox();
		
//		comboBoxTipoElemento.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TipoElemento tipoElegido = new TipoElemento();
//				if (comboBoxTipoElemento.getSelectedIndex()!= -1) {tipoElegido =(TipoElemento)comboBoxTipoElemento.getSelectedItem();}
//				llenarComboElemento(tipoElegido);
//			}
//		});
		
		
		comboBoxTipoElemento.setBounds(255, 33, 398, 26);
		desktopPane.add(comboBoxTipoElemento);
		
		
///////////// txt Fecha Hora Desde///////////////////
		txtFechaHoraDesde = new JTextField();
		txtFechaHoraDesde.setText("2010-01-01 00:00:00");
		txtFechaHoraDesde.setBounds(255, 105, 393, 26);
		desktopPane.add(txtFechaHoraDesde);
		txtFechaHoraDesde.setColumns(10);
		JLabel lblFecha = new JLabel("Fecha y Hora desde de la reserva");
		lblFecha.setBounds(15, 108, 276, 20);
		desktopPane.add(lblFecha);
		
///////////// txt Fecha Hora Hasta///////////////////
		txtFechaHoraHasta = new JTextField();
		txtFechaHoraHasta.setText("2010-01-01 00:00:00");
		txtFechaHoraHasta.setBounds(255, 165, 393, 26);
		desktopPane.add(txtFechaHoraHasta);
		txtFechaHoraHasta.setColumns(10);
		JLabel lblHora = new JLabel("Fecha y hora hasta de la reserva");
		lblHora.setBounds(15, 168, 282, 20);
		desktopPane.add(lblHora);

///////////// Combo Elemento///////////////////		
		JLabel lblSeleccioneElementoA = new JLabel("Elemento a Reservar:");
		lblSeleccioneElementoA.setBounds(15, 231, 263, 20);
		desktopPane.add(lblSeleccioneElementoA);
		comboBoxElemento = new JComboBox();
		comboBoxElemento.setBounds(255, 228, 398, 26);
		desktopPane.add(comboBoxElemento);
		
	
		
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
		
		llenarComboTipo();
		
	}
	

////////////////LLENA EL COMBO DE ELEMENTOS/////////////////
//	private void llenarComboElemento(TipoElemento tipoElegido){
//		try {
//			this.comboBoxElemento.setModel(new DefaultComboBoxModel(ctrlReserva.getElementosDelTipo(tipoElegido).toArray()));
//			this.comboBoxElemento.setSelectedIndex(-1);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this,"No hay elementos del tipo seleccionado para mostrar");
//		}
//	}
	
////////////////LLENA EL COMBO DE TIPO DE ELEMENTO///////////
	private void llenarComboTipo() 
	{
		try 
		{	
			this.comboBoxTipoElemento.setModel(new DefaultComboBoxModel(ctrlReserva.getTipoElemento().toArray()));
			System.out.println(ctrlReserva.getTipoElemento().toArray()[0]);
			this.comboBoxTipoElemento.setSelectedIndex(-1);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this,"No hay tipos de elementos para mostrar");
		}
		
	}
	
	
	private ArrayList<Elemento> llenarElemento()
	{
		ArrayList<Elemento> listadoElementos = new ArrayList<Elemento>();
		try {
			listadoElementos = ctrlReserva.obtenerElemento((Integer)comboBoxElemento.getSelectedItem(), txtFechaHoraDesde.getText(), txtFechaHoraHasta.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "No se pueden obtener los elementos disponibles");
		}
		
		return listadoElementos;
	}
	
////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO//////////////////
	private void reservar(Persona pers) 
	{
		Reserva res = new Reserva();
		res = mapearDeFormulario(pers);
		try {
			ctrlReserva.crearReserva(res);
			JOptionPane.showMessageDialog(this, "Se realizó la reserva correctamente");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "La Reserva no se pudo realizar CONTROLADOR");
		}
		
	}
	

////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO///////////////////
	public void mapearAFormulario(Reserva res)
	{
		if (res.getElemento()!=null){comboBoxElemento.setSelectedItem(res.getElemento());}
		if (res.getTipo()!=null){comboBoxTipoElemento.setSelectedItem(res.getTipo());}
		txtFechaHoraDesde.setText(String.valueOf(res.getFechaHoraDesde()));
		txtFechaHoraHasta.setText(String.valueOf(res.getFechaHoraHasta()));
		txtObservacion.setText(res.getObservacion());
	}

////////////////METODO PARA TOMAR LOS DATOS DEL FORMULARIO Y AGREGARLO EN LA BASE DE DATOS///////////////////
	public Reserva mapearDeFormulario(Persona pers)
	{
		Reserva res = new Reserva();
		if (comboBoxElemento.getSelectedIndex()!= -1) {res.setElemento((Elemento)comboBoxElemento.getSelectedItem());}
		if (comboBoxTipoElemento.getSelectedIndex()!= -1) {res.setTipo((TipoElemento)comboBoxTipoElemento.getSelectedItem());}
		try {
			//res.setFechaHoraDesde(formato.parse(txtFechaHoraDesde.getText()));
			//res.setFechaHoraHasta(formato.parse(txtFechaHoraHasta.getText()));
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
		comboBoxElemento.setSelectedIndex(-1);
		comboBoxTipoElemento.setSelectedIndex(-1);
		txtFechaHoraDesde.setText("");
		txtFechaHoraHasta.setText("");
		txtObservacion.setText("");
		
	}
}
