package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import entidades.Persona;
import entidades.Reserva;
import logica.ControladorDeReserva;

import javax.swing.GroupLayout;
import javax.swing.JButton;

public class MisReservas extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTable table;
	private ControladorDeReserva ctrlReserva = new ControladorDeReserva();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	public MisReservas(Persona pers) {
		setTitle("Mis Reserva");
		
		setClosable(true);
		setBounds(100, 100, 507, 312);
		
		scrollPane = new JScrollPane();
		
		JButton btnEliminar = new JButton("Cancelar Reserva");
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
					.addContainerGap(176, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(162))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(groupLayout);
		
		try{
			
			reservas = ctrlReserva.reservasPendientesPersona(pers);
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		
		initDataBindings();
	}
	
	public void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, reservas, table);
		//
		BeanProperty<Reserva, String> personaBeanProperty_0 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty_0).setColumnName("Id").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty = BeanProperty.create("elemento.id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Elemento").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_1 = BeanProperty.create("tipo.id");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Tipo de Elemento").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_2 = BeanProperty.create("persona.id");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Persona").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_3 = BeanProperty.create("fechaHoraDesde");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Fecha y Hora desde").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_4 = BeanProperty.create("fechaHoraHasta");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Fecha y Hora hasta").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_5 = BeanProperty.create("observacion");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("Observaciones").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	

	private void eliminar() {
		int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea cancelar la Reserva?");
		if (Confirmar == JOptionPane.YES_OPTION){
			int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
			try {
				ctrlReserva.borrarReserva(this.reservas.get(indexElemento));
				reservas.clear();
				reservas = ctrlReserva.consultarTodo();
				initDataBindings();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se pudo cancelar la Reserva");;
			}
			
		}

	}

}
