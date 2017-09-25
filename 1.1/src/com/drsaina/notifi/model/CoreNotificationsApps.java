package com.drsaina.notifi.model;

import javax.persistence.*;

/**
 * Created by mars on 9/10/2017.
 */
@Entity
@Table(name = "Core_NotificationsApps", schema = "dbo", catalog = "mNotification")
public class CoreNotificationsApps {
    private int appId;
    private String appNameCaption;
    private String appName;
    private String appTokenId;
    private String appRestApiKey;

    @Id
    @Column(name = "AppId")
    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "AppNameCaption")
    public String getAppNameCaption() {
        return appNameCaption;
    }

    public void setAppNameCaption(String appNameCaption) {
        this.appNameCaption = appNameCaption;
    }

    @Basic
    @Column(name = "AppName")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "AppTokenId")
    public String getAppTokenId() {
        return appTokenId;
    }

    public void setAppTokenId(String appTokenId) {
        this.appTokenId = appTokenId;
    }

    @Basic
    @Column(name = "AppRestApiKey")
    public String getAppRestApiKey() {
        return appRestApiKey;
    }

    public void setAppRestApiKey(String appRestApiKey) {
        this.appRestApiKey = appRestApiKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreNotificationsApps that = (CoreNotificationsApps) o;

        if (appId != that.appId) return false;
        if (appNameCaption != null ? !appNameCaption.equals(that.appNameCaption) : that.appNameCaption != null)
            return false;
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) return false;
        if (appTokenId != null ? !appTokenId.equals(that.appTokenId) : that.appTokenId != null) return false;
        if (appRestApiKey != null ? !appRestApiKey.equals(that.appRestApiKey) : that.appRestApiKey != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appId;
        result = 31 * result + (appNameCaption != null ? appNameCaption.hashCode() : 0);
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + (appTokenId != null ? appTokenId.hashCode() : 0);
        result = 31 * result + (appRestApiKey != null ? appRestApiKey.hashCode() : 0);
        return result;
    }
}
