package presentacion;

import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entidades.TipoElemento;

import javax.swing.JComboBox;

import javax.swing.JInternalFrame;

public class AgregarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;

	public AgregarElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta Elemento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, "name_525680675616");
		
		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del Elemento");
		lblAltaTipoDe.setBounds(10, 11, 381, 14);
		desktopPane.add(lblAltaTipoDe);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 36, 137, 14);
		desktopPane.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 33, 256, 20);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		lblCantidadMaximaDe.setBounds(10, 66, 151, 14);
		desktopPane.add(lblCantidadMaximaDe);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaelemento();
			}
		});
		btnAlta.setBounds(177, 126, 89, 23);
		desktopPane.add(btnAlta);
		
		JComboBox comboBoxTipoElemento = new JComboBox<TipoElemento>();
		comboBoxTipoElemento.setBounds(224, 63, 146, 20);
		desktopPane.add(comboBoxTipoElemento);
	}
	
	private void altaelemento() {
				
	}

}
