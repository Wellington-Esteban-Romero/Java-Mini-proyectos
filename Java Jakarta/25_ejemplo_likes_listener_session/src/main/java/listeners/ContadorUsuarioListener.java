package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ContadorUsuarioListener implements HttpSessionListener {


	public void sessionCreated(HttpSessionEvent se)  {

		int usuarios = (int) se.getSession().getServletContext().getAttribute("usuarios");

		se.getSession().getServletContext().setAttribute("usuarios",++usuarios);
	}

	public void sessionDestroyed(HttpSessionEvent se)  { 
		int usuarios = (int) se.getSession().getServletContext().getAttribute("usuarios");
		if (usuarios > 0) {
			se.getSession().getServletContext().setAttribute("usuarios",--usuarios);
		}
		
	}

}
