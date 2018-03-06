package com.innovative.housingsecurity.firebase_services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.innovative.housingsecurity.R;

import java.util.Map;

/**
 * Created by pulkit on 29/12/17.
 */

public class AndroidFirebaseMsgService extends FirebaseMessagingService {

    private final int NOTIFICATION_ID = 10;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);

        try {
            Map<String, String> data = remoteMessage.getData();

            createNotification(data, data.get("message"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNotification(Map<String, String> data, String message) {

//        Intent intent = new Intent(getApplicationContext(), OpenVhiClassJhaJanaHai.class);
//        intent.putExtra("id", message);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent approvedIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        PendingIntent declineIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
//                .setSmallIcon(R.drawable.ic_dashboard)
//                .setContentTitle(message)
//                .setContentText(message)
//                .setAutoCancel(true)
//                .setSound(uri)
//                .setVibrate(new long[]{0, 300, 300, 300})
////                .setContentIntent(approvedIntent)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .addAction(0, "Approved", approvedIntent)
//                .addAction(0, "Decline", declineIntent);
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }

}
