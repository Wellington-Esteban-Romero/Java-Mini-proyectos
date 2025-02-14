package locator;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionLocator {

	private static String ref = "java:comp/env/reflibreria";

	public static Connection getConnection () throws SQLException {

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(ref);
			return ds.getConnection();
		} catch (SQLException| NamingException e) {
			e.printStackTrace();
			throw new SQLException();
		}
	}
}