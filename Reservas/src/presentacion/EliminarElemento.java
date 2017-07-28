package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class EliminarElemento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarElemento frame = new EliminarElemento();
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
	public EliminarElemento() {
		setBounds(100, 100, 450, 300);

	}

}
