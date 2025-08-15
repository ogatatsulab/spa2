package spa2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( "/echo" )
public class EchoServlet extends HttpServlet {
  
  @Override
  protected void doPost( HttpServletRequest req, HttpServletResponse res )
    throws ServletException, IOException {
    
    String name = req.getParameter( "name" );
    req.setAttribute( "name", name );
    req.getRequestDispatcher( "/result.jsp" ).forward( req, res );
    return;
  }
  
  @Override
  protected void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    
    doPost( req, res );
    return;
  }

}
