package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AgregarProductoListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
    	session.setAttribute("productos", new ArrayList<>());
    }
}
