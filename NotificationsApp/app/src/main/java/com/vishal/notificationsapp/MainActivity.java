package com.vishal.notificationsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.zero,null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Intent iNotify = new Intent(getApplicationContext(), MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,REQ_CODE,iNotify,PendingIntent.FLAG_IMMUTABLE);

        // Big picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(),R.drawable.zero,null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Vishal")
                .setSummaryText("Image Message");

        // Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("I")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message From Vishal");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.zero)
                    .setContentText("New Message")
                    .setSubText("New Message From User")
                    .setVisibility(Notification.VISIBILITY_PUBLIC)
                    .setStyle(inboxStyle)
                    .setContentIntent(pendingIntent)
                  //  .setAutoCancel(false)
                    .setOngoing(true)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.zero)
                    .setContentText("New Message")
                    .setContentIntent(pendingIntent)
                    .setSubText("New Message From User")
                    .setStyle(inboxStyle)
                    .setOngoing(true)
                //    .setAutoCancel(false)
                    .setVisibility(Notification.VISIBILITY_PUBLIC)
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);
    }
}