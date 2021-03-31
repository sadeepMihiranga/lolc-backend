package lk.sadeep.mms.lolc.entiry;

import javax.persistence.*;
import java.util.List;

@Entity(name = "UserRole")
@Table(name = "user_role")
public class UserRole
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "role",
            nullable = false
    )
    private String role;

    @Column(
            name = "role_description",
            columnDefinition = "TEXT"
    )
    private String roleDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole") // mappedBy should be camel case of Entity name
    private List<User> userList;

    public UserRole(){}

    public UserRole(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
