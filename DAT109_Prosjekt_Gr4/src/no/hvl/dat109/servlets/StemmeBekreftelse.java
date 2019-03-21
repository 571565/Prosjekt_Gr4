package no.hvl.dat109.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StemmeBekreftelse
 */
@WebServlet("/StemmeBekreftelse")
public class StemmeBekreftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
        if (sesjon == null || sesjon.getAttribute("deltaker") == null) {
        	response.sendRedirect("LoggInn");
        } else {
        	request.setAttribute("standid", sesjon.getAttribute("standid"));
        	request.setAttribute("score", sesjon.getAttribute("score"));
        	request.getRequestDispatcher("WEB-INF/StemmeSide.jsp").forward(request, response);
        }
	}
		


}
