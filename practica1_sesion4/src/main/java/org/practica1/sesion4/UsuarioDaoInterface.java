package org.practica1.sesion4;

import java.util.List;

public interface UsuarioDaoInterface {
	public void creaTabla();
	public void insertaUsuario(Usuario usuario);
	public Usuario buscaUsuario(int id);
	public List<Usuario> leeUsuarios();
}
