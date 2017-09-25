package com.drsaina.notifi.model;

import javax.persistence.*;

/**
 * Created by mars on 9/10/2017.
 */
@Entity
@Table(name = "Core_NotificationsUsersTokens", schema = "dbo", catalog = "mNotification")
public class CoreNotificationsUsersTokens {
    private int tokenId;
    private int userId;
    private String userTokenId;

    @Id
    @Column(name = "TokenId")
    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    @Basic
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserTokenId")
    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreNotificationsUsersTokens that = (CoreNotificationsUsersTokens) o;

        if (tokenId != that.tokenId) return false;
        if (userId != that.userId) return false;
        if (userTokenId != null ? !userTokenId.equals(that.userTokenId) : that.userTokenId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tokenId;
        result = 31 * result + userId;
        result = 31 * result + (userTokenId != null ? userTokenId.hashCode() : 0);
        return result;
    }
}
