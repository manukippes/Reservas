package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import entidades.Persona;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import entidades.Persona;
import logica.ControladorDeElemento;
import logica.ControladorDePersona;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;


public class ListadoPersona extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ControladorDePersona ctrlPersona = new ControladorDePersona();
	private ArrayList<Persona> personas = new ArrayList<Persona>();

	public ListadoPersona() {
		setTitle("Personas");
		setClosable(true);
		setBounds(25, 25, 650, 312);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					modificar(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()));
					}
				catch (Exception e){
					JOptionPane.showMessageDialog(ListadoPersona.this,"Para editar, debe seleccionar una fila  "," Error de selección",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				eliminar();
				}
			catch (Exception exc){
				JOptionPane.showMessageDialog(ListadoPersona.this,"Para eliminar, debe seleccionar una fila  "," Error de selección",JOptionPane.WARNING_MESSAGE);
			}
			};

		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addComponent(btnEliminar)
					.addGap(128)
					.addComponent(btnEditar)
					.addContainerGap(205, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnEditar))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().setLayout(groupLayout);
		
		try{
			
			personas = ctrlPersona.consultarTodo();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		
		initDataBindings();
	}
	
	public void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, personas, table);
		//
		BeanProperty<Persona, String> personaBeanProperty_0 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty_0).setColumnName("Id").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("DNI").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Apellido").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_4 = BeanProperty.create("usuario");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Usuario").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_5 = BeanProperty.create("contrasena");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("Contraseña").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_6 = BeanProperty.create("habilitado");
		jTableBinding.addColumnBinding(personaBeanProperty_6).setColumnName("Habilitado").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_7 = BeanProperty.create("categoria");
		jTableBinding.addColumnBinding(personaBeanProperty_7).setColumnName("Categoria").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	

	public void modificar(int id) {
		int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
		AgregarPersona menuPers = new AgregarPersona(id);
		menuPers.showPersona(this.personas.get(indexElemento));
		this.getDesktopPane().add(menuPers);
		menuPers.setVisible(true);  
		dispose();			////////////LA TABLA NO SE ACTUALIZA UNA VEZ AGREGADA LA PERSONA, LA ELIMINAMOS Y LA CREAMOS LUEGO DE NUEVO		
	}
	
	private void eliminar() {		
		int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar a " + table.getValueAt(table.getSelectedRow(), 3) +", "+ (table.getValueAt(table.getSelectedRow(), 2)+" ?"),"Confirmar eliminacion",JOptionPane.YES_NO_OPTION);
		if (Confirmar == JOptionPane.YES_OPTION){
			int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
			try {
				ctrlPersona.borrarPersona(this.personas.get(indexElemento));
				personas = ctrlPersona.consultarTodo();
				initDataBindings();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se pudo eliminar la Persona");;
			}
			
	}

	}
	 
}
