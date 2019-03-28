package no.hvl.dat109.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "JuryLoggInn", urlPatterns = "/JuryLoggInn")
public class JuryLoggInn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String pw;
       
	public void init() throws ServletException {
		pw = this.getInitParameter("pw");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("WEB-INF/LoggInnJury.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passord = request.getParameter("password");
		
		if (!passord.equals(pw)) {
			
			response.sendRedirect("JuryLoggInn");
			
		} else {
			
			HttpSession sesjon = request.getSession(false);
			
			if (sesjon != null) {
				sesjon.invalidate();
			}

			sesjon = request.getSession(true);
			
			sesjon.setMaxInactiveInterval(1000);
			
			sesjon.setAttribute("passord", passord);
			
			response.sendRedirect("Jury");
		}
	}

}
