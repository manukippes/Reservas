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
	private ControladorDeTipoElemento ctrlTipoElemento = new ControladorDeTipoElemento();
	private JTextField txtId;

	public AgregarTipoElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Menu Tipo de Elemento");
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

///////////////ID/////////////////////////////
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 41, 154, 20);
		desktopPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(83, 41, 302, 20);
		desktopPane.add(txtId);
		txtId.setColumns(10);
		
///////////////NOMBRE/////////////////////////////
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 80, 81, 14);
		desktopPane.add(lblNewLabel);
		txtNombre = new JTextField();
		txtNombre.setBounds(83, 77, 302, 20);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
///////////////CANTIDAD MAXIMA DE RESERVAS/////////////////////////////
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de reservas pendientes");
		lblCantidadMaximaDe.setBounds(10, 117, 330, 14);
		desktopPane.add(lblCantidadMaximaDe);
		textCantMaxReservas = new JTextField();
		textCantMaxReservas.setColumns(10);
		textCantMaxReservas.setBounds(321, 111, 64, 20);
		desktopPane.add(textCantMaxReservas);
		
///////////////BOTON DE ACEPTAR/////////////////////////////
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaTipoelemento();
			}
		});
		btnAceptar.setBounds(282, 189, 113, 29);
		desktopPane.add(btnAceptar);
		
///////////////BOTON DE CANCELAR/////////////////////////////
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(142, 189, 115, 29);
		desktopPane.add(btnCancelar);
		
///////////////BOTON DE LIMPIAR/////////////////////////////
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(12, 189, 115, 29);
		desktopPane.add(btnLimpiar);
		
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
