package htlinn;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@WebServlet(name = "homepage")
public class homepage extends HttpServlet {
    Random rand = new Random();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Values im Parameter sollte so ausschauen "+((String)request.getParameter("value")));
        response.setHeader("Set-Cookie", "HttpOnly;Secure;SameSite=Strict");
        Map<String,String> map = new HashMap<String,String>();
        map.put("portal", openPortal());
        flashOnPage(request,response, map);

    }

    private void flashOnPage(HttpServletRequest request, HttpServletResponse response, Map<String, String> map) throws IOException
    {
        response.setContentType("application/Json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));

    }


    private String openPortal() {
        String link = "https://www.google.com/maps/place/";
        Random rand = new Random();
        link = generateCoordinats(90,link);
        if(rand.nextBoolean()){
            link += 'N';
        }
        else {
            link += 'S';
        }
        link += "+";
        link = generateCoordinats(180,link);

        if(rand.nextBoolean()){
            link+= "E";
        }
        else{
            link += "W";
        }
        return link;
    }

    private String generateCoordinats(int maxdegrees,String link) {

        link += rand.nextInt(maxdegrees);
        link += "°";
        link += rand.nextInt(60);
        link += "'";
        link += rand.nextInt(60);
        link += "''";

        return link;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher =  request.getRequestDispatcher("homepage.html");
        dispatcher.forward(request,response);
    }
}
