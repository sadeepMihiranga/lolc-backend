package lk.sadeep.mms.lolc.dto;

public class UserRoleDTO
{
    private int id;
    private String role;
    private String roleDescription;

    public UserRoleDTO(){}

    public UserRoleDTO(int id, String role, String roleDescription) {
        this.id = id;
        this.role = role;
        this.roleDescription = roleDescription;
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

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
