package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservarElemento extends JInternalFrame {
	private JTextField txtFechaHoraDesde;
	private JTextField txtFechaHoraHasta;
	private JTextField txtObservacion;
	private JLabel lblSeleccioneTipoDe;
	private JComboBox comboBoxElemento;

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
		lblSeleccioneTipoDe = new JLabel("Tipo de Elemento a reservar:");
		lblSeleccioneTipoDe.setBounds(15, 36, 296, 20);
		desktopPane.add(lblSeleccioneTipoDe);
		JComboBox comboBoxTipoElemento = new JComboBox();
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
		
	}
	

	private void reservar() {
		
		
	}
}
