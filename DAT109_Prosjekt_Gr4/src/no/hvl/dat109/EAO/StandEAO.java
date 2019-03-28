package no.hvl.dat109.EAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import no.hvl.dat109.Deltaker;
import no.hvl.dat109.Stand;


@Stateless
public class StandEAO {
    
	@PersistenceContext(name = "StandPU")
    private EntityManager em;

    public void leggTilStand(Stand s) {
        em.persist(s);
    }
    
    public Integer  hentTotalScore(String navn) {
    	return (Integer) em.createQuery("SELECT s.totalscore FROM Stand s WHERE s.navn = '" + navn + "'").getSingleResult();
    }

    public Stand hentStand(String navn) {
        return em.find(Stand.class, navn);
    }

    public List<Stand> hentStands() {
        
        return (List<Stand>) em.createQuery("SELECT s FROM Stand s").getResultList();
    }

	public void giNyttNavn(String gammeltNavn, String nyttNavn) {
		Stand stand = hentStand(gammeltNavn);
		Stand nyStand = new Stand(nyttNavn, stand.getTotalscore());
		leggTilStand(nyStand);
		em.remove(stand);
		
		
		
	}
}
