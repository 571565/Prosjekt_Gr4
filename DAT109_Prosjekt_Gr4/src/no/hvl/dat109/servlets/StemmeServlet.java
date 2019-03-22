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

		HttpSession sesjon = request.getSession(false);

		if (sesjon != null) {

			Deltaker deltaker = (Deltaker) sesjon.getAttribute("deltaker");

			if (deltaker != null) {

				String tlfDeltaker = deltaker.getTlf();
				String standi = (String) sesjon.getAttribute("standid");
				Integer score = Integer.parseInt(request.getParameter("score"));

				stemme = new Stemme(tlfDeltaker, standi, score);
				System.out.println(stemme);
				sesjon.setAttribute("score", score);
				try {
					stemmeEAO.leggTilStemme(stemme);

					response.sendRedirect("StemmeBekreftelse");
					return;
				} catch (Exception e) {
					stemmeEAO.oppdaterStemme(stemme);

				}

			}

		}

		response.sendRedirect("LoggInn");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);

		if (sesjon != null) {
			Deltaker deltaker = (Deltaker) sesjon.getAttribute("deltaker");
			if (deltaker != null) {

				request.getRequestDispatcher("WEB-INF/Stemme.jsp").forward(request, response);

			}

		}

	}

}
