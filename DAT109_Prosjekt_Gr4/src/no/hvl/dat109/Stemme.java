package no.hvl.dat109;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema = "scriptDB", name = "stemme")
public class Stemme {
	
	private String deltaker;
	private String stand;
	private Integer score;
	
	
	public Stemme(String deltaker, String stand, Integer score) {
		super();
		this.deltaker = deltaker;
		this.stand = stand;
		this.score = score;
	}
	
	public Stemme(HttpServletRequest request) {
		this.deltaker = request.getParameter("deltakerid");
		this.stand = request.getParameter("stand");
		this.score = Integer.parseInt(request.getParameter("score"));
	}
	


	public String getDeltaker() {
		return deltaker;
	}

	public void setDeltaker(String deltaker) {
		this.deltaker = deltaker;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

}
