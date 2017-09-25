package com.drsaina.notifi.model;

import javax.persistence.*;

/**
 * Created by mars on 9/10/2017.
 */
@Entity
@Table(name = "Core_NotificationsParameters", schema = "dbo", catalog = "mNotification")
public class CoreNotificationsParameters {
    private int notificationDataId;
    private int notificationId;
    private String notificationDataCaption;
    private String notificationDataValue;

    @Id
    @Column(name = "NotificationDataId")
    public int getNotificationDataId() {
        return notificationDataId;
    }

    public void setNotificationDataId(int notificationDataId) {
        this.notificationDataId = notificationDataId;
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
    @Column(name = "NotificationDataCaption")
    public String getNotificationDataCaption() {
        return notificationDataCaption;
    }

    public void setNotificationDataCaption(String notificationDataCaption) {
        this.notificationDataCaption = notificationDataCaption;
    }

    @Basic
    @Column(name = "NotificationDataValue")
    public String getNotificationDataValue() {
        return notificationDataValue;
    }

    public void setNotificationDataValue(String notificationDataValue) {
        this.notificationDataValue = notificationDataValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreNotificationsParameters that = (CoreNotificationsParameters) o;

        if (notificationDataId != that.notificationDataId) return false;
        if (notificationId != that.notificationId) return false;
        if (notificationDataCaption != null ? !notificationDataCaption.equals(that.notificationDataCaption) : that.notificationDataCaption != null)
            return false;
        if (notificationDataValue != null ? !notificationDataValue.equals(that.notificationDataValue) : that.notificationDataValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = notificationDataId;
        result = 31 * result + notificationId;
        result = 31 * result + (notificationDataCaption != null ? notificationDataCaption.hashCode() : 0);
        result = 31 * result + (notificationDataValue != null ? notificationDataValue.hashCode() : 0);
        return result;
    }
}
