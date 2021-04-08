package pe.upc.experimentos.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastpName;
    private String lastmName;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String firstName, String lastpName, String lastmName, String username, String password) {
        this.firstName = firstName;
        this.lastpName = lastpName;
        this.lastmName = lastmName;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastpName, String lastmName, String username, String password, Collection<Role> roles) {
    	   this.firstName = firstName;
           this.lastpName = lastpName;
           this.lastmName = lastmName;
           this.username = username;
           this.password = password;
           this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastpName() {
        return lastpName;
    }

    public void setLastpName(String lastpName) {
        this.lastpName = lastpName;
    }

    public String getLastmName() {
        return lastmName;
    }
    
    public void setLastmName(String lastmName) {
        this.lastmName = lastmName;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastpName='" + lastpName + '\'' +
                ", lastmName='" + lastmName + '\'' +
                ", username ='" + username  + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }
}

