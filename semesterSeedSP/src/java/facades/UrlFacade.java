/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Url;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;



/**
 *
 * @author Cookie
 */
public class UrlFacade {

    private EntityManagerFactory emf;

    public UrlFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Url addUrlToDB(Url u) {

        EntityManager em = emf.createEntityManager();

        u = new Url("Angular Airline", "Test Airline for Sprint 1", "http://angularairline-plaul.rhcloud.com/");

        try {
            em.getTransaction().begin();
//        for (Url url : urls) {
//            em.persist(url);
//        }
            em.persist(u);
            em.getTransaction().commit();
            return u;
        } finally {
            em.close();
        }
    }

    public List<Url> getUrls() {

//        EntityManager em = emf.createEntityManager();
//
//        Query query = em.createQuery("SELECT u FROM Url u", Url.class
//        );
//
//        List<Url> airlines = query.getResultList();
//        return query.getResultList();
        
        //Temporary added airlines
        List<Url> testFlight = new ArrayList();
        testFlight.add(new Url("test", "", "http://angularairline-plaul.rhcloud.com/api"));
        testFlight.add(new Url("outsourcing", "", "http://sargardon-001-site1.atempurl.com/api"));
        
        return testFlight;
    }
}
