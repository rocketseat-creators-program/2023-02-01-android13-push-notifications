package com.example.pushnotifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

const val CHANNEL_ID = "fcm_channel"
const val CHANNEL_NAME = "Fcm Channel"
const val NOTIFICATION_ID = 1

fun NotificationManager.sendNotification(appContext: Context, title: String, message: String) {
    val builder = NotificationCompat.Builder(appContext, CHANNEL_ID)

    builder
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(title)
        .setContentText(message)
        .setContentIntent(getPendingIntent(appContext))
        .priority = NotificationCompat.PRIORITY_DEFAULT

    notify(NOTIFICATION_ID, builder.build())
}

private fun getPendingIntent(appContext: Context): PendingIntent {
    val intent = Intent(appContext, MainActivity::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    }

    return PendingIntent.getActivity(
        appContext,
        0,
        intent,
        PendingIntent.FLAG_ONE_SHOT
    )
}