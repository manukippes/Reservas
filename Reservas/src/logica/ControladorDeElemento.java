package logica;

import java.util.ArrayList;

import datos.DatosElemento;
import datos.DatosTipoElemento;
import entidades.Elemento;
import entidades.TipoElemento;

public class ControladorDeElemento {
			private DatosElemento baseElemento;
			private DatosTipoElemento baseTipoElemento;
			
			public ControladorDeElemento()
			{
				baseElemento = new DatosElemento();
				baseTipoElemento = new DatosTipoElemento();
			}
			
			public void crearElemento(Elemento ele) throws Exception{
				baseElemento.agregarElemento(ele);
						
			};
			
			public void borrarElemento (Elemento ele) throws Exception{
				baseElemento.eliminarElemento(ele);
			};
			
			public void modificarElemento(Elemento ele) throws Exception{
				baseElemento.modificarElemento(ele);
			};
			

			public Elemento consultaPorNombre(Elemento ele) throws Exception{
				return baseElemento.buscarPorNombre(ele);
			}
			
			public ArrayList<Elemento> consultarTodo() throws Exception{
				return baseElemento.buscarTodo();
			}
			
			public ArrayList<TipoElemento> getTipoElemento() throws Exception
			{
				return baseTipoElemento.buscarTodo();
			}
			

}