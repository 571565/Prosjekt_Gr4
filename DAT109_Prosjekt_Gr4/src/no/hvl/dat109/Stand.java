package no.hvl.dat109;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "DAT109_Prosjekt", name = "stand")
public class Stand {
	
	@Id
	private String navn;
	
	private Integer totalscore;
	
	public Stand() {
		
	}

	
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
