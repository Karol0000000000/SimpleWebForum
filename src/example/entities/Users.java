package example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String login;
    private String password;
    private int id_role;
    private Timestamp date;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Topics> userTopics = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Registrations> userRegistrations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_role", insertable = false, updatable = false)
    private Roles role;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id) {
        this.id_user = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public Set<Topics> getUserTopics() {
        return userTopics;
    }

    public void setUserTopics(Set<Topics> userTopics) {
        this.userTopics = userTopics;
    }

    public Set<Registrations> getUserRegistrations() {
        return userRegistrations;
    }

    public void setUserRegistrations(Set<Registrations> userRegistrations) {
        this.userRegistrations = userRegistrations;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_user +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id_role=" + id_role +
                ", date=" + date +
                '}';
    }
}
