package example.app.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Creates an instances of the entity manager factory when the application starts. 
 * @author Jonathon
 *
 */
@WebListener
public class EM implements ServletContextListener {

    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT = "esellerpro";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return emf.createEntityManager();
    }

}