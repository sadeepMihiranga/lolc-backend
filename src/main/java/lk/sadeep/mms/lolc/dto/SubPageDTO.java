package lk.sadeep.mms.lolc.dto;

import lk.sadeep.mms.lolc.entiry.MainPage;

public class SubPageDTO
{
    private int id;
    private String pageName;
    private String pageLink;
    private MainPage mainPage;

    public SubPageDTO(){}

    public SubPageDTO(int id, String pageName, String pageLink) {
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

    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Override
    public String toString() {
        return "SubPageDTO{" +
                "id=" + id +
                ", pageName='" + pageName + '\'' +
                ", pageLink='" + pageLink + '\'' +
                ", mainPage=" + mainPage +
                '}';
    }
}
