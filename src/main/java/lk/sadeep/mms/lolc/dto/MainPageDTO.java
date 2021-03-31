package lk.sadeep.mms.lolc.dto;

import lk.sadeep.mms.lolc.entiry.SubPage;
import lk.sadeep.mms.lolc.entiry.UserRole;

import java.util.List;

public class MainPageDTO
{
    private int id;
    private String pageName;
    private String pageLink;
    private String pageIcon;
    private int activeStatus;
    private List<SubPageDTO> subPages;

    public MainPageDTO(){}

    public MainPageDTO(int id, String pageName, String pageLink, String pageIcon, int activeStatus) {
        this.id = id;
        this.pageName = pageName;
        this.pageLink = pageLink;
        this.pageIcon = pageIcon;
        this.activeStatus = activeStatus;
    }

    public MainPageDTO(int id, String pageName, String pageLink, String pageIcon, int activeStatus, List<SubPageDTO> subPages) {
        this.id = id;
        this.pageName = pageName;
        this.pageLink = pageLink;
        this.pageIcon = pageIcon;
        this.activeStatus = activeStatus;
        this.subPages = subPages;
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

    public List<SubPageDTO> getSubPages() {
        return subPages;
    }

    public void setSubPages(List<SubPageDTO> subPages) {
        this.subPages = subPages;
    }
}
