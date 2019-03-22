package no.hvl.dat109;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(schema = "DAT109_Prosjekt", name = "stemme")
public class Stemme {
	
	@Id
	private String deltaker;
	
	@Id
	private String stand;
	
	private int score;
	
	public Stemme() {
		
	}
	
	
	public Stemme(String deltaker, String stand, Integer score) {
		super();
		this.deltaker = deltaker;
		this.stand = stand;
		this.score = score;
	}
	
	public Stemme(HttpServletRequest request) {
		this.deltaker = request.getParameter("deltaker");
		this.stand = request.getParameter("standid");
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


	@Override
	public String toString() {
		return "Stemme [deltaker=" + deltaker + ", stand=" + stand + ", score=" + score + "]";
	}
	
	

}
