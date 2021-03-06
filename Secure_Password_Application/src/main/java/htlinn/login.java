package htlinn;

import com.sun.javafx.css.CssError;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();


        if(DBManager.getDBM().checkUser(username, password)){
            try {
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                response.sendRedirect("homepage");
            }catch (IOException e){
                System.out.println(e);
            }
        }
        else{
            RequestDispatcher d = request.getRequestDispatcher("login.html");
            d.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.forward(request,response);

    }
}
