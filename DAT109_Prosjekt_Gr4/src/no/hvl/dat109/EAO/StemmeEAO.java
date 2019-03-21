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

import no.hvl.dat109.Stemme;


@Stateless
public class StemmeEAO {
    
	@PersistenceContext(name = "StemmePU")
    private EntityManager em;

    public void leggTilStemme(Stemme s) {
        em.persist(s);
    }

    public Stemme hentStemme(String mobil) {
        return em.find(Stemme.class, mobil);
    }

    public List<Stemme> hentBrukere() {
        
        return (List<Stemme>) em.createQuery("SELECT s FROM Bruker s").getResultList();
    }
}
