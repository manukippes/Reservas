package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Elemento;
import entidades.Persona;
import entidades.TipoElemento;
import logica.ControladorDePersona;
import logica.ControladorDeReserva;

import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.SystemColor;

public class PrincipalEscritorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorDePersona ctrlPersona = new ControladorDePersona();
	public JDesktopPane desktopPane;
	private JComboBox comboBoxPersonas = new JComboBox();

	public PrincipalEscritorio(Persona pers) {
		
		setTitle("Sistema de Reservas");
//		setExtendedState(Frame.);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 737);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, "name_2544348427397");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		if(pers.getCategoria().equals("Administrador"))
		{
			
			JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
			menuBar.add(mnAdministracin);
///////////////Persona//////////////////////
		JMenu mnPersona = new JMenu("Persona");
		mnAdministracin.add(mnPersona);
		
		JMenuItem mntmPersona = new JMenuItem("Agregar Persona");
		mntmPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarPersona ventanaPA = new AgregarPersona(-1);
				desktopPane.add(ventanaPA);
				ventanaPA.setVisible(true);
				ventanaPA.toFront();
			}
		});
		mnPersona.add(mntmPersona);
		
		JMenuItem mntmConsultarPersona = new JMenuItem("Listado de Personas");
		mntmConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPersona ventanaCP = new ListadoPersona();
				desktopPane.add(ventanaCP);
				ventanaCP.setVisible(true);
				ventanaCP.toFront();				
			}
		});
		mnPersona.add(mntmConsultarPersona);

///////////////Tipo de Elemento//////////////////////
		JMenu mnTipoDeElemento = new JMenu("Tipo de Elemento");
		mnAdministracin.add(mnTipoDeElemento);
		
		JMenuItem mntmTipoDeElemento = new JMenuItem("Agregar Tipo de Elemento");
		mntmTipoDeElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTipoElemento ventanaTE = new AgregarTipoElemento(-1, pers);
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				ventanaTE.toFront();
				
			}
		});
		mnTipoDeElemento.add(mntmTipoDeElemento);
		
		JMenuItem mntmConsultarTipoDe = new JMenuItem("Listado Tipo de Elemento");
		mntmConsultarTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoTipoElemento ventanaTE = new ListadoTipoElemento(pers);
				ventanaTE.setVisible(true);
				desktopPane.add(ventanaTE);
				ventanaTE.toFront();
			}
		});
		mnTipoDeElemento.add(mntmConsultarTipoDe);
		
		
///////////////Elemento//////////////////////
		JMenu mnElemento = new JMenu("Elemento");
		mnAdministracin.add(mnElemento);
		
		JMenuItem mntmElemento = new JMenuItem("Agregar Elemento");
		mntmElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarElemento ventanaE = new AgregarElemento(-1,pers);
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				ventanaE.toFront();
			}
		});
		mnElemento.add(mntmElemento);
		
		JMenuItem mntmConsultarElemento = new JMenuItem("Listado de Elemento");
		mntmConsultarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoElemento ventanaE = new ListadoElemento(pers);
				ventanaE.setVisible(true);
				desktopPane.add(ventanaE);
				ventanaE.toFront();
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
				ventanaRE.toFront();
			}
		});
		mnNewMenu.add(mntmBorrarReserva);
		}
		else
		{
			JMenu mnReserva = new JMenu("Reserva");
			menuBar.add(mnReserva);
///////////////Reserva Usuario//////////////////////
			
			
		JMenuItem mntmAlta = new JMenuItem("Reservar Elemento");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservarElemento ventanaRE;
				if (!(pers.getCategoria().equals("Encargado"))){
					ventanaRE = new ReservarElemento(pers);
					ventanaRE.setVisible(true);
					desktopPane.add(ventanaRE);
					ventanaRE.toFront();
					
				}
				else{
					
					try {					
						comboBoxPersonas.setModel(new DefaultComboBoxModel(ctrlPersona.consultarUsuariosExternos().toArray()));
					} catch (Exception e1) {
						System.out.println(e);
						JOptionPane.showMessageDialog(contentPane, "Seleccione la persona","Persona", EXIT_ON_CLOSE);
					}
					
					Object[] options = new Object[] {};
					JOptionPane jop = new JOptionPane("Por favor seleccione la persona", JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE,null,options, null);
					jop.add(comboBoxPersonas);
					JOptionPane.showMessageDialog(getContentPane(),jop,"Seleccione la persona", EXIT_ON_CLOSE);
					 
					Persona personaActual = personaActual=((Persona)comboBoxPersonas.getSelectedItem()); 					 
										
					ventanaRE = new ReservarElemento(personaActual);
					ventanaRE.setVisible(true);
					desktopPane.add(ventanaRE);
					ventanaRE.toFront();
					
				}
			}
		});
		mnReserva.add(mntmAlta);
		
		if(pers.getCategoria().equals("Online")){
		JMenuItem mntmBaja = new JMenuItem("Mis Reservas Pendientes");
			mntmBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MisReservas ventanaMISRE = new MisReservas(pers);
					ventanaMISRE.setVisible(true);
					desktopPane.add(ventanaMISRE);
					ventanaMISRE.toFront();
				}
			});
		mnReserva.add(mntmBaja);
		}
/////////////////////////////////////////////////////
		}
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesión");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ventanaLogin = new Login();
				ventanaLogin.setVisible(true);
				dispose();
			}
		});
		mnSalir.add(mntmCerrarSesion);
		
		JMenuItem mntmSalirAplicacion = new JMenuItem("Salir de la Aplicación");
		mntmSalirAplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnSalir.add(mntmSalirAplicacion);
				

	}
}
