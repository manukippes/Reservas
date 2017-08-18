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

public class ReservarElemento extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservarElemento frame = new ReservarElemento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservarElemento() {
		setTitle("Reservar Elemento");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 732, 673);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_40315080594877");
		
		JLabel lblSeleccioneTipoDe = new JLabel("Seleccione Tipo de Elemento a reservar:");
		lblSeleccioneTipoDe.setBounds(15, 36, 296, 20);
		desktopPane.add(lblSeleccioneTipoDe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(307, 33, 398, 26);
		desktopPane.add(comboBox);
		
		JLabel lblIndiqueFechaY = new JLabel("Indique Fecha y Hora de la reserva");
		lblIndiqueFechaY.setBounds(15, 95, 263, 20);
		desktopPane.add(lblIndiqueFechaY);
		
		textField = new JTextField();
		textField.setBounds(61, 134, 227, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(346, 134, 146, 26);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(303, 137, 54, 20);
		desktopPane.add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(15, 137, 54, 20);
		desktopPane.add(lblFecha);
		
		JLabel lblSeleccioneElementoA = new JLabel("Seleccione Elemento a Reservar:");
		lblSeleccioneElementoA.setBounds(15, 228, 263, 20);
		desktopPane.add(lblSeleccioneElementoA);
		
		JButton btnBuscarElemento = new JButton("Buscar Elemento");
		btnBuscarElemento.setBounds(273, 183, 179, 29);
		desktopPane.add(btnBuscarElemento);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 473, 681, 79);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(15, 437, 121, 20);
		desktopPane.add(lblObservaciones);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(303, 587, 115, 29);
		desktopPane.add(btnReservar);

	}
}
