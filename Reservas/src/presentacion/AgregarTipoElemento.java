package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidades.TipoElemento;
import logica.ControladorDeTipoElemento;

public class AgregarTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textCantMaxReservas;
	private ControladorDeTipoElemento ctrlTipoElemento;

	public AgregarTipoElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta Tipo de Elemento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, "name_525680675616");
		
		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del Tipo de Elemento");
		lblAltaTipoDe.setBounds(10, 11, 307, 14);
		desktopPane.add(lblAltaTipoDe);
		
///////////////NOMBRE/////////////////////////////
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(20, 53, 81, 14);
		desktopPane.add(lblNewLabel);
		txtNombre = new JTextField();
		txtNombre.setBounds(93, 50, 302, 20);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
///////////////CANTIDAD MAXIMA DE RESERVAS/////////////////////////////
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes");
		lblCantidadMaximaDe.setBounds(20, 83, 330, 14);
		desktopPane.add(lblCantidadMaximaDe);
		textCantMaxReservas = new JTextField();
		textCantMaxReservas.setColumns(10);
		textCantMaxReservas.setBounds(331, 77, 64, 20);
		desktopPane.add(textCantMaxReservas);
		
///////////////BOTON DE ALTA/////////////////////////////
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaTipoelemento();
			}
		});
		btnAlta.setBounds(176, 143, 89, 23);
		desktopPane.add(btnAlta);
		
	}
	
///////////////METODO PARA DAR DE ALTA/////////////////////////////
	private void altaTipoelemento() {
		TipoElemento tipoele = new TipoElemento();
		ctrlTipoElemento = new ControladorDeTipoElemento();
		tipoele.setNombre(txtNombre.getText());
		tipoele.setCant_max_reservas(Integer.parseInt(textCantMaxReservas.getText()));
		try {
			ctrlTipoElemento.crearTipoElemento(tipoele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
}
