package spa2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( "/api/echo" )
public class EchoServletSpa extends HttpServlet {
  
  @Override
  protected void doPost( HttpServletRequest req, HttpServletResponse res )
    throws ServletException, IOException {
    
    req.setCharacterEncoding( "UTF-8" );
    String name = req.getParameter( "name" );
    String message = "こんにちは、" + ( name == null ? "" : name ) + "さん！";
    
    res.setCharacterEncoding( "UTF-8" );
    res.setContentType( "application/json;charaset=UTF-8" );
    res.getWriter().write( "{\"message\":\"" + jsonEscape( message ) + "\"}" );
    return;
  }
  
  private String jsonEscape( String s ) {
    if ( s == null ) return "";
    return s.replace( "\\", "\\\\" )
      .replace( "\"", "\\\"" )
      .replace( "\n", "\\n" )
      .replace( "\r", "\\r" );
  }
  
  @Override
  protected void doGet( HttpServletRequest req, HttpServletResponse res )
    throws ServletException, IOException {
    doPost( req, res );
    return;
  }

}
