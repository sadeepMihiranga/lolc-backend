package lk.sadeep.mms.lolc.entiry;

import javax.persistence.*;

@Entity(name = "Programme")
@Table(
        name = "programme",
        uniqueConstraints = {
                @UniqueConstraint(name = "programme_name_unique", columnNames = "name") // customize the unique constraint
        }
)
public class Programme
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
            name = "no_of_cources",
            nullable = false
    )
    private int noOfCources;

    @Column(
            name = "active_status",
            nullable = false,
            insertable = false,
            columnDefinition = "integer default 1"
    )
    private int activeStatus;

    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_student_programme")
    )
    @ManyToOne(optional = false)
    private Student student;

    public Programme() {
    }
}
