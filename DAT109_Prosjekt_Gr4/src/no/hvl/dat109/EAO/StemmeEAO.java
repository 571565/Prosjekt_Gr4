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

	public List<Stemme> hentStemmer() {

		return (List<Stemme>) em.createQuery("SELECT s FROM stemme s").getResultList();
	}

	public List<Stemme> hentStemmeNr(String tlf) {
		return (List<Stemme>) em.createQuery("SELECT s FROM Stemme s WHERE s.deltaker LIKE :custStand")
				.setParameter("custStand", tlf).getResultList();
	}

	public void oppdaterStemme(Stemme stemme) {
		em.createQuery("UPDATE Stemme p SET p.score = :score WHERE p.deltaker = '" + stemme.getDeltaker() + "' AND p.stand ='" + stemme.getStand() + "'")
		.setParameter("score", stemme.getScore())
        .executeUpdate();
	}
}
