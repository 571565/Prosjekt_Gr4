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


@Stateless
public class DeltakerEAO {
    
	@PersistenceContext(name = "DeltakerPU")
    private EntityManager em;

    public void leggTilbruker(Deltaker s) {
        em.persist(s);
    }

    public Deltaker hentBruker(Integer tlf) {
        return em.find(Deltaker.class, tlf);
    }

    public List<Deltaker> hentBrukere() {
        
        return (List<Deltaker>) em.createQuery("SELECT s FROM Bruker s").getResultList();
    }
}
