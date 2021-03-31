package lk.sadeep.mms.lolc.entiry;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email") // customize the unique constraint
        }
)
@EntityListeners(AuditingEntityListener.class)
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @Column(name = "home_no")
    private String homeNo;

    @Column(name = "street_mNo")
    private String streetNo;

    @Column(name = "city")
    private String city;

    @Column(
            name = "active_status",
            nullable = false,
            insertable = false,
            columnDefinition = "integer default 1"
    )
    private int activeStatus;

    @JoinColumn(
            name = "section_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_section_student") // customized foreign key name
    )
    @ManyToOne(optional = false)
    private Section section;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Programme> programmes;

    public Student(){}
}
