package htlinn;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class Listener_DBcreated_and_contextfinished
 *
 */
@WebListener
public class Listener_DBcreated_and_contextfinished implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener_DBcreated_and_contextfinished() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         
    	//Class.forName(config.getInitParameter("DBDRIVER"));
    	/*
    	ServletContext ctx = arg0.getServletContext();
    	
    	String dbr= ctx.getInitParameter("DBDRIVER");
    	String pth = ctx.getInitParameter("DBPATH");
    	String us = ctx.getInitParameter("DBUSER");
    	String pas = ctx.getInitParameter("DBPASSWORD");
    	
    	DBManager.getDBM().Initialize(dbr, pth, us, pas);
    	*/
    	//create database connection from init parameters and 
    	//https://coderanch.com/t/493245/java/parameter-web-xml-file
    	
    	
    	try{
    		Context initContext = new InitialContext();
    		Context envContext = (Context)initContext.lookup("java:/comp/env");
    		DataSource dataSource = (DataSource)envContext.lookup("jdbc/dbExample");
	    	DBManager m = new DBManager().getDBM();
	    	m.Initialize(dataSource);
    	}catch(Exception e){e.printStackTrace();}
    }
	
}
