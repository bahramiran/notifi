package com.drsaina.notifi;

import com.drsaina.notifi.util.HibernateUtil;
import com.drsaina.notifi.util.NotificationListener;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ServerNotification {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		if(sf==null||sf.isClosed()) {
			HibernateUtil.buildSessionFactory();
			sf = HibernateUtil.getSessionFactory();
		}

		Session session = sf.openSession();
		new NotificationListener().run();

	}

}