package no.hvl.dat109.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.EAO.StandEAO;

/**
 * Servlet implementation class Jury
 */
@WebServlet("/Jury")
public class Jury extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private StandEAO standEAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		
		if (sesjon == null || sesjon.getAttribute("passord") == null) {
			response.sendRedirect("JuryLoggInn");
		} else {
			sesjon.setAttribute("stand", standEAO.hentStands());
			request.getRequestDispatcher("WEB-INF/JurySide.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
