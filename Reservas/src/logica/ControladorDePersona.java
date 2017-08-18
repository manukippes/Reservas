package logica;

import java.util.ArrayList;

import datos.DatosPersona;
import entidades.Persona;


public class ControladorDePersona {
	private DatosPersona basePersona = new DatosPersona();
	
	public void crearPersona(Persona pers) throws Exception{
		basePersona.agregarPersona(pers);
				
	};
	
	public void borrarPersona (Persona pers) throws Exception{
		basePersona.eliminarPersona(pers);
	};
	
	public void modificarPersona(Persona pers) throws Exception{
		basePersona.modificarPersona(pers);
	};
	

	public Persona consultaPorDni(Persona p) throws Exception{
		return this.consultaPorDni(p.getDni());
	}
	
	public Persona consultaPorDni(String dni) throws Exception{
		return basePersona.buscarPorDni(dni);
	}
	
	public ArrayList<Persona> consultaPorNombreApellido(Persona p) throws Exception{
		return basePersona.buscarPorNYA(p);
		
	}
	
	public ArrayList<Persona> consultarTodo() throws Exception{
		return basePersona.buscarTodo();
	}

}
