
package deploy;

import entity.Role;
import entity.User;
import facades.UserFacade;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.ws.rs.core.Context;
import security.PasswordHash;

@WebListener
public class DeploymentConfiguration implements ServletContextListener
{

    public static String PU_NAME = "PU-Local";

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        Map<String, String> env = System.getenv();
        //If we are running in the OPENSHIFT environment change the pu-name 
        if (env.keySet().contains("OPENSHIFT_MYSQL_DB_HOST")) {
            PU_NAME = "PU_OPENSHIFT";
        }
        try {
            ServletContext context = sce.getServletContext();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
            EntityManager em = emf.createEntityManager();

            //This flag is set in Web.xml -- Make sure to disable for a REAL system
            boolean makeTestUsers = context.getInitParameter("makeTestUsers").toLowerCase().equals("true");
            if (!makeTestUsers
                    || (em.find(User.class, "user") != null && em.find(User.class, "admin") != null && em.find(User.class, "user_admin") != null)) {
                return;
            }
            Role userRole = new Role("User");
            Role adminRole = new Role("Admin");

            User user = new User("user", PasswordHash.createHash("test"), "user@sp.com", "Bob", "Angularowski");
            User admin = new User("admin", PasswordHash.createHash("test"), "admin@sp.com", "Boss", "Adminowski");

            user.AddRole(userRole);
            admin.AddRole(adminRole);

            try {
                em.getTransaction().begin();
                em.persist(userRole);
                em.persist(adminRole);

                em.persist(user);
                em.persist(admin);

                em.getTransaction().commit();
            } finally {
                em.close();
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(DeploymentConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }

}
