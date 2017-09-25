package com.drsaina.notifi.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mars on 9/10/2017.
 */
@Entity
@Table(name = "Core_Notifications", schema = "dbo", catalog = "mNotification")
public class CoreNotifications {
    private int notificationId;
    private String notificationTitle;
    private String notificationContents;
    private String notificationMode;
    private String notificationType;
    private String notificationSubtitleIos;
    private String notificationSmallIcon;
    private String notificationLargeIcon;
    private String notificationUrl;
    private String notificationChromeBigPic;
    private String notificationChromeWebIcon;
    private String notificationFirefoxIcon;
    private Integer notificationPriority;
    private Timestamp notificationSendAfter;
    private boolean notificationIsIos;
    private boolean notificationIsWeb;
    private boolean notificationIsAndroid;
    private boolean notificationState;
    private String notificationAppName;

    @Id
    @Column(name = "NotificationId")
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    @Basic
    @Column(name = "NotificationTitle")
    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    @Basic
    @Column(name = "NotificationContents")
    public String getNotificationContents() {
        return notificationContents;
    }

    public void setNotificationContents(String notificationContents) {
        this.notificationContents = notificationContents;
    }

    @Basic
    @Column(name = "NotificationMode")
    public String getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(String notificationMode) {
        this.notificationMode = notificationMode;
    }

    @Basic
    @Column(name = "NotificationType")
    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    @Basic
    @Column(name = "NotificationSubtitleIOS")
    public String getNotificationSubtitleIos() {
        return notificationSubtitleIos;
    }

    public void setNotificationSubtitleIos(String notificationSubtitleIos) {
        this.notificationSubtitleIos = notificationSubtitleIos;
    }

    @Basic
    @Column(name = "NotificationSmallIcon")
    public String getNotificationSmallIcon() {
        return notificationSmallIcon;
    }

    public void setNotificationSmallIcon(String notificationSmallIcon) {
        this.notificationSmallIcon = notificationSmallIcon;
    }

    @Basic
    @Column(name = "NotificationLargeIcon")
    public String getNotificationLargeIcon() {
        return notificationLargeIcon;
    }

    public void setNotificationLargeIcon(String notificationLargeIcon) {
        this.notificationLargeIcon = notificationLargeIcon;
    }

    @Basic
    @Column(name = "NotificationUrl")
    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    @Basic
    @Column(name = "NotificationChromeBigPic")
    public String getNotificationChromeBigPic() {
        return notificationChromeBigPic;
    }

    public void setNotificationChromeBigPic(String notificationChromeBigPic) {
        this.notificationChromeBigPic = notificationChromeBigPic;
    }

    @Basic
    @Column(name = "NotificationChromeWebIcon")
    public String getNotificationChromeWebIcon() {
        return notificationChromeWebIcon;
    }

    public void setNotificationChromeWebIcon(String notificationChromeWebIcon) {
        this.notificationChromeWebIcon = notificationChromeWebIcon;
    }

    @Basic
    @Column(name = "NotificationFirefoxIcon")
    public String getNotificationFirefoxIcon() {
        return notificationFirefoxIcon;
    }

    public void setNotificationFirefoxIcon(String notificationFirefoxIcon) {
        this.notificationFirefoxIcon = notificationFirefoxIcon;
    }

    @Basic
    @Column(name = "NotificationPriority")
    public Integer getNotificationPriority() {
        return notificationPriority;
    }

    public void setNotificationPriority(Integer notificationPriority) {
        this.notificationPriority = notificationPriority;
    }

    @Basic
    @Column(name = "NotificationSendAfter")
    public Timestamp getNotificationSendAfter() {
        return notificationSendAfter;
    }

    public void setNotificationSendAfter(Timestamp notificationSendAfter) {
        this.notificationSendAfter = notificationSendAfter;
    }

    @Basic
    @Column(name = "NotificationIsIOS")
    public boolean isNotificationIsIos() {
        return notificationIsIos;
    }

    public void setNotificationIsIos(boolean notificationIsIos) {
        this.notificationIsIos = notificationIsIos;
    }

    @Basic
    @Column(name = "NotificationIsWeb")
    public boolean isNotificationIsWeb() {
        return notificationIsWeb;
    }

    public void setNotificationIsWeb(boolean notificationIsWeb) {
        this.notificationIsWeb = notificationIsWeb;
    }

    @Basic
    @Column(name = "NotificationIsAndroid")
    public boolean isNotificationIsAndroid() {
        return notificationIsAndroid;
    }

    public void setNotificationIsAndroid(boolean notificationIsAndroid) {
        this.notificationIsAndroid = notificationIsAndroid;
    }

    @Basic
    @Column(name = "NotificationState")
    public boolean isNotificationState() {
        return notificationState;
    }

    public void setNotificationState(boolean notificationState) {
        this.notificationState = notificationState;
    }

    @Basic
    @Column(name = "NotificationAppName")
    public String getNotificationAppName() {
        return notificationAppName;
    }

    public void setNotificationAppName(String notificationAppName) {
        this.notificationAppName = notificationAppName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoreNotifications that = (CoreNotifications) o;

        if (notificationId != that.notificationId) return false;
        if (notificationIsIos != that.notificationIsIos) return false;
        if (notificationIsWeb != that.notificationIsWeb) return false;
        if (notificationIsAndroid != that.notificationIsAndroid) return false;
        if (notificationState != that.notificationState) return false;
        if (notificationTitle != null ? !notificationTitle.equals(that.notificationTitle) : that.notificationTitle != null)
            return false;
        if (notificationContents != null ? !notificationContents.equals(that.notificationContents) : that.notificationContents != null)
            return false;
        if (notificationMode != null ? !notificationMode.equals(that.notificationMode) : that.notificationMode != null)
            return false;
        if (notificationType != null ? !notificationType.equals(that.notificationType) : that.notificationType != null)
            return false;
        if (notificationSubtitleIos != null ? !notificationSubtitleIos.equals(that.notificationSubtitleIos) : that.notificationSubtitleIos != null)
            return false;
        if (notificationSmallIcon != null ? !notificationSmallIcon.equals(that.notificationSmallIcon) : that.notificationSmallIcon != null)
            return false;
        if (notificationLargeIcon != null ? !notificationLargeIcon.equals(that.notificationLargeIcon) : that.notificationLargeIcon != null)
            return false;
        if (notificationUrl != null ? !notificationUrl.equals(that.notificationUrl) : that.notificationUrl != null)
            return false;
        if (notificationChromeBigPic != null ? !notificationChromeBigPic.equals(that.notificationChromeBigPic) : that.notificationChromeBigPic != null)
            return false;
        if (notificationChromeWebIcon != null ? !notificationChromeWebIcon.equals(that.notificationChromeWebIcon) : that.notificationChromeWebIcon != null)
            return false;
        if (notificationFirefoxIcon != null ? !notificationFirefoxIcon.equals(that.notificationFirefoxIcon) : that.notificationFirefoxIcon != null)
            return false;
        if (notificationPriority != null ? !notificationPriority.equals(that.notificationPriority) : that.notificationPriority != null)
            return false;
        if (notificationSendAfter != null ? !notificationSendAfter.equals(that.notificationSendAfter) : that.notificationSendAfter != null)
            return false;
        if (notificationAppName != null ? !notificationAppName.equals(that.notificationAppName) : that.notificationAppName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = notificationId;
        result = 31 * result + (notificationTitle != null ? notificationTitle.hashCode() : 0);
        result = 31 * result + (notificationContents != null ? notificationContents.hashCode() : 0);
        result = 31 * result + (notificationMode != null ? notificationMode.hashCode() : 0);
        result = 31 * result + (notificationType != null ? notificationType.hashCode() : 0);
        result = 31 * result + (notificationSubtitleIos != null ? notificationSubtitleIos.hashCode() : 0);
        result = 31 * result + (notificationSmallIcon != null ? notificationSmallIcon.hashCode() : 0);
        result = 31 * result + (notificationLargeIcon != null ? notificationLargeIcon.hashCode() : 0);
        result = 31 * result + (notificationUrl != null ? notificationUrl.hashCode() : 0);
        result = 31 * result + (notificationChromeBigPic != null ? notificationChromeBigPic.hashCode() : 0);
        result = 31 * result + (notificationChromeWebIcon != null ? notificationChromeWebIcon.hashCode() : 0);
        result = 31 * result + (notificationFirefoxIcon != null ? notificationFirefoxIcon.hashCode() : 0);
        result = 31 * result + (notificationPriority != null ? notificationPriority.hashCode() : 0);
        result = 31 * result + (notificationSendAfter != null ? notificationSendAfter.hashCode() : 0);
        result = 31 * result + (notificationIsIos ? 1 : 0);
        result = 31 * result + (notificationIsWeb ? 1 : 0);
        result = 31 * result + (notificationIsAndroid ? 1 : 0);
        result = 31 * result + (notificationState ? 1 : 0);
        result = 31 * result + (notificationAppName != null ? notificationAppName.hashCode() : 0);
        return result;
    }
}
