package no.hvl.dat109;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema = "scriptDB", name = "Deltaker")
public class Deltaker {

	@Id
	private String tlf;

	public Deltaker(HttpServletRequest request) {
		this.tlf = request.getParameter("tlf");
	}

	public Deltaker(String tlf) {
		super();
		this.tlf = tlf;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

}
