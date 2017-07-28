package datos;

import java.sql.*;
import java.util.ArrayList;
import entidades.*;
import java.security.KeyStore.ProtectionParameter;

public class DatosElemento 
{
	
	public ArrayList<Persona> buscarTodo()
	{
		Statement stm=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		
		try 
		{
			stm = FactoryConnection.getinstancia().getConn().createStatement();
			rs = stm.executeQuery("select * from persona");
			if(rs!=null){
				while(rs.next()){
					Persona persona=new Persona();
					persona.setId(rs.getInt("id"));
					persona.setDni(rs.getString("dni"));
					persona.setNombre(rs.getString("nombre"));
					persona.setApellido(rs.getString("apellido"));
					persona.setUsuario(rs.getString("usuario"));
					persona.setHabilitado(rs.getBoolean("habilitado"));
					persona.setCategoria(rs.getString("categoria"));
					pers.add(persona);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		try {
			if(rs!=null) rs.close();
			if(stm!=null) stm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pers;
		
	}
	
	public Persona buscarPorDni(Persona p){ 
		PreparedStatement stm= null;
		ResultSet rs= null;
		Persona pers = null;
		
		
		try {
			stm = FactoryConnection.getinstancia().getConn().prepareStatement
					("SELECT id,nombre,apellido,dni,habilitado FROM personas WHERE dni=?");
			stm.setString(1,p.getDni());
			rs=stm.executeQuery();
			if(rs!=null && rs.next()){
				pers=new Persona();
				pers.setId(rs.getInt("id"));
				pers.setNombre(rs.getString("nombre"));
				pers.setApellido(rs.getString("apellido"));
				pers.setDni(rs.getString("dni"));
				pers.setHabilitado(rs.getBoolean("habilitado"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stm!=null)stm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return pers;
	}
	
	public void agregarPersona (Persona pers)
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"INSERT INTO personas(dni,nombre,apellido,habilitado,categoria) VALUES (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, pers.getDni());
			pstm.setString(2, pers.getNombre());
			pstm.setString(3, pers.getApellido());
			pstm.setBoolean(4, pers.isHabilitado());
			pstm.setString(5, pers.getCategoria());
			pstm.executeUpdate();
			rs=pstm.getGeneratedKeys();
			if(rs!=null && rs.next()){
				pers.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

