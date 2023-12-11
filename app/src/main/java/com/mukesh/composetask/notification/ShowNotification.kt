package com.mukesh.composetask.notification

import android.Manifest
import android.content.Context
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.mukesh.composetask.BuildConfig
import com.mukesh.composetask.R
import android.app.NotificationManager
import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.mukesh.composetask.ui.MainActivity

fun showTimerCompleteNotification(mainContext: Context?){
    mainContext?.let { context ->
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)


        val notificationBuilder = NotificationCompat.Builder(context, BuildConfig.APPLICATION_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Timer Task")
            .setContentText("Your timer is completed.")
            .setAutoCancel(true)
            .setSilent(false)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
            .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setContentIntent(pendingIntent)

//    val notificationManager = getSystemService(context, Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationManager = NotificationManagerCompat.from(context)

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(BuildConfig.APPLICATION_ID, "Timer Task", NotificationManager.IMPORTANCE_HIGH).apply {
                description = "Your timer is completed."
                setBypassDnd(true)
                enableVibration(true)
                setShowBadge(true)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    setAllowBubbles(true)
                }
            }
            notificationManager.createNotificationChannel(channel)
        }

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notificationManager.notify(0, notificationBuilder.build())
    }
}