package com.drsaina.notifi.fcm;

import com.drsaina.notifi.model.*;
import com.drsaina.notifi.util.HibernateUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mars on 8/19/2017.
 */
public class FcmNotificationSender {

    SessionFactory sf;
    public void Send(List<CoreNotifications> list)
    {
        sf = HibernateUtil.getSessionFactory();

        for (CoreNotifications item:list) {
            if (item.getNotificationMode().equals("single")) {
                singleUser(item);
            }
            else if(item.getNotificationMode().equals("All"))
                AllUser(item);
        }
    }

    private void singleUser(CoreNotifications notifiConfig)
    {
        try {
            CoreNotificationsApps app = getInfoApp(notifiConfig);
            FcmNotificationMessage fcmNotificationMessage = setFcmNotificationMessage(notifiConfig);
            JsonObject data = getData(notifiConfig,notifiConfig.getNotificationType());
            String[] listuserst = getUsers(notifiConfig);

            FcmNotification fcmNotification = new FcmNotification();
            fcmNotification.setTo(null);
            fcmNotification.setRegistration_ids(listuserst);
            fcmNotification.setNotification(fcmNotificationMessage);
            fcmNotification.setData(data);

            Gson gson = new Gson();
            String strJsonBody = gson.toJson(fcmNotification);

            SendToServerFcm(strJsonBody,app.getAppTokenId());

            changeStatusNotification(notifiConfig);

        } catch(Throwable t) {
            t.printStackTrace();
        }
    }

    private void AllUser(CoreNotifications notifiConfig)
    {
        try {
            CoreNotificationsApps app = getInfoApp(notifiConfig);
            FcmNotificationMessage fcmNotificationMessage = setFcmNotificationMessage(notifiConfig);
            JsonObject data = getData(notifiConfig,notifiConfig.getNotificationType());

            FcmNotification fcmNotification = new FcmNotification();
            fcmNotification.setTo("/topics/All");
            fcmNotification.setRegistration_ids(null);
            fcmNotification.setNotification(fcmNotificationMessage);
            fcmNotification.setData(data);

            Gson gson = new Gson();

            String strJsonBody = gson.toJson(fcmNotification);

            SendToServerFcm(strJsonBody,app.getAppTokenId());

            changeStatusNotification(notifiConfig);

        } catch(Throwable t) {
        }

    }

    public FcmNotificationMessage setFcmNotificationMessage(CoreNotifications notifiConfig)
    {
        FcmNotificationMessage fcmNotificationMessage = new FcmNotificationMessage();
        fcmNotificationMessage.setTitle(notifiConfig.getNotificationTitle());
        fcmNotificationMessage.setBody(notifiConfig.getNotificationContents());
        fcmNotificationMessage.setSilent(false);
        fcmNotificationMessage.setSound("Enabled");

        return fcmNotificationMessage;
    }

    public String[] getUsers(CoreNotifications notifiConfig)
    {

        Session sessionUser = sf.openSession();
        Query query3 = sessionUser.createQuery("from CoreNotificationsSendedUsers where notificationId= :id ");
        query3.setParameter("id", notifiConfig.getNotificationId());
        List<CoreNotificationsSendedUsers> listuser = query3.list();

        String[] listuserst = new String[listuser.size()];

        int index = 0;
        for(CoreNotificationsSendedUsers item:listuser)
        {
            listuserst[index]=item.getUserTokenId();
            index++;
        }

        sessionUser.close();
        return listuserst;

    }

    public JsonObject getData(CoreNotifications notifiConfig,String type)
    {
        Session sessionData = sf.openSession();
        Query queryData = sessionData.createQuery("from CoreNotificationsParameters where notificationId= :id ");
        queryData.setParameter("id", notifiConfig.getNotificationId());
        List<CoreNotificationsParameters> listdata = queryData.list();
        JsonObject data = new JsonObject();
        data.addProperty("type",type);
        for(CoreNotificationsParameters item:listdata)
        {
            data.addProperty(item.getNotificationDataCaption(),item.getNotificationDataValue());
        }
        sessionData.close();

        return data;
    }

    public CoreNotificationsApps getInfoApp(CoreNotifications notifiConfig)
    {
        Session session = sf.openSession();
        Query query = session.createQuery("from CoreNotificationsApps where appName= :name ");
        query.setParameter("name", notifiConfig.getNotificationAppName());
        List<CoreNotificationsApps> list = query.list();
        CoreNotificationsApps app = list.get(0);
        session.close();
        return app;
    }

    public void changeStatusNotification(CoreNotifications notifiConfig)
    {
        Session session2 = sf.openSession();
        Query query2 = session2.createQuery("from CoreNotifications where notificationId= :id ");
        query2.setParameter("id",notifiConfig.getNotificationId());
        List<CoreNotifications> list2 = query2.list();
        CoreNotifications no = list2.get(0);
        session2.beginTransaction();
        no.setNotificationState(true);
        session2.getTransaction().commit();
        session2.close();
    }

    public void SendToServerFcm(String strJsonBody,String token)
    {
        URL url = null;
        try {
            String jsonResponse;

            url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);

            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("Authorization", "Key="+token);
            con.setRequestMethod("POST");

            System.out.println("strJsonBody:\n"
                    + strJsonBody);

            byte[] sendBytes = strJsonBody.getBytes("UTF-8");
            con.setFixedLengthStreamingMode(sendBytes.length);

            OutputStream outputStream = con.getOutputStream();
            outputStream.write(sendBytes);

            int httpResponse = con.getResponseCode();
            System.out.println("httpResponse: " + httpResponse);

            if (  httpResponse >= HttpURLConnection.HTTP_OK
                    && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                scanner.close();
            }

            else {
                Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                scanner.close();
            }

            System.out.println("jsonResponse:\n" + jsonResponse);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
