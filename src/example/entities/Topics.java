package example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_topic;
    private String title;
    @Lob
    private String content;
    private Timestamp date;
    private int id_user;

    @ManyToOne
    @JoinColumn(name="id_user", insertable = false, updatable = false)
    private Users user;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    @OrderBy(value = "date ASC")
    private Set<Registrations> registrationsOfTopic = new HashSet<>();

    public int getId_topic() {
        return id_topic;
    }

    public void setId_topic(int id_topic) {
        this.id_topic = id_topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<Registrations> getRegistrationsOfTopic() {
        return registrationsOfTopic;
    }

    public void setRegistrationsOfTopic(Set<Registrations> registrationsOfTopic) {
        this.registrationsOfTopic = registrationsOfTopic;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "id_topic=" + id_topic +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", id_user=" + id_user +
                '}';
    }
}
