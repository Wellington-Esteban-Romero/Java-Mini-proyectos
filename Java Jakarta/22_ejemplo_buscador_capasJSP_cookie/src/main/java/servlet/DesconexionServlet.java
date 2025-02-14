package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DesconexionServlet")
public class DesconexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie("fecha", "");
		c.setMaxAge(0);
		response.addCookie(c);
		req.getSession().invalidate();
		req.getRequestDispatcher("login.jsp").forward(req, response);
	}

}
