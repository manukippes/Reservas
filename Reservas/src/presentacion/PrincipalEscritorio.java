package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class PrincipalEscritorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JDesktopPane desktopPane;

	public PrincipalEscritorio() {
		setTitle("Sistema de Reservas");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_2544348427397");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		menuBar.add(mnAdministracin);
		
///////////////Persona//////////////////////
		JMenu mnPersona = new JMenu("Persona");
		mnAdministracin.add(mnPersona);
		
		JMenuItem mntmConsultarPersona = new JMenuItem("Consultar Persona");
		mntmConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPersona ventanaCP = new ConsultarPersona();
				ventanaCP.setVisible(true);
				desktopPane.add(ventanaCP);
				
			}
		});
		mnPersona.add(mntmConsultarPersona);
		
		JMenuItem mntmPersona = new JMenuItem("Agregar Persona");
		mntmPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPersona ventanaPA = new AgregarPersona();
				desktopPane.add(ventanaPA);
				ventanaPA.setVisible(true);
			}
		});
		mnPersona.add(mntmPersona);
		
		JMenuItem mntmModificarPersona = new JMenuItem("Modificar Persona");
		mntmModificarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarPersona ventanaMP = new ModificarPersona();
				ventanaMP.setVisible(true);
				desktopPane.add(ventanaMP);
			}
		});
		mnPersona.add(mntmModificarPersona);
		
		JMenuItem mntmBorrarPersona = new JMenuItem("Borrar Persona");
		mntmBorrarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarPersona ventanaEP = new EliminarPersona();
				ventanaEP.setVisible(true);
				desktopPane.add(ventanaEP);
			}
		});
		mnPersona.add(mntmBorrarPersona);

///////////////Tipo de Elemento//////////////////////
		JMenu mnTipoDeElemento = new JMenu("Tipo de Elemento");
		mnAdministracin.add(mnTipoDeElemento);
		
		JMenuItem mntmTipoDeElemento = new JMenuItem("Agregar Tipo de Elemento");
		mnTipoDeElemento.add(mntmTipoDeElemento);
		
		JMenuItem mntmModificarTipoDe = new JMenuItem("Modificar Tipo de Elemento");
		mnTipoDeElemento.add(mntmModificarTipoDe);
		
		JMenuItem mntmConsultarTipoDe = new JMenuItem("Consultar Tipo de Elento");
		mnTipoDeElemento.add(mntmConsultarTipoDe);
		
		JMenuItem mntmEliminarTipoDe = new JMenuItem("Borrar Tipo de Elemento");
		mnTipoDeElemento.add(mntmEliminarTipoDe);
		
///////////////Elemento//////////////////////
		JMenu mnElemento = new JMenu("Elemento");
		mnAdministracin.add(mnElemento);
		
		JMenuItem mntmElemento = new JMenuItem("Agregar Elemento");
		mnElemento.add(mntmElemento);
		
		JMenuItem mntmConsultarElemento = new JMenuItem("Consultar Elemento");
		mnElemento.add(mntmConsultarElemento);
		
		JMenuItem mntmModificarElemento = new JMenuItem("Modificar Elemento");
		mnElemento.add(mntmModificarElemento);
		
		JMenuItem mntmEliminarElemento = new JMenuItem("Borrar Elemento");
		mnElemento.add(mntmEliminarElemento);
		
///////////////Reserva Administracion//////////////////////
		JMenu mnNewMenu = new JMenu("Reserva");
		mnAdministracin.add(mnNewMenu);
		
		JMenuItem mntmReserva = new JMenuItem("Agregar Reserva");
		mnNewMenu.add(mntmReserva);
		
		JMenuItem mntmConsultarReserva = new JMenuItem("Consultar Reserva");
		mnNewMenu.add(mntmConsultarReserva);
		
		JMenuItem mntmModificarReserva = new JMenuItem("Modificar Reserva");
		mnNewMenu.add(mntmModificarReserva);
		
		JMenuItem mntmBorrarReserva = new JMenuItem("Borrar Reserva");
		mnNewMenu.add(mntmBorrarReserva);

///////////////Reserva Usuario//////////////////////
		JMenu mnReserva = new JMenu("Reserva");
		menuBar.add(mnReserva);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mnReserva.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mnReserva.add(mntmBaja);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mnReserva.add(mntmConsulta);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnReserva.add(mntmModificar);
/////////////////////////////////////////////////////
		

	}
}
