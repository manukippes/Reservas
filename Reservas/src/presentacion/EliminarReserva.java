package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class EliminarReserva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarReserva frame = new EliminarReserva();
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
	public EliminarReserva() {
		setBounds(100, 100, 450, 300);

	}

}
