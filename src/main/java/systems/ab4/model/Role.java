package systems.ab4.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/17/2017.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;

    @OneToMany
    private List<User> users;

    public Role() {
        users = new ArrayList<>();
    }

    public Role(String roleName) {
        this();
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
