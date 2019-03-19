package no.hvl.dat109;

public class Vote {
	
	private Integer tlf;
	private Integer score;
	

	public Vote(Integer tlf, Integer score) {
		super();
		this.tlf = tlf;
		this.score = score;
	}
	
	
	public Integer getTlf() {
		return tlf;
	}
	public void setTlf(Integer tlf) {
		this.tlf = tlf;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

}
