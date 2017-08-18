package datos;

import java.sql.*;
import java.util.ArrayList;
import entidades.*;

public class DatosTipoElemento 
{
	
	public ArrayList<TipoElemento> buscarTodo() throws Exception
	{
		Statement stm=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipoelemento= new ArrayList<TipoElemento>();
		
		try 
		{
			stm = FactoryConnection.getinstancia().getConn().createStatement();
			rs = stm.executeQuery("select id,nombre,cant_max_reservas from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tipoele=new TipoElemento();
					tipoele.setId(rs.getInt("id"));
					tipoele.setNombre(rs.getString("nombre"));
					tipoele.setCant_max_reservas(rs.getInt("cant_max_reservas"));
					tipoelemento.add(tipoele);
				}
			}
		} 
		catch (Exception e) 
		{
			throw e;
		}
		
		try {
			if(rs!=null) rs.close();
			if(stm!=null) stm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (Exception e) {
			
			throw e;
		}
		
		return tipoelemento;
		
	}
	
	public TipoElemento buscarPorNombre(TipoElemento tipoele) throws Exception { 
		PreparedStatement stm= null;
		ResultSet rs= null;
		TipoElemento tipoelemento = null;
		
		
		try {
			stm = FactoryConnection.getinstancia().getConn().prepareStatement
					("SELECT * FROM tipoelemento WHERE nombre=?");
			stm.setString(1,tipoele.getNombre());
			rs=stm.executeQuery();
			if(rs!=null && rs.next()){
				tipoelemento=new TipoElemento();
				tipoelemento.setId(rs.getInt("id"));
				tipoelemento.setNombre(rs.getString("nombre"));
				tipoelemento.setCant_max_reservas(rs.getInt("cant_max_reservas"));
				}
		} catch (Exception e) {
			throw e;
		}
		
		try {
			if(rs!=null)rs.close();
			if(stm!=null)stm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}
		
		
		return tipoelemento;
	}
	
	public void agregarTipoElemento (TipoElemento tipoele) throws Exception
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"INSERT INTO tipoelemento(nombre,cant_max_reservas) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, tipoele.getNombre());
			pstm.setInt(2, tipoele.getCant_max_reservas());
			pstm.executeUpdate();
			rs=pstm.getGeneratedKeys();
			if(rs!=null && rs.next()){
				tipoele.setId(rs.getInt(1));
			}
		} catch (Exception e) {
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
	
	public void eliminarTipoElemento(TipoElemento tipoele) throws Exception
	{
		PreparedStatement pstm = null;
		
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"DELETE FROM tipoelemento WHERE id=?");
			pstm.setInt(1, tipoele.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}		
	}
	
	public void modificarTipoElemento(TipoElemento tipoele) throws Exception
	{
		PreparedStatement pstm = null;
		
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"UPDATE tipoelemento SET nombre=?,cant_max_reservas=? WHERE id=?");
			pstm.setInt(1, tipoele.getId());
			pstm.setString(2, tipoele.getNombre());
			pstm.setInt(3, tipoele.getCant_max_reservas());
			pstm.executeUpdate();
		} catch (Exception e) {
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

