package no.hvl.dat109;



public class Stand {
	
	private String navn;
	private Integer totalscore;

	
	public Stand(String navn, Integer totalscore) {
		super();
		this.navn = navn;
		this.totalscore = totalscore;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public Integer getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(Integer totalscore) {
		this.totalscore = totalscore;
	}
	
	

}
