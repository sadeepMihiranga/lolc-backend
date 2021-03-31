package lk.sadeep.mms.lolc.entiry;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Section")
@Table(
        name = "section",
        uniqueConstraints = {
                @UniqueConstraint(name = "section_name_unique", columnNames = "name") // customize the unique constraint
        }
)
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "capacity",
            nullable = false
    )
    private int capacity;

    @Column(
            name = "no_of_student",
            nullable = false
    )
    private int noOfStudent;

    @Column(
            name = "active_status",
            nullable = false,
            insertable = false,
            columnDefinition = "integer default 1"
    )
    private int activeStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
    private List<Student> students;

    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_course_section")
    )
    @ManyToOne(optional = false)
    private Course course;

    public Section() {
    }

}
