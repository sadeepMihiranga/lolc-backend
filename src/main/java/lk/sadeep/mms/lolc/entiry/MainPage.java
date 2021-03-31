package lk.sadeep.mms.lolc.entiry;

import org.apache.catalina.User;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity(name = "MainPage")
@Table( name = "main_page")
public class MainPage
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

    @Column(
            name = "page_icon",
            nullable = false
    )
    private String pageIcon;

    @Column(
            name = "active_status",
            nullable = false,
            insertable = false,
            columnDefinition = "integer default 1"
    )
    private int activeStatus;

    @Column(
            name = "user_role_id",
            nullable = false
    )
    private int userRoleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainPage")
    private List<SubPage> subPages;

    public MainPage() {
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

    public String getPageIcon() {
        return pageIcon;
    }

    public void setPageIcon(String pageIcon) {
        this.pageIcon = pageIcon;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public List<SubPage> getSubPages() {
        return subPages;
    }

    public void setSubPages(List<SubPage> subPages) {
        this.subPages = subPages;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
}
