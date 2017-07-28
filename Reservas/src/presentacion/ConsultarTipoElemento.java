package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConsultarTipoElemento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarTipoElemento frame = new ConsultarTipoElemento();
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
	public ConsultarTipoElemento() {
		setBounds(100, 100, 450, 300);

	}

}
