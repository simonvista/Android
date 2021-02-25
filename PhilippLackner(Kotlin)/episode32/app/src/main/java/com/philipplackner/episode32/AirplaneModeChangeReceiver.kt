package com.philipplackner.episode32

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        ?: if(null) return else continue in this case
        val isAirplaneModeEnabled=intent?.getBooleanExtra("state",false) ?: return
        if (isAirplaneModeEnabled){
            Toast.makeText(context,"Airplane Mode Enabled",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Airplane Mode Disabled",Toast.LENGTH_LONG).show()
        }
    }
}