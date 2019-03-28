package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.Deltaker;
import no.hvl.dat109.Stand;
import no.hvl.dat109.EAO.StandEAO;

@WebServlet("/LoggInnStand")
public class LoggInnStand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String standedit;

	@EJB
	private StandEAO standEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);

		if (sesjon != null && sesjon.getAttribute("deltaker") != null) {
			standedit = (String) sesjon.getAttribute("standedit");
			response.sendRedirect("StandSide");
			return;
		} else {
			standedit = "UiB";
		}

		request.setAttribute("stands", standEAO.hentStands());

		request.getRequestDispatcher("WEB-INF/StandLoggInn.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String passord = request.getParameter("passord");
		standedit = request.getParameter("standedit");

		if (passord == "") {
			response.sendRedirect("LoggInnStand");
			return;

		} else {

			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setAttribute("standedit", standedit);

			response.sendRedirect("StandSide" + "?standedit=" + standedit);
		}

	}

}
