package lk.sadeep.mms.lolc.entiry;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Course")
@Table(
        name = "course",
        uniqueConstraints = {
                @UniqueConstraint(name = "course_name_unique", columnNames = "name") // customize the unique constraint
        }
)
public class Course
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
            name = "active_status",
            nullable = false,
            insertable = false,
            columnDefinition = "integer default 1"
    )
    private int activeStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Section> sections;

    public Course() {
    }
}
