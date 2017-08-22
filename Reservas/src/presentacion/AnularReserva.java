package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AnularReserva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnularReserva frame = new AnularReserva();
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
	public AnularReserva() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Anular Reservas");
		setBounds(20, 20, 785, 545);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_40930650395461");
		
		JLabel lblSeleccionarLasReservas = new JLabel("Seleccionar las reservas a anular");
		lblSeleccionarLasReservas.setBounds(15, 16, 249, 20);
		desktopPane.add(lblSeleccionarLasReservas);
		
		JButton btnAnular = new JButton("Anular");
		btnAnular.setBounds(315, 477, 115, 29);
		desktopPane.add(btnAnular);

	}

}
