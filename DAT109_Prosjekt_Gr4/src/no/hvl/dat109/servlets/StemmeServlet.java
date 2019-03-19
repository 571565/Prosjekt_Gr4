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
import no.hvl.dat109.EAO.StemmeEAO;

@WebServlet("/Stemme")
public class StemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Stemme stemme;

	@EJB
	private StemmeEAO stemmeEAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession();

		if (sesjon != null) {

			Deltaker deltaker = (Deltaker) sesjon.getAttribute("deltaker");

			if (deltaker != null) {

				stemme = new Stemme(request);

				stemmeEAO.leggTilStemme(stemme);

				response.sendRedirect("StemmeSide");
				return;

			}

		}

		response.sendRedirect("LoggInn");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("stemme", stemme);

		request.getRequestDispatcher("WEB-INF/stemme.jsp").forward(request, response);
	}

}
