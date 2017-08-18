package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

import entidades.Elemento;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDeTipoElemento;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AgregarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private ControladorDeElemento ctrlElemento;
//	private ControladorDeTipoElemento ctrlTipoElemento;
	private JComboBox comboBoxTipoElemento;

	
	public AgregarElemento() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta Elemento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		

		JLabel lblAltaTipoDe = new JLabel("Ingrese datos del Elemento");
		
////////////////NOMBRE////////////////////////////////
		JLabel lblNewLabel = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
////////////////TIPO DE ELEMENTO////////////////////////////////		
		JLabel lblCantidadMaximaDe = new JLabel("Tipo de Elemento");
		comboBoxTipoElemento = new JComboBox();
		
		
////////////////BOTON DE ALTA DE ELEMENTO////////////////////////////////
		JButton btnAlta = new JButton("Alta");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCantidadMaximaDe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBoxTipoElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
						.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAltaTipoDe, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadMaximaDe)
						.addComponent(comboBoxTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(281, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaelemento();
			}
		});
		
		llenarCombo();
	}

///////////////METODO PARA DAR DE ALTA/////////////////////////////
	public void altaelemento() {
		Elemento ele = new Elemento();
		ctrlElemento = new ControladorDeElemento();
		ele.setNombre(txtNombre.getText());
		if (comboBoxTipoElemento.getSelectedIndex() != -1){
			ele.setTipo((TipoElemento)comboBoxTipoElemento.getSelectedItem());
		}
		try {
			ctrlElemento.crearElemento(ele);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Error al crear el Elemento");
		}
				
	}
		
	public void llenarCombo() {
		ctrlElemento = new ControladorDeElemento();
		try {
			this.comboBoxTipoElemento.setModel(new DefaultComboBoxModel(ctrlElemento.getTipoElemento().toArray()));
			this.comboBoxTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"No hay categorias para mostrar");
		}
		
	}
	
//	public void mapearAFormulario()
//	{
//		
//	}
//	
//	public Elemento mapearDeFormulario()
//	{
//		return Elemento;
//	}

}
