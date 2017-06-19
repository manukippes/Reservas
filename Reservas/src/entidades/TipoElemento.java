package entidades;

public class TipoElemento {
	private int id;
	private String nombre;
	private int cant_max_reservas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCant_max_reservas() {
		return cant_max_reservas;
	}
	public void setCant_max_reservas(int cant_max_reservas) {
		this.cant_max_reservas = cant_max_reservas;
	}

}
