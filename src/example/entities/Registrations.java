package example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "registrations")
public class Registrations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_registration;
    @Lob
    private String content;
    private Timestamp date;
    private int id_topic;
    private int id_user;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "id_topic", insertable = false, updatable = false)
    private Topics topic;

    public int getId_registration() {
        return id_registration;
    }

    public void setId_registration(int id_registration) {
        this.id_registration = id_registration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId_topic() {
        return id_topic;
    }

    public void setId_topic(int id_topic) {
        this.id_topic = id_topic;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }
}
