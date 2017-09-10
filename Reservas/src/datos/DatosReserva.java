package datos;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import entidades.*;
import utilidades.ExcepcionesEscritorio;

import java.nio.channels.SelectableChannel;
import java.security.KeyStore.ProtectionParameter;

public class DatosReserva 
{
	ArrayList<Reserva>listadoRes = new ArrayList<Reserva>();
	
	public ArrayList<Reserva> buscarTodo() throws Exception
	{
		Statement stm=null;
		ResultSet rs=null;
		
		try {
			stm = FactoryConnection.getinstancia().getConn().createStatement();
			rs = stm.executeQuery("SELECT * FROM reserva");
			if(rs!=null){
				while(rs.next()){
					Reserva res = new Reserva();
					res.setId(rs.getInt("id"));
					res.setElemento(new Elemento());
					res.getElemento().setId(rs.getInt("elemento"));
					res.setTipo(new TipoElemento());
					res.getTipo().setId(rs.getInt("tipo"));
					res.setPersona(new Persona());
					res.getPersona().setId(rs.getInt("persona"));
					res.setFechaHoraDesde(rs.getDate("fechaHoraDesde"));
					res.setFechaHoraHasta(rs.getDate("fechaHoraHasta"));
					res.setObservacion(rs.getString("observacion"));
					listadoRes.add(res);
				}
			}
			
			
		} catch (SQLException e) {
			throw e;
		} catch (ExcepcionesEscritorio e) {
			throw e;
		}
		
		try {
			if(rs!=null)rs.close();
			if(stm!=null)stm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (SQLException e) {
			throw e;
		}
		
		return listadoRes;
	}
	
	public void agregarReserva(Reserva res) throws Exception
	{
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"INSERT INTO reserva(elemento,tipo,persona,fechaHoraDesde,fechaHoraHasta,observacion) VALUES (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, res.getElemento().getId());
			pstm.setInt(2, res.getTipo().getId());
			pstm.setInt(3, res.getPersona().getId());
			pstm.setTimestamp(4, new Timestamp(res.getFechaHoraDesde().getTime()));
			pstm.setTimestamp(5, new Timestamp(res.getFechaHoraHasta().getTime()));
			pstm.setString(6, res.getObservacion());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();
			if(rs!=null & rs.next())
			{
				res.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			throw e;
		} catch (ExcepcionesEscritorio e) {
			throw e;
		}
		
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}
				
	}

	public void eliminarReserva(Reserva res) throws Exception
	{
		PreparedStatement pstm = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement("DELETE FROM reserva WHERE id=?");
			pstm.setInt(1, res.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} catch (ExcepcionesEscritorio e) {
			throw e;
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}
		
	}
		
	public void modificarReserva(Reserva res) throws Exception
	{
		PreparedStatement pstm = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement("UPDATE reserva SET elemento=?, tipo=?, persona=?, fechaHoraDesde=?, fechaHoraHasta=?, observacion=? WHERE id=?");
			pstm.setInt(1, res.getElemento().getId());
			pstm.setInt(2, res.getTipo().getId());
			pstm.setInt(3, res.getPersona().getId());
			pstm.setTimestamp(4, new Timestamp(res.getFechaHoraDesde().getTime()));
			pstm.setTimestamp(5, new Timestamp(res.getFechaHoraHasta().getTime()));
			pstm.setString(6, res.getObservacion());
			pstm.setInt(7, res.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} catch (ExcepcionesEscritorio e) {
			throw e;
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}
	}
	

			
}

