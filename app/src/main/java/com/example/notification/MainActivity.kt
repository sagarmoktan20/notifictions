package com.example.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
  val channel_Id="channelid"
    val channel_Name="channelname"
    val ntificationId=1
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CreateNotificationChannel()

        //pending intent
        val intent=Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)
            val notification=NotificationCompat.Builder(this,channel_Id)
                .setContentText("congrats for entering 27th day of 30 day app devlopment")
                .setContentTitle("Congrats,sagar")
                .setSmallIcon(R.drawable.baseline_circle_notifications_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()
        val btn=findViewById<Button>(R.id.button)
        val notificationManager=NotificationManagerCompat.from(this)
        btn.setOnClickListener {
            notificationManager.notify(ntificationId,notification)
        }


    }

    fun CreateNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel(channel_Id,channel_Name,NotificationManager.IMPORTANCE_DEFAULT).apply {
                description="this is a sample of discription"
                lightColor= Color.RED
                enableLights(true)
            }
            val manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}