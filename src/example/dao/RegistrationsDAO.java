package example.dao;

import example.entities.Registrations;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RegistrationsDAO {

    private static EntityManager em;

    public RegistrationsDAO(EntityManager em) {
        this.em = em;
    }

    public boolean addRegistration(Registrations registration) {

        return SimpleDAO.simpleAdd(registration);
    }

    public boolean removeRegistrationsOfTopic(int id_topic) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.createQuery("DELETE from Registrations where id_topic = :id")
                    .setParameter("id", id_topic)
                    .executeUpdate();
            et.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }
}
