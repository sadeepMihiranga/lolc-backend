package lk.sadeep.mms.lolc.entiry;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email"), // customize the unique constraint
                @UniqueConstraint(name = "user_username_unique", columnNames = "username")
        }
)
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable
{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1 // incrementing by 1
    ) // customize auto increment sequence for the id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    ) // use the customized sequence
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "username",
            nullable = false
    )
    private String username;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @Column(
            name = "full_name",
            columnDefinition = "TEXT"
    )
    private String fullName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "updated_by")
    private int updatedBy;

    @Column(
            name = "logging_attempts",
            nullable = false,
            columnDefinition = "integer default 0"
    )
    private int loggingAttempts;

    @Column(
            name = "active_status",
            nullable = false,
            insertable = false,
            columnDefinition = "integer default 1"
    )
    private int activeStatus;

    @Column(
            name = "email",
            nullable = false
            //unique = true /* inside table annotation already set the unique with custom id */
    )
    private String email;

    @JoinColumn(
            name = "user_role_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_user_user_role") // customized foreign key name
    )
    @ManyToOne(optional = false)
    private UserRole userRole;

    public User(){}

    public User(String username, String password, String fullName, String contactNumber, int createdBy, String email, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.createdBy = createdBy;
        this.email = email;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getLoggingAttempts() {
        return loggingAttempts;
    }

    public void setLoggingAttempts(int loggingAttempts) {
        this.loggingAttempts = loggingAttempts;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
