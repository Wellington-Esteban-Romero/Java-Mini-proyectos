package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final String url = "jdbc:mysql://localhost:3306/agenda";

	final String usuario = "root";

	final String contra = "";

	final String driver = "com.mysql.cj.jdbc.Driver";

	{
		try {
			Class.forName(driver);
			DriverManager.getConnection(url, usuario, contra);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(
				Connection conn = DriverManager.getConnection(url,usuario,contra);
				Statement st = conn.createStatement()
				) {
			String query = "insert into contactos (nombre,email,numero) values('servlet','servlet@ejemplo.com','123456789')";
			st.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
