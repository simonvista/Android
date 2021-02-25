package com.philipplackner.episode30

import android.app.IntentService
import android.content.Intent
import android.util.Log

//  IntentService runs on another thread(not main thread) and doesn't support multi-thread.
class MyIntentService : IntentService("myIntentService") {
    init{
        instance=this
    }
    companion object{
        private lateinit var instance:MyIntentService
        var isRunning=false
        fun stopService(): Unit {
            Log.d("MyIntentService","Service was stopped")
            isRunning=false
            instance.stopSelf()
        }
        
    }
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning=true
            while (isRunning){
                Log.d("MyIntentService","Service is running")
                Thread.sleep(1000)
            }
        }catch (e:InterruptedException){
            Thread.currentThread().interrupt()
        }
    }
}