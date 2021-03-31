package lk.sadeep.mms.lolc.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDTO
{
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String contactNumber;
    private int createdBy;
    private String createdDate;
    private int updatedBy;
    private String updatedDate;
    private int loggingAttempts;
    private int activeStatus;
    private String email;
    private UserRoleDTO userRoleDTO;

    public UserDTO() {
    }

    public UserDTO(int id, String username, String password, String fullName, String contactNumber, int createdBy, String createdDate,
                   int updatedBy, String updatedDate, int loggingAttempts, int activeStatus, String email, UserRoleDTO userRoleDTO) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.loggingAttempts = loggingAttempts;
        this.activeStatus = activeStatus;
        this.email = email;
        this.userRoleDTO = userRoleDTO;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
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

    public UserRoleDTO getUserRoleDTO() {
        return userRoleDTO;
    }

    public void setUserRoleDTO(UserRoleDTO userRoleDTO) {
        this.userRoleDTO = userRoleDTO;
    }
}
