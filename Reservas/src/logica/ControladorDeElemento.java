package logica;

import java.util.ArrayList;

import datos.DatosElemento;
import datos.DatosTipoElemento;
import entidades.Elemento;
import entidades.TipoElemento;
import utilidades.ExcepcionEspecial;

public class ControladorDeElemento {
			private DatosElemento baseElemento;
			private DatosTipoElemento baseTipoElemento;
			
			public ControladorDeElemento()
			{
				baseElemento = new DatosElemento();
				baseTipoElemento = new DatosTipoElemento();
			}
			
			public void crearElemento(Elemento ele) throws Exception, ExcepcionEspecial{
	
				if (ele.getNombre().length() != 0){
						try{
							baseElemento.agregarElemento(ele);
						}
						catch (Exception a){
							throw new ExcepcionEspecial("tipo de elemento");
						}
					}
				else{
					throw new ExcepcionEspecial("nombre");
					}		
						
			};
			
			public void borrarElemento (Elemento ele) throws Exception{
				baseElemento.eliminarElemento(ele);
			};
			
			public void modificarElemento(Elemento ele) throws Exception{
					
					if (ele.getNombre().length() != 0){
							try{
								baseElemento.modificarElemento(ele);
							}
							catch (Exception a){
								throw new ExcepcionEspecial("tipo de elemento");
							}
						}
					else{
						throw new ExcepcionEspecial("nombre");
						}		
							
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