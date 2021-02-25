package com.philipplackner.episode30

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

//  Service run on main thread by default and support multi-thread.
class MyService : Service() {
    val TAG="MyService"
    init {
        Log.d(TAG,"Service is running")
    }
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString= intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG,dataString)
        }
//        service runs on main thread. while loop will block others for ever
//        Start another thread so that others can access main thread
        Thread{
            while (true){}
        }.start()
//        service runs on main thread. while loop will block others to access main thread for ever
//        while (true){}
//        Recreate the last intent killed by Android to service
        return START_STICKY
    }
//      This thread won't stop due to while loop
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service is killed")
    }
}