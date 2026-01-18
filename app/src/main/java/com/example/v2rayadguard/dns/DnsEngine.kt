package com.example.v2rayadguard.dns

import android.util.Log
import java.net.InetAddress
import java.net.UnknownHostException

class DnsEngine {

    private val dnsServers = listOf("8.8.8.8", "8.8.4.4") // Example DNS servers

    fun resolveDomain(domain: String): List<String> {
        return try {
            val inetAddresses = InetAddress.getAllByName(domain)
            inetAddresses.map { it.hostAddress }
        } catch (e: UnknownHostException) {
            Log.e("DnsEngine", "Domain resolution failed for $domain", e)
            emptyList()
        }
    }

    fun setDnsServers(servers: List<String>) {
        // Logic to set custom DNS servers
    }

    fun getDnsServers(): List<String> {
        return dnsServers
    }

    fun clearCache() {
        // Logic to clear DNS cache if applicable
    }
}