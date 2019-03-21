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

	private String standid = "Hvl";
	
	@EJB
	private DeltakerEAO deltakerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//standid = request.getParameter("standid");
		

		HttpSession sesjon = request.getSession(false);

		if (sesjon != null) {
			Deltaker deltaker = (Deltaker) sesjon.getAttribute("deltaker");

			if (deltaker != null) {
				sesjon.setAttribute("deltaker", deltaker);
				
				if (standid == "") {
				response.sendRedirect("StemmeSide");
				return;
				} else {
				response.sendRedirect("Stemme" + "?standid=" + standid);
				return;
				}
				
			}

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
				deltakerEAO.leggTilbruker(deltaker);
			}

			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);

			sesjon.setMaxInactiveInterval(1000);
			
			sesjon.setAttribute("tlf", tlf);

			sesjon.setAttribute("deltaker", deltaker);
			
			sesjon.setAttribute("standid", standid);
			
			response.sendRedirect("Stemme" + "?standid=" + standid);
		}

	}
}
