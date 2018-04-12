package org.practica1.sesion4;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import pack.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UsuarioDaoInterface dao;

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		List<DtoUsuario> nombreusuarios = new ArrayList<DtoUsuario>;
		nombreusuarios=dao.NombreUsuario(user);
		model.addAttribute("listaUsuarios", nombreusuarios);

		if (user.equals("servicios") && pass.equals("servicios")) return "listausuarios";
		else return sesion(model, request);
			
	}
	
	
	

	
/*@RequestMapping(value = "/ListaUsuarios", method = RequestMethod.POST)
	
		public void listausuarios(Model model) { //Si hago los return en buscausuario, aquí sería void, puesto que no devuelvo nada??
		
		//String login = request.getParameter("name");
		//String password = request.getParameter("pass");
			
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario> ();
			
			Usuario user1 = new Usuario ("Manuel","Casquel Orzaes", "maco0007@ujaen.es", "123456789", "23005");
			Usuario user2 = new Usuario ("Marta","Gonzalez Gonzalez","mgg00079@ujaen.es", "789456123", "23006");
			
			usuarios.add(user1);
			usuarios.add(user2);
	
			usuarios=dao.buscaUsuario(usuarios); //En UsuarioDaoJdbc implemento la parte donde comprueba el login.
			//return "home"; //Aquí no sabía qué poner, porque los returns según el login están en buscausuario (tampoco sé si está bien).
		}
*/
			
	
	
	@RequestMapping(value = "/Sesion", method = RequestMethod.POST)
	public String sesion(Model model, HttpServletRequest request) {
		
		String nom = null;
		String ape = null;
		String ema = null;
		String tel = null;
		String cod = null;

		HttpSession session = request.getSession(true); //En caso de que no exista la sesion, la crea.
		session.setMaxInactiveInterval(60); //El valor es en segundos.
		
		
		nom=request.getParameter("nombre");
		ape=request.getParameter("apellidos");
		ema=request.getParameter("useremail");
		tel=request.getParameter("telefono");
		cod=request.getParameter("codpost");
		
		DtoUsuario usuario = (DtoUsuario)session.getAttribute("usuario");
		
		
		if (usuario == null) {
			if(nom == null && ape == null && ema == null && tel == null && cod == null) {
				return "registrosesion";
			}
			else {
				
				DtoUsuario user = new DtoUsuario(nom, ape, ema, tel, cod);
				request.setAttribute("usuario", user);
				session.setAttribute("usuario", user);
				return "usuarioregistrado";
			}
		}
		else {
			return "usuarioregistrado";
		}
	}
}