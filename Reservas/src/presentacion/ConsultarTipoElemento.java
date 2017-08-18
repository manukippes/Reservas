package presentacion;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidades.TipoElemento;
import logica.ControladorDeTipoElemento;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ConsultarTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreBuscar;
	private JDesktopPane desktopPane;
	private JTable table;
	private ControladorDeTipoElemento ctrlTipoElemento;

	public ConsultarTipoElemento() {
		setTitle("Consulta de Tipo de Elemento");
		setBounds(100, 100, 619, 440);
		getContentPane().setLayout(new CardLayout(0, 0));
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_1954078469190");
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 89, 564, 2);
		desktopPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Ingrese Nombre del tipo de Elemento");
		lblNewLabel.setBounds(10, 11, 326, 14);
		desktopPane.add(lblNewLabel);
		
//////////////NOMBRE//////////////////////
		txtNombreBuscar = new JTextField();
		txtNombreBuscar.setBounds(305, 8, 203, 20);
		desktopPane.add(txtNombreBuscar);
		txtNombreBuscar.setColumns(10);
		
//////////////BOTON BUSCAR UN TIPO DE ELEMENTO//////////////////////
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarTipoElemento();
			}

		});
		btnBuscar.setBounds(249, 50, 89, 23);
		desktopPane.add(btnBuscar);
		
//////////////BOTON LISTAR TODO//////////////////////
		JButton btnListadoDeTodos = new JButton("Listado de todos los Tipos de Elementos");
		btnListadoDeTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearTabla();
			}
		});
		btnListadoDeTodos.setBounds(199, 107, 231, 23);
		desktopPane.add(btnListadoDeTodos);

	}
	
//////////METODO QUE CREA LA GRILLA////////////
	public void crearTabla() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 225, 701, 204);
		desktopPane.add(scrollPane);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		Object [][] fila;
		String [] columna = {"ID","Nombre","Cant_Max_Reservas_Pendientes"};
		fila = obtenerTipoElemento();
		DefaultTableModel modelo = new DefaultTableModel(fila,columna);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}

//////////METODO QUE CARGA TODOS LOS ELEMENTOS DE LA BASE DE DATOS A LA GRILLA////////////
	public Object[][] obtenerTipoElemento() {
		ArrayList <TipoElemento> tipoEle = new ArrayList<TipoElemento>();
		ctrlTipoElemento = new ControladorDeTipoElemento();
		try {
			tipoEle = ctrlTipoElemento.consultarTodo();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		Object matrizInfo [][] = new Object [tipoEle.size()][8];
		for (int i = 0; i < tipoEle.size(); i++) {
			matrizInfo [i][0]=tipoEle.get(i).getId();
			matrizInfo [i][1]=tipoEle.get(i).getNombre();
			matrizInfo [i][2]=tipoEle.get(i).getCant_max_reservas();
		}
		
		return matrizInfo;
	}



///////////////METODO PARA CONSULTAR UN ELEMENTO///////////////////////////
	private void consultarTipoElemento() {
			TipoElemento TipoEle = new TipoElemento();
			ctrlTipoElemento = new ControladorDeTipoElemento();
			TipoElemento TipoelementoNuevo = new TipoElemento();
			TipoelementoNuevo.setNombre(txtNombreBuscar.getText());
			try {
				TipoEle = ctrlTipoElemento.consultaPorNombre(TipoelementoNuevo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,e.getMessage());
			}
			Object matrizInfo [][] = new Object [1][8];
				matrizInfo [0][0]=TipoEle.getId();
				matrizInfo [0][1]=TipoEle.getNombre();
				matrizInfo [0][2]=TipoEle.getCant_max_reservas();
											
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 225, 701, 204);
			desktopPane.add(scrollPane);
			scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
			scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			
			Object [][] fila;
			String [] columna = {"ID","DNI","Nombre","Cant_Max_Reservas_Pendientes"};
			fila = matrizInfo;
			DefaultTableModel modelo = new DefaultTableModel(fila,columna);
			table = new JTable();
			table.setModel(modelo);
			scrollPane.setViewportView(table);
	}
}
