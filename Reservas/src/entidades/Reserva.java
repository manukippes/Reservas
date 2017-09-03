package entidades;

import java.sql.Date;
import java.sql.Time;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Reserva {
	private int id;
	private TipoElemento tipo;
	private Date fechaHoraDesde;
	private Date fechaHoraHasta;
	private Elemento elemento;
	private String observacion;
	private Persona persona;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoElemento getTipo() {
		return tipo;
	}
	public void setTipo(TipoElemento tipo) {
		this.tipo = tipo;
	}
	public Date getFechaHoraDesde() {
		return fechaHoraDesde;
	}
	public void setFechaHoraDesde(Date fechaHoraDesde) {
		this.fechaHoraDesde = fechaHoraDesde;
	}
	public Date getFechaHoraHasta() {
		return fechaHoraHasta;
	}
	public void setFechaHoraHasta(Date fechaHoraHasta) {
		this.fechaHoraHasta = fechaHoraHasta;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
		
}
