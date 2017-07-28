package logica;

import java.util.ArrayList;

import entidades.Persona;

public class ControladorDePersona {
private ArrayList <Persona> personas = new ArrayList <Persona>();
	
	public void crearPersona(Persona pers){
		personas.add(pers);		
	};
	
	public void borrarPersona (Persona pers){
		for (int i=0; i < this.personas.size(); i++){
			if(pers.getDni()== personas.get(i).getDni()) {
				personas.remove(i);}	
			}
	};
	
	public void modificarPersona(Persona pers){
		for (int i=0; i < this.personas.size(); i++){
			if(pers.getDni()== personas.get(i).getDni()) {
				personas.remove(i);
				personas.add(pers);
				}	
			}
	};
	

	public Persona consultaPorDni(Persona p){
		return this.consultaPorDni(p.getDni());
	}
	
	public Persona consultaPorDni(String dni){
		
		for (int i=0; i < this.personas.size(); i++){
			if(dni==(personas.get(i).getDni())) {
				return personas.get(i);
				
			}
		}
		return null; 
	}
	
	public Persona consultaPorNombreApellido(Persona p){
		
		for (int i=0; i < this.personas.size(); i++){
			if(personas.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& personas.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return personas.get(i);		
			}
			
		}
		return null;
		
	}
	
	public ArrayList<Persona> consultarTodo(){
		return this.personas;
	}

}
