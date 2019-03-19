package no.hvl.dat109;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema = "scriptDB", name = "Deltaker")
public class Deltaker {

	@Id
	private Integer tlf;

	public Deltaker(HttpServletRequest request) {
		this.tlf = Integer.parseInt(request.getParameter("tlf"));
	}

	public Deltaker(Integer tlf) {
		super();
		this.tlf = tlf;
	}

	public Integer getTlf() {
		return tlf;
	}

	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}

}
