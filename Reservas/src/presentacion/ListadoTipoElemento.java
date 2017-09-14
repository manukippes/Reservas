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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import entidades.Elemento;
import entidades.Persona;
import entidades.TipoElemento;
import logica.ControladorDeElemento;
import logica.ControladorDeTipoElemento;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ListadoTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ControladorDeTipoElemento ctrlTipoElemento = new ControladorDeTipoElemento();
	private ArrayList<TipoElemento> tipoElementos = new ArrayList<TipoElemento>();

	public ListadoTipoElemento(Persona pers) 
	{
		setTitle("Tipos de Elemento");
		setClosable(true);
		setBounds(25, 25, 507, 312);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					modificar(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()), pers);
					}
				catch (Exception exc){
					JOptionPane.showMessageDialog(ListadoTipoElemento.this,"Para editar, debe seleccionar una fila  "," Error de selección",JOptionPane.WARNING_MESSAGE);
				};
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					eliminar(pers);
					}
				
				catch (Exception exc){
					JOptionPane.showMessageDialog(ListadoTipoElemento.this,"Para eliminar, debe seleccionar una fila  "," Error de selección",JOptionPane.WARNING_MESSAGE);
				};
			}

		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(125, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(133)
					.addComponent(btnEditar)
					.addGap(103))
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
			tipoElementos = ctrlTipoElemento.consultarTodo(pers);
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		
		initDataBindings();

	}

	
	public void initDataBindings() 
	{
		JTableBinding<TipoElemento, List<TipoElemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, tipoElementos, table);
		//
		BeanProperty<TipoElemento, String> tipoElementoBeanProperty_0 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty_0).setColumnName("Id").setEditable(false);
		//
		BeanProperty<TipoElemento, String> tipoElementoBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<TipoElemento, String> tipoElementoBeanProperty_1 = BeanProperty.create("cant_max_reservas");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty_1).setColumnName("Cantidad Maxima de Reservas").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	

	public void modificar(int idTipoElemento, Persona pers) 
	{
		try{
			int indexTipoElemento=table.convertRowIndexToModel(table.getSelectedRow());
			AgregarTipoElemento menuTipoEle = new AgregarTipoElemento(idTipoElemento, pers);
			menuTipoEle.showTipoElemento(this.tipoElementos.get(indexTipoElemento)); 
			this.getDesktopPane().add(menuTipoEle);
			menuTipoEle.setVisible(true);
			dispose();}
		catch (Exception e){
			JOptionPane.showMessageDialog(this,"Para modificar, primero debe seleccionar una fila    "," Error de selección",JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	private void eliminar(Persona pers)
	{
		int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar el elemento " + table.getValueAt(table.getSelectedRow(), 1)+" ?","Confirmar eliminacion",JOptionPane.YES_NO_OPTION);
		if (Confirmar == JOptionPane.YES_OPTION)
		{
			int indexTipoElemento=table.convertRowIndexToModel(table.getSelectedRow());
			try 
			{
				ctrlTipoElemento.borrarTipoElemento(this.tipoElementos.get(indexTipoElemento));
				tipoElementos = ctrlTipoElemento.consultarTodo(pers);
				initDataBindings();
				
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(this,"No se puede eliminar el tipo de elemento    "," Error",JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
}
