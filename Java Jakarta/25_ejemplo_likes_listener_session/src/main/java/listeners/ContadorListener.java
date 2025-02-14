package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
	
@WebListener
public class ContadorListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context =  sce.getServletContext();
    	context.setAttribute("contador", 0);
    	context.setAttribute("usuarios", 0);
    }
	
}
