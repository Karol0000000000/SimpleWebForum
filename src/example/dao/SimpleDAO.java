package example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SimpleDAO {

    private static EntityManager em;

    public SimpleDAO(EntityManager em){
        this.em = em;
    }

    public static <T> boolean simpleAdd( T objectOfTClassToAdd){

        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            em.persist(objectOfTClassToAdd);
            et.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }
}
