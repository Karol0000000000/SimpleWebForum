package example.dao;

import example.entities.Users;
import example.utils.SimpleUtils;
import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;

public class UsersDAO {

    private EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public Users getAfterLogin(String login){

        return em.createQuery("select u from Users u where login = :login",Users.class)
                .setParameter("login",login)
                .getSingleResult();
    }

    public boolean addUser(Users user){

        //user.setPassword(SimpleUtils.getMD5(user.getPassword()));
        user.setId_role(1);
        user.setDate(new Timestamp(new Date().getTime()));

        return SimpleDAO.simpleAdd(user);
    }


}
