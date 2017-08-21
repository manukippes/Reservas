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

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import entidades.Elemento;
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


public class ListadoTipoElemento extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ControladorDeTipoElemento ctrlTipoElemento = new ControladorDeTipoElemento();
	private ArrayList<TipoElemento> tipoElementos = new ArrayList<TipoElemento>();

	public ListadoTipoElemento() {
		setTitle("Listado de Tipo de Elemento");
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
		
		setBounds(100, 100, 619, 440);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 603, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 399, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(groupLayout);
		
		try{
			
			tipoElementos = ctrlTipoElemento.consultarTodo();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		
		initDataBindings();

	}

	
	public void initDataBindings() {
		JTableBinding<TipoElemento, List<TipoElemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, tipoElementos, table);
		//
		BeanProperty<TipoElemento, String> personaBeanProperty_0 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty_0).setColumnName("Id").setEditable(false);
		//
		BeanProperty<TipoElemento, String> personaBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<TipoElemento, String> personaBeanProperty_1 = BeanProperty.create("cant_max_reservas");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Cantidad Maxima de Reservas").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	

	public void modificar() {
		int indexTipoElemento=table.convertRowIndexToModel(table.getSelectedRow());
		AgregarTipoElemento menuTipoEle = new AgregarTipoElemento();
		//menuTipoEle.showTipoElemento(this.tipoElementos.get(indexTipoElemento)); //LLAMADA METODO NO DEFINIDOS HOY
		this.getDesktopPane().add(menuTipoEle);
		menuTipoEle.setVisible(true);
		
	}
	
	private void eliminar() {
		int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar el Tipo de Elemento?");
		if (Confirmar == JOptionPane.YES_OPTION){
			int indexTipoElemento=table.convertRowIndexToModel(table.getSelectedRow());
			try {
				ctrlTipoElemento.borrarTipoElemento(this.tipoElementos.get(indexTipoElemento));
				tipoElementos = ctrlTipoElemento.consultarTodo();
				initDataBindings();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se pudo eliminar el Tipo de Elemento");;
			}
			
		}
		
	}

}
