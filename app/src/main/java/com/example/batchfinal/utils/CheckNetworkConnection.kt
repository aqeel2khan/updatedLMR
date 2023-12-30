package com.example.batchfinal.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.example.batchfinal.R

object CheckNetworkConnection {
    fun isConnection(context: Context, toast: Boolean = true): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val conn = connectivityManager.activeNetworkInfo
        return if (conn != null && conn.isAvailable && conn.isConnected){
            true
        }else{
            if (toast)
                Toast.makeText(context, R.string.please_check_internet, Toast.LENGTH_LONG).show()
            false
        }
    }
}