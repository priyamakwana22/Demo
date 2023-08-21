package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.R
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding
    var channelNAME = "Channel_Name"
    var channelID = "Channel_Id"
    var notificationID = 1

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {

            var notification = NotificationCompat.Builder(this,channelID)
                .setContentTitle("NotificationDEMO")
                .setContentText("Hello from Gujarat Univeristy")
                .setSmallIcon(R.drawable.notification_bg)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            var notificationManager = NotificationManagerCompat.from(this)

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                var channel = NotificationChannel(channelID,channelNAME, NotificationManager.IMPORTANCE_DEFAULT)
                    .apply {
                        lightColor = Color.GREEN
                        enableLights(true)
                        enableVibration(true)
                        description = "Static Notifications..."
                    }

                val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }


                var channel = NotificationChannel(channelID,channelNAME,NotificationManager.IMPORTANCE_DEFAULT)
                    .apply {
                        lightColor = Color.GREEN
                        enableLights(true)
                        enableVibration(true)
                        description = "Static Notifications..."
                    }

                val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)

            notificationManager.notify(notificationID,notification.build())
        }
    }
}

//package com.example.notifications_demo
//
//import android.Manifest
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.graphics.Color
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.annotation.RequiresApi
//import androidx.core.app.ActivityCompat
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import com.example.notifications_demo.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//
//    private lateinit var binding : ActivityMainBinding
//
//    var channelNAME = "Channel_Name"
//    var channelID = "Channel_Id"
//    var notificationID = 1
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnClick.setOnClickListener {
//
//            var notification = NotificationCompat.Builder(this,channelID)
//                .setContentTitle("NotificationDEMO")
//                .setContentText("Hello from Gujarat Univeristy")
//                .setSmallIcon(androidx.core.R.drawable.notification_bg)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//
//            var notificationManager = NotificationManagerCompat.from(this)
//
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//
//                var channel = NotificationChannel(channelID,channelNAME,NotificationManager.IMPORTANCE_DEFAULT)
//                    .apply {
//                        lightColor = Color.GREEN
//                        enableLights(true)
//                        enableVibration(true)
//                        description = "Static Notifications..."
//                    }
//
//                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//                manager.createNotificationChannel(channel)
//            }
//
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.POST_NOTIFICATIONS
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                var channel = NotificationChannel(channelID,channelNAME,NotificationManager.IMPORTANCE_DEFAULT)
//                    .apply {
//                        lightColor = Color.GREEN
//                        enableLights(true)
//                        enableVibration(true)
//                        description = "Static Notifications..."
//                    }
//
//                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//                manager.createNotificationChannel(channel)
//            }
//            notificationManager.notify(notificationID,notification.build())
//        }
//
//    }
//}