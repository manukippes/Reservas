package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ModificarReserva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarReserva frame = new ModificarReserva();
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
	public ModificarReserva() {
		setBounds(100, 100, 450, 300);

	}

}
