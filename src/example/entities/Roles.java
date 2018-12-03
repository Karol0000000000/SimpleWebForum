package example.entities;

import javax.persistence.*;
import java.awt.desktop.UserSessionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Users> usersWithThisRole = new ArrayList<>();

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsersWithThisRole() {
        return usersWithThisRole;
    }

    public void setUsersWithThisRole(List<Users> usersWithThisRole) {
        this.usersWithThisRole = usersWithThisRole;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id_role=" + id_role +
                ", name='" + name + '\'' +
                '}';
    }
}
