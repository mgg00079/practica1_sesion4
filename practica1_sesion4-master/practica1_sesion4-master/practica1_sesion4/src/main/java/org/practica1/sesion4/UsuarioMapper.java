package org.practica1.sesion4;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.practica1.sesion4.DtoUsuario;

public class UsuarioMapper implements RowMapper<DtoUsuario> {
	public DtoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		DtoUsuario u = new DtoUsuario();
		
		u.setNombre(rs.getString("Nombre"));
		u.setApellidos(rs.getString("Apellidos"));
		u.setEmail(rs.getString("Email"));
		u.setContrase�a(rs.getString("Contrase�a"));
		u.setTelefono(rs.getString("Telefono"));
		u.setCp(rs.getString("Codigo Postal"));
		u.setAdmin(rs.getBoolean("Admin"));
		
		return u;
	}
}
