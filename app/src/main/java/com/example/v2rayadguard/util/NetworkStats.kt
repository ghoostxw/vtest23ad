package com.example.v2rayadguard.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

data class NetworkStats(
    var bytesReceived: Long = 0,
    var bytesSent: Long = 0
) {
    fun updateStats(received: Long, sent: Long) {
        bytesReceived += received
        bytesSent += sent
    }

    fun resetStats() {
        bytesReceived = 0
        bytesSent = 0
    }

    fun getTotalBytes(): Long {
        return bytesReceived + bytesSent
    }

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val networkCapabilities = connectivityManager.activeNetwork?.let { connectivityManager.getNetworkCapabilities(it) }
                networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
            } else {
                val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
                activeNetwork?.isConnected == true
            }
        }
    }
}