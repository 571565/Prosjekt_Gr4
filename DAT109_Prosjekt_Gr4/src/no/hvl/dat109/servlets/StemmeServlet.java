package no.hvl.dat109.servlets;

import java.io.IOException;
import java.net.HttpCookie;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.Deltaker;
import no.hvl.dat109.Stemme;
import no.hvl.dat109.StemmeOgStand;
import no.hvl.dat109.EAO.StemmeEAO;

@WebServlet("/Stemme")
public class StemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Stemme stemme;
	
	private String standid;

	@EJB
	private StemmeEAO stemmeEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		HttpSession sesjon = request.getSession(false);

		if (sesjon != null) {

			Deltaker deltaker = (Deltaker) sesjon.getAttribute("deltaker");

			if (deltaker != null) {
				
				String tlfDeltaker = deltaker.getTlf();
				String stand = (String) sesjon.getAttribute("standid");
				Integer score = Integer.parseInt(request.getParameter("score"));
				
				stemme = new Stemme(tlfDeltaker, stand, score);
				
				try {
				stemmeEAO.leggTilStemme(stemme);
				} catch (Exception e) {
					stemmeEAO.oppdaterStemme(stemme);
				}
				
				
				sesjon.setAttribute("score", score);
				
				response.sendRedirect("StemmeBekreftelse");
				return;

			}

		}

		response.sendRedirect("LoggInn");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("stemme", stemme);
		
		
		
		HttpSession sesjon = request.getSession(false);
	
		
		if (sesjon != null) {
			Deltaker deltaker = (Deltaker) sesjon.getAttribute("deltaker");
			if (deltaker != null) {
				
				request.getRequestDispatcher("WEB-INF/Stemme.jsp").forward(request, response);
				
				
			}
			
		} else {
			standid = request.getParameter("standid");
			
			if (standid == null || standid == "") {
				standid = "Hvl";
				
			}
			
			sesjon = request.getSession(true);
			
			sesjon.setAttribute("standid", standid);

			sesjon.setMaxInactiveInterval(1000);
			
			response.sendRedirect("LoggInn");
		}
		
		
		
		
	}

}
