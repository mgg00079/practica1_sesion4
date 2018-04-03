package org.practica1.sesion4;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsuarioDaoJdbc implements UsuarioDaoInterface {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void creaTabla() {
		this.jdbcTemplate.execute("create table usuarios (nombre String, apellidos String, email String, telefono String, codigopostal String)");
	}
	
	public void insertaUsuario(Usuario usuario) {
		String sql = "insert into usuarios values (?, ?, ?, ?, ?)";
		Object[] parametros = {usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getTelefono(), usuario.getCp()};
		this.jdbcTemplate.update(sql, parametros);
	}
	
	public Usuario buscaUsuario(int id) { //Devuelve el usuario buscado o null si no existe.
		String sql = "select * from usuarios where id = ?";
		Object[] parametros = {id}; //Array de objetos.
		UsuarioMapper mapper = new UsuarioMapper();
		List<Usuario> usuarios = this.jdbcTemplate.query(sql,  parametros, mapper);
		if (usuarios.isEmpty()) return null;
		else return usuarios.get(0);
	}
	
	public List<Usuario> leeUsuarios(){
		String sql = "select * from usuarios";
		UsuarioMapper mapper = new UsuarioMapper();
		List<Usuario> usuarios = this.jdbcTemplate.query(sql, mapper);
		return usuarios;
	}
}
