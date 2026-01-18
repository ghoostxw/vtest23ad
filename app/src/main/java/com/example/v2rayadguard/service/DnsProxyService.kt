package com.example.v2rayadguard.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.v2rayadguard.dns.DnsEngine

class DnsProxyService : Service() {

    private lateinit var dnsEngine: DnsEngine

    override fun onCreate() {
        super.onCreate()
        dnsEngine = DnsEngine(this)
        Log.d(TAG, "DNS Proxy Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        dnsEngine.start()
        Log.d(TAG, "DNS Proxy Service started")
        return START_STICKY
    }

    override fun onDestroy() {
        dnsEngine.stop()
        Log.d(TAG, "DNS Proxy Service destroyed")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    companion object {
        private const val TAG = "DnsProxyService"
    }
}