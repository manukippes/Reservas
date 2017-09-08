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

	public ReservarElemento() {
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
		comboBoxTipoElemento.setBounds(255, 33, 398, 26);
		desktopPane.add(comboBoxTipoElemento);
		
///////////// txt Fecha Hora Desde///////////////////
		txtFechaHoraDesde = new JTextField();
		txtFechaHoraDesde.setText("AAAA-MM-DD HH:MM:SS");
		txtFechaHoraDesde.setBounds(255, 105, 393, 26);
		desktopPane.add(txtFechaHoraDesde);
		txtFechaHoraDesde.setColumns(10);
		JLabel lblFecha = new JLabel("Fecha y Hora desde de la reserva");
		lblFecha.setBounds(15, 108, 276, 20);
		desktopPane.add(lblFecha);
		
///////////// txt Fecha Hora Hasta///////////////////
		txtFechaHoraHasta = new JTextField();
		txtFechaHoraHasta.setText("AAAA-MM-DD HH:MM:SS");
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
				reservar();
			}
		});
		btnReservar.setBounds(298, 447, 115, 29);
		desktopPane.add(btnReservar);
		
		llenarCombos();
		
	}
	

////////////////LLENA LOS COMBOS//////////////////
	private void llenarCombos() 
	{
		try 
		{
			this.comboBoxTipoElemento.setModel(new DefaultComboBoxModel(ctrlReserva.getTipoElemento().toArray()));
			this.comboBoxTipoElemento.setSelectedIndex(-1);
			this.comboBoxElemento.setModel(new DefaultComboBoxModel(ctrlReserva.getElemento().toArray()));
			this.comboBoxElemento.setSelectedIndex(-1);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this,"No hay tipos de elementos para mostrar");
		}
		
	}
	
////////////////METODO PARA MOSTRAR LOS DATOS DE LA BASE DE DATOS EN EL FORMULARIO//////////////////
	private void reservar() 
	{
		Reserva res = new Reserva();
		res = mapearDeFormulario();
		try {
			ctrlReserva.crearReserva(res);
			JOptionPane.showMessageDialog(this, "Se realizó la reserva correctamente");
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "La Reserva no se pudo realizar");
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
	public Reserva mapearDeFormulario()
	{
		Reserva res = new Reserva();
		if (comboBoxElemento.getSelectedIndex()!= -1) {res.setElemento((Elemento)comboBoxElemento.getSelectedItem());}
		if (comboBoxTipoElemento.getSelectedIndex()!= -1) {res.setTipo((TipoElemento)comboBoxTipoElemento.getSelectedItem());}
		try {
			res.setFechaHoraDesde(formato.parse(txtFechaHoraDesde.getText()));
			res.setFechaHoraHasta(formato.parse(txtFechaHoraHasta.getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Formato fecha y hora invalido");
		}
		res.setObservacion(txtObservacion.getText());
		Persona pers = new Persona();
		pers.setId(7);
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
