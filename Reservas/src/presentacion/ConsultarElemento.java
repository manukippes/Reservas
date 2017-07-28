package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConsultarElemento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarElemento frame = new ConsultarElemento();
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
	public ConsultarElemento() {
		setBounds(100, 100, 450, 300);

	}

}
