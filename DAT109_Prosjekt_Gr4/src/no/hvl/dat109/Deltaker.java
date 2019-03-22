package no.hvl.dat109;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema = "DAT109_Prosjekt", name = "deltaker")
public class Deltaker {

	@Id
	private String tlf;
	
	public Deltaker() {
		
	}

	public Deltaker(HttpServletRequest request) {
		this.tlf = request.getParameter("tlf");
	}

	public Deltaker(String tlf) {
		this.tlf = tlf;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "Deltaker [tlf=" + tlf + "]";
	}
	
	

}
