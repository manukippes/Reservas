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
import javax.swing.table.DefaultTableModel;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import entidades.Elemento;
import logica.ControladorDeElemento;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class ConsultarElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ControladorDeElemento ctrlElemento;
	private ArrayList<Elemento> elementos;
	private JScrollPane scrollPane;

	public ConsultarElemento() {
		setTitle("Consulta de Elemento");
		setBounds(100, 100, 637, 410);
		
		scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
		);
		getContentPane().setLayout(groupLayout);
		
		try{
			this.elementos=ctrlElemento.consultarTodo();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		
		initDataBindings();
	}
	
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elementos, table);
		//
		BeanProperty<Elemento, String> personaBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Elemento, String> personaBeanProperty_1 = BeanProperty.create("tipo.nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("tipo").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}

	
}
