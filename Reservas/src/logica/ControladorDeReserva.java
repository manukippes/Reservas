package logica;

import java.util.ArrayList;

import datos.DatosElemento;
import datos.DatosReserva;
import datos.DatosTipoElemento;
import entidades.Elemento;
import entidades.Reserva;
import entidades.TipoElemento;

public class ControladorDeReserva {
private DatosReserva baseReserva = new DatosReserva();
private DatosTipoElemento baseTipoElemento = new DatosTipoElemento();
private DatosElemento baseElemento = new DatosElemento();
	
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
	
	public ArrayList<TipoElemento> getTipoElemento() throws Exception
	{
		return baseTipoElemento.buscarTodo();
	}
	
	public ArrayList<Elemento> getElemento() throws Exception
	{
		return baseElemento.buscarTodo();
	}

}
