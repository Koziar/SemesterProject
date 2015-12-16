/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import entity.Url;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import net.minidev.json.JSONObject;

/**
 *
 * @author Cookie
 */
public class UrlFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
    private EntityManager em = emf.createEntityManager();

    public Url addUrlToDB(Url u) {
        List<Url> url = new ArrayList<>();
        Url u1 = new Url("Angular Airline", "Test Airline for Sprint 1", "http://angularairline-plaul.rhcloud.com/");
        Url u2 = new Url("Angular Airline2", "Test Airline for Sprint 2", "http://www.developerscrappad.com/228/java/java-ee/ejb3-jpa-dealing-with-date-time-and-timestamp/");
        url.add(u1);
        url.add(u2);
        try {
            em.getTransaction().begin();
            for (Url url1 : url) {
                em.persist(url1);
            }

//            em.persist(u);
            em.getTransaction().commit();
            return u;
        } finally {
//            em.close();
        }

    }

    public List<Url> getUrls() {
        Query query = em.createQuery("SELECT u FROM Url u", Url.class);
        return query.getResultList();
    }
//    public static void main(String[] args) {
//        Url u1 = new Url("hhhh", "jjjjjj", "kkkkkkkk");
//        UrlFacade u = new UrlFacade();
//        u.addUrlToDB(new Url("Angular Airline", "Test Airline for Sprint 1", "http://angularairline-plaul.rhcloud.com/"));
//        String j1 = getJSONFromPerson(u1);
//        System.out.println();
//    }

//    private static String readUrl(String urlString) throws Exception {
//        BufferedReader reader = null;
//        try {
//            URL url = new URL(urlString);
//            reader = new BufferedReader(new InputStreamReader(url.openStream()));
//            StringBuffer buffer = new StringBuffer();
//            int read;
//            char[] chars = new char[1024];
//            while ((read = reader.read(chars)) != -1) {
//                buffer.append(chars, 0, read);
//            }
//
//            return buffer.toString();
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
//    }
    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
//

//    public static void main(String[] args) {
//        UrlFacade uf = new UrlFacade();
//        uf.addUrlToDB(new Url("Angular Airline", "Test Airline for Sprint 1", "http://angularairline-plaul.rhcloud.com/"));
//
//        uf.getUrls();
//        System.out.println(uf.getUrls());
//    }
}
