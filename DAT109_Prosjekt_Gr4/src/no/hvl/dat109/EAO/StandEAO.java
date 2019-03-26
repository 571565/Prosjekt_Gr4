package no.hvl.dat109.EAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.Stand;
import no.hvl.dat109.Stemme;

@Stateless
public class StandEAO {
	
	@PersistenceContext(name = "StandPU")
    private EntityManager em;

    public void leggTilStand(Stand s) {
        em.persist(s);
    }
    
    public void oppdaterStand(Stemme s) {
    	em.createQuery("UPDATE Stand p SET p.totalscore = p.totalscore + :score WHERE p.navn LIKE :standNavn")
    			.setParameter("score", s.getScore())
    			.setParameter("standNavn", s.getStand())
    	        .executeUpdate();
    }

    public Stemme finnStand(String s) {
    	return em.find(Stemme.class, s);
    }

    public List<Stemme> hentStand(String stand) {
        
        return (List<Stemme>) em.createQuery("SELECT s FROM Stand s WHERE s.navn LIKE :custStand")
        		.setParameter("custStand", stand)
        		.getResultList();
    }

}
