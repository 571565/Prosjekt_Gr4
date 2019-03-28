package no.hvl.dat109.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.Stand;
import no.hvl.dat109.EAO.StandEAO;


@WebServlet("/StandSide")
public class StandSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private StandEAO standEAO;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
        if (sesjon == null || sesjon.getAttribute("standedit") == null) {
        	response.sendRedirect("LoggInnStand");
        } else {
        	String standnavn = (String) sesjon.getAttribute("standedit");
        	request.setAttribute("navn", standnavn);
        	Integer totalscore = standEAO.hentTotalScore(standnavn);
        	request.setAttribute("totalscore", totalscore);
        	System.out.println(standnavn);
        	
        	request.getRequestDispatcher("WEB-INF/StandSide.jsp").forward(request, response);
        	
        	
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String navn = (String) request.getParameter("standnavn");
		
		if(navn == "") {
			doGet(request, response);
		}else {
			HttpSession sesjon = request.getSession(false);
			
			String gammeltNavn = (String) sesjon.getAttribute("standedit");
			String nyttNavn = request.getParameter("standnavn");
			System.out.println(gammeltNavn);
			System.out.println(nyttNavn);
			
			

			
			standEAO.giNyttNavn(gammeltNavn, nyttNavn);
			
			
			
			
			sesjon.setAttribute("standedit", nyttNavn);
			response.sendRedirect("StandSide" + "?standedit=" + nyttNavn);
			
			
			
		}
		
	}

}
