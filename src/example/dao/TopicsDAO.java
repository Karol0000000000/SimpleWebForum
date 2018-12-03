package example.dao;

import example.entities.Topics;
import example.entities.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicsDAO {

    private EntityManager em;

    public TopicsDAO(EntityManager emf){
        this.em = emf;
    }

    public List<Topics> getAllTopics(){
        return em.createQuery("select t from Topics t",Topics.class).getResultList();
    }

    public Topics getTopic(int id) {
        return em.find(Topics.class,id);
    }

    public boolean addTopic(Topics topic){

        return SimpleDAO.simpleAdd(topic);
    }

    public boolean removeTopic(int id_topic){

        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            em.createQuery("delete from Topics where id_topic = :id")
                    .setParameter("id",id_topic)
                    .executeUpdate();
            et.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            et.rollback();
            return false;
        }
    }
}
