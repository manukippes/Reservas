package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import datos.DatosPersona;
import entidades.Persona;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConsultarPersona extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JDesktopPane desktopPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;

	public ConsultarPersona() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Consultar Personas");
		setBounds(100, 100, 747, 531);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, "name_4595815705129");

//////////GRILLA////////////
		
		

//////////DNI////////////
		JLabel lblDni1 = new JLabel("DNI");
		lblDni1.setBounds(15, 16, 69, 20);
		desktopPane.add(lblDni1);
		txtDni = new JTextField();
		txtDni.setBounds(99, 13, 216, 26);
		desktopPane.add(txtDni);
		txtDni.setColumns(10);

//////////NOMBRE////////////
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 67, 69, 20);
		desktopPane.add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setBounds(99, 64, 216, 26);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
//////////APELLIDO////////////		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 103, 69, 20);
		desktopPane.add(lblApellido);
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(99, 100, 216, 26);
		desktopPane.add(txtApellido);
		
//////////SEPARADOR////////////
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 159, 701, 2);
		desktopPane.add(separator);
		
//////////BOTON BUSCAR POR DNI////////////
		JButton btnBuscarPorDni = new JButton("Buscar");
		btnBuscarPorDni.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				buscarPorDni();
			}
		});
		btnBuscarPorDni.setBounds(353, 12, 115, 29);
		desktopPane.add(btnBuscarPorDni);
		
//////////BOTON BUSCAR POR NOMBRE Y APELLIDO////////////
		JButton btnBuscarPorNYA = new JButton("Buscar");
		btnBuscarPorNYA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorNYA();
			}

		});
		btnBuscarPorNYA.setBounds(353, 79, 115, 29);
		desktopPane.add(btnBuscarPorNYA);

//////////BOTON LISTAR PERSONAS////////////
		JButton btnListaPersonas = new JButton("Listar Personas");
		btnListaPersonas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				crearTabla();
			}
		});
		btnListaPersonas.setBounds(196, 180, 290, 29);
		desktopPane.add(btnListaPersonas);

	}

//////////METODO QUE CARGA PERSONAS DE LA BASE DE DATOS////////////
	public Object[][] obtenerPersona() {
		ArrayList <Persona> pers = new ArrayList<Persona>();
		DatosPersona datospersona = new DatosPersona();	
		pers = datospersona.buscarTodo();
		Object matrizInfo [][] = new Object [pers.size()][8];
		for (int i = 0; i < pers.size(); i++) {
			matrizInfo [i][0]=pers.get(i).getId();
			matrizInfo [i][1]=pers.get(i).getDni();
			matrizInfo [i][2]=pers.get(i).getNombre();
			matrizInfo [i][3]=pers.get(i).getApellido();
			matrizInfo [i][4]=pers.get(i).getUsuario();
			matrizInfo [i][5]=pers.get(i).getContrasena();
			matrizInfo [i][6]=pers.get(i).isHabilitado();
			matrizInfo [i][7]=pers.get(i).getCategoria();
		}
		
		return matrizInfo;
	}

	public void crearTabla() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 225, 701, 204);
		desktopPane.add(scrollPane);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		Object [][] fila;
		String [] columna = {"ID","DNI","Nombre","Apellido","Usuario","Contraseña","Habilitado","Categoria"};
		fila = obtenerPersona();
		DefaultTableModel modelo = new DefaultTableModel(fila,columna);
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}
	
	public void buscarPorDni() {
		Persona pers = new Persona();
		DatosPersona datospersona = new	DatosPersona();
		Persona personanueva = new Persona();
		personanueva.setDni(txtDni.getText());
		pers = datospersona.buscarPorDni(personanueva);
		Object matrizInfo [][] = new Object [1][8];
			matrizInfo [0][0]=pers.getId();
			matrizInfo [0][1]=pers.getDni();
			matrizInfo [0][2]=pers.getNombre();
			matrizInfo [0][3]=pers.getApellido();
			matrizInfo [0][4]=pers.getUsuario();
			matrizInfo [0][5]=pers.getContrasena();
			matrizInfo [0][6]=pers.isHabilitado();
			matrizInfo [0][7]=pers.getCategoria();
						
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 225, 701, 204);
		desktopPane.add(scrollPane);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		Object [][] fila;
		String [] columna = {"ID","DNI","Nombre","Apellido","Usuario","Contraseña","Habilitado","Categoria"};
		fila = matrizInfo;
		DefaultTableModel modelo = new DefaultTableModel(fila,columna);
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}
	

	public void buscarPorNYA() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 225, 701, 204);
		desktopPane.add(scrollPane);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		ArrayList <Persona> pers = new ArrayList<Persona>();
		DatosPersona datospersona = new DatosPersona();	
		Persona personanueva = new Persona();
		personanueva.setNombre(txtNombre.getText());
		personanueva.setApellido(txtApellido.getText());
		pers = datospersona.buscarPorNYA(personanueva);
		Object matrizInfo [][] = new Object [pers.size()][8];
		for (int i = 0; i < pers.size(); i++) {
			matrizInfo [i][0]=pers.get(i).getId();
			matrizInfo [i][1]=pers.get(i).getDni();
			matrizInfo [i][2]=pers.get(i).getNombre();
			matrizInfo [i][3]=pers.get(i).getApellido();
			matrizInfo [i][4]=pers.get(i).getUsuario();
			matrizInfo [i][5]=pers.get(i).getContrasena();
			matrizInfo [i][6]=pers.get(i).isHabilitado();
			matrizInfo [i][7]=pers.get(i).getCategoria();
		}
		
		Object [][] fila;
		String [] columna = {"ID","DNI","Nombre","Apellido","Usuario","Contraseña","Habilitado","Categoria"};
		fila = matrizInfo;
		DefaultTableModel modelo = new DefaultTableModel(fila,columna);
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
	}
	 
}
