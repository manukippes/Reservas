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
		mntmTipoDeElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTipoElemento ventanaTE = new AgregarTipoElemento();
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				
			}
		});
		mnTipoDeElemento.add(mntmTipoDeElemento);
		
		JMenuItem mntmModificarTipoDe = new JMenuItem("Modificar Tipo de Elemento");
		mntmModificarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarTipoElemento ventanaTE = new ModificarTipoElemento();
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				
			}
		});
		mnTipoDeElemento.add(mntmModificarTipoDe);
		
		JMenuItem mntmConsultarTipoDe = new JMenuItem("Consultar Tipo de Elento");
		mntmConsultarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarTipoElemento ventanaTE = new ConsultarTipoElemento();
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				
			}
		});
		mnTipoDeElemento.add(mntmConsultarTipoDe);
		
		JMenuItem mntmEliminarTipoDe = new JMenuItem("Borrar Tipo de Elemento");
		mntmEliminarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarTipoElemento ventanaTE = new EliminarTipoElemento();
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				
			}
		});
		mnTipoDeElemento.add(mntmEliminarTipoDe);
		
///////////////Elemento//////////////////////
		JMenu mnElemento = new JMenu("Elemento");
		mnAdministracin.add(mnElemento);
		
		JMenuItem mntmElemento = new JMenuItem("Agregar Elemento");
		mntmElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarElemento ventanaE = new AgregarElemento();
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				
			}
		});
		mnElemento.add(mntmElemento);
		
		JMenuItem mntmConsultarElemento = new JMenuItem("Consultar Elemento");
		mntmConsultarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarElemento ventanaE = new ConsultarElemento();
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				
			}
		});
		mnElemento.add(mntmConsultarElemento);
		
		JMenuItem mntmModificarElemento = new JMenuItem("Modificar Elemento");
		mntmModificarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarElemento ventanaE = new ModificarElemento();
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				
			}
		});
		mnElemento.add(mntmModificarElemento);
		
		JMenuItem mntmEliminarElemento = new JMenuItem("Borrar Elemento");
		mntmEliminarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarElemento ventanaE = new EliminarElemento();
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				
			}
		});
		mnElemento.add(mntmEliminarElemento);
		
///////////////Reserva Administracion//////////////////////
		JMenu mnNewMenu = new JMenu("Reserva");
		mnAdministracin.add(mnNewMenu);
		
		JMenuItem mntmReserva = new JMenuItem("Agregar Reserva");
		mntmReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarReserva ventanaRE = new AgregarReserva();
				ventanaRE.setVisible(true);
				desktopPane.add(ventanaRE);
				
			}
		});
		mnNewMenu.add(mntmReserva);
		
		JMenuItem mntmConsultarReserva = new JMenuItem("Consultar Reserva");
		mntmConsultarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarReserva ventanaRE = new ConsultarReserva();
				ventanaRE.setVisible(true);
				desktopPane.add(ventanaRE);
				
			}
		});
		mnNewMenu.add(mntmConsultarReserva);
		
		JMenuItem mntmModificarReserva = new JMenuItem("Modificar Reserva");
		mntmModificarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarReserva ventanaRE = new ModificarReserva();
				ventanaRE.setVisible(true);
				desktopPane.add(ventanaRE);
				
			}
		});
		mnNewMenu.add(mntmModificarReserva);
		
		JMenuItem mntmBorrarReserva = new JMenuItem("Borrar Reserva");
		mntmBorrarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarReserva ventanaRE = new EliminarReserva();
				ventanaRE.setVisible(true);
				desktopPane.add(ventanaRE);
				
			}
		});
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
