package com.example.v2rayadguard.service

import android.app.PendingIntent
import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import com.example.v2rayadguard.data.repository.ConfigRepository
import com.example.v2rayadguard.util.NetworkStats
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VpnTunnelService : VpnService() {

    private var vpnInterface: ParcelFileDescriptor? = null
    private val configRepository = ConfigRepository()
    private val networkStats = NetworkStats()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startVpn()
        return START_STICKY
    }

    private fun startVpn() {
        val builder = Builder()
        builder.setSession("V2RayAdGuard")
            .addAddress("10.0.0.2", 24)
            .addRoute("0.0.0.0", 0)

        vpnInterface = builder.establish()
        if (vpnInterface != null) {
            // Start the VPN core in a separate coroutine
            CoroutineScope(Dispatchers.IO).launch {
                runVpnCore()
            }
        }
    }

    private suspend fun runVpnCore() {
        // Implement the logic to run the VPN core (e.g., using JNI to call Go functions)
        withContext(Dispatchers.Default) {
            // Placeholder for VPN core execution
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopVpn()
    }

    private fun stopVpn() {
        vpnInterface?.close()
        vpnInterface = null
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        // Handle rebind if necessary
    }

    override fun onUnbind(intent: Intent?): Boolean {
        stopVpn()
        return super.onUnbind(intent)
    }

    private fun createNotification(): PendingIntent {
        val notificationIntent = Intent(this, MainActivity::class.java)
        return PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}