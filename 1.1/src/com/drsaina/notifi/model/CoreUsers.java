package com.drsaina.notifi.model;

import javax.persistence.*;

/**
 * Created by mars on 9/10/2017.
 */
@Entity
@Table(name = "Core_Users", schema = "dbo", catalog = "mNotification")
public class CoreUsers {
    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer parentId;
    private boolean isSuperAdmin;
    private Boolean userStatus;
    private String userType;

    @Id
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ParentID")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "IsSuperAdmin")
    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }

    @Basic
    @Column(name = "UserStatus")
    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "UserType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreUsers coreUsers = (CoreUsers) o;

        if (userId != coreUsers.userId) return false;
        if (isSuperAdmin != coreUsers.isSuperAdmin) return false;
        if (username != null ? !username.equals(coreUsers.username) : coreUsers.username != null) return false;
        if (password != null ? !password.equals(coreUsers.password) : coreUsers.password != null) return false;
        if (firstName != null ? !firstName.equals(coreUsers.firstName) : coreUsers.firstName != null) return false;
        if (lastName != null ? !lastName.equals(coreUsers.lastName) : coreUsers.lastName != null) return false;
        if (email != null ? !email.equals(coreUsers.email) : coreUsers.email != null) return false;
        if (parentId != null ? !parentId.equals(coreUsers.parentId) : coreUsers.parentId != null) return false;
        if (userStatus != null ? !userStatus.equals(coreUsers.userStatus) : coreUsers.userStatus != null) return false;
        if (userType != null ? !userType.equals(coreUsers.userType) : coreUsers.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (isSuperAdmin ? 1 : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
