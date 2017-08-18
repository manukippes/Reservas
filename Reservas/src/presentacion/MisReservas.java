package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MisReservas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisReservas frame = new MisReservas();
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
	public MisReservas() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mis Reservas");
		setBounds(100, 100, 764, 566);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_40825839592492");
		
		JLabel lblReservasPendientes = new JLabel("Reservas pendientes:");
		lblReservasPendientes.setBounds(15, 16, 160, 20);
		desktopPane.add(lblReservasPendientes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(311, 406, 115, 29);
		desktopPane.add(btnCancelar);

	}

}
