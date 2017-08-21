package presentacion;

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
//		setExtendedState(Frame.);
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
		
		JMenuItem mntmPersona = new JMenuItem("Agregar Persona");
		mntmPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPersona ventanaPA = new AgregarPersona();
				desktopPane.add(ventanaPA);
				ventanaPA.setVisible(true);
			}
		});
		mnPersona.add(mntmPersona);
		
		JMenuItem mntmConsultarPersona = new JMenuItem("Listado de Personas");
		mntmConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPersona ventanaCP = new ListadoPersona();
				ventanaCP.setVisible(true);
				desktopPane.add(ventanaCP);
				
			}
		});
		mnPersona.add(mntmConsultarPersona);

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
		
		JMenuItem mntmConsultarTipoDe = new JMenuItem("Listado Tipo de Elemento");
		mntmConsultarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoTipoElemento ventanaTE = new ListadoTipoElemento();
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				
			}
		});
		mnTipoDeElemento.add(mntmConsultarTipoDe);
		
		
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
		
		JMenuItem mntmConsultarElemento = new JMenuItem("Listado de Elemento");
		mntmConsultarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoElemento ventanaE = new ListadoElemento();
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				
			}
		});
		mnElemento.add(mntmConsultarElemento);
		
///////////////Reserva Administracion//////////////////////
		JMenu mnNewMenu = new JMenu("Reserva");
		mnAdministracin.add(mnNewMenu);
		
		JMenuItem mntmBorrarReserva = new JMenuItem("Anular Reserva");
		mntmBorrarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnularReserva ventanaRE = new AnularReserva();
				ventanaRE.setVisible(true);
				desktopPane.add(ventanaRE);
				
			}
		});
		mnNewMenu.add(mntmBorrarReserva);

///////////////Reserva Usuario//////////////////////
		JMenu mnReserva = new JMenu("Reserva");
		menuBar.add(mnReserva);
		
		JMenuItem mntmAlta = new JMenuItem("Reservar Elemento");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservarElemento ventanaRE = new ReservarElemento();
				ventanaRE.setVisible(true);
				desktopPane.add(ventanaRE);
			}
		});
		mnReserva.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Mis Reservas");
			mntmBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MisReservas ventanaMISRE = new MisReservas();
					ventanaMISRE.setVisible(true);
					desktopPane.add(ventanaMISRE);
				}
			});
		mnReserva.add(mntmBaja);
		
/////////////////////////////////////////////////////
		

	}
}