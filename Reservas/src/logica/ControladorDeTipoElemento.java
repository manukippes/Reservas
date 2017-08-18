package logica;

import java.util.ArrayList;

import datos.DatosTipoElemento;
import entidades.TipoElemento;

public class ControladorDeTipoElemento {
private DatosTipoElemento baseTipoElemento = new DatosTipoElemento();
	
	public void crearTipoElemento(TipoElemento tipoele) throws Exception{
		baseTipoElemento.agregarTipoElemento(tipoele);
				
	};
	
	public void borrarTipoElemento (TipoElemento tipoele) throws Exception{
		baseTipoElemento.eliminarTipoElemento(tipoele);
	};
	
	public void modificarTipoElemento(TipoElemento tipoele) throws Exception{
		baseTipoElemento.modificarTipoElemento(tipoele);
	};
	

	public TipoElemento consultaPorNombre(TipoElemento tipoele) throws Exception{
		return baseTipoElemento.buscarPorNombre(tipoele);
	}
	
	public ArrayList<TipoElemento> consultarTodo() throws Exception{
		return baseTipoElemento.buscarTodo();
	}
}
