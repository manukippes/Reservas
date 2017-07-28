package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ModificarTipoElemento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarTipoElemento frame = new ModificarTipoElemento();
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
	public ModificarTipoElemento() {
		setBounds(100, 100, 450, 300);

	}

}
