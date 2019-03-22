package no.hvl.dat109.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.Deltaker;
import no.hvl.dat109.EAO.DeltakerEAO;

@WebServlet("/LoggInn")
public class LoggInn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String standid;
	
	@EJB
	DeltakerEAO deltakerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		

		HttpSession sesjon = request.getSession(false);
		
		if (sesjon != null) {
			standid = (String) sesjon.getAttribute("standid");
		} else {
			response.sendRedirect("Stemme");
			return;
		}

		
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tlf = request.getParameter("tlf");
		
		

		if (tlf == "") {
			response.sendRedirect("LoggInn");
			return;

		} else {
			
			Deltaker deltaker = deltakerEAO.hentBruker(tlf);
			
			if (deltaker == null) {
				deltaker = new Deltaker(tlf);
			}

			
			HttpSession sesjon = request.getSession(true);
			
			
			sesjon.setMaxInactiveInterval(1000);
			
<<<<<<< HEAD
=======
			
			sesjon.setAttribute("tlf", tlf);
		
>>>>>>> origin/Kjetil
			sesjon.setAttribute("deltaker", deltaker);

			sesjon.setAttribute("tlf", tlf);
			
			sesjon.setAttribute("standid", standid);
			
			response.sendRedirect("Stemme" + "?standid=" + standid);
		}

	}
}
