package com.drsaina.notifi.model;

import javax.persistence.*;

/**
 * Created by mars on 9/10/2017.
 */
@Entity
@Table(name = "Core_NotificationsSendedUsers", schema = "dbo", catalog = "mNotification")
public class CoreNotificationsSendedUsers {
    private int sendedUsersId;
    private int notificationId;
    private String userTokenId;

    @Id
    @Column(name = "SendedUsersId")
    public int getSendedUsersId() {
        return sendedUsersId;
    }

    public void setSendedUsersId(int sendedUsersId) {
        this.sendedUsersId = sendedUsersId;
    }

    @Basic
    @Column(name = "NotificationId")
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
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

        CoreNotificationsSendedUsers that = (CoreNotificationsSendedUsers) o;

        if (sendedUsersId != that.sendedUsersId) return false;
        if (notificationId != that.notificationId) return false;
        if (userTokenId != null ? !userTokenId.equals(that.userTokenId) : that.userTokenId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sendedUsersId;
        result = 31 * result + notificationId;
        result = 31 * result + (userTokenId != null ? userTokenId.hashCode() : 0);
        return result;
    }
}
