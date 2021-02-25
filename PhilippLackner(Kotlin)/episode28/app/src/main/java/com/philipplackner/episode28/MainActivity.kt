package com.philipplackner.episode28

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    Global variables
    val CHANNEL_ID="channelID"
    val CHANNEL_NAME="channelName"
    val NOTIFICATION_ID=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        val intent=Intent(this,MainActivity::class.java)
        val pendindIntent=TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification=NotificationCompat
            .Builder(this,CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("This is content text")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendindIntent)
            .build()
        val notificationManager=NotificationManagerCompat.from(this)
        btnShowNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID,notification)
        }
    }
    fun createNotificationChannel(){
//        Android version before Oreo didn't need notification channel
        if (SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor=Color.GREEN
                enableLights(true)
            }
            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

        }
    }

}
