package no.hvl.dat109.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.EAO.StemmeEAO;

/**
 * Servlet implementation class StemmeSide
 */
@WebServlet("/StemmeSide")
public class StemmeSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private StemmeEAO stemmeEAO;
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
        if (sesjon == null || sesjon.getAttribute("deltaker") == null) {
        	response.sendRedirect("LoggInn");
        } else {
        	request.setAttribute("stemme", stemmeEAO.hentStemmer((String) sesjon.getAttribute("tlf")));
        	request.setAttribute("tlf", sesjon.getAttribute("tlf"));
        	request.getRequestDispatcher("WEB-INF/StemmeSide.jsp").forward(request, response);
        }
	}
		
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		
		 if (sesjon == null || sesjon.getAttribute("deltaker") == null) {
			 response.sendRedirect("LoggInn");
		 } else {
			 request.getRequestDispatcher("WEB-INF/StemmeBekreftelse.jsp").forward(request, response);
		 }
		
		
		
	}

}
