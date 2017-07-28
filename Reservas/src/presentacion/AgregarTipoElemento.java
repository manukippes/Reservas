package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AgregarTipoElemento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarTipoElemento frame = new AgregarTipoElemento();
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
	public AgregarTipoElemento() {
		setBounds(100, 100, 450, 300);

	}

}
