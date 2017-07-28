package datos;

import java.sql.*;
import java.util.ArrayList;
import entidades.*;
import java.security.KeyStore.ProtectionParameter;

public class DatosPersona 
{
	
	public ArrayList<Persona> buscarTodo()
	{
		Statement stm=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		
		try 
		{
			stm = FactoryConnection.getinstancia().getConn().createStatement();
			rs = stm.executeQuery("select id,dni,nombre,apellido,usuario,contrasena,habilitado,categoria from personas");
			if(rs!=null){
				while(rs.next()){
					Persona persona=new Persona();
					persona.setId(rs.getInt("id"));
					persona.setDni(rs.getString("dni"));
					persona.setNombre(rs.getString("nombre"));
					persona.setApellido(rs.getString("apellido"));
					persona.setUsuario(rs.getString("usuario"));
					persona.setContrasena(rs.getString("contrasena"));
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
					("SELECT * FROM personas WHERE dni=?");
			stm.setString(1,p.getDni());
			rs=stm.executeQuery();
			if(rs!=null && rs.next()){
				pers=new Persona();
				pers.setId(rs.getInt("id"));
				pers.setNombre(rs.getString("nombre"));
				pers.setApellido(rs.getString("apellido"));
				pers.setUsuario(rs.getString("usuario"));
				pers.setContrasena(rs.getString("contrasena"));
				pers.setDni(rs.getString("dni"));
				pers.setHabilitado(rs.getBoolean("habilitado"));
				pers.setCategoria(rs.getString("categoria"));
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
	
	public ArrayList<Persona> buscarPorNYA(Persona p)
	{
		PreparedStatement stm= null;
		ResultSet rs= null;
		ArrayList<Persona> personas = new ArrayList<>();
		Persona pers = new Persona();
		String nombre = p.getNombre();
		String apellido = p.getApellido();
				
		try {
			
			if (!(nombre.isEmpty()) && !(apellido.isEmpty())) {
				stm=FactoryConnection.getinstancia().getConn().prepareStatement
						("SELECT * FROM personas WHERE nombre=? AND apellido=?");
				stm.setString(1, nombre);
				stm.setString(2, apellido);
			}else 
				if (nombre.isEmpty()) 
				{
				stm=FactoryConnection.getinstancia().getConn().prepareStatement
						("SELECT * FROM personas WHERE apellido=?");
				stm.setString(1, apellido);
				}
				else 
				{
				stm=FactoryConnection.getinstancia().getConn().prepareStatement
						("SELECT * FROM personas WHERE nombre=?");
				stm.setString(1, nombre);
				}
			
			rs=stm.executeQuery();
			if(rs!=null && rs.next())
			{
				pers.setId(rs.getInt("id"));
				pers.setNombre(rs.getString("nombre"));
				pers.setApellido(rs.getString("apellido"));
				pers.setUsuario(rs.getString("usuario"));
				pers.setContrasena(rs.getString("contrasena"));
				pers.setDni(rs.getString("dni"));
				pers.setHabilitado(rs.getBoolean("habilitado"));
				pers.setCategoria(rs.getString("categoria"));
				personas.add(pers);
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
		
		return personas;
	}
	
	public void agregarPersona (Persona pers)
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"INSERT INTO personas(dni,nombre,apellido,usuario,contrasena,habilitado,categoria) VALUES (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, pers.getDni());
			pstm.setString(2, pers.getNombre());
			pstm.setString(3, pers.getApellido());
			pstm.setString(4, pers.getUsuario());
			pstm.setString(5, pers.getContrasena());
			pstm.setBoolean(6, pers.isHabilitado());
			pstm.setString(7, pers.getCategoria());
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
	
	public void eliminarPersona(Persona perselimina)
	{
		PreparedStatement pstm = null;
		
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"DELETE FROM personas WHERE id=?");
			pstm.setInt(1, perselimina.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void modificarPersona(Persona persmodifica)
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = FactoryConnection.getinstancia().getConn().prepareStatement(
					"UPDATE personas SET dni=?, nombre=?,apellido=?,usuario=?,contrasena=?,categoria=?,dni=?,habilitado=? WHERE id=?");
			pstm.setInt(1, persmodifica.getId());
			pstm.setString(2, persmodifica.getNombre());
			pstm.setString(3, persmodifica.getApellido());
			pstm.setString(4, persmodifica.getUsuario());
			pstm.setString(5, persmodifica.getContrasena());
			pstm.setString(6, persmodifica.getCategoria());
			pstm.setString(7, persmodifica.getDni());
			pstm.setBoolean(8, persmodifica.isHabilitado());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConnection.getinstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	
}

