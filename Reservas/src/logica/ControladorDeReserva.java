package logica;

import java.util.ArrayList;
import datos.DatosReserva;
import entidades.Reserva;

public class ControladorDeReserva {
private DatosReserva baseReserva = new DatosReserva();
	
	public void crearReserva(Reserva res) throws Exception{
		baseReserva.agregarReserva(res);
				
	};
	
	public void borrarReserva(Reserva res) throws Exception{
		baseReserva.eliminarReserva(res);
	};
	
	public void modificarReserva(Reserva res) throws Exception{
		baseReserva.modificarReserva(res);
	};
	
	public ArrayList<Reserva> consultarTodo() throws Exception{
		return baseReserva.buscarTodo();
	}

}
