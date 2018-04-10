package org.practica1.sesion4;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioDaoInterface {
	public void creaTabla();
	public void insertaUsuario(Usuario usuario);
	public ArrayList<Usuario> buscaUsuario(ArrayList<Usuario> usuarios);
	public List<Usuario> leeUsuarios();
}
