package example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBConfig implements ServletContextListener {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(emf !=null && emf.isOpen()){
            emf.close();
        }
    }
}
