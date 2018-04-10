package org.practica1.sesion4;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoJdbc implements UsuarioDaoInterface {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String buscaUsuario(String login, String password) { //Comprueba si el usuario es admin, si no lo es, redirecciona al registro.
		
		String sql = "select * from usuarios where id = ?";
		//Object[] parametros = {id}; //Array de objetos.
		UsuarioMapper mapper = new UsuarioMapper();
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, mapper);
		
		if (login.equals("servicios") && password.equals("servicios")) return "listausuarios";
		else return "registrosesion";
		
	}
	
	public void creaTabla() {
		this.jdbcTemplate.execute("create table usuarios (nombre String, apellidos String, email String, telefono String, codigopostal String)");
	}
	
	public void insertaUsuario(Usuario usuario) {
		String sql = "insert into usuarios values (?, ?, ?, ?, ?)";
		Object[] parametros = {usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getTelefono(), usuario.getCp()};
		this.jdbcTemplate.update(sql, parametros);
	}
	
	
	public List<Usuario> leeUsuarios(){
		String sql = "select * from usuarios";
		UsuarioMapper mapper = new UsuarioMapper();
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, mapper);
		return usuarios;
	}


}
