package presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import entidades.Elemento;
import logica.ControladorDeElemento;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class ListadoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ControladorDeElemento ctrlElemento = new ControladorDeElemento();
	private ArrayList<Elemento> elementos = new ArrayList<Elemento>();

	public ListadoElemento() {
		setTitle("Elementos");
		
		setClosable(true);
		setBounds(100, 100, 507, 312);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificar();
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}

		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(120, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(38)
					.addComponent(btnEditar)
					.addGap(145))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnEditar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(groupLayout);
		
		try{
			
			elementos = ctrlElemento.consultarTodo();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		
		initDataBindings();
	}
	
	public void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elementos, table);
		//
		BeanProperty<Elemento, String> personaBeanProperty_0 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty_0).setColumnName("Id").setEditable(false);
		//
		BeanProperty<Elemento, String> personaBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Elemento, String> personaBeanProperty_1 = BeanProperty.create("tipo.id");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("tipo").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	

	public void modificar() {
		try
			{
			int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
			AgregarElemento menuEle = new AgregarElemento(-1);
			menuEle.showElemento(this.elementos.get(indexElemento));
			this.getDesktopPane().add(menuEle);
			menuEle.setVisible(true);}
		catch (Exception e){
			JOptionPane.showMessageDialog(this,"Por favor seleccione una fila");
		}
		
	}
	
	private void eliminar() {
		int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar al Elemento?");
		if (Confirmar == JOptionPane.YES_OPTION){
			int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
			try {
				ctrlElemento.borrarElemento(this.elementos.get(indexElemento));
				elementos = ctrlElemento.consultarTodo();
				initDataBindings();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se pudo eliminar el Elemento");;
			}
			
		}
		
	}
	
	

	
}
