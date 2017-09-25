package com.drsaina.notifi.util;

import com.drsaina.notifi.fcm.FcmNotificationSender;
import com.drsaina.notifi.model.CoreNotifications;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by mars on 8/20/2017.
 */
public class NotificationListener extends Thread {
    @Override
    public void run() {
        while (true)
        {
            try {
                SessionFactory sf = HibernateUtil.getSessionFactory();
                if(sf==null||sf.isClosed()) {
                    HibernateUtil.buildSessionFactory();
                    sf = HibernateUtil.getSessionFactory();
                }
                Session session = sf.openSession();
                List<CoreNotifications> list = session.createQuery("from CoreNotifications where notificationState= false ").list();
                session.close();

                if(!list.isEmpty()) {
                    FcmNotificationSender notificationSender = new com.drsaina.notifi.fcm.FcmNotificationSender();
                    notificationSender.Send(list);
                }
                Thread.sleep(1*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
