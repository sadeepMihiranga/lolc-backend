package lk.sadeep.mms.lolc.entiry;


import javax.persistence.*;

@Entity(name = "SubPage")
@Table( name = "sub_page")
public class SubPage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "page_name",
            nullable = false
    )
    private String pageName;

    @Column(
            name = "page_link",
            nullable = false
    )
    private String pageLink;

    @JoinColumn(name = "mainPageId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MainPage mainPage;

    public SubPage() {
    }

    public SubPage(int id, String pageName, String pageLink) {
        this.id = id;
        this.pageName = pageName;
        this.pageLink = pageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }
}
