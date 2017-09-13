package presentacion;

import java.awt.EventQueue;
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

import entidades.Elemento;
import entidades.Reserva;
import logica.ControladorDeReserva;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnularReserva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private ArrayList<Reserva> listadoReserva = new ArrayList<Reserva>();
	private ControladorDeReserva ctrlReserva = new ControladorDeReserva();
	private JScrollPane scrollPane;

	public AnularReserva() {
		setClosable(true);
		setTitle("Anular Reservas");
		setBounds(25, 25, 785, 601);
				
		JLabel lblSeleccionarLasReservas = new JLabel("Seleccionar las reservas a anular");
		
		JButton btnAnular = new JButton("Anular");
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anularReserva();
			}
		});
		
		scrollPane = new JScrollPane();
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(294)
							.addComponent(btnAnular, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSeleccionarLasReservas, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSeleccionarLasReservas, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAnular)
					.addGap(52))
		);
				
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(groupLayout);
		
		consultar();
		initDataBindings();

	}
	
	private void consultar() {
		try {
			listadoReserva = ctrlReserva.consultarTodo();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error al consultar Reservas",JOptionPane.ERROR_MESSAGE);
		}
		
	}


	private void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listadoReserva, table);
		//
		BeanProperty<Reserva, String> personaBeanProperty_0 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty_0).setColumnName("Id").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty = BeanProperty.create("elemento.id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Id de Elemento").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_1 = BeanProperty.create("tipo.id");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Id de tipo").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_2 = BeanProperty.create("persona.id");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Id de Persona").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_3 = BeanProperty.create("fechaHoraDesde");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Fecha y Hora Desde").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_4 = BeanProperty.create("fechaHoraHasta");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Fecha y Hora Hasta").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_5 = BeanProperty.create("observacion");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("Observacion").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_6 = BeanProperty.create("estado");
		jTableBinding.addColumnBinding(personaBeanProperty_6).setColumnName("Estado").setEditable(false);

		jTableBinding.setEditable(false);
		jTableBinding.bind();		
	}


	private void anularReserva() {
		int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la Reserva id: " + table.getValueAt(table.getSelectedRow(), 0)+" de fecha: "+table.getValueAt(table.getSelectedRow(), 4)+" ?","Confirmar eliminacion",JOptionPane.YES_NO_OPTION);
		if (Confirmar == JOptionPane.YES_OPTION){
		
		//int Confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar la Reserva?");
		//if (Confirmar == JOptionPane.YES_OPTION){
			int indexReserva=table.convertRowIndexToModel(table.getSelectedRow());
			try {
				ctrlReserva.borrarReserva(this.listadoReserva.get(indexReserva));
				listadoReserva.clear();
				consultar();
				initDataBindings();
												
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "No se pudo eliminar la Reserva");
			}
						
		}				
	}
}
