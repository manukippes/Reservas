package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ModificarElemento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarElemento frame = new ModificarElemento();
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
	public ModificarElemento() {
		setBounds(100, 100, 780, 630);

	}

}
