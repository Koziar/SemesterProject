package facades;

import entity.Url;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class UrlFacade {

    private EntityManagerFactory emf;

    public UrlFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Url> getUrls() {

        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Url u", Url.class);
        List<Url> airlines = query.getResultList();
        return query.getResultList();
    }
}
