package org.practica1.sesion4;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UsuarioMapper implements RowMapper <Usuario> {
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
		Usuario usuario = new Usuario();
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setTelefono(rs.getString("telefono"));
		usuario.setEmail(rs.getString("email"));
		usuario.setCp(rs.getString("cp"));
		
		return usuario;
	}
}
